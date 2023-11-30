package com.example.mobileexam;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mobileinterfacesexam.entrenamentsinfo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Entrenaments extends Fragment {

    public Entrenaments() {
        // Constructor público requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_entrenaments, container, false);

        TextView textView1 = view.findViewById(R.id.textView1);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView3 = view.findViewById(R.id.textView3);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paso = "-Te colocas de una forma comoda.\n" + "-Posicionas las manos en paralelo.\n" + "-Y bajas y subes.\n";
                navigateToFragmentB("Push Ups",paso);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paso = "-Agarras una mancuerca en cada mano.\n" + "-Levantas la izquierda.\n" + "-Levantas la derecha.\n";
                navigateToFragmentB("Mancuernas",paso);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paso = "-Pones tu espalda recta.\n" + "-Doblas las rodillas.\n" + "-Y Bajas.\n";
                navigateToFragmentB("Sentadillas",paso);
            }
        });

        return view;
    }



    private void navigateToFragmentB(String nombre,String pasos) {

        entrenamentsinfo entrenamentsinformacion = new entrenamentsinfo();
        Bundle args = new Bundle();
        args.putString("nombre", nombre);
        args.putString("pasos",pasos);
        entrenamentsinformacion.setArguments(args);


        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerlayout, entrenamentsinformacion);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
