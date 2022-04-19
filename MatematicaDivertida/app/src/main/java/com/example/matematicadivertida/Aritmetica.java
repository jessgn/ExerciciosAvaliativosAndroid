package com.example.matematicadivertida;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
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
    int aux = 0;
    int pontos= 0;
    int num1, num2, result =0;
    String operando;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);
        operandos= new String[]{ "+", "-"};
        TextView inputA = findViewById(R.id.textViewOutputAri);
        num1 = r.nextInt(10);
        num2 = r.nextInt(10);
        operando = operandos[r.nextInt(2)];

        if (operando == "+"){
            result = num1 + num2;
        }else {
            result = num1 - num2;
        }
        inputA.setText(String.valueOf(num1) + operando + String.valueOf(num2));
    }

    public void nextAri(View view){
        String message;
        if(aux < 5){
            EditText respostaIn = findViewById(R.id.editTextNumberAri);
             if (respostaIn.getText().length() < 0){
                 Toast.makeText(this, "Insira uma resposta válida", Toast.LENGTH_LONG).show();
             }else{
                 int resposUsu = Integer.parseInt(respostaIn.getText().toString());
                  if(resposUsu == result){
                      message = "A resposta está correta!";
                      pontos += 20;
                  }else{
                      message = "A resposta está incorreta! \n A resposta certa é " + result;
                  }
                 new AlertDialog.Builder(this)
                         .setTitle("Resposta")
                         .setMessage(message)
                         .show();
                  aux++;

                 operandos= new String[]{ "+", "-" };
                 TextView inputA = findViewById(R.id.textViewOutputAri);
                 num1 = r.nextInt(10);
                 num2 = r.nextInt(10);
                 int op = r.nextInt(2);
                 operando = operandos[op];

                 if (operando == "+"){
                     result = num1 + num2;
                 }else {
                     result = num1 - num2;
                 }
                 inputA.setText(String.valueOf(num1) + operando + String.valueOf(num2));
                 respostaIn.setText("");
             }
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Fim de jogo!")
                    .setMessage("A pontuação é " + pontos)
                    .show();
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
            finish();
        }
    }
}