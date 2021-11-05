package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class Custom extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)
                getActivity().getSystemService((infService));
        View inflado = li.inflate(R.layout.activity_dialogo_personalizado, null);
        TextView tvNombre = (TextView) inflado.findViewById(R.id.nombre);
        TextView tvPass = (TextView) inflado.findViewById(R.id.contrasinal);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Usuario y contraseña");
        builder.setView(inflado);
        builder.setPositiveButton("Aceptar", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Has escrito: nombre: '" +
                                tvNombre.getText().toString() +
                                "'. Contraseña: '" + tvPass.getText().toString() + "' y has pulsado 'Aceptar'", Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("Cancelar", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Has pulsado 'Cancelar'",
                                Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }
}
