package uz.lifepc.dictionarytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;


public class about extends AppCompatActivity {
    ImageButton tg_btn,tel_btn,mail_btn,mail_btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("Biz haqimizda");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(("#0099ff"))));

        tg_btn=findViewById(R.id.imb1);
        tel_btn=findViewById(R.id.imb3);
        mail_btn=findViewById(R.id.imb2);
        mail_btn2=findViewById(R.id.imb4);

        tg_btn.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/Dilnoza1983"));
            startActivity(intent);
        });

        tel_btn.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:+998933401683"));
            startActivity(intent);
        });

        mail_btn.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:dilnozayuldasheva1983@gmail.com"));
            startActivity(intent);
        });

        mail_btn2.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:dilnoza.yuldasheva@univ-silkroad.uz"));
            startActivity(intent);
        });
    }

}