package priv.barrow.oes.portlet.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

public class ExamUtil {

    private static final Log LOG = LogFactoryUtil.getLog(ExamUtil.class);

    public static Map<String, Object> getExamValueMap(Fields fields) {
        Locale defaultLocale = LocaleUtil.getDefault();
        Map<String, Object> valueMap = new HashMap<>();

        Field questionCountField = fields.get("QuestionCount");
        Field examNameField = fields.get("ExamName");
        Field startTimeField = fields.get("StartTime");
        Field closeTimeField = fields.get("CloseTime");

        int questionCount = (int) questionCountField.getValue(defaultLocale);
        String examName = (String) examNameField.getValue(defaultLocale);
        String startTimeString = (String) startTimeField.getValue(defaultLocale);
        String closeTimeString = (String) closeTimeField.getValue(defaultLocale);

        return valueMap;
    }
}