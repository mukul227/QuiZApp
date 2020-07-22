package com.example.quizapp;

import androidx.annotation.NonNull;

import com.example.quizapp.Model.QuizListModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class FirebaseRepository {
    private onFirestoreTaskComplete firestoreTaskComplete;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    public FirebaseRepository(onFirestoreTaskComplete firestoreTaskComplete) {
        this.firestoreTaskComplete = firestoreTaskComplete;
    }

    private Query cReference = firestore.collection("QuizList").whereEqualTo("Visibility","public");

    public void getQuizdata() {

        cReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    firestoreTaskComplete.quizListDataAdded(task.getResult().toObjects(QuizListModel.class));
                } else {
                    firestoreTaskComplete.onError(task.getException());
                }
            }
        });
    }

    public interface onFirestoreTaskComplete {
        void quizListDataAdded(List<QuizListModel> quizListModels);

        void onError(Exception e);

    }
}
