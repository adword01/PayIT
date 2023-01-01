package com.example.payit.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.payit.R;

import java.util.ArrayList;
import java.util.Objects;

public class OfferViewPagerAdapter extends PagerAdapter{

    private Context context;
    private ArrayList<String> offerList;
    int[] images;
    LayoutInflater mLayoutInflater;


    public OfferViewPagerAdapter(Context context, int[] images){
        this.context=context;
        this.offerList=offerList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,int position){
        View view = LayoutInflater.from(context).inflate(R.layout.offer_viewpager_item,container,false);
//        TextView txtOffer=view.findViewById(R.id.OfferGame);
//        txtOffer.setText(offerList.get(position));
//        container.addView(view);
//        return view;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewMain);

        // setting the image in the imageView
        imageView.setImageResource(images[position]);

        // Adding the View
        Objects.requireNonNull(container).addView(view);

        return view;

    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        View view=(View) object;
        container.removeView((LinearLayout)object);
    }
}
