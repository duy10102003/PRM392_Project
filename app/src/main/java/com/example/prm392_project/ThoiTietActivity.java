package com.example.prm392_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThoiTietActivity extends AppCompatActivity {
    EditText edtSearch;
    Button btnSearch, btnChangeActivity;
    ImageView imgIcon;
    TextView txtThanhpho,txtQuocGia,txtNhietDo,txtTrangThai,txtDoam, txtGio, txtMay, txtNgayCapNhat;

    String City = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoi_tiet);
        edtSearch = findViewById(R.id.edittextSearch);
        btnSearch = findViewById(R.id.btnSearch);
        // btnChangeActivity = findViewById(R.id.btnChangeActivity);
        txtThanhpho = findViewById(R.id.textviewThanhpho);
        txtQuocGia = findViewById(R.id.textviewQuocGia);
        txtNhietDo = findViewById(R.id.textviewNhietDo);
        txtTrangThai = findViewById(R.id.textviewTrangThai);
        txtGio = findViewById(R.id.textviewGio);
        txtDoam = findViewById(R.id.textviewDoam);
        txtMay = findViewById(R.id.textviewMay);
        txtNgayCapNhat = findViewById(R.id.textviewNgayCapNhat);
        imgIcon = findViewById(R.id.imgIcon);
        GetCurrentWeatherData("Hanoi");
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtSearch.getText().toString();
                if (city.equals("")){
                    City = "Hanoi";
                    GetCurrentWeatherData(City);
                }
                else {
                    City = city;
                    GetCurrentWeatherData(city);
                }

            }
        });


    }
    public void GetCurrentWeatherData(String data){

    }

}