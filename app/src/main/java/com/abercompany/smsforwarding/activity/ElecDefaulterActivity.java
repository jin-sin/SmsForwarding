package com.abercompany.smsforwarding.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.abercompany.smsforwarding.R;
import com.abercompany.smsforwarding.databinding.ActivityElecDefaulterBinding;
import com.abercompany.smsforwarding.model.ElecDefaulter;
import com.abercompany.smsforwarding.model.GetElecDefaulter;
import com.abercompany.smsforwarding.util.NetworkUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElecDefaulterActivity extends AppCompatActivity {

    private ActivityElecDefaulterBinding binding;

    private List<ElecDefaulter> elecDefaulters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_elec_defaulter);
        binding.setElecDefaulter(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                break;
        }
    }

    private void getElecDefaulter() {
        Call<GetElecDefaulter> getElecDefaulterCall = NetworkUtil.getInstace().getElecDefaulter("");
        getElecDefaulterCall.enqueue(new Callback<GetElecDefaulter>() {
            @Override
            public void onResponse(Call<GetElecDefaulter> call, Response<GetElecDefaulter> response) {
                GetElecDefaulter getElecDefaulter = response.body();
                String result = getElecDefaulter.getResult();

                if ("success".equals(result)) {
                    elecDefaulters = getElecDefaulter.getElecDefaulterList();
                }
            }

            @Override
            public void onFailure(Call<GetElecDefaulter> call, Throwable t) {

            }
        });
    }

    private void setElecDefaulterAdapter(List<ElecDefaulter> elecDefaulters) {

    }
}
