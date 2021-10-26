package com.example.mysqlandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysqlandroid.R;
import com.example.mysqlandroid.model.DataModel;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    public AdapterData(Context ctx, List<DataModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = mList.get(position);
        holder.nama.setText(dm.getNama());
        holder.npm.setText(dm.getNpm());
        holder.prodi.setText(dm.getProdi());
        holder.fakultas.setText(dm.getFakultas());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView nama, npm, prodi, fakultas;
        public HolderData(View v){
            super(v);

            nama = (TextView) v.findViewById(R.id.viewNama);
            npm = (TextView) v.findViewById(R.id.viewNpm);
            prodi = (TextView) v.findViewById(R.id.viewProdi);
            fakultas = (TextView) v.findViewById(R.id.viewFakultas);
        }
    }
}
