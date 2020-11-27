package com.pmadera.entregasemana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvLugares;
    private ArrayList<Lugar> listaLugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvLugares=(RecyclerView)findViewById(R.id.rvLugares);

        GridLayoutManager glm=new GridLayoutManager(this,2);
        rvLugares.setLayoutManager(glm);

        CargoLugares();

        CargoAdaptador();

    }

    private void CargoLugares() {
        listaLugares=new ArrayList<>();

        listaLugares.add(new Lugar("Montevideo",R.drawable.montevideo,-34.90328,-56.18816));

        listaLugares.add(new Lugar("Colonia",R.drawable.colonia,-34.46262,-57.83976));

        listaLugares.add(new Lugar("Piriapolis",R.drawable.piriapolis,-34.86287,-55.27471));

        listaLugares.add(new Lugar("Punta del Este",R.drawable.punta_del_este,-34.94747,-54.93382));

    }

    private void CargoAdaptador(){
        LugarAdaptador oAdaptador=new LugarAdaptador(listaLugares,this);
        rvLugares.setAdapter(oAdaptador);
    }

}