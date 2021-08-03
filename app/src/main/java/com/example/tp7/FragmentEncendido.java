package com.example.tp7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentEncendido extends Fragment {

    View layoutRoot;
    ImageView ivEncendido;
    ImageView ivLinternaPrendida;
    ImageView ivBotonEncendido;
    Button btnSeteosEncendido;

    public FragmentEncendido() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutRoot = inflater.inflate(R.layout.fragment_encendido, container, false);

        ObtenerReferencias();
        SetearListeners();

        return layoutRoot;
    }

    private void ObtenerReferencias(){
        ivEncendido = (ImageView) layoutRoot.findViewById(R.id.ivEncendido);
        ivLinternaPrendida = (ImageView) layoutRoot.findViewById(R.id.ivLinternaEncendida);
        ivBotonEncendido = (ImageView) layoutRoot.findViewById(R.id.ivBotonEncendido);
        btnSeteosEncendido = (Button) layoutRoot.findViewById(R.id.btnSeteosEncendido);
    }

    private void SetearListeners(){
        ivEncendido.setOnClickListener(ivEncendido_Click);
        btnSeteosEncendido.setOnClickListener(btnSeteosEncendido_Click);
    }

    View.OnClickListener ivEncendido_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();
            assert actividadContenedora != null;
            actividadContenedora.IrAlFragmentApagado();
        }
    };

    View.OnClickListener btnSeteosEncendido_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();
            assert actividadContenedora != null;
            actividadContenedora.IrAlFragmentSeteos();
        }
    };
}