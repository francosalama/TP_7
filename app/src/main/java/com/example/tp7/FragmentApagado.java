package com.example.tp7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class FragmentApagado extends Fragment {

    View layoutRoot;
    ImageView ivApagado;
    ImageView ivLinternaApagada;
    ImageView ivBotonApagado;
    Button btnSeteosApagado;

    public FragmentApagado() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutRoot = inflater.inflate(R.layout.fragment_apagado, container, false);

        ObtenerReferencias();
        SetearListeners();

        return layoutRoot;
    }

    private void ObtenerReferencias(){
        ivApagado = (ImageView) layoutRoot.findViewById(R.id.ivApagado);
        ivLinternaApagada = (ImageView) layoutRoot.findViewById(R.id.ivLinternaApagada);
        ivBotonApagado = (ImageView) layoutRoot.findViewById(R.id.ivBotonApagado);
        btnSeteosApagado = (Button) layoutRoot.findViewById(R.id.btnSeteosApagado);
    }

    private void SetearListeners(){
        ivApagado.setOnClickListener(ivApagado_Click);
        btnSeteosApagado.setOnClickListener(btnSeteosApagado_Click);
    }

    View.OnClickListener ivApagado_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();
            assert actividadContenedora != null;
            actividadContenedora.IrAlFragmentEncendido();
        }
    };

    View.OnClickListener btnSeteosApagado_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();
            assert actividadContenedora != null;
            actividadContenedora.IrAlFragmentSeteos();
        }
    };
}