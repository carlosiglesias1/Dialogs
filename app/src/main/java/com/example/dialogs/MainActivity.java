package com.example.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListenerDialogFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button message = (Button) this.findViewById(R.id.message);
        Button threeOptions = (Button) this.findViewById(R.id.three_buttons);
        Button lista = (Button) this.findViewById(R.id.lista);
        Button radio = (Button) this.findViewById(R.id.radio);
        Button checkbox = (Button) this.findViewById(R.id.checkbox);
        Button custom = (Button) this.findViewById(R.id.custom);
        Button fechaHora = (Button) this.findViewById(R.id.fechaHora);
        message.setOnClickListener(this::onClick);
        threeOptions.setOnClickListener(this::onClick);
        lista.setOnClickListener(this::onClick);
        radio.setOnClickListener(this::onClick);
        custom.setOnClickListener(this::onClick);
        checkbox.setOnClickListener(this::onClick);
        fechaHora.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, DateTimePicker.class)));
    }

    public void onClick(View view) {
        AlertDialog dialog;
        AlertDialog.Builder builder;
        switch (view.getId()) {
            case R.id.message:
                builder = new AlertDialog.Builder(this);
                builder.setMessage("Hola Mundo").setTitle("Mensaje").setIcon(R.mipmap.ic_launcher);
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.three_buttons:
                builder = new AlertDialog.Builder(this);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("3 botones")
                        .setMessage("¿Es fácil?")
                        .setPositiveButton("Sí", (dialogInterface, i) -> {
                            Toast toast = Toast.makeText(MainActivity.this, "Es fácil", Toast.LENGTH_SHORT);
                            toast.show();
                            dialogInterface.dismiss();
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = Toast.makeText(MainActivity.this, "No es fácil", Toast.LENGTH_SHORT);
                                toast.show();
                                dialogInterface.dismiss();
                            }
                        })
                        .setNeutralButton("Tal vez", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = Toast.makeText(MainActivity.this, "No es difícil", Toast.LENGTH_SHORT);
                                toast.show();
                                dialogInterface.dismiss();
                            }
                        });
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.lista:
                builder = new AlertDialog.Builder(this);
                ListView lista = new ListView(this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planetas, android.R.layout.simple_list_item_1);
                lista.setAdapter(adapter);
                lista.setOnItemClickListener(
                        (new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                TextView showText = new TextView(lista.getContext());
                                showText.setText(((TextView) view).getText().toString());
                                showText.setTextIsSelectable(true);
                                AlertDialog.Builder builder = new AlertDialog.Builder(lista.getContext());
                                builder.setTitle("Has seleccionado: ")
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        });
                                builder.setView(showText);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        }));
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("Planetas Del Sistema Solar")
                        .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setView(lista);
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.radio:
                ListaDialogFragment listaDialogFragment = new ListaDialogFragment();
                listaDialogFragment.show(this.getSupportFragmentManager(), "Radio listener");
                break;
            case R.id.checkbox:
                Multiple multiple = new Multiple();
                multiple.show(MainActivity.this.getSupportFragmentManager(), "Checkbox List");
                break;
            case R.id.custom:
                Custom custom = new Custom();
                custom.show(MainActivity.this.getSupportFragmentManager(), "Custom Dialog");
                break;
        }
    }

    public void onDialogListaClick(String str) {
        Toast.makeText(this, "Mensaje desde MainActivity: " + str, Toast.LENGTH_LONG).show();
    }
}