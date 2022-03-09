package com.example.receiver;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.broadcastreceiver.R;
/**
 * created by Arshad Khan.......
 */

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentActivity extends Fragment {

    public FragmentActivity() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentActivity newInstance(String param1, String param2) {
        FragmentActivity fragment = new FragmentActivity();
        Bundle args = new Bundle();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.ACTION1);
                i.setPackage("com.example.broadcastreceiver");
                getActivity().sendBroadcast(i);
            }
        });

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.ACTION2);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(i);
            }
        });
        return view;
    }
    }
