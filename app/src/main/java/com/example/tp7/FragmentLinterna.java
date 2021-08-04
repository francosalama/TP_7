package com.example.tp7;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentLinterna extends Fragment {

    View layoutRoot;
    ImageView ivApagado;
    ImageView ivLinterna;
    ImageView ivBoton;
    Button btnSeteos;
    TextView tvTel;
    boolean encendido = false;

    private CameraManager mCameraManager;
    private String mCameraId;

    public FragmentLinterna() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutRoot = inflater.inflate(R.layout.fragment_linterna, container, false);

        ObtenerReferencias();
        SetearListeners();

        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        int telefono = sharedPreferences.getInt("telefono", 911);
        tvTel.setText(String.valueOf(telefono));

        boolean isFlashAvailable = getContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        mCameraManager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);
        try {
            mCameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        return layoutRoot;
    }

    private void ObtenerReferencias(){
        ivApagado = (ImageView) layoutRoot.findViewById(R.id.ivApagado);
        ivLinterna = (ImageView) layoutRoot.findViewById(R.id.ivLinterna);
        ivBoton = (ImageView) layoutRoot.findViewById(R.id.ivBoton);
        btnSeteos = (Button) layoutRoot.findViewById(R.id.btnSeteos);
        tvTel = (TextView) layoutRoot.findViewById(R.id.tvTel);
    }

    private void SetearListeners(){
        ivApagado.setOnClickListener(ivApagado_Click);
        btnSeteos.setOnClickListener(btnSeteosApagado_Click);
        ivBoton.setOnClickListener(ivBoton_Click);
    }

    View.OnClickListener ivApagado_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!encendido){
                ivApagado.setImageResource(R.drawable.encendido);
                ivLinterna.setImageResource(R.drawable.linterna_prendida);
                encendido = true;
                switchFlashLight(encendido);
            } else{
                ivApagado.setImageResource(R.drawable.apagado);
                ivLinterna.setImageResource(R.drawable.linterna_apagada);
                encendido = false;
                switchFlashLight(encendido);
            }
        }
    };

    View.OnClickListener ivBoton_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tvTel.getText().toString()));
            startActivity(intent);
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

    public void switchFlashLight(boolean status) {
        try {
            mCameraManager.setTorchMode(mCameraId, status);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}