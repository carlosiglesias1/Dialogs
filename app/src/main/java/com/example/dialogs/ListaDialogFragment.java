package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class ListaDialogFragment extends DialogFragment {
    ListenerDialogFragment listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ListenerDialogFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Lista. Elige un planeta");
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(getActivity(), R.array.planetas, android.R.layout.simple_list_item_1);
        builder.setSingleChoiceItems(R.array.planetas, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int opcion) {
                CharSequence strName = adaptador.getItem(opcion);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                builderInner.setMessage(strName);
                builderInner.setTitle("Has seleccionado:");
                listener.onDialogListaClick("Has seleccionado " + strName);
                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builderInner.show();
            }
        });
        return builder.create();
    }
}
