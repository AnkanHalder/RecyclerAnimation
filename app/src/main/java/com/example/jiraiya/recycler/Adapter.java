package com.example.jiraiya.recycler;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {

    List<GetSetDetails> items = Collections.emptyList();
    private Context context;
    private LayoutInflater inflater;
    private int pos=0;

    Adapter(Context context,List<GetSetDetails> items){
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View vh = inflater.inflate(R.layout.item,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(vh);

        return holder;
    }

    //Delete from Position.

     private void delete(int position){
        items.remove(position);
        notifyItemRemoved(position);
    }

    //Delete from Contents

    private void deleteByContents(String str){
        int index = items.indexOf(str);
        if(index != -1){
            items.remove(index);
            notifyItemRemoved(index);
        }
    }

    //Add Item

    private void addItem(GetSetDetails gsd){
        items.add(gsd);
        notifyItemInserted(items.size());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        GetSetDetails gsd = items.get(i);
        myViewHolder.text.setText(gsd.getName());
        AnimationUtils.slide_right_to_left(myViewHolder);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CustomDialog dialog_alert =new CustomDialog(context);
//                dialog_alert.setPositiveButton("Yes");
//                dialog_alert.setNeagtiveButton("No");
//                dialog_alert.setMessage("Are You Sure ?This is a better version of the simple list of items that we saw earlier.\n" +
//                        "Each of the items in the list has a CheckBoxbeside it." +
//                        " The isChecked boolean value returns the checkBox current state.");
//                dialog_alert.setTitle("Are you sure?");
//                dialog_alert.setCanceledOnTouchOutside(false);
//                dialog_alert.show();

               final AlertAcknowledgement alertAcknowledgement = new AlertAcknowledgement(context);
               alertAcknowledgement.setMessage("This is a better version of the simple list of items that we saw earlier" +
                       ".Each of the items in the list has a CheckBoxbeside it." +
                       "This is a better version of the simple list of items that we saw earlier." +
                       "Each of the items in the list has a CheckBoxbeside it.");
               alertAcknowledgement.setButtonText("Okies");
               alertAcknowledgement.setTitle("Holla");
               alertAcknowledgement.setCanceledOnTouchOutside(false);
               //alertAcknowledgement.tryy();
               alertAcknowledgement.show();
               alertAcknowledgement.setOnOkClickedListener(new AlertAcknowledgement.OnOkClicked() {
                   @Override
                   public void status(boolean status) {
                       if(status) {
                           Toast.makeText(context, "True", Toast.LENGTH_SHORT).show();
                           alertAcknowledgement.dismiss();
                       }
                   }
               });

            }
        });

//        if(i > pos){
//            //Scrolling Down
//
//        }else {
//            //Scrolling Up
//            AnimationUtils.animate5(myViewHolder,false);
//        }
//        pos = i;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView text;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.item_text);

    }

}
