package com.example.quizapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quizapp.Model.QuizListModel;
import com.example.quizapp.R;

import java.util.List;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.Holder> {
    private List<QuizListModel> quizListModelList;

    private OnQuizListItemClicked onQuizListItemClicked;

    public QuizListAdapter(OnQuizListItemClicked onQuizListItemClicked) {
        this.onQuizListItemClicked = onQuizListItemClicked;
    }

    public void setQuizListModelList(List<QuizListModel> quizListModelList) {
        this.quizListModelList = quizListModelList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.listtitle.setText(quizListModelList.get(position).getName());
        String imageUrl = quizListModelList.get(position).getImage();
        Glide
                .with(holder.itemView.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder_image)
                .into(holder.listImage);
        String listDescription = quizListModelList.get(position).getDescription();
        if (listDescription.length()>150){
            listDescription = listDescription.substring(0, 150);
        }
        holder.listdesc.setText(listDescription + "...");
        holder.listlevel.setText(quizListModelList.get(position).getLevel());

    }

    @Override
    public int getItemCount() {
        if (quizListModelList == null) {
            return 0;

        } else {
            return quizListModelList.size();
        }

    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView listImage;
        private TextView listtitle, listdesc, listlevel;
        private Button listButton;

        public Holder(@NonNull View itemView) {
            super(itemView);
            listImage = itemView.findViewById(R.id.list_image);
            listtitle = itemView.findViewById(R.id.list_title);
            listdesc = itemView.findViewById(R.id.list_desc);
            listlevel = itemView.findViewById(R.id.list_difficulty);
            listButton = itemView.findViewById(R.id.list_btn);
            listButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onQuizListItemClicked.onItemClicked(getAdapterPosition());
        }
    }

    public interface OnQuizListItemClicked {
        void onItemClicked(int position);

    }
}
