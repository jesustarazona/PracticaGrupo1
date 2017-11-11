package com.jesusvillarroya.davidluna.example.practice1_e6_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class ListActivity extends AppCompatActivity {

    private ListView lv1;
    private TextView tv1;

    private String [] opcion1;
    private String [] opcion2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Recibimos los datos que nos llegan
        Bundle bundle = getIntent().getExtras();
        final int opcion = bundle.getInt("opcion");

        lv1 = (ListView)findViewById(R.id.lv1);
        tv1 = (TextView)findViewById(R.id.tv1);


        if (opcion == 1) {
            opcion1 = new String[]{"Android", "iPhone - iPad", "Experiencia usuario", "Bases de datos avanzadas", "Redes ADHOC", "Ensamblado de aplicaciones", "Modelado de aplicaciones", "Compilación de modelos"};
            opcion2 = new String[]{"5", "5", "5", "8", "5", "4", "5", "4"};
        } else if (opcion == 2) {
            opcion1 = new String[]{"Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5", "Tarea 6", "Tarea 7", "Tarea 8", "Tarea 9", "Tarea 10", "Tarea 11", "Tarea 12"};
            opcion2 = new String[]{"contenidos básicos","contenidos básicos","EditText y Button", "RadioButton", "CheckBox", "Spinner", "ListView","Imagine Button", "Mensajes - Toast", "EditText verificado", "llamar a un activity", "enviar parámetros a un activity"};
        }

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcion1);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String sub = (String) lv1.getItemAtPosition(i);
                if (opcion == 1) {
                    tv1.setText("\"" + sub + "\" realiza " + opcion2[i] + " sesiones.");
                } else if (opcion == 2){
                    tv1.setText("\"" + sub + "\" - explica - " + opcion2[i]);
                }

            }
        });


    }



    //Cerrar Activity
    public void finishView(View view){
        finish();
    }

}
