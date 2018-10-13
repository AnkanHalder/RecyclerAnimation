package com.example.jiraiya.recycler;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class CustomDialog extends AppCompatDialogFragment {

    private String yes = "Yes";
    private String no = "No";
    private String message = "Enter Message";
    private String title= "Change Title";
    OnOptionClick optionClick;
    private FragmentManager manager;
    private Context context;
    private boolean cancelable = true;

    @SuppressLint("ValidFragment")
    public CustomDialog(Context context){
        this.context = context;
        this.manager = ((FragmentActivity)context).getSupportFragmentManager();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater =getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dilague_layout,null);
        Button accept = (Button) view.findViewById(R.id.accept_alert);
        Button reject = (Button) view.findViewById(R.id.deny_alert);
        TextView textview = (TextView) view.findViewById(R.id.message_acknow);

        accept.setText(yes);
        reject.setText(no);
        textview.setText(message);


        //Not null check
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(optionClick != null)
                optionClick.onResult(true);
            }
        });

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(optionClick != null)
                optionClick.onResult(false);
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setView(view).setTitle(title).create();
        alertDialog.setCanceledOnTouchOutside(cancelable);

        return alertDialog;
    }

    @Override
    public void onAttach(Context contextt) {
        super.onAttach(context);
        try{
            optionClick =(OnOptionClick)context;
        }catch (ClassCastException c){
            c.printStackTrace();
        }
    }
    void show(){
        show(manager,"Custom");
    }


    public void setOnOptionClickListener(OnOptionClick onOptionClick) {
        this.optionClick =onOptionClick;
    }

    void setMessage(String message){
        this.message=message;
    }

    void setPositiveButton(String yes){
        this.yes=yes;
    }

    void setNeagtiveButton(String no){
        this.no=no;
    }

    void setTitle(String title){
        this.title = title;
    }
    void setCanceledOnTouchOutside(boolean cancelable){
        this.cancelable=cancelable;
    }

    public interface OnOptionClick{
        void onResult(boolean status);
    }

}


