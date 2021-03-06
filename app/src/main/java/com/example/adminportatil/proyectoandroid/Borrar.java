package com.example.adminportatil.proyectoandroid;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Borrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
    }

    public void borrar(View view) {
        KebabsSQLiteHelper kqlh = new KebabsSQLiteHelper(this);
        SQLiteDatabase db = kqlh.getWritableDatabase();

        RadioButton r1 = findViewById(R.id.tipo_keb);
        EditText codigo = findViewById(R.id.cod);

        if (r1.isChecked()) {
            db.execSQL("DELETE FROM tipo_kebab WHERE cod_tipo_kebab = " + Integer.parseInt(codigo.getText().toString()) + "");

            Toast toast = Toast.makeText(this, "El tipo de kebab ha sido borrado correctamente.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            db.execSQL("DELETE FROM pedido WHERE cod_pedido = " + Integer.parseInt(codigo.getText().toString()) + "");

            Toast toast = Toast.makeText(this, "El pedido ha sido borrado correctamente.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void cerrar(View v) {
        finish();
        System.exit(0);
    }
}
