package com.example.adminportatil.proyectoandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {
    RadioButton r1, r2;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        et = findViewById(R.id.resultado_busqueda);

        et.setEnabled(false);
    }

    public void buscar(View view) {

        KebabsSQLiteHelper kqlh = new KebabsSQLiteHelper(this);
        SQLiteDatabase db = kqlh.getWritableDatabase();

        String[] campos_tipo_kebab = new String[]{"cod_tipo_kebab", "nombre_tipo_kebab", "precio"};
        String[] campos_pedido = new String[]{"cod_pedido", "cod_cliente", "pedido_completado"};

        et.setText("");

        if (r1.isChecked()) {
            Cursor tipo = db.query("tipo_kebab", campos_tipo_kebab, null, null, null, null, null);

            if (tipo.moveToFirst()) {
                do {
                    et.append("Codigo tipo kebab: " + tipo.getString(0) + "\n");
                    et.append("Nombre tipo kebab: " + tipo.getString(1) + "\n");
                    et.append("Precio tipo kebab: " + tipo.getInt(2) + "€\n\n");
                } while (tipo.moveToNext());
            }

            tipo.close();
        } else {
            try {
                Cursor c = db.query("pedido", campos_pedido, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        et.append("Codigo pedido: " + c.getInt(0) + "\n");
                        et.append("Codigo cliente: " + c.getString(1) + "\n");
                        et.append("Pedido completado: " + c.getInt(2) + "\n");
                    } while (c.moveToNext());
                }

                c.close();
            } catch (Exception e) {
                Toast toast = Toast.makeText(this, "No hay ningun pedido.", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }

    public void cerrar(View v) {
        finish();
        System.exit(0);
    }
}
