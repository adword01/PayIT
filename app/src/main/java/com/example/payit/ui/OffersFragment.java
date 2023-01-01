package com.example.payit.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.payit.R;
import com.example.payit.adapter.OfferAdapter;
import com.example.payit.adapter.OfferViewPagerAdapter;
import com.example.payit.model.DealerModel;
import com.example.payit.model.OfferModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class OffersFragment extends Fragment {

    private Context context;
    private RecyclerView offerRecycler,dealersRecycler,dealersRecyclerOnline;
    private DealerAdapter adapter;
    private ViewPager viewPager;
    private ArrayList<String> offerArray;
    private LinearLayout lnrlyt;
    private Timer timer;
    private int count = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public OffersFragment() {
        // Required empty public constructor
    }

    public static OffersFragment newInstance() {
        OffersFragment fragment = new OffersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {






        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_offers, container, false);

        LinearLayout layout = view.findViewById(R.id.recharge_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), Recharges.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.bill_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), BillsActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.send_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), ScannerActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.travel_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), UberActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.grocery_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Toast.makeText(context, "No running offer found", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), ScannerActivity.class);
//                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.food_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), ZomatoActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.elc_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), Electricity_Activity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.movies_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
//                Intent intent = new Intent(getActivity(), ZomatoActivity.class);
//                startActivity(intent);
                Toast.makeText(context, "No new offer playing in theaters", Toast.LENGTH_SHORT).show();
            }
        });

        initViews(view);
        setUpViewPager();

        ArrayList<DealerModel> offlineMerchantList=new ArrayList<>();
        offlineMerchantList.add(new DealerModel("StarBucks","Flat","Rs."+"39","Cashback","Valid Once per User"));
        offlineMerchantList.add(new DealerModel("McDonalds","Get Burger worth","Rs."+"69","Free","Valid for New User"));
        offlineMerchantList.add(new DealerModel("Metro","Flat","Rs."+"19","Free","Bill Payment of Rs. 500"));
        offlineMerchantList.add(new DealerModel("JIO Recharge","Cashback","Rs."+"55","Wallet","On Recharge of Rs.555"));
        adapter=new DealerAdapter(context,offlineMerchantList);
        dealersRecycler.setAdapter(adapter);

        ArrayList<DealerModel> onlineDealerList=new ArrayList<>();
        onlineDealerList.add(new DealerModel("Zomato","Get","20%","Cashback","Valid Twice Per User"));
        onlineDealerList.add(new DealerModel("Swiggy","Get","15%","Cashback","For new user only"));
        onlineDealerList.add(new DealerModel("PVR Cinema","Get","50%","Cashback","Book 4 Tickets"));
        onlineDealerList.add(new DealerModel("PharmEasy","Get","70%","Cashback","Valid Twice Per User"));
        adapter=new DealerAdapter(context,onlineDealerList);
        dealersRecyclerOnline.setAdapter(adapter);

        ArrayList<OfferModel> offerList=new ArrayList<>();
        offerList.add(new OfferModel("Bill Payment","25% Cashback",R.drawable.cashless));
        offerList.add(new OfferModel("Electricity","38% Cashback",R.drawable.credit_card__1_));
        offerList.add(new OfferModel("Water Bill","15% Cashback",R.drawable.ic_add));
        OfferAdapter adapter=new OfferAdapter(context,offerList);
        offerRecycler.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(()->{
                    if (count<=3){
                        viewPager.setCurrentItem(count);
                        count++;
                    }else{
                        count=0;
                        viewPager.setCurrentItem(count);
                    }
                });
            }
        },500,2000);
        return view;
    }

    private void setUpViewPager() {
        offerArray = new ArrayList<>();
        offerArray.add("25% Cashback ");
        offerArray.add("Free Recharge");
        offerArray.add("20% Cashback on Credit Cards");
        offerArray.add("Free Lounge Access on Flight Booking");
//        OfferViewPagerAdapter viewPagerAdapter=new OfferViewPagerAdapter(context,offerArray);
//        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(40,20,40,20);
        viewPager.setPageMargin(20);
        addBottomDots(0);

    }

    private void addBottomDots(int currentPage) {
        TextView[] mTxtDot=new TextView[offerArray.size()];
        lnrlyt.removeAllViews();

        for(int i=0;i< mTxtDot.length;i++){
            mTxtDot[i]=new TextView(context);
            mTxtDot[i].setText(Html.fromHtml("&#8226"));
//            mTxtDot[i].setText("Offers");
            mTxtDot[i].setTextSize(35);
            mTxtDot[i].setTextColor(getResources().getColor(R.color.grey));
            lnrlyt.addView(mTxtDot[i]);
        }
        if(mTxtDot.length>0)
            mTxtDot[currentPage].setTextColor(getResources().getColor(R.color.grey_400));
    }

    private void initViews(View view) {
        viewPager=view.findViewById(R.id.offer_view_pager);
        lnrlyt=view.findViewById(R.id.ln_points);
        offerRecycler=view.findViewById(R.id.rv_bill_pay_offers);
        dealersRecycler=view.findViewById(R.id.rv_offline_merchant);
        dealersRecyclerOnline=view.findViewById(R.id.online_dealers_recycler);
//        offerRecycler.setNestedScrollingEnabled(false);
        dealersRecyclerOnline.setNestedScrollingEnabled(false);
        dealersRecycler.setNestedScrollingEnabled(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        offerRecycler.setLayoutManager(layoutManager);
        dealersRecycler.setLayoutManager(new GridLayoutManager(context,3));
        dealersRecyclerOnline.setLayoutManager(new GridLayoutManager(context,3));
    }
    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }
}