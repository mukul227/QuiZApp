package com.example.quizapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.FirebaseRepository;
import com.example.quizapp.Model.QuizListModel;

import java.util.List;

public class QuizListViewModel extends ViewModel implements FirebaseRepository.onFirestoreTaskComplete {
    private MutableLiveData<List<QuizListModel>> quizListModelData = new MutableLiveData<>();

    public LiveData<List<QuizListModel>> getQuizListModelData() {
        return quizListModelData;
    }


    private FirebaseRepository firebaseRepository = new FirebaseRepository(this);

    public QuizListViewModel() {
        firebaseRepository.getQuizdata();
    }

    @Override
    public void quizListDataAdded(List<QuizListModel> quizListModels) {
        quizListModelData.setValue(quizListModels);
    }

    @Override
    public void onError(Exception e) {

    }
}
