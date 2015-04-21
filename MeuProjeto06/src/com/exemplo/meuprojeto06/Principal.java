package com.exemplo.meuprojeto06;



import java.util.ArrayList;
import java.util.List;

import meuadapter.CarroAdapter;

import entidade.Carro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class Principal extends Activity {

	private ListView listadecarros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Recupera a ListView declarada no arquivo de layout da Activity
        listadecarros = (ListView) findViewById(R.id.listacarros);
        //Cria a Lista de carros que será apresentada no ListView
        //Esse conteúdo poderia esta sendo obtido de um Banco de Dados
        List<Carro> lista = new ArrayList<Carro>();
        //Cria os objetos Carros que serão apresentados na ListView
        Carro c1 = new Carro("Fiat", "Palio", 2010);
        Carro c2 = new Carro("Volkswagen", "Gol", 1990);
        Carro c3 = new Carro("Chevrolet", "Monza", 1980);
        //Adiciona os Carros a Lista
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        //Cria um Adapter baseado no nosso Adapter
        //Ele recebe como argumento, a nosso Activity e a Lista de que será apresentada
        //na ListView
        CarroAdapter meuadapter = new CarroAdapter(this, lista);
        //Vincula o nosso adapter a ListView de forma que eles possam
        //conversar para apresentar os dados
        listadecarros.setAdapter(meuadapter);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
