package com.example.payit.ui;

import android.text.style.BackgroundColorSpan;
import android.widget.AutoCompleteTextView;
import android.widget.MediaController;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.payit.R;
import android.widget.VideoView;


import com.example.payit.R;
import com.example.payit.adapter.TransactionAdapter;
import com.example.payit.model.TransactionModel;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    AutoCompleteTextView filter;

    public TransactionFragment() {
        // Required empty public constructor
    }

    public static TransactionFragment newInstance() {
        TransactionFragment fragment=new TransactionFragment();
        Bundle args=new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        this.context=context;
    }
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        VideoView videoView = (VideoView) findViewById(R.id.videoView);
//        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.stock);
//        videoView.start();
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_transaction, container, false);
        initViews(view);

        ArrayList<TransactionModel> transactionModelArrayList = new ArrayList<>();
        transactionModelArrayList.add(new TransactionModel("2 days ago","Paid to","Flipkart","Rs."+"765","Debited from",R.drawable.ic_to_contact));

        transactionModelArrayList.add(new TransactionModel("1 day ago","Paid to","Zomato","Rs."+"500","Debited from",R.drawable.ic_to_contact));

        transactionModelArrayList.add(new TransactionModel("1 day ago","Paid to","Flipkart","Rs."+"200","Debited from",R.drawable.ic_to_contact));

        transactionModelArrayList.add(new TransactionModel("2 days ago","Cashback","PizzaHut","Rs."+"190","Credited to",R.drawable.ic_to_account));

        transactionModelArrayList.add(new TransactionModel("3 days ago","Paid to","BigBazaar","Rs."+"110","Debited from",R.drawable.ic_to_contact));

        transactionModelArrayList.add(new TransactionModel("4 days ago","Paid to","Crompton","Rs."+"700","Debited from",R.drawable.ic_to_contact));

        transactionModelArrayList.add(new TransactionModel("5 days ago","Paid to","Ajio","Rs."+"900","Debited from",R.drawable.ic_to_contact));

        transactionModelArrayList.add(new TransactionModel("6 days ago","Paid to","Myntra","Rs."+"190","Credited to",R.drawable.ic_to_account));

        TransactionAdapter adapter=new TransactionAdapter(transactionModelArrayList,context);
        recyclerView.setAdapter(adapter);
        return view;

    }
    private void initViews(View view){
        recyclerView=view.findViewById(R.id.transaction_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));


    }
}