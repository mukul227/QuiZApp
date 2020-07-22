package com.example.quizapp.Model;

import com.google.firebase.firestore.DocumentId;

public class QuestionModel {
    @DocumentId
private String questionId;
    private String  Question,Option_A,Option_B,Option_C,Answer;
    private long Timer;

    public QuestionModel() {
    }

    public QuestionModel(String questionId, String question, String option_A, String option_B, String option_C, String answer, long timer) {
        this.questionId = questionId;
        Question = question;
        Option_A = option_A;
        Option_B = option_B;
        Option_C = option_C;
        Answer = answer;
        Timer = timer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOption_A() {
        return Option_A;
    }

    public void setOption_A(String option_A) {
        Option_A = option_A;
    }

    public String getOption_B() {
        return Option_B;
    }

    public void setOption_B(String option_B) {
        Option_B = option_B;
    }

    public String getOption_C() {
        return Option_C;
    }

    public void setOption_C(String option_C) {
        Option_C = option_C;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public long getTimer() {
        return Timer;
    }

    public void setTimer(long timer) {
        Timer = timer;
    }
}
