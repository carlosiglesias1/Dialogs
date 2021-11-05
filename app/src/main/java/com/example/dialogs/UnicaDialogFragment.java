package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class UnicaDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Lista. Elige un planeta");
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(getActivity(), R.array.planetas, android.R.layout.simple_list_item_1);
        builder.setSingleChoiceItems(R.array.planetas, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int opcion) {
                        CharSequence strName = adaptador.getItem(opcion);
                        Toast.makeText(getActivity(), "Usuario pulsó " + strName, Toast.LENGTH_LONG).show();
                        dismiss();
                    }
                });
        return builder.create();
    }
}
