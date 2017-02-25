package priv.barrow.oes.portlet.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import priv.barrow.model.QuestionRecordLink;
import priv.barrow.oes.portlet.addquestion.exception.NoQuestionStructureException;
import priv.barrow.oes.portlet.model.Constants;
import priv.barrow.oes.portlet.model.Question;

public class QuestionUtil {

    private static Log LOG = LogFactoryUtil.getLog(QuestionUtil.class);

    public static List<Question> getQuestions (List<QuestionRecordLink> questionRecordLinks) {
        if (Validator.isNull(questionRecordLinks) || questionRecordLinks.isEmpty()) {
            return null;
        }

        List<Question> questions = new ArrayList<>();
        for (QuestionRecordLink link : questionRecordLinks) {

            Question question = getQuestion(link);
            if (Validator.isNotNull(question)) {
                questions.add(question);
            }
        }

        return questions;
    }

    public static Question getQuestion(QuestionRecordLink questionRecordLink) {
        if (Validator.isNull(questionRecordLink)) {
            return null;
        }

        DDLRecord record = null;
        long recordId = questionRecordLink.getDdlRecordId();

        try {
            record = DDLRecordLocalServiceUtil.getDDLRecord(recordId);
        } catch (PortalException e) {
            LOG.error(String.format("Get DDLRcord by recordId [%d] failed.", recordId), e);
        }

        if (Validator.isNull(record)) {
            return null;
        }

        DDMFormValues ddmFormValues = null;
        try {
            ddmFormValues = record.getDDMFormValues();
        } catch (PortalException e) {
            LOG.error(String.format("get DDMFormValues from record failed. recordId: [%d]", recordId));
        }

        if (Validator.isNull(ddmFormValues)) {
            return null;
        }

        Locale locale = LocaleUtil.getDefault();
        Map<String, List<DDMFormFieldValue>> fieldValues = ddmFormValues.getDDMFormFieldValuesMap();

        DDMFormFieldValue descriptionFormFieldValue = fieldValues.get(Constants.DESCRIPTION).get(0);
        DDMFormFieldValue optionAFormFieldValue = fieldValues.get(Constants.OPTION_A).get(0);
        DDMFormFieldValue optionBFormFieldValue = fieldValues.get(Constants.OPTION_B).get(0);
        DDMFormFieldValue optionCFormFieldValue = fieldValues.get(Constants.OPTION_C).get(0);
        DDMFormFieldValue optionDFormFieldValue = fieldValues.get(Constants.OPTION_D).get(0);
        DDMFormFieldValue answerFormFieldValue = fieldValues.get(Constants.ANSWER).get(0);

        Value descriptionValue = descriptionFormFieldValue.getValue();
        Value optionAValue = optionAFormFieldValue.getValue();
        Value optionBValue = optionBFormFieldValue.getValue();
        Value optionCValue = optionCFormFieldValue.getValue();
        Value optionDValue = optionDFormFieldValue.getValue();
        Value answerValue = answerFormFieldValue.getValue();

        String description = descriptionValue.getString(locale);
        String optionA = optionAValue.getString(locale);
        String optionB = optionBValue.getString(locale);
        String optionC = optionCValue.getString(locale);
        String optionD = optionDValue.getString(locale);
        String answer = answerValue.getString(locale);

        Question question =
                new Question(questionRecordLink.getQuestionOrder(),
                        description,
                        optionA,
                        optionB,
                        optionC,
                        optionD,
                        answer);

        return question;
    }

    public static DDMStructure getQuestionDDMStructure() {
        DynamicQuery structrueQuery = DDMStructureLocalServiceUtil.dynamicQuery();
        Property property = PropertyFactoryUtil.forName("name");
        Criterion criterion =
                property.like(StringPool.PERCENT+ Constants.QUESTION + Constants.NAME_END_TAG + StringPool.PERCENT);
        structrueQuery.add(criterion);
        List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.dynamicQuery(structrueQuery);

        if (Validator.isNull(ddmStructures) || ddmStructures.isEmpty()) {
            String errorMessage = String.format("No ddmStructure found with name [%s]", Constants.QUESTION);
            LOG.error(errorMessage, new NoQuestionStructureException(errorMessage));
            return null;
        }

        return ddmStructures.get(0);
    }

    public static Fields getQuestionStructureFields(long structureId, ServiceContext serviceContext) {
        if (Validator.isNull(serviceContext)) {
            serviceContext = new ServiceContext();
        }

        Fields fields = null;
        try {
            fields = DDMUtil.getFields(structureId, serviceContext);
        } catch (PortalException e) {
            LOG.error(String.format("Get fields from ddmStructure which id is [%s] failed.", structureId), e);
        }

        return fields;
    }

    public static DDLRecordSet getQuestionRecordSet(long questionStructureId) {
        DynamicQuery dynamicQuery = DDLRecordSetLocalServiceUtil.dynamicQuery();
        Property property = PropertyFactoryUtil.forName("DDMStructureId");
        Criterion criterion = property.eq(questionStructureId);
        dynamicQuery.add(criterion);
        List<DDLRecordSet> list = DDLRecordSetLocalServiceUtil.dynamicQuery(dynamicQuery);
        if (Validator.isNull(list) || list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}