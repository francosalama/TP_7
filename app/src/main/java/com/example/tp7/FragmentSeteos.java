package com.example.tp7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentSeteos extends Fragment {

    View layoutRoot;
    EditText edTelefono;
    Button btnGuardar;

    public FragmentSeteos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutRoot = inflater.inflate(R.layout.fragment_seteos, container, false);

        ObtenerReferencias();
        SetearListeners();



        return layoutRoot;
    }

    private void ObtenerReferencias(){
        edTelefono = (EditText) layoutRoot.findViewById(R.id.edTelefono);
        btnGuardar = (Button) layoutRoot.findViewById(R.id.btnGuardar);
    }

    private void SetearListeners(){
        btnGuardar.setOnClickListener(btnGuardar_Click);
    }

    View.OnClickListener btnGuardar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putInt("telefono", Integer.parseInt(edTelefono.getText().toString()));
            myEdit.commit();

            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();
            assert actividadContenedora != null;
            actividadContenedora.IrAlFragmentLinterna();
        }
    };
}