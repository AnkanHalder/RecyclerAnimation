package com.example.jiraiya.recycler;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

@SuppressLint("ValidFragment")
public class LoadingProgressDialog extends AppCompatDialogFragment {

    View vh;
    private AlertDialog alertDialog;
    private Context context;
    private FragmentManager manager;
    private OnClickListener listener;
    private TextView text;

    @SuppressLint("ValidFragment")
    public LoadingProgressDialog(Context context){
        this.context = context;
        this.manager =((FragmentActivity)context).getSupportFragmentManager();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        vh = getActivity().getLayoutInflater().inflate(R.layout.alert_acknowledgement_layout,null);
        text = (TextView) vh.findViewById(R.id.textView);
        alertDialog = new AlertDialog.Builder(getActivity()).setView(vh).setTitle("Wait").create();
        alertDialog.setCanceledOnTouchOutside(true);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onResult(true);
            }
        });

        return alertDialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnClickListener) context;
        }
        catch (ClassCastException e){
            e.printStackTrace();
        }
    }


    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    void show(){
        show(manager,"Testing");
    }

    public interface OnClickListener{
        void onResult(boolean result);
    }
}
