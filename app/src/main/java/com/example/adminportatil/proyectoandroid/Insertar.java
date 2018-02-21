package com.example.adminportatil.proyectoandroid;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Insertar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
    }

    public void insertarPedido (View view){
        KebabsSQLiteHelper kqlh = new KebabsSQLiteHelper(this);
        SQLiteDatabase db = kqlh.getWritableDatabase();

        EditText cod_pedido = findViewById(R.id.codigo_pedido);
        EditText codigo_cliente = findViewById(R.id.codigo_cliente);

        db.execSQL("INSERT INTO pedido (cod_pedido, cod_cliente) VALUES (" + Integer.parseInt(cod_pedido.getText().toString()) + ", " + Integer.parseInt(codigo_cliente.getText().toString()) + ")");
    }

    public void insertarTipoKebab (View view){
        KebabsSQLiteHelper kqlh = new KebabsSQLiteHelper(this);
        SQLiteDatabase db = kqlh.getWritableDatabase();

        EditText nombre = findViewById(R.id.nombre);
        EditText precio = findViewById(R.id.precio);

        db.execSQL("INSERT INTO tipo_kebab (nombre_tipo_kebab, precio) VALUES (" + Integer.parseInt(nombre.getText().toString()) + ", " + Integer.parseInt(precio.getText().toString()) + ")");
    }
}