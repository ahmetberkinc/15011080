package com.example.k5odev;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SaveActivity extends AppCompatActivity {
String txt;
String txt2;
String txt3;
private static final int REQUEST_CALL = 1;
private TextView fnumara;
private TextView feposta;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        TextView fad;
        Button dersler;
        TextView fsoyad;
        TextView fdogum_yeri;
        TextView fdogum_tarihi;
        ImageView fresim;
        ImageView fara;
        ImageView fmail;
        TextView ftc;
        fnumara=(TextView)findViewById(R.id.fnumara);
        fmail=(ImageView)findViewById(R.id.fmail);
        dersler=(Button)findViewById(R.id.dersler);
        fara=(ImageView)findViewById(R.id.fara);
        fad=(TextView)findViewById(R.id.fad);
        feposta=(TextView)findViewById(R.id.feposta);
        fresim=(ImageView)findViewById(R.id.fresim);
        fsoyad=(TextView)findViewById(R.id.fsoyad);
        fdogum_yeri=(TextView)findViewById(R.id.fdogum_yeri);
        fdogum_tarihi=(TextView)findViewById(R.id.fdogum_tarihi);
        ftc=(TextView)findViewById(R.id.ftc);
        txt=getIntent().getExtras().getString("AD");
        fad.setText(txt);
        txt=getIntent().getExtras().getString("SOYAD");
        fsoyad.setText(txt);
        txt=getIntent().getExtras().getString("DOGUM_YERI");
        fdogum_yeri.setText(txt);
        txt=getIntent().getExtras().getString("GUN");
        txt2=getIntent().getExtras().getString("AY");
        txt3=getIntent().getExtras().getString("YIL");
        fdogum_tarihi.setText(txt+"/"+txt2+"/"+txt3);
        txt=getIntent().getExtras().getString("TC");
        ftc.setText(txt);
        txt=getIntent().getExtras().getString("NUMARA");
        fnumara.setText(txt);
        feposta.setText(getIntent().getExtras().getString("MAIL"));
        Intent intent=getIntent();
        //Bitmap bitmap=(Bitmap)getIntent().getParcelableExtra("Resim");
        //fresim.setImageBitmap(bitmap);
        //Bundle extras = getIntent().getExtras();
        String imageUrl = getIntent().getStringExtra("RESIM");
        Uri myUri =Uri.parse(imageUrl);
        fresim.setImageURI(myUri);


        fara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });



        dersler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDersler();
            }
        });

        fmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail(){
        String madress = feposta.getText().toString();
        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,madress);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));
    }

    private void makePhoneCall(){
        String number = fnumara.getText().toString();
        if(number.trim().length() > 0){

        if(ContextCompat.checkSelfPermission(SaveActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(SaveActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

        }else{
            String dial = "tel:"+number;
            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
        }

        }else{
            Toast.makeText(SaveActivity.this,"Numara Giriniz",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(this,"İzin Verilmedi",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openDersler(){
        //Intent dersler=new Intent(this,Courses.class);
        //startActivity(dersler);
        ArrayList<ExampleCourse> exampleCourses2=new ArrayList<>();
        exampleCourses2.add(new ExampleCourse("Bilgisayar Bilimlerine Giriş","100","61","70 70 70"));
        exampleCourses2.add(new ExampleCourse("Fizik 1","60","58","40 40 60"));
        exampleCourses2.add(new ExampleCourse("Matematik 1","70","66","70 70 60"));
        exampleCourses2.add(new ExampleCourse("Lineer Cebir","75","45","70 90 40"));
        exampleCourses2.add(new ExampleCourse("Yapısal Programlamaya Giriş","90","46","80 90 100"));
        exampleCourses2.add(new ExampleCourse("Veritabanı Yönetimi","70","41","50 60 70"));
        exampleCourses2.add(new ExampleCourse("Matematik 2","90","54","60 80 70"));
        exampleCourses2.add(new ExampleCourse("İstatistik ve Olasılık Hesapları","40","53","80 47 99"));
        exampleCourses2.add(new ExampleCourse("Alt Seviye Programlama","47","52","90 80 70"));
        exampleCourses2.add(new ExampleCourse("Ayrık Matematik","78","49","82 80 66"));
        exampleCourses2.add(new ExampleCourse("Veri Yapıları ve Algoritmalar","150","53","56 58 62"));
        recyclerView = findViewById(R.id.recyclerView);
        //performansla alakalı
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new ExampleAdapter2(exampleCourses2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
