package com.edchristy99.pertemuandb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.edchristy99.pertemuandb.Database.DataDiri;

import java.util.ArrayList;
import java.util.List;

public class DataDiriAdapter extends RecyclerView.Adapter<DataDiriAdapter.ViewHolder>{
    private  DataDiriListener listener;
    private List<DataDiri>dataDiris;
    public Context context;
    public String nama, alamat;
    public  int id;
    public char jk;



    public DataDiriAdapter(DataDiri[]list, DataDiriListener listener) {
        this.context= context;
        this.listener = listener;
    }

    public List<DataDiri> getDataDiris() {
        return dataDiris;
    }

    public void setDataDiris(List<DataDiri> dataDiris) {
        this.dataDiris = dataDiris;
    }


    @NonNull
    @Override
    public DataDiriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_diri_item, parent, false);
        return new ViewHolder(itemRow);
    }
    @Override
    public void onBindViewHolder(@NonNull DataDiriAdapter.ViewHolder holder, final int position) {
        holder.tvNama.setText(getDataDiris().get(position).getNama());
        holder.tvAlamat.setText(getDataDiris().get(position).getAlamat());
        holder.tvJk.setText(getDataDiris().get(position).getJk());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonDelete(getDataDiris().get(position));
            }
        });



    }


    private void setContentView(int activity_data_diri_adapter) {
    }




    @Override
    public int getItemCount() {
        return list.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvAlamat, tvJk;
        private Button btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvJk = itemView.findViewById(R.id.tv_jk);
            tvNama = itemView.findViewById(R.id.tv_nama);
            btnDelete = itemView.findViewById(R.id.btn_Delete);




        }
    }
}
