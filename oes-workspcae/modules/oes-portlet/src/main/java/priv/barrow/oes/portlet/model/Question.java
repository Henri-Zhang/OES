package priv.barrow.oes.portlet.model;

import java.util.Date;

public class Question {

    private long order;
    private String description;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private long creatorId;
    private String creatorName;
    private Date createdTime;
    private Date modifiedTime;

    public Question() {}

    public Question(Long order, String description,
            String optionA, String optionB, String optionC, String optionD, String answer) {
        this.order = order;
        this.description = description;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
