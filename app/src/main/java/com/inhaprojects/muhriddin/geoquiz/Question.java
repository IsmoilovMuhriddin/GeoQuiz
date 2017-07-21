package com.inhaprojects.muhriddin.geoquiz;

/**
 * Created by Muhriddin on 2017-07-21.
 */

public class Question {
    private int questionId;
    private boolean answer;

    public Question(int questionId, boolean answer) {

        this.questionId = questionId;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {

        this.questionId = questionId;
    }
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
    public boolean isAnswer() {

        return answer;
    }

}
