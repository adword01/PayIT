package com.example.payit.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.payit.R;
import com.example.payit.adapter.OfferViewPagerAdapter;
import com.example.payit.helper.BottomNavHelp;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    ImageView contact;
    private Toolbar mToolbar;
    private TextView toolbartext;
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private OffersFragment offerFragment;
    private PaymentFragment paymentFragment;
    private TransactionFragment transactionFragment;



    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            =item -> {
        switch (item.getItemId()){
            case R.id.navigation_home:
                toolbartext.setText("PayIT");
                setUpFragment(homeFragment);
                return true;

            case R.id.navigation_offers:
                toolbartext.setText("Offers");
                setUpFragment(offerFragment);
                return true;

            case R.id.navigation_payment:
                toolbartext.setText("Scan & Pay");
                setUpFragment(paymentFragment);
                return true;

            case R.id.navigation_transactions:
                toolbartext.setText("Transactions");
                setUpFragment(transactionFragment);
                return true;

            case R.id.navigation_account:
                toolbartext.setText("My Account");
                setUpFragment(accountFragment);
                return true;

            default:
                return false;
        }
    };

    private void setUpFragment(Fragment Fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.replace(R.id.home_view,Fragment);
        fragmentTransaction.commit();
    }

    public class OfferActivity extends AppCompatActivity {

        // creating object of ViewPager
        ViewPager viewPager;
//        ViewPager=findViewById(R.id.offer_view_pager);
//        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // images array
        int[] images = {R.drawable.gift_card, R.drawable.home, R.drawable.healthcare,
                R.drawable.transaction, R.drawable.ic_grocery_store_green, R.drawable.bus, R.drawable.home__1_};

        // Creating Object of ViewPagerAdapter
        OfferViewPagerAdapter OfferViewPagerAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_transaction);




//            VideoView videoView = findViewById(R.id.videoView);
//            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.snp_feature_02);
//            videoView.start();
//
//            MediaController mediaController = new MediaController(this);
//            //link mediaController to videoView
//            mediaController.setAnchorView(videoView);
//            //allow mediaController to control our videoView
//            videoView.setMediaController(mediaController);
//            videoView.start();

//            setContentView(R.layout.OffersFragment);

            // Initializing the ViewPager Object
//            mViewPager = (ViewPager)findViewById(R.id.offer_view_pager);

            // Initializing the ViewPagerAdapter
//            mViewPagerAdapter = new OfferViewPagerAdapter(this,OffersFragment.class);
//
            // Adding the Adapter to the ViewPager
//            mViewPager.setAdapter(mViewPagerAdapter);
        }
    }

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initViews();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.home_view,new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().hide();
        //setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        toolbartext.setText("PayIT");
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        BottomNavHelp.removeShiftMode(bottomNavigationView);

        FragmentTransaction beginTransaction=getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.home_view,homeFragment);
        beginTransaction.commit();
//        setContentView(R.layout.fragment_account);
//        btn=(Button) findViewById(R.id.Logout);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                finish();
//            }
//        });
//        contact=findViewById(R.id.contact);

//        contact.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this,ScannerActivity.class);
//                startActivity(intent);
//            }
//        });
    }
    private void initViews(){
        setContentView(R.layout.activity_main);
        mToolbar=findViewById(R.id.toolbar);
        toolbartext=findViewById(R.id.title_toolbar);
        bottomNavigationView=findViewById(R.id.navigation);
        homeFragment=HomeFragment.newInstance();
        accountFragment=AccountFragment.newInstance();
        offerFragment=OffersFragment.newInstance();
        paymentFragment=PaymentFragment.newInstance();
        transactionFragment=TransactionFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.notify:
                Toast.makeText(this,"Notification",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.scanNpay:
                Toast.makeText(this,"Make Payment",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
