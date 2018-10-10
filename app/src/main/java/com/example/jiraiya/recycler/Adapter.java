package com.example.jiraiya.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        if(i > pos){
            //Scrolling Down
            AnimationUtils.animate(myViewHolder,true);
        }else {
            //Scrolling Up
            AnimationUtils.animate(myViewHolder,false);
        }
        pos = i;

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
