package com.example.projecttimtro.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projecttimtro.HostelListAdapter;
import com.example.projecttimtro.R;
import com.example.projecttimtro.models.address.Province;
import com.example.projecttimtro.models.hostel.HostelModel;
import com.example.projecttimtro.services.Api_Services;
import com.example.projecttimtro.services.InstanceServerLocal;
import com.example.projecttimtro.services.InstanceServerProvinces;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements InstanceServerLocal, InstanceServerProvinces {

    RecyclerView recyclerViewHostels;
    HostelListAdapter mAdapter;
    List<HostelModel> hostelModelList;
    List<Province> provinceList;
    Spinner spinnerProvince;


    private void bindingElement(){
        recyclerViewHostels = findViewById(R.id.recyclerviewHostel);
        spinnerProvince = findViewById(R.id.spinnerLocation);
        hostelModelList = new ArrayList<HostelModel>();
        provinceList = new ArrayList<Province>();
    }

    private void bindingAction(){

    }

    public void getHostels(List<HostelModel> hostelModelList, String value){
        String mess ="address";
        Api_Services rest_api = retrofitLocal.create(Api_Services.class);
        rest_api.getHostelsByAddress(mess, value)
                .enqueue(new Callback<List<HostelModel>>() {

                    @Override
                    public void onResponse(Call<List<HostelModel>> call, Response<List<HostelModel>> response) {
                        Log.i("check size response",""+response.body().size());
                        mAdapter.setData(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<HostelModel>> call, Throwable t) {
                        Log.i("check size error",""+t.toString());
                    }
                });
    }

    public void getProvinces(){
        Api_Services rest_api = retrofitProvince.create(Api_Services.class);
        Log.i("Call API PROVINCE","Thanh Cong");
        rest_api.getProvinces().enqueue(new Callback<List<Province>>() {
                    @Override
                    public void onResponse(Call<List<Province>> call, Response<List<Province>> response) {
                        Log.i("GET PROVINCES:","Successfully");
                        mAdapter = new HostelListAdapter( HomeActivity.this);
                        recyclerViewHostels.setAdapter(mAdapter);
                        recyclerViewHostels.setLayoutManager(new GridLayoutManager(HomeActivity.this, 2));
                        provinceList.addAll(response.body());
                        List<String> nameProvincesList = new ArrayList<>();
                        for (Province p: provinceList) {
                            nameProvincesList.add(p.getName());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(HomeActivity.this,
                                android.R.layout.simple_spinner_dropdown_item, nameProvincesList);

                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerProvince.setAdapter(adapter);
                        spinnerProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(HomeActivity.this, nameProvincesList.get(i), Toast.LENGTH_SHORT).show();
                                getHostels(hostelModelList, nameProvincesList.get(i));
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<List<Province>> call, Throwable t) {
                        Log.i("Provinces Failed","Failed!!!!"+t.toString());
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindingElement();
        getProvinces();
    }


}