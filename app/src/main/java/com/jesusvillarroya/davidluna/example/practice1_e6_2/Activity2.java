package com.jesusvillarroya.davidluna.example.practice1_e6_2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Activity2 extends AppCompatActivity {

    private TextView tv1;
    private ImageView iv1;
    private Spinner s1;
    private RadioButton rb1, rb2;
    private EditText webPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Recibimos los datos que nos llegan
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("nombre");

        iv1 = (ImageView)findViewById(R.id.iv1);
        tv1 = (TextView)findViewById(R.id.tv1);
        s1 = (Spinner)findViewById(R.id.s1);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        webPage = (EditText)findViewById(R.id.et3);



        //Logo
        iv1.setImageResource(R.mipmap.halloween);
        //Bienvenida
        tv1.setText("Bienvenido " + name.toString());

        //Opciones spinner
        String[]opciones = {"Master USJ", "Ejercicios Android"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        s1.setAdapter(adapter);

    }

    public void doTask(View view) {

        String selec = s1.getSelectedItem().toString();
        Intent i = new Intent(this, ListActivity.class);

        if (selec.equals("Master USJ")) {
           i.putExtra("opcion", 1);

        } else if (selec.equals("Ejercicios Android")){
          i.putExtra("opcion", 2);
        }

        startActivity(i);

    }

    //Método para prácticas realizadas
    public void saveTasks(View view){
        String message = "";

        if (rb1.isChecked()) {
            message = "¡¡Felicidades!! \nHas completado tus tareas.";
        } else if (rb2.isChecked()) {
            message = "No te despistes que se acaba el tiempo. \n¡EMPIEZA YA!";
        } else {
            message = "No sé si has hecho o no tus tareas, \n¡Repóndeme!";
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();

    }



    //Método para ver la dirección web
    public void goWeb(View view){

        Intent i = new Intent(this, WebsiteActivity.class);
        i.putExtra("url", webPage.getText().toString());
        startActivity(i);


    }

    //Cerrar Activity
    public void finishView(View view){
        finish();
    }
}
