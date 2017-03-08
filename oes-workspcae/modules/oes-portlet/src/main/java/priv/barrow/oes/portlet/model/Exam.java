package priv.barrow.oes.portlet.model;

import java.util.Date;
import java.util.List;

public class Exam {
    private long examId;
    private String name;
    private int questionCount;
    private List<Question> questions;
    private long creatorId;
    private String creatorName;
    private Date createdTime;

    public Exam(Long examId, String name, int questionCount, List<Question> questions,
            long creatorId, String creatorName, Date createdTime) {
        this.examId = examId;
        this.name = name;
        this.questionCount = questionCount;
        this.questions = questions;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.createdTime = createdTime;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
