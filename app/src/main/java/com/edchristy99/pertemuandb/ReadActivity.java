package com.edchristy99.pertemuandb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.edchristy99.pertemuandb.Database.AppDatabase;
import com.edchristy99.pertemuandb.Database.DataDiri;

public class ReadActivity extends AppCompatActivity  {
    private AppDatabase appDatabase;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        //iniDB
        appDatabase = AppDatabase.iniDB(getApplicationContext());
        recyclerView = findViewById(R.id.rvMain);
        recyclerView.setHasFixedSize(true);

        //di bukaaa
        read();
    }

    private void read() {
        final DataDiri[] list = appDatabase.dao().getData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //tampikin je recycle View
        DataDiriAdapter adapter = new DataDiriAdapter(this, new DataDiriListener() {
            @Override
            public void onButtonDelete(DataDiri item) {
                appDatabase.dao().deleteData(item);
                list.clear();
                read();
            }
        });
        adapter.setHasStableIds(list);
    }
}
