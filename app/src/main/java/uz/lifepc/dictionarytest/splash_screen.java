package uz.lifepc.dictionarytest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView longimg = findViewById(R.id.longimg);
        longimg.setOnLongClickListener(v -> {
            AlertDialog alertDialog=new AlertDialog.Builder(this).
                    setTitle("Dasturchi haqida:")
                    .setMessage("Esanov Otabek, (www.lifepc.uz)")
                    .setPositiveButton("Ok\uD83D\uDE01", (dialog, which) -> dialog.cancel()).show();

            return true;
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splash_screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3333);
    }
}