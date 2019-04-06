package com.example.k5odev;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExapleViewHolder> {
    private ArrayList<ExampleCourse> mexampleList;

    public static class ExapleViewHolder extends RecyclerView.ViewHolder{

        public TextView course_name,student_count,average_point;
        public ExapleViewHolder(@NonNull View itemView) {
            super(itemView);
            course_name = itemView.findViewById(R.id.course_name);
            student_count = itemView.findViewById(R.id.student_count);
            average_point = itemView.findViewById(R.id.average_point);
        }
    }

    public ExampleAdapter(ArrayList<ExampleCourse> exampleList){
        mexampleList = exampleList;
    }

    @NonNull
    @Override
    public ExapleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_course,viewGroup,false);
        ExapleViewHolder exapleViewHolder =new ExapleViewHolder(v);
        return exapleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExapleViewHolder exapleViewHolder, int i) {
        ExampleCourse currentcourse = mexampleList.get(i);

        exapleViewHolder.course_name.setText(currentcourse.getCourse_name());
        Log.d("myTag", currentcourse.getCourse_name());
        exapleViewHolder.student_count.setText(currentcourse.getStudent_count());
        exapleViewHolder.average_point.setText(currentcourse.getAverage_point());
    }

    @Override
    public int getItemCount() {
        return mexampleList.size();
    }
}
