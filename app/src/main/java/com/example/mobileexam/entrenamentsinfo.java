package com.example.mobileinterfacesexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.mobileexam.Entrenaments;
import com.example.mobileexam.R;


public class entrenamentsinfo extends Fragment {

    public entrenamentsinfo() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_entrenamentsinfo, container, false);


        Bundle args = getArguments();
        if (args != null && args.containsKey("nombre")) {
            String nombre = args.getString("nombre", "");
            String pasos = args.getString("pasos", "");
            if (nombre.equals("Mancuernas")){
            ImageView imageView = view.findViewById(R.id.imagen);
            imageView.setImageResource(R.mipmap.mancuerna_foreground);
            } else if (nombre.equals("Push Ups")) {
                ImageView imageView = view.findViewById(R.id.imagen);
                imageView.setImageResource(R.mipmap.pushup_foreground);
            } else if (nombre.equals("Sentadillas")) {
                ImageView imageView = view.findViewById(R.id.imagen);
                imageView.setImageResource(R.mipmap.sentadilla_foreground);
            }




            TextView textView = view.findViewById(R.id.textViewFragmentinfo);
            textView.setText(nombre);
            TextView textView1 = view.findViewById(R.id.pasos);
            textView1.setText(pasos);
        }
        Button btnBack = view.findViewById(R.id.volver);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volveratras();
            }
        });
        return view;
    }
    public void volveratras(){
        Entrenaments entrenaments = new Entrenaments();
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerlayout, entrenaments);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}