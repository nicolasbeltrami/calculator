package com.example.practica_02_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isOpPress = false;

    private  double primerNumero = 0;

    private int segundoNumeroIndex = 0;

    private char operacionActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button division = findViewById(R.id.division);
        final Button multiplicacion = findViewById(R.id.multiplicacion);
        final Button punto = findViewById(R.id.punto);
        final Button suma = findViewById(R.id.suma);
        final Button resta = findViewById(R.id.resta);
        final Button igual = findViewById(R.id.igual);
        final Button borrar = findViewById(R.id.borrar);
        final Button limpiar = findViewById(R.id.limpiar);


        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int id = view.getId();
                switch (id){
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.punto:
                        calculatorScreen.append(".");
                        break;
                    case R.id.suma:
                        String screenContentSuma = calculatorScreen.getText().toString();
                        segundoNumeroIndex = screenContentSuma.length() + 1;
                        primerNumero = Double.parseDouble(screenContentSuma);
                        calculatorScreen.append("+");
                        isOpPress = true;
                        operacionActual = '+';
                        break;
                    case R.id.resta:
                        String screenContentResta = calculatorScreen.getText().toString();
                        segundoNumeroIndex = screenContentResta.length() + 1;
                        primerNumero = Double.parseDouble(screenContentResta);
                        calculatorScreen.append("-");
                        isOpPress = true;
                        operacionActual = '-';
                        break;
                    case R.id.multiplicacion:
                        String screenContentMult = calculatorScreen.getText().toString();
                        segundoNumeroIndex = screenContentMult.length() + 1;
                        primerNumero = Double.parseDouble(screenContentMult);
                        calculatorScreen.append("*");
                        isOpPress = true;
                        operacionActual = '*';
                        break;
                    case R.id.division:
                        String screenContentDiv = calculatorScreen.getText().toString();
                        segundoNumeroIndex = screenContentDiv.length() + 1;
                        primerNumero = Double.parseDouble(screenContentDiv);
                        calculatorScreen.append("+");
                        isOpPress = true;
                        operacionActual = '+';
                        break;
                    case R.id.igual:
                        if( isOpPress ){
                            if (operacionActual =='+'){
                                String screenContentSum = calculatorScreen.getText().toString();
                                double segundoNumero = Double.parseDouble(screenContentSum.substring(segundoNumeroIndex,screenContentSum.length()));
                                segundoNumero += primerNumero;
                                calculatorScreen.setText(String.valueOf(segundoNumero));
                            }if (operacionActual =='-'){
                                String screenContentRes = calculatorScreen.getText().toString();
                                double segundoNumero = Double.parseDouble(screenContentRes.substring(segundoNumeroIndex,screenContentRes.length()));
                                segundoNumero -= primerNumero;
                                calculatorScreen.setText(String.valueOf(segundoNumero));
                            }if (operacionActual =='*'){
                                String screenContentM = calculatorScreen.getText().toString();
                                double segundoNumero = Double.parseDouble(screenContentM.substring(segundoNumeroIndex,screenContentM.length()));
                                segundoNumero *= primerNumero;
                                calculatorScreen.setText(String.valueOf(segundoNumero));
                            }if (operacionActual =='/'){
                                String screenContentD = calculatorScreen.getText().toString();
                                double segundoNumero = Double.parseDouble(screenContentD.substring(segundoNumeroIndex,screenContentD.length()));
                                segundoNumero /= primerNumero;
                                calculatorScreen.setText(String.valueOf(segundoNumero));
                            }
                        }

                        break;
                    case R.id.borrar:

                        break;
                    case R.id.limpiar:

                        break;

                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        punto.setOnClickListener(calculatorListener);
        igual.setOnClickListener(calculatorListener);
        suma.setOnClickListener(calculatorListener);
        resta.setOnClickListener(calculatorListener);
        multiplicacion.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        borrar.setOnClickListener(calculatorListener);
        limpiar.setOnClickListener(calculatorListener);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayElements = calculatorScreen.getText().toString();
                int largo = displayElements.length();
                if(largo > 0) {
                    displayElements = displayElements.substring(0, largo - 1);
                    calculatorScreen.setText(displayElements);
                }
            }
        });
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorScreen.setText("");
            }
        });

    }

}
