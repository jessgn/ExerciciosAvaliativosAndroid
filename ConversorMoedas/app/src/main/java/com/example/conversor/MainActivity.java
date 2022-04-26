package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conversor.api.RetrofitConfig;
import com.example.conversor.model.Currency;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RadioButton deReal, deDolar, deEuro, deEth, deBtc;
    RadioButton paraReal, paraDolar, paraEuro, paraEth, paraBtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void currencyCalc(View view) {
        deReal = findViewById(R.id.radioButtonDeReal);
        deDolar = findViewById(R.id.radioButtonDeDolar);
        deEuro = findViewById(R.id.radioButtonDeEuro);
        deEth = findViewById(R.id.radioButtonDeEthereum);
        deBtc = findViewById(R.id.radioButtonDeBitcoin);
        paraReal = findViewById(R.id.radioButtonParaReal);
        paraDolar = findViewById(R.id.radioButtonParaDolar);
        paraEuro = findViewById(R.id.radioButtonParaEuro);
        paraEth = findViewById(R.id.radioButtonParaEthereum);
        paraBtc = findViewById(R.id.radioButtonParaBitcoin);

        EditText input = findViewById(R.id.editTextInput);
        TextView output = findViewById(R.id.textViewOutput);

        RadioGroup groupDe = findViewById(R.id.radioGroup);
        int selectedDe = groupDe.getCheckedRadioButtonId();
        RadioButton selectedDeButton = findViewById(selectedDe);

        RadioGroup groupPara = findViewById(R.id.radioGroup3);
        int selectedPara = groupDe.getCheckedRadioButtonId();
        RadioButton selectedParaButton = findViewById(selectedDe);

        double inputMoney = Double.parseDouble(input.getText().toString());
        double outputMoney = 0;

        String de = selectedDeButton.getText().toString();
        String para = selectedParaButton.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setMessage("Convertendo...");
        progressDialog.show();

        Call<HashMap<String, Currency>> call = new RetrofitConfig().getCurrencyService().getCurrentCurrency(de, para);
        call.enqueue(new Callback<HashMap<String, Currency>>() {
            @Override
            public void onResponse(Call<HashMap<String, Currency>> call, Response<HashMap<String, Currency>> response) {
                if(response.isSuccessful()) {
                    HashMap<String, Currency> currency = response.body();
                    String hashKey = de.toUpperCase() + para.toUpperCase();
                    progressDialog.setMessage(currency.get(hashKey).getBid());
//                    progressDialog.dismiss();
                } else {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<HashMap<String, Currency>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro inesperado, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });

    }
}