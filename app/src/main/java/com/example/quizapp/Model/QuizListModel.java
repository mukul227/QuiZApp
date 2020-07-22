package com.example.quizapp.Model;

import com.google.firebase.firestore.DocumentId;

public class QuizListModel {

    @DocumentId
    private  String quiz_id;
    private String Name,Description,Image,Level,Visibility;
    private long Questions;

    public QuizListModel(String quiz_id, String name, String description, String image, String level, String visibility, long questions) {
        this.quiz_id = quiz_id;
        Name = name;
        Description = description;
        Image = image;
        Level = level;
        Visibility = visibility;
        Questions = questions;
    }

    public QuizListModel() {
    }

    public String getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(String quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getVisibility() {
        return Visibility;
    }

    public void setVisibility(String visibility) {
        Visibility = visibility;
    }

    public long getQuestions() {
        return Questions;
    }

    public void setQuestions(long questions) {
        Questions = questions;
    }
}
