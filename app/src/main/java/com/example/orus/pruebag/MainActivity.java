package com.example.orus.pruebag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text_nome, text_lastmane;
    EditText edit_nome, editText_lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_lastmane = (TextView) findViewById(R.id.textView_Lastname);
        text_nome = (TextView) findViewById(R.id.textView_Name);
        edit_nome = (EditText) findViewById(R.id.editText_Name);
        editText_lastName = (EditText) findViewById(R.id.editText_lasName);

        loadPreferences();
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_save:
                savePreferences();
                break;
            case R.id.button_load:
                Intent intent = new Intent(this, MostrarActividad.class);
                startActivity(intent);
                break;
        }
    }

    public void savePreferences(){
        SharedPreferences preferences = getSharedPreferences("filexml", Context.MODE_PRIVATE);

        String nom = edit_nome.getText().toString();
        String ape = editText_lastName.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("Nombre: ", nom);
        editor.putString("Apellido: ",ape);
        text_nome.setText(nom);
        text_lastmane.setText(ape);
        editor.commit();
    }
    public void loadPreferences(){
        SharedPreferences preferences = getSharedPreferences("filexml", Context.MODE_PRIVATE);
        String nome1 = preferences.getString("Nombre", "NO hay usuarios registrados");
        String lastName1 = preferences.getString("Apellido", "No hay usuarios registrados");

        text_nome.setText(nome1);
        text_lastmane.setText(lastName1);
    }
}
