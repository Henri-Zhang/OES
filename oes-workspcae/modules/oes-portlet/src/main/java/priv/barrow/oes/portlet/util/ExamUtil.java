package priv.barrow.oes.portlet.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;

import priv.barrow.model.ExamData;
import priv.barrow.model.ExamQuestionLink;
import priv.barrow.model.StudentExamLink;
import priv.barrow.oes.portlet.constants.ExamConstants;
import priv.barrow.oes.portlet.model.Exam;
import priv.barrow.oes.portlet.model.Question;
import priv.barrow.service.ExamQuestionLinkLocalServiceUtil;

public class ExamUtil {

    private static final Log LOG = LogFactoryUtil.getLog(ExamUtil.class);

    public static Map<String, Object> getExamValueMap(Fields fields) {
        Locale defaultLocale = LocaleUtil.getDefault();
        Map<String, Object> valueMap = new HashMap<>();

        Field questionCountField = fields.get(ExamConstants.QUESTION_COUNT_FIELD_NAME);
        Field examNameField = fields.get(ExamConstants.EXAM_NAME_FIELD_NAME);

        int questionCount = (int) questionCountField.getValue(defaultLocale);
        String examName = (String) examNameField.getValue(defaultLocale);

        valueMap.put(ExamConstants.QUESTION_COUNT_FIELD_NAME, questionCount);
        valueMap.put(ExamConstants.EXAM_NAME_FIELD_NAME, examName);

        return valueMap;
    }

    public static Exam getExam(DDLRecord examRecord) {
        long examRecordId = examRecord.getRecordId();
        List<ExamQuestionLink> examQuestionLinks =
                ExamQuestionLinkLocalServiceUtil.findByExamRecordId(examRecordId);

        List<Question> questions = new ArrayList<>();
        for (ExamQuestionLink examQuestionLink : examQuestionLinks) {
            Question question = QuestionUtil.getQuestion(examQuestionLink);
            questions.add(question);
        }
        int questionCount = questions.size();

        DDMFormValues ddmFormValues = null;
        try {
            ddmFormValues = examRecord.getDDMFormValues();
        } catch (PortalException e) {
            LOG.error(String.format(
                    "Get DDMFormValues from DDLRecord failed. recordId: [%d]", examRecord.getRecordId()), e);
        }

        Map<String, List<DDMFormFieldValue>> fieldValues = ddmFormValues.getDDMFormFieldValuesMap();
        String examName = StringPool.BLANK;
        try {
            examName = fieldValues.get(ExamConstants.EXAM_NAME_FIELD_NAME)
                    .get(0).getValue().getString(Locale.getDefault());
        } catch (NullPointerException e) {
            LOG.error("Got a NullPointerException when fetch examName.", e);
        }

        long creatorId = examRecord.getUserId();
        Date createdTime = examRecord.getCreateDate();
        User creator = null;
        try {
            creator = UserLocalServiceUtil.getUser(creatorId);
        } catch (PortalException e) {
            LOG.error(String.format("Get user by userId failed. userId: [%d]", creatorId), e);
        }

        String creatorName = creator.getFullName();

        return new Exam(examRecordId, examName, questionCount, questions, creatorId, creatorName, createdTime);
    }

    public static List<Exam> getExamsByRecords(List<DDLRecord> examRecords) {
        List<Exam> exams = new ArrayList<>();
        for (DDLRecord record : examRecords) {
            Exam exam = getExam(record);
            exams.add(exam);
        }

        return exams;
    }

    public static List<Exam> getExamsByStudentExamLinks(List<StudentExamLink> studentExamLinks) {
        List<Exam> exams = new ArrayList<>();
        for (StudentExamLink studentExamLink : studentExamLinks) {
            long examRecordId = studentExamLink.getExamRecordId();
            DDLRecord examRecord = null;
            try {
                examRecord = DDLRecordLocalServiceUtil.getDDLRecord(examRecordId);
            } catch (PortalException e) {
                LOG.error(String.format("Get DDLRecord by recordId failed. recordId: [%d]", examRecordId), e);
            }

            Exam exam = getExam(examRecord);
            exams.add(exam);
        }

        return exams;
    }

    public static Map<Long, String> convertToResultMap(List<ExamData> examDatas) {
        Map<Long, String> resultMap = new HashMap<>();
        for (ExamData examData : examDatas) {
            resultMap.put(examData.getQuestionOrder(), examData.getResult());
        }

        return resultMap;
    }

}
