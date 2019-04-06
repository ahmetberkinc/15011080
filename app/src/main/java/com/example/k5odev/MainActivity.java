package com.example.k5odev;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//NESTED İF
//DOGUM TARİHİNDEN YASINI BULUP ONU KAYDETMEMİZ LAZIM
//ıntent tiplerini işledik
//CALLİNG A NUMBER,SHOWİNG LOCATİON ON A MAP, VİEWİNG A WEBPAGE ON A BROWSER ÖRNEK İNTENT TİPLERİ
//SENDİNG A EMAİL CREATİNG AND ADDİNG(ACTION_SEND)AND CALENDAR EVENT(ACTION_INSERT)
//INTENTİ MODİFİYE EDEBİLİYORUZ EKSTRA ÖZELLİKLER EKLEYEBİLİYORUZ
//BİZİM UYGULAMAMIZI GERÇEKLEİTREBELİECEK EKLENTİ VARMI DİYE KONTROL EDİYORUZ
//BAZI İŞLERİ YAPTIRABİLECEĞİMİZ KAÇ FARKLI UYGULAMA VAR BUNU KULLANABİLİRİZ
//BELİRLİ PATTERNLERİ VAR
//APP CHOOSER EKRANI KULLANARAK HER ZAMAN AYNI UYGULAMAYI KULLANMAYI ENGELLEYEBİLİRİZ
//START ACTİVTY STARTACTİTY FOR RESULT
//INTENT ACTIONLARINI İNCELE
//TELEFON NUMARASI AL ÖBÜR SAYFAYA AKTAR BUTONA BASARAK KİŞİYİ ARAYABİLMEYİ SAĞLAMALIYIZ

public class MainActivity extends AppCompatActivity {
    private Uri selectedImage;
    Spinner gun;
    Spinner yil;
    Spinner ay;
    EditText ad;
    Intent gecis;
    EditText numara;
    EditText soyad;
    EditText mail;
    Spinner dogum_yeri;
    EditText tc;
    Button temizle;
    Button resim;
    Context context=this;
    ImageView img;
    private static  final int REQUEST_CODE=1;
    private Button kaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gun=(Spinner)findViewById(R.id.gun);
        numara=(EditText)findViewById(R.id.numara);
        temizle=(Button)findViewById(R.id.clear);
        ay=(Spinner)findViewById(R.id.ay);
        yil=(Spinner)findViewById(R.id.yil);
        ad=(EditText)findViewById(R.id.ad);
        mail=(EditText)findViewById(R.id.mail);
        tc=(EditText)findViewById(R.id.tc);
        soyad=(EditText)findViewById(R.id.soyad);
        kaydet=(Button)findViewById(R.id.kaydet);
        dogum_yeri=(Spinner)findViewById(R.id.dogum_yeri);
        resim=(Button)findViewById(R.id.resim);
        img=(ImageView)findViewById(R.id.img);

        this.resim.setOnClickListener(new ImagePıckListener());

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedImage != null) {
                    openSaveActivity();
                }
                else
                    Toast.makeText(getApplicationContext(),"Lütfen Resim Seçiniz",Toast.LENGTH_SHORT).show();
            }
        });

        //TUM FORMU TEMİZLEMESİ LAZIM
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.setText("");
                soyad.setText("");
                tc.setText("");
                numara.setText("");
                gun.setSelection(0);
                ay.setSelection(0);
                yil.setSelection(0);
                mail.setText("");
                dogum_yeri.setSelection(0);
                img.setImageURI(null);
            }
        });


        gun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"Secilen Gun "+ parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        ay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"Secilen Ay "+ parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        yil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"Secilen Yil "+ parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    class ImagePıckListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent1=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent1.setType("image/*");
            startActivityForResult(Intent.createChooser(intent1,"Resim yukle"),REQUEST_CODE);
        }
    }
    public void onActivityResult(int requestcode,int resultcode,Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(resultcode == Activity.RESULT_OK && data!=null){
            switch (requestcode){
                case REQUEST_CODE:
                    selectedImage = data.getData();
                    img.setImageURI(selectedImage);
                    break;
                    default:
                        break;
            }
        }
    }

    public void openSaveActivity(){
        String text =ad.getText().toString();
        String text2=soyad.getText().toString();
        String text3=dogum_yeri.getSelectedItem().toString();
        String text4=gun.getSelectedItem().toString();
        String text5=ay.getSelectedItem().toString();
        String text6=yil.getSelectedItem().toString();
        String text7=tc.getText().toString();
        String text8=numara.getText().toString();
        Intent gecis = new Intent(this,SaveActivity.class);
        gecis.putExtra("AD",text);
        gecis.putExtra("SOYAD",text2);
        gecis.putExtra("DOGUM_YERI",text3);
        gecis.putExtra("GUN",text4);
        gecis.putExtra("AY",text5);
        gecis.putExtra("YIL",text6);
        gecis.putExtra("TC",text7);
        gecis.putExtra("NUMARA",text8);
        gecis.putExtra("RESIM",selectedImage.toString());
        gecis.putExtra("MAIL",mail.getText().toString());
        startActivity(gecis);
    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelable("uri",selectedImage);

    }

    protected void onRestoreInstanceState(Bundle savedInstaceState){
        super.onRestoreInstanceState(savedInstaceState);
        selectedImage = savedInstaceState.getParcelable("uri");
        img.setImageURI(selectedImage);
    }



}
