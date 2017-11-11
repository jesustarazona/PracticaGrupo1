package com.jesusvillarroya.davidluna.example.practice1_e6_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
    }

    public void login(View view){

        if (et1.length() == 0 || et2.length() == 0) {
            //Es necesario que sean rellenados los campos Usuario y Password
            Toast notificacion = Toast.makeText(this, "Los campos usuario y contraseña deben de ser rellenados", Toast.LENGTH_LONG);
            notificacion.show();
        } else {
            String name = et1.getText().toString();
            //Estando los campos rellenados, los enviamos al siguiente activity
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("nombre", name.toUpperCase());
            startActivity(intent);
        }

    }
}
