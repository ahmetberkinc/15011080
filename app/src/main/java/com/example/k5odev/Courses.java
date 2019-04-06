package com.example.k5odev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Courses extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ArrayList<ExampleCourse> exampleCourses=new ArrayList<>();
        exampleCourses.add(new ExampleCourse("Bilgisayar Bilimlerine Giriş","100","61","70 70 70"));
        exampleCourses.add(new ExampleCourse("Fizik 1","60","58","40 40 60"));
        exampleCourses.add(new ExampleCourse("Matematik 1","70","66","70 70 60"));
        exampleCourses.add(new ExampleCourse("Lineer Cebir","75","45","70 90 40"));
        exampleCourses.add(new ExampleCourse("Yapısal Programlamaya Giriş","90","46","80 90 100"));
        exampleCourses.add(new ExampleCourse("Veritabanı Yönetimi","70","41","50 60 70"));
        exampleCourses.add(new ExampleCourse("Matematik 2","90","54","60 80 70"));
        exampleCourses.add(new ExampleCourse("İstatistik ve Olasılık Hesapları","40","53","80 47 99"));
        exampleCourses.add(new ExampleCourse("Alt Seviye Programlama","47","52","90 80 70"));
        exampleCourses.add(new ExampleCourse("Ayrık Matematik","78","49","82 80 66"));
        exampleCourses.add(new ExampleCourse("Veri Yapıları ve Algoritmalar","150","53","56 58 62"));



        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleCourses);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
