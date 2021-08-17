package com.example.tp7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

    public  boolean onCreateOptionsMenu(Menu menu)  {
        //  Infla  el  menu:
        //    Agrega  los  items  a  la  action  bar,  si  se  encuentra presente.
        getMenuInflater().inflate(R.menu.menu,  menu);

        //  You  must  return  true  for  the  menu  to  be  displayed;
        //    if  you  return  false  it  will  not  be  shown.
        return  true; }



    public  boolean onOptionsItemSelected(@NonNull MenuItem item)  {
        boolean blnReturn  = true;
        String    strTitle;

        strTitle  =  item.getTitle().toString(); //  Obtengo el  Titulo  de  MenuItem  presionado.
        switch (item.getItemId())  {
            case R.id.action_seteos:
                IrAlFragmentSeteos();
                break;
                case R.id.action_linterna:
                    IrAlFragmentLinterna();
                    break;
                    default:
                        blnReturn  = false;
                        break;
        }
                        //  Return  (boolean)  false  to  allow  normal  menu processing  to  proceed
                        //  true  to  consume  it  here.
        return blnReturn;
        }

    public void IrAlFragmentLinterna(){
        ReemplazarFragment(fragmentLinterna);
    }
    public void IrAlFragmentSeteos(){
        ReemplazarFragment(fragmentSeteos);
    }
}