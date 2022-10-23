package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityPostulanteInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);


        ArrayList<Postulante> registro = new ArrayList<Postulante>();

        //para probar funcionamiento
        Postulante p1 = new Postulante("Luis",
                "Condori", "Villalba",
                "01/01/2001", "San Francisco",
                "Ingenieria de Sistemas", "72800700");

        registro.add(p1);

        EditText buscarTexto = findViewById(R.id.editTextSearch);
        TextView txtDNI = findViewById(R.id.textDNI);
        TextView txtNombres = findViewById(R.id.textNombres);
        TextView txtApellidos = findViewById(R.id.textApellidos);
        TextView txtFechaN = findViewById(R.id.textFN);
        TextView txtColegio = findViewById(R.id.textColegio);
        TextView txtCarrera = findViewById(R.id.textCarrera);
        Button btnBuscar = (Button) findViewById(R.id.botonbuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < registro.size(); i++) {
                    if(buscarTexto.getText().toString().equals(registro.get(i).dni))
                    {
                        txtDNI.setText(txtDNI.getText() + registro.get(i).dni);
                        txtApellidos.setText(txtApellidos.getText() + registro.get(i).edtPaterno + ' ' + registro.get(i).edtMaterno);
                        txtFechaN.setText(txtFechaN.getText() + registro.get(i).edtFecNacimiento);
                        txtNombres.setText(txtNombres.getText() + registro.get(i).edtNombres);
                        txtCarrera.setText(txtCarrera.getText() + registro.get(i).edtCarrera);
                        txtColegio.setText(txtColegio.getText() + registro.get(i).edtColegio);
                        break;
                    }
                    if (i == registro.size()-1){
                        txtDNI.setText("DNI: ");
                        txtApellidos.setText("Apellidos: ");
                        txtFechaN.setText("Fecha de Nacimiento: ");
                        txtNombres.setText("Nombres: ");
                        txtCarrera.setText("Carrera: ");
                        txtColegio.setText("Colegio: ");
                    }
                }
            }
        });

    }
}