package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class Multiple extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Lista. Elige tu selección");
        String[]
                planets = getResources().getStringArray(R.array.planetas);
        builder.setMultiChoiceItems(planets, null, new
                DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int opcion, boolean
                            isChecked) {
                        if (isChecked)
                            Toast.makeText(getActivity(), "Has seleccionado " +
                                    planets[opcion], Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "Has deseleccionado " +
                                    planets[opcion], Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setPositiveButton("Aceptar", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Has seleccionado 'Aceptar'",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("Cancelar", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Has seleccionado 'Cancelar' ", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
