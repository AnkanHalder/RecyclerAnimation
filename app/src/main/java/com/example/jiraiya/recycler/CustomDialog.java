package com.example.jiraiya.recycler;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


public class CustomDialog extends AppCompatDialogFragment {


    Button accept,reject;
    AlertDialog alertDialog;
    OnOptionClick optionClick;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        LayoutInflater inflater =getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dilague_layout,null);
        accept = (Button)view.findViewById(R.id.accept_alert);
        reject = (Button)view.findViewById(R.id.deny_alert);


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionClick.onResult(true);
            }
        });

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionClick.onResult(false);
            }
        });

        alertDialog = new AlertDialog.Builder(getActivity()).setView(view).setTitle("Title").create();

        return alertDialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            optionClick =(OnOptionClick)context;
        }catch (ClassCastException c){
            c.printStackTrace();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }


    public void setOnOptionClickListener(OnOptionClick onOptionClick) {
        this.optionClick =onOptionClick;
    }

    public interface OnOptionClick{
        void onResult(boolean status);
    }

}


