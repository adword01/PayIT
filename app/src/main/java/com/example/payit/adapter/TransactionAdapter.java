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
import com.example.payit.model.TransactionModel;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {
    private ArrayList<TransactionModel> txnList;
    private Context context;

    public TransactionAdapter(ArrayList<TransactionModel> txnList, Context context) {
        this.txnList = txnList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {
        holder.txnImg.setImageResource(txnList.get(position).getImg_txn_way());
        holder.txnDate.setText(txnList.get(position).getTxn_date());
        holder.txnTxtView.setText(txnList.get(position).getTxn_med());
        holder.txnDealer.setText(txnList.get(position).getTxn_dealer());
        holder.txnAmt.setText(txnList.get(position).getTxn_amt());
        holder.txnAmtDebCard.setText(txnList.get(position).getTxn_amt_cd());


    }

    @Override
    public int getItemCount() {
        return txnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView txnImg;
        private TextView txnDate, txnTxtView, txnDealer, txnAmt, txnAmtDebCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txnImg = itemView.findViewById(R.id.imv_transaction_type);
            txnDate = itemView.findViewById(R.id.txt_transaction_date);
            txnTxtView = itemView.findViewById(R.id.txn_transaction_type);
            txnDealer = itemView.findViewById(R.id.txt_transaction_merchant);
            txnAmt = itemView.findViewById(R.id.transaction_amt);
            txnAmtDebCard = itemView.findViewById(R.id.txn_transaction_cred_deb);

        }

    }

}