package com.example.tp7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentApagado fragmentApagado;
    FragmentEncendido fragmentEncendido;
    FragmentSeteos fragmentSeteos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CrearFragments();
        IrAlFragmentApagado();
    }

    private void CrearFragments(){
        fragmentApagado = new FragmentApagado();
        fragmentEncendido = new FragmentEncendido();
        fragmentSeteos = new FragmentSeteos();
    }

    public void ReemplazarFragment(Fragment fragmento){
        FragmentManager manager;
        FragmentTransaction transaction;

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fraContenedor,fragmento,null);
        transaction.commit();
    }

    public void IrAlFragmentApagado(){
        ReemplazarFragment(fragmentApagado);
    }

    public void IrAlFragmentEncendido(){
        ReemplazarFragment(fragmentEncendido);
    }

    public void IrAlFragmentSeteos(){
        ReemplazarFragment(fragmentSeteos);
    }
}