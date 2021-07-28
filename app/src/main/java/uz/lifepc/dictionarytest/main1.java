package uz.lifepc.dictionarytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class main1 extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Dbhelper dbhelper;

    ArrayList<String> listitems=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        dbhelper=new Dbhelper(this);

        getSupportActionBar().setTitle("Орнитонимлар");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(("#0099ff"))));
        listitems=dbhelper.getWord(1);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listitems);
        listView =findViewById(R.id.list1);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            String itemtxt= adapter.getItem(position);
            Intent intent=new Intent(main1.this,dictionary1.class);
            Bundle bundle=new Bundle();
            bundle.putString("key1",itemtxt);
            bundle.putString("key2","main1");

            intent.putExtras(bundle);
            startActivity(intent);
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

}