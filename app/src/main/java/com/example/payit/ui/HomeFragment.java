package com.example.payit.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.payit.R;
import com.example.payit.adapter.HomeViewPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
    private Context context;
    private ViewPager viewPager;
    private LinearLayout lnrLyt;
    private ArrayList<Integer> offerList;
    private int count = 0;
    private Timer timer;
    private static ImageView imgview;





    public HomeFragment() {


        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }




    public void onCreate(LayoutInflater inflater,ViewGroup container,
                         Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);







        }
//        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//
//        VideoView view = (VideoView)rootView.findViewById(R.id.videoView);
//        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.fps;

//        view.start();




    private void initViews(View view){
        viewPager= view.findViewById(R.id.view_pager_home);
        lnrLyt=view.findViewById(R.id.ln_points_home);
        context = getContext();


    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button offer_btn=(Button)view.findViewById(R.id.offer_btn) ;
//        Button contact_btn=(Button)view.findViewById(R.id.contact_btn) ;


        offer_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.home_view,new OffersFragment());
//                fr.replace(R.id.home_view,new PaymentFragment());
                fr.commit();
            }
        });
        LinearLayout layout = view.findViewById(R.id.contact_btn);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.self_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), ScannerActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.sb_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), SplitBillActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.info_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
//                Intent intent = new Intent(getActivity(), ScannerActivity.class);
//                startActivity(intent);
                Toast.makeText(context, "Made by Aditya @IIIT UNA", Toast.LENGTH_LONG).show();
            }
        });
        layout = view.findViewById(R.id.txn_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), BillsActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.rem_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), Recharges.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.request_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), RequestActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.more_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), uicred.class);
                startActivity(intent);
            }
        });


        //RECHARGES AND BILLS

        layout = view.findViewById(R.id.mobile_ln);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), RechargeActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.electricity_ln);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), Electricity_Activity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.broadband_ln);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), BroadbandActivity.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.cards_ln);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), CreditActivity.class);
                startActivity(intent);
            }
        });

        layout = view.findViewById(R.id.insurance_ln);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), InsuranceActivity.class);
                startActivity(intent);
            }
        });

        layout = view.findViewById(R.id.water_ln);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), WaterActivity.class);
                startActivity(intent);
            }
        });



//BUY ON PAYIT
        layout = view.findViewById(R.id.gft_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), GiftcardActivty.class);
                startActivity(intent);
            }
        });
        layout = view.findViewById(R.id.bus_lyt);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), BusActivity.class);
                startActivity(intent);
            }
        });

        imgview = view.findViewById(R.id.zomato);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), ZomatoActivity.class);
                startActivity(intent);
            }
        });
        imgview = view.findViewById(R.id.swiggy);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), SwiggyActivity.class);
                startActivity(intent);
            }
        });
        imgview = view.findViewById(R.id.youtube);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), YoutubeActivity.class);
                startActivity(intent);
            }
        });
        imgview = view.findViewById(R.id.uber);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD your action here
                Intent intent = new Intent(getActivity(), UberActivity.class);
                startActivity(intent);
            }
        });







        initViews(view);




        //setupViewPager();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                addBottomDots(position);
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
        getActivity().runOnUiThread(() ->{
            if(count<=5){
                viewPager.setCurrentItem(count);
                count++;
            }
            else{
                count=0;
                viewPager.setCurrentItem(count);
            }
        });
    }
},500,2000);


        return view;
    }
    private void setupViewPager() {
        offerList=new ArrayList<>();
        offerList.add(R.drawable.uber);
        offerList.add(R.drawable.zomato);
        offerList.add(R.drawable.swiggy);
        HomeViewPagerAdapter viewPagerAdapter=new HomeViewPagerAdapter(context,offerList);
        viewPager.setAdapter(viewPagerAdapter);
        addBottomDots(0);

    }

    private void addBottomDots(int currentPage){
        TextView[] mTxtDot=new TextView[offerList.size()];
        lnrLyt.removeAllViews();

        for(int i=0;i< mTxtDot.length;i++){
            mTxtDot[i]=new TextView(context);
            mTxtDot[i].setText(Html.fromHtml("&#8226;"));
            mTxtDot[i].setTextSize(35);
            mTxtDot[i].setTextColor(getResources().getColor(R.color.black));
            lnrLyt.addView(mTxtDot[i]);
        }

        if(mTxtDot.length>0)
            mTxtDot[currentPage].setTextColor(getResources().getColor(R.color.grey_400));
    }
    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }

}