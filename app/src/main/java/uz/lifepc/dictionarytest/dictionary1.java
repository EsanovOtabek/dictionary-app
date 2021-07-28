package uz.lifepc.dictionarytest;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dictionary1 extends AppCompatActivity {
    WebView txt_value;
    TextView txt_key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary1);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("key1", "Xa'tolik");
        String main = bundle.getString("key2", "Xa'tolik");
        int dyctype = getClassName(main);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(("#0099ff"))));

        txt_value = findViewById(R.id.txt_value);
        txt_key = findViewById(R.id.txt_key);

        Dbhelper dbhelper = new Dbhelper(this);

        Word word = dbhelper.getWord(title, dyctype);
        txt_key.setText(title);
        String txt=word.value;
        txt_value.loadData(txt, "text/html", "UTF-8");
    }

    public int getClassName(String str) {
        int ss;
        switch (str) {
            case "main1":
                ss=1;
                break;
            case "main2":
                ss=2;
                break;
            case "main3":
                ss=3;
                break;
            case "main4":
                ss=4;
                break;
            default:
                ss=5;
        }
        return ss;
    }
}