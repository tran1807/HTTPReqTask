package com.example.httpreqtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.httpreqtask.adapter.ProductAdapter;
import com.example.httpreqtask.models.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.httpreqtask.util.config.*;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    RecyclerView rcv;
    ProductAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = findViewById(R.id.button);
        rcv = findViewById(R.id.rcv_product);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (new HTTPReqTask()).execute();
            }
        });
    }
    private class HTTPReqTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            try {
                Request.Builder builder = new Request.Builder();
                builder.url(BASE_URL_API);
                Request request = builder.build();
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            return "[]";
        }

        @Override
        protected void onPostExecute(String data) {
            Log.i("finish", "good");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Product>>(){}.getType();
            List<Product> productList = gson.fromJson(data, type);
            adapter = new ProductAdapter(productList,getApplicationContext());
            rcv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            Log.i("data", productList.size() + "");
        }
    }
}