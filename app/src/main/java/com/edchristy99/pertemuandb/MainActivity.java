package com.edchristy99.pertemuandb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.edchristy99.pertemuandb.Database.AppDatabase;
import com.edchristy99.pertemuandb.Database.DataDiri;
import com.edchristy99.pertemuandb.Database.DataDiriDAO;

public class MainActivity extends AppCompatActivity {

    private AppDatabase appDatabase;
    private Button btnInput, btnRead;
    private EditText etNama, etAlamat, etJk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.iniDB(getApplicationContext());
        etAlamat = findViewById(R.id.et_alamat);
        etJk = findViewById(R.id.et_jk);
        etNama = findViewById(R.id.et_nama);

        btnRead=findViewById(R.id.btn_Read);
        btnInput = findViewById(R.id.btn_input);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nextReadActivity();
            }
        });

    }

    private void insertData(){
        //simpan ke string
            String Nama = etNama.getText().toString();
            String Alamat = etAlamat.getText().toString();
            char Jk = etJk.getText().toString().charAt(0);

            DataDiri item = new DataDiri();
            item.setNama(Nama);
            item.setAlamat(Alamat);
            item.setJk(Jk);



        //panggil fungsi insert data
        appDatabase.dao().insertData(item);
        etNama.setText("");
        etJk.setText("");
        etJk.setText("");
    }

    public void nextReadActivity(){
        Intent intent = new Intent(this,ReadActivity.class);
        this.startActivity(intent);
    }


}
