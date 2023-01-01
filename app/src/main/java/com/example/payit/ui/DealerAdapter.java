package com.example.payit.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.payit.R;
import com.example.payit.model.DealerModel;

import java.util.ArrayList;

public class DealerAdapter extends RecyclerView.Adapter<DealerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DealerModel> dealerModelArrayList;

    public DealerAdapter(Context context, ArrayList<DealerModel> dealerModelArrayList) {
        this.context = context;
        this.dealerModelArrayList = dealerModelArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_dealers,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.dealerName.setText(dealerModelArrayList.get(position).getDealer_name());
        holder.discountOffer.setText(dealerModelArrayList.get(position).getDiscount_offer());
        holder.discountAmt.setText(dealerModelArrayList.get(position).getDiscount_amt());
        holder.discountVc.setText(dealerModelArrayList.get(position).getDiscount_way());
        holder.discountDetails.setText(dealerModelArrayList.get(position).getDiscount_detail());


    }

    @Override
    public int getItemCount() {
        return dealerModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView dealerName,discountOffer,discountAmt,discountVc,discountDetails;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            dealerName=itemView.findViewById(R.id.dealer_txt);
            discountOffer=itemView.findViewById(R.id.dealer_off);
            discountAmt=itemView.findViewById(R.id.dealer_off_price);
            discountVc=itemView.findViewById(R.id.dealer_off_bw);
            discountDetails=itemView.findViewById(R.id.discount_info);
        }
    }
}
