//En aqui se encuentra la autenticacion de la aplicacion
package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtUsuario = findViewById(R.id.edtUsuario);
        EditText edtPassword = findViewById(R.id.edtPassword);
        TextView txtMensaje = findViewById(R.id.txtMensaje);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edtUsuario.getText().toString();
                String password = edtPassword.getText().toString();
                if (usuario.equals("admin") && password.equals("1234")) {
                    Log.d(TAG,"valida," + usuario + "," + password);
                    txtMensaje.setText("Autenticacion valida");
                } else {
                    txtMensaje.setText("Autenticacion no valida");
                    Log.d(TAG,"invalido," + usuario + "," + password);
                }
            }
        });
    }
}