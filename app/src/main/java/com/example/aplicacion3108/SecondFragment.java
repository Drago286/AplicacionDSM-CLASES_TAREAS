package com.example.aplicacion3108;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.aplicacion3108.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText txt_number1, txt_number2, txt_res;
    private Spinner op_operation;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        txt_number1=(EditText) binding.numer1;
        txt_number2=(EditText)binding.editTextTextPersonName2;
        txt_res=(EditText)binding.responseTxt;
        op_operation = (Spinner) binding.spinner;

        String [] operations=
                {
                        "Selecciona una opcion:",
                        "Sumar",
                        "Restar",
                        "Multiplicar",
                        "Dividir",
                };

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this.getContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operations);



        op_operation.setAdapter(adapter));




        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        binding.thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });

        binding.btnCalcular.setOnClickListener((View v)->{
            String selected = op_operation.getSelectedItem().toString();

            switch (selected){
                case "Sumar":{
                    sum();
                    break;

                }case "Restar":{
                    res();
                    break;

                }case "Multiplicar":{
                    mult();
                    break;

                }case "Dividir":{
                    div();
                    break;

                } default:{
                    showMessage();
                }
            }
        });




    }
    public void showMessage(){
        Toast.makeText(this.getContext(),"No ha seleccionado ninguna opcion",Toast.LENGTH_SHORT).show();
    }

    public String sum(){
        double val1= Integer.parseInt(txt_number1.getText().toString());
        double val2= Integer.parseInt(txt_number2.getText().toString());
        double sum = val1+val2;
        String res = String.valueOf(sum);

            txt_res.setText(res);

        return res;
    }
    public String res(){
        double val1= Integer.parseInt(txt_number1.getText().toString());
        double val2= Integer.parseInt(txt_number2.getText().toString());
        double res = val1-val2;
        String resul = String.valueOf(res);

            txt_res.setText(resul);

        return resul;
    }

    public String mult(){
        double val1= Integer.parseInt(txt_number1.getText().toString());
        double val2= Integer.parseInt(txt_number2.getText().toString());
        double mult = val1*val2;
        String res = String.valueOf(mult);

            txt_res.setText(res);

        return res;
    }


    public String div() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        String res = "";
        if (val_2 != 0) {
            double div = val_1 / val_2;
            res = String.valueOf(div);

                txt_res.setText(res);

        } else {
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }
        return res;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}