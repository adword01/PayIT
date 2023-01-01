package com.example.payit.ui;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.payit.R;


public class AccountFragment extends Fragment {
    private VideoView videoView;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance() {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    private TextView User;
    private String num;

    public static void setArgument(Bundle b) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_account, container, false);
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        videoView = view.findViewById(R.id.account_vid);
        setupRawVideo();

//        User=view.findViewById(R.id.text_info);
//        Bundle bundle = getArguments();
//        String num = bundle.getString("Number");
//        User.setText("Welcome User, " + num);


//        videoView = (VideoView) view.findViewById(R.id.account_vid);
//        ((VideoView) videoView).setMediaController(new MediaController(getContext()));
//        Uri video = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.error404);
//        ((VideoView) videoView).setVideoURI(video);
//        ((VideoView) videoView).start();



//        Button contact_btn=(Button)view.findViewById(R.id.contact_btn) ;


//        ImageView imageView = getView().findViewById(R.id.imageView2);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "User Profile !", Toast.LENGTH_SHORT).show();            }
//        });

//        VideoView vidv = getView().findViewById(R.id.account_vid);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(),"Under Development",Toast.LENGTH_SHORT).show();
//                // Do something when the image is clicked
//            }
//        });

        Button Logout = view.findViewById(R.id.Logout);

        Logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Logout Successfully", Toast.LENGTH_LONG).show();

//                fr.replace(R.id.home_view, new OffersFragment());
////                fr.replace(R.id.home_view,new PaymentFragment());
//                fr.commit();
            }

        });
        LinearLayout layout = view.findViewById(R.id.info_btn);
        layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Developed by Aditya @IIITU With ❤ \n PayIT", Toast.LENGTH_SHORT).show();


//                fr.replace(R.id.home_view, new OffersFragment());
////                fr.replace(R.id.home_view,new PaymentFragment());
//                fr.commit();
            }

        });

//        Button info = view.findViewById(R.id.info_btn);
//
//        info.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                FragmentTransaction fr = getFragmentManager().beginTransaction();
//                Toast.makeText(getActivity(), "Created By Aditya with ❤", Toast.LENGTH_SHORT).show();
//                fr.replace(R.id.home_view, new OffersFragment());
////                fr.replace(R.id.home_view,new PaymentFragment());
//                fr.commit();



        return view;
    }
    private void setupRawVideo() {
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.dev;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                videoView.start(); //need to make transition seamless.
            }
        });

//        MediaController mediaController = new MediaController(getActivity());
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
    }
}




