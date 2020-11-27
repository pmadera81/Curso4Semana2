package com.pmadera.entregasemana2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latitud;
    private double longitud;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle parametros=getIntent().getExtras();
        nombre=parametros.getString(getResources().getString(R.string.pNombre));
        latitud=parametros.getDouble(getResources().getString(R.string.pLatitud));
        longitud=parametros.getDouble(getResources().getString(R.string.pLongitud));


        LatLng lugar = new LatLng(latitud, longitud);
        //mMap.addMarker(new MarkerOptions().position(lugar).title(nombre));
        mMap.addMarker(new MarkerOptions().position(lugar).title(nombre)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marcador));



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar, (float) 13));


    }
}