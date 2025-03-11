package com.example.test4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private List<Test> testList;
    private OnTestClickListener onTestClickListener;

    public TestAdapter(List<Test> testList, OnTestClickListener onTestClickListener) {
        this.testList = testList;
        this.onTestClickListener = onTestClickListener;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new TestViewHolder(view, onTestClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        Test test = testList.get(position);
        holder.bind(test);
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView testTitle;
        OnTestClickListener onTestClickListener;

        public TestViewHolder(@NonNull View itemView, OnTestClickListener onTestClickListener) {
            super(itemView);
            this.onTestClickListener = onTestClickListener;
            testTitle = itemView.findViewById(R.id.testTitle);
            itemView.setOnClickListener(this);
        }

        public void bind(Test test) {
            testTitle.setText(test.getTitle());
        }

        @Override
        public void onClick(View v) {
            onTestClickListener.onTestClick(getAdapterPosition());
        }
    }

    public interface OnTestClickListener {
        void onTestClick(int position);
    }
}