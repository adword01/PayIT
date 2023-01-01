package com.example.payit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.payit.R;
import com.example.payit.model.OfferModel;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder>{
    public Context context;
    public ArrayList<OfferModel> offerModelArrayList;


    public OfferAdapter(Context context,ArrayList<OfferModel> offerModelArrayList){
        this.context=context;
        this.offerModelArrayList=offerModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offers,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.offerImgView.setImageResource(offerModelArrayList.get(position).getImage());
        holder.offerItem.setText(offerModelArrayList.get(position).getOffer_on());
        holder.offerDescription.setText(offerModelArrayList.get(position).getOffer_details());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView offerImgView;
        public TextView offerItem,offerDescription;



        public ViewHolder(@NonNull View itemView){
            super(itemView);
            offerImgView=itemView.findViewById(R.id.offer_img);
            offerItem=itemView.findViewById(R.id.offer_txt);
            offerDescription=itemView.findViewById(R.id.offer_info);

        }


    }


}
