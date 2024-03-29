package oes.custom.core.jsps;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.deploy.hot.CustomJspBag;
import com.liferay.portal.kernel.url.URLContainer;

@Component(
    immediate = true,
    property = {
        "context.id=OESCustomJspBag",
        "context.name=Custom JSP Bag",
        "service.ranking:Integer=10000"
    }
)

public class OESCustomJspBag implements CustomJspBag {

    @Activate
    protected void activate(BundleContext bundleContext) {
        bundle = bundleContext.getBundle();
        customJsps = new ArrayList<>();

        Enumeration<URL> entries = bundle.findEntries(
            getCustomJspDir(), "*.jsp", true);

        while (entries.hasMoreElements()) {
            URL url = entries.nextElement();
            customJsps.add(url.getPath());
        }
    }

    private Bundle bundle;
    private List<String> customJsps;

    private final URLContainer urlContainer = new URLContainer() {

        @Override
        public URL getResource(String name) {
            return bundle.getEntry(name);
        }

        @Override
        public Set<String> getResources(String path) {
            Set<String> paths = new HashSet<>();
            for (String entry : customJsps) {
                if (entry.startsWith(path)) {
                    paths.add(entry);
                }
            }

            return paths;
        }
    };

    @Override
    public String getCustomJspDir() {
        return "META-INF/jsps";
    }

    @Override
    public List<String> getCustomJsps() {
        return customJsps;
    }

    @Override
    public URLContainer getURLContainer() {
        return urlContainer;
    }

    @Override
    public boolean isCustomJspGlobal() {
        return true;
    }

}
