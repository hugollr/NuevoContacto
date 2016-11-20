package com.llavador.nuevocontacto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
//import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.DatePicker;
//import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Contacto este;
    TextInputEditText etNombre;
    DatePicker dpFecha;
    TextInputEditText etTelefono;
    TextInputEditText etEmail;
    TextInputEditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        dpFecha = (DatePicker) findViewById(R.id.dpFecha);
        etTelefono = (TextInputEditText) findViewById(R.id.etTelefono);
        etEmail  = (TextInputEditText) findViewById(R.id.etEmail);
        etDescripcion = (TextInputEditText) findViewById(R.id.etDescripcion);
    }

    protected void irASiguiente(View v){
        este = new Contacto(etNombre.getText().toString(),
                fechaATexto(),
                etTelefono.getText().toString(),
                etEmail.getText().toString(),
                etDescripcion.getText().toString());
        Intent intent = new Intent(MainActivity.this, MainConfirm.class);
        ArrayList<String> valores = este.valores();
        intent.putExtra("datos", valores);
        startActivity(intent);
    }

    private String fechaATexto(){
        StringBuilder salida = new StringBuilder();

        salida.append(dpFecha.getDayOfMonth()).append("-");
        salida.append(mesReal(dpFecha.getMonth())).append("-");
        salida.append(dpFecha.getYear());

        return salida.toString();
    }

    private String mesReal(Integer mes){
        String salida;

        mes++;
        if (mes < 10){
            salida = "0" + mes.toString();
        } else {
            salida = mes.toString();
        }
        return salida;
    }
}
