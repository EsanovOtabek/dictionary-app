package uz.lifepc.dictionarytest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class main3 extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Dbhelper dbhelper;

    ArrayList<String> listitems=new ArrayList<>();
    ArrayAdapter<String> adapter;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle("Синонимия");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(("#0099ff"))));

        dbhelper=new Dbhelper(this);
        listView =findViewById(R.id.list1);
        listitems=dbhelper.getWord(3);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listitems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            dialog(adapter.getItem(position));
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        query=query.trim();
        if (query.length()>0) {
            Toast.makeText(this, query, Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.trim();
        adapter.getFilter().filter(newText);
        adapter.notifyDataSetChanged();
        return true;
    }

    private void dialog(String txt) {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setMessage(txt)
                .setPositiveButton("Ok", (dialog, which) -> dialog.cancel()).show();
    }
}