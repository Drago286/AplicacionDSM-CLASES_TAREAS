package com.example.aplicacion3108;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.aplicacion3108.databinding.FragmentFirstBinding;
import com.example.aplicacion3108.databinding.FragmentThirdBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private FragmentThirdBinding binding2;

    private EditText txt_number1, txt_number2, txt_res;
    private RadioButton rad_sum, rad_sub, rad_mul, rad_div;
    private RadioGroup rad_group;
    private CheckBox check_sum,check_sub,check_mult,check_div;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_number1 = (EditText) binding.firstNumber;
        txt_number2 = (EditText) binding.secondNumber;
        txt_res = (EditText) binding.txtResultado;
        rad_sum = (RadioButton) binding.radSum;
        rad_sub = (RadioButton) binding.radSubtract;
        rad_mul = (RadioButton) binding.radMultiply;
        rad_div = (RadioButton) binding.radDivide;
        rad_group = (RadioGroup) binding.radGroup;
        check_sum = (CheckBox) binding.sumBox;
        check_sub = (CheckBox) binding.subBox;
        check_mult = (CheckBox) binding.multBox;
        check_div = (CheckBox) binding.divBox;


        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment2);
            }
        });
        binding.ThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_thirdFragment);
            }
        });


        binding.calculate.setOnClickListener((View v) -> {
            String resultado = "";
            txt_res.setText("");
            if (!(txt_number1.getText().toString().equalsIgnoreCase("")) &&
                    !(txt_number2.getText().toString().equalsIgnoreCase(""))) {
                if(rad_div.isChecked() || rad_mul.isChecked() ||
                    rad_sum.isChecked() || rad_sub.isChecked() ||
                    check_sum.isChecked() || check_sub.isChecked() ||
                    check_mult.isChecked() || check_div.isChecked()) {
                    if (rad_sum.isChecked()) {
                        check_sum.setChecked(false);
                        check_sub.setChecked(false);
                        check_mult.setChecked(false);
                        check_div.setChecked(false);
                        sum();
                    } else if (rad_sub.isChecked()) {
                        check_sum.setChecked(false);
                        check_sub.setChecked(false);
                        check_mult.setChecked(false);
                        check_div.setChecked(false);
                        res();
                    } else if (rad_mul.isChecked()) {
                        check_sum.setChecked(false);
                        check_sub.setChecked(false);
                        check_mult.setChecked(false);
                        check_div.setChecked(false);
                        mult();
                    } else if (rad_div.isChecked()) {
                        check_sum.setChecked(false);
                        check_sub.setChecked(false);
                        check_mult.setChecked(false);
                        check_div.setChecked(false);
                        div();
                    } else {

                        if (check_sum.isChecked()) {
                            resultado += "|Suma: " + sum() + "|\n";
                        }
                        if (check_sub.isChecked()) {
                            resultado += "|Resta: " + res() + "|\n";
                        }
                        if (check_mult.isChecked()) {
                            resultado += "|Multiplicacion: " + mult() + "|\n";
                        }
                        if (check_div.isChecked()) {
                            resultado += " |Division: " + div() + "|\n";
                        }
                        txt_res.setText(resultado);
                    }
                }else {
                    showMessage();
                    //MENSAJE DE SELECCIONAR UNA OPERACION
                }
            }
            rad_sum.setChecked(false);
            rad_sub.setChecked(false);
            rad_mul.setChecked(false);
            rad_div.setChecked(false);
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
        if (rad_sum.isChecked()) {
            txt_res.setText(res);
        }
        return res;
    }
    public String res(){
        double val1= Integer.parseInt(txt_number1.getText().toString());
        double val2= Integer.parseInt(txt_number2.getText().toString());
        double res = val1-val2;
        String resul = String.valueOf(res);
        if (rad_sub.isChecked()) {
            txt_res.setText(resul);
        }
        return resul;
    }

    public String mult(){
        double val1= Integer.parseInt(txt_number1.getText().toString());
        double val2= Integer.parseInt(txt_number2.getText().toString());
        double mult = val1*val2;
        String res = String.valueOf(mult);
        if (rad_mul.isChecked()) {
            txt_res.setText(res);
        }
        return res;
    }


    public String div() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        String res = "";
        if (val_2 != 0) {
            double div = val_1 / val_2;
            res = String.valueOf(div);
            if (rad_div.isChecked()) {
                txt_res.setText(res);
            }
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