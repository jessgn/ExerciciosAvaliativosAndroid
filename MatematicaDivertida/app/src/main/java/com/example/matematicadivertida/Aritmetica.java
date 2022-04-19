package com.example.matematicadivertida;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Aritmetica extends AppCompatActivity {

    Random r = new Random();
    String[] operandos;
    int qtd =0;
    int aux = 1;
    int pontos= 0;
    int num1, num2, result =0;
    String operando;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);
    }

    public void nextAri(View view){
        if(aux < 5){
            operandos= new String[]{ "+", "-" };
            TextView inputA = findViewById(R.id.textViewOutputAri);
            num1 = r.nextInt(10);
            num2 = r.nextInt(10);
            operando = operandos[r.nextInt(1)];
            String message;

            if (operando == "+"){
                result = num1 + num2;
            }else {
                result = num1 - num2;
            }
            inputA.setText(String.valueOf(num1) + operando + String.valueOf(num2));

            EditText respostaIn = findViewById(R.id.editTextNumberAri);
             if (respostaIn.getText().length() < 0){
                 Toast.makeText(this, "Insira uma resposta válida", Toast.LENGTH_LONG).show();
             }else{
                 int resposUsu = Integer.parseInt(respostaIn.getText().toString());
                  if(resposUsu == result){
                      message = "A resposta está correta!";
                  }else{
                      message = "A resposta está incorreta! \n A resposta certa é " + result;
                  }
                 new AlertDialog.Builder(this)
                         .setTitle("Resposta")
                         .setMessage(message)
                         .show();
             }
        }
    }
}