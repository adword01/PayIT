package com.example.payit.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.payit.R;
import com.google.android.material.tabs.TabLayout;


public class PaymentFragment extends Fragment {

    private Context context;
    private TabLayout tabLayout;

    public PaymentFragment() {
        // Required empty public constructor
    }

    public static PaymentFragment newInstance() {
        PaymentFragment fragment=new PaymentFragment();
        Bundle args=new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_payment, container, false);
        initViews(view);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position=tab.getPosition();
                if(position==0){
                    Toast.makeText(context,"QR Scanner",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,QrScanner.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(context,"Payment Gateway",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,ScannerActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position=tab.getPosition();
                if(position==0){
                    Toast.makeText(context,"QR Scanner",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,QrScanner.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(context,"Payment Gateway",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,ScannerActivity.class);
                    startActivity(intent);
                }}
        });
        return view;
    }

    private void initViews(View view) {
        tabLayout=view.findViewById(R.id.pay_tab);
        tabLayout.addTab(tabLayout.newTab().setText("Scan QR"));
        tabLayout.addTab(tabLayout.newTab().setText("Payment Gateway"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

}