package com.example.mysqlandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.hardware.lights.LightState;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mysqlandroid.adapter.AdapterData;
import com.example.mysqlandroid.api.ApiRequestBiodata;
import com.example.mysqlandroid.api.Retroserver;
import com.example.mysqlandroid.model.DataModel;
import com.example.mysqlandroid.model.ResponsModel;
import com.example.mysqlandroid.model.TampilData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button tampilData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tampilData = (Button) findViewById(R.id.tampilkanData);

        ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);

        tampilData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godata = new Intent(MainActivity.this, TampilData.class);
                startActivity(godata);
            }
        });
    }
}