package uz.lifepc.dictionarytest;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("ОРНИТОНИМЛАРНИНГ ИЗОҲЛИ ЛУҒАТИ");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(("#0099ff"))));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater1=getMenuInflater();
        inflater1.inflate(R.menu.tool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:{
                Intent i1=new Intent(MainActivity.this,about.class);
                startActivity(i1);
                return  true;
            }
            case R.id.logout:{
                finish();
                System.exit(3);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
/****---- tezkor funksiyalar ----****/
    public void card1_go(View view) {
        goIntent(main1.class);
    }
    public void card2_go(View view) {
        goIntent(main2.class);
    }
    public void card3_go(View view) {
        goIntent(main3.class);
    }
    public void card4_go(View view) {
        goIntent(main4.class);
    }
    public void card5_go(View view) {
        goIntent(main5.class);
    }
    public void card6_go(View view) {
        goIntent(main6.class);
    }

    void goIntent(Class mClass){
        Intent intent1=new Intent(MainActivity.this,mClass);
        startActivity(intent1);
    }
}