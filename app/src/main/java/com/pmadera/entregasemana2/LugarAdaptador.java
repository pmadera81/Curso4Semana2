package com.pmadera.entregasemana2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LugarAdaptador extends RecyclerView.Adapter<LugarAdaptador.LugarAdaptadorViewHolder> {
    private ArrayList<Lugar> listaLugares;
    private Activity activity;

    public LugarAdaptador(ArrayList<Lugar> listaLugares, Activity activity) {
        this.listaLugares = listaLugares;
        this.activity = activity;
    }

    @NonNull
    @Override
    public LugarAdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lugares,parent,false);

        return new LugarAdaptadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LugarAdaptadorViewHolder holder, int position) {
        final Lugar oLugar=listaLugares.get(position);

        holder.imgFoto.setImageResource(oLugar.getFoto());
        holder.tvNombre.setText(oLugar.getNombre());

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity ,MapsActivity.class);
                intent.putExtra(activity.getResources().getString(R.string.pLatitud) ,oLugar.getLatitud());
                intent.putExtra(activity.getResources().getString(R.string.pLongitud),oLugar.getLongitud());
                intent.putExtra(activity.getResources().getString(R.string.pNombre),oLugar.getNombre());

                activity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listaLugares.size();
    }

    public static class LugarAdaptadorViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombre;

        public LugarAdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto=(ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombre=(TextView)itemView.findViewById(R.id.tvNombreLugar);

        }
    }
}
