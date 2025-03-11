package com.example.test4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private List<Question> questions;

    public QuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.bind(question);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionText;
        RadioGroup optionsRadioGroup;
        RadioButton option1, option2, option3, option4;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionText);
            optionsRadioGroup = itemView.findViewById(R.id.optionsRadioGroup);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
        }

        public void bind(Question question) {
            questionText.setText(question.getQuestionText());
            option1.setText(question.getOptions().get(0));
            option2.setText(question.getOptions().get(1));
            option3.setText(question.getOptions().get(2));
            option4.setText(question.getOptions().get(3));

            // Сбрасываем выбор
            optionsRadioGroup.clearCheck();
        }
    }
}