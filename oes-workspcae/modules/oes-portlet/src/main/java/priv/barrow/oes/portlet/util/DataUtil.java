package priv.barrow.oes.portlet.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
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

            DDMFormField descriptionFormField = new DDMFormField("Description", "textarea");
            DDMFormField optionAFormField = new DDMFormField("OptionA", "text");
            DDMFormField optionBFormField = new DDMFormField("OptionB", "text");
            DDMFormField optionCFormField = new DDMFormField("OptionC", "text");
            DDMFormField optionDFormField = new DDMFormField("OptionD", "text");
            DDMFormField answerFormField = new DDMFormField("Answer", "radio");

            descriptionFormField.setProperty("Description", description);
            optionAFormField.setProperty("OptionA", optionA);
            optionBFormField.setProperty("OptionB", optionB);
            optionCFormField.setProperty("OptionC", optionC);
            optionDFormField.setProperty("OptionD", optionD);
            answerFormField.setProperty("Answer", answer);

            DDMForm ddmForm = new DDMForm();
            ddmForm.addDDMFormField(descriptionFormField);
            ddmForm.addDDMFormField(optionAFormField);
            ddmForm.addDDMFormField(optionBFormField);
            ddmForm.addDDMFormField(optionCFormField);
            ddmForm.addDDMFormField(optionDFormField);
            ddmForm.addDDMFormField(answerFormField);

            DDMFormValues ddmFormValues = new DDMFormValues(ddmForm);

            DDLRecord newRecord = null;
            try {
                newRecord = DDLRecordLocalServiceUtil.addRecord(20164, 20147, 50950, 0, ddmFormValues, serviceContext);
            } catch (PortalException e) {
                e.printStackTrace();
                continue;
            }

            if (newRecord == null) {
                continue;
            }

            QuestionRecordLinkLocalServiceUtil.addQuestionRecordLink(newRecord.getRecordId());

        }

        System.out.println("-----------------");
    }

}