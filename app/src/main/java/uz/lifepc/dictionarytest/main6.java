package uz.lifepc.dictionarytest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class main6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getSupportActionBar().setTitle("Фойдаланилган адабиётлар рўйхати");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(("#0099ff"))));

    }
}