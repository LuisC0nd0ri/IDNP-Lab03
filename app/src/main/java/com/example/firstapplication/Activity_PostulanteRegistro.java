package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Activity_PostulanteRegistro extends AppCompatActivity {

    private static String TAG = "Activity_PostulanteRegistro";

    private void resetForm(EditText form[], TextView txtMensaje) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < form.length; i++) {
            form[i].setText("");
        }
        txtMensaje.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        ArrayList<Postulante> registro = new ArrayList<Postulante>();
        EditText form[] = {
                findViewById(R.id.editNombres),
                findViewById(R.id.editPaterno),
                findViewById(R.id.editMaterno),
                findViewById(R.id.editFecNacimiento),
                findViewById(R.id.editColegio),
                findViewById(R.id.editCarrera),
                findViewById(R.id.editDNI)
        };


        TextView txtMensaje = findViewById(R.id.txtMensaje);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistro);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMensaje.setText("Registro  Exitoso");
                registro.add(Postulante.createPostulante(form));
                try {
                    resetForm(form, txtMensaje);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}