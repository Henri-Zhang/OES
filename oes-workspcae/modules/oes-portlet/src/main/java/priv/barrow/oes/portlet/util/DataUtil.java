package priv.barrow.oes.portlet.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import priv.barrow.service.QuestionRecordLinkLocalServiceUtil;

public class DataUtil {
    private static Log LOG = LogFactoryUtil.getLog(DataUtil.class);

    public static void questionImport(String path, ServiceContext serviceContext) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            LOG.error("This file no found.", e);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = null;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray questionArray = null;
        try {
            questionArray = JSONFactoryUtil.createJSONArray(sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < questionArray.length(); i++) {
            JSONObject questionObject = questionArray.getJSONObject(i);
            String description = (String) questionObject.get("Description");
            String optionA = (String) questionObject.get("OptionA");
            String optionB = (String) questionObject.get("OptionB");
            String optionC = (String) questionObject.get("OptionC");
            String optionD = (String) questionObject.get("OptionD");
            String answer = (String) questionObject.get("Answer");

            Map<String, Serializable> fieldsMap = new HashMap<>();
            fieldsMap.put("Description", description);
            fieldsMap.put("OptionA", optionA);
            fieldsMap.put("OptionB", optionB);
            fieldsMap.put("OptionC", optionC);
            fieldsMap.put("OptionD", optionD);
            fieldsMap.put("Answer", answer);

            DDLRecord newRecord = null;
            try {
                newRecord = DDLRecordLocalServiceUtil.addRecord(20164, 20147, 50950, 0, fieldsMap, serviceContext);
            } catch (PortalException e) {
                e.printStackTrace();
                System.out.println("No." + i + "This question import failed." + description);
                continue;
            }

            if (newRecord == null) {
                continue;
            }

            QuestionRecordLinkLocalServiceUtil.addQuestionRecordLink(newRecord.getRecordId(), description);
            System.out.println("No." + i + "This question import completed." + description);
        }

        System.out.println("-----------------");
    }

}
