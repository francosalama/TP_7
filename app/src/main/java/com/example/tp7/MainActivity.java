package com.example.tp7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentLinterna fragmentLinterna;
    FragmentSeteos fragmentSeteos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CrearFragments();
        IrAlFragmentLinterna();
    }

    private void CrearFragments(){
        fragmentLinterna = new FragmentLinterna();
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

    public void IrAlFragmentLinterna(){
        ReemplazarFragment(fragmentLinterna);
    }
    public void IrAlFragmentSeteos(){
        ReemplazarFragment(fragmentSeteos);
    }
}