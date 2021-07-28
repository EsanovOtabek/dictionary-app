package uz.lifepc.dictionarytest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class main5 extends AppCompatActivity implements SearchView.OnQueryTextListener {
    ArrayList<String> lists=new ArrayList<>(),lists2=new ArrayList<>();
    ArrayAdapter<String> adapter;
    String[] str={
            "А.Н.","НАТИЛ","Б.","Б-нома" ,"БЭ" ,"5-РУС" ,"Д" ,"ДЛТ" ,"ДТС" ,"Зд" ,
            "ЗЭ" ,"Инт.","К","КИРС","ПСС","РЎЛ","СТ","ТЁТ","ЎзМЭ","ЎзР","ЎИМ",
            "ЎШЛ","ЎТИЛ","ЎТИЛ -5","ЎТЭЛ","ЎТЎИЛ","ЎҲД","ЎХШЛ","ҚБД","ҚЎХС","ҚҚ"
    };
    int[] rid={
            R.string.adabiyot1,
            R.string.adabiyot2,
            R.string.adabiyot3,
            R.string.adabiyot4,
            R.string.adabiyot5,
            R.string.adabiyot6,
            R.string.adabiyot7,
            R.string.adabiyot8,
            R.string.adabiyot9,
            R.string.adabiyot10,
            R.string.adabiyot11,
            R.string.adabiyot12,
            R.string.adabiyot13,
            R.string.adabiyot14,
            R.string.adabiyot15,
            R.string.adabiyot16,
            R.string.adabiyot17,
            R.string.adabiyot18,
            R.string.adabiyot19,
            R.string.adabiyot20,
            R.string.adabiyot21,
            R.string.adabiyot22,
            R.string.adabiyot23,
            R.string.adabiyot24,
            R.string.adabiyot25,
            R.string.adabiyot26,
            R.string.adabiyot27,
            R.string.adabiyot28,
            R.string.adabiyot29,
            R.string.adabiyot30,
            R.string.adabiyot31
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().setTitle("Шартли қисқартмалар");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(("#0099ff"))));
        ListView listView = findViewById(R.id.listview);
        lists.addAll(Arrays.asList(str));
        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lists);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String title= adapter.getItem(position);
            dialog(id,title,position);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem searchitem=menu.findItem(R.id.menu_search);

        SearchView searchView= (SearchView) searchitem.getActionView();
        searchView.setQueryHint("Qidirish");
        searchView.setOnQueryTextListener(this);
        searchView.setIconified(false);
        return true;
    }

    private void dialog(long id, String title, int pos) {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(rid[pos])
                .setPositiveButton("Ok", (dialog, which) -> dialog.cancel()).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this,query,Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }

}