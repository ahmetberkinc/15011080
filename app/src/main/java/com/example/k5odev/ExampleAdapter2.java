package com.example.k5odev;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExampleAdapter2 extends RecyclerView.Adapter<ExampleAdapter2.ExampleViewHolder> {
    private ArrayList<ExampleCourse> mexampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView course_name2,points2;
        public RelativeLayout relative_layout;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            course_name2 = itemView.findViewById(R.id.course_name2);
            points2 = itemView.findViewById(R.id.points2);
            relative_layout = (RelativeLayout)itemView.findViewById(R.id.relative_layout);
        }
    }

    public ExampleAdapter2(ArrayList<ExampleCourse> exampleList){
        mexampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_course2,viewGroup,false);
        ExampleViewHolder exampleViewHolder =new ExampleViewHolder(v);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        ExampleCourse currentcourse = mexampleList.get(i);
        exampleViewHolder.course_name2.setText(currentcourse.getCourse_name());
        Log.d("myTag", currentcourse.getCourse_name());
        exampleViewHolder.points2.setText(currentcourse.getPoints());
        Log.d("myTag", currentcourse.getPoints());

        exampleViewHolder.relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(),Courses.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mexampleList.size();
    }
}
