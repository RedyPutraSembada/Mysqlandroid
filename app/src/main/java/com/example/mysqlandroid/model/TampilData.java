package com.example.mysqlandroid.model;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysqlandroid.R;
import com.example.mysqlandroid.adapter.AdapterData;
import com.example.mysqlandroid.api.ApiRequestBiodata;
import com.example.mysqlandroid.api.Retroserver;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilData {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataModel> mItems = new ArrayList<>();
    ProgressDialog pd;
    private Bundle savedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProgressDialog(this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
        Call<ResponsModel> gdata = api.getBiodata();
        gdata.enqueue(new Callback<ResponsModel>(){
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response){
                pd.hide();
                Log.d("RETRO", "RESPONSE  : " + response.body().getKode());
                mItems = response.body().getResult();

                mAdapter = new AdapterData(TampilData.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged(); A
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");
            }
        });
    }
}
