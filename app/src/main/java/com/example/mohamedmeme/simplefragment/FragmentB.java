package com.example.mohamedmeme.simplefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {

    private static final String TAG = "FragmentBLifeCycle";
    private static final String MESSAGE_KEY = "message";
    private String message;
    private TextView tvMessage;




//method that send the data from fragment to another fragment
    public static FragmentB newInstance (String message){

        FragmentB fragmentB=new FragmentB();
        Bundle bundle=new Bundle();
        bundle.putString(MESSAGE_KEY,message);
        fragmentB.setArguments(bundle);
        return fragmentB;

    }

    //onAttach Method get the context of the activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach");
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");

        Bundle bundle=getArguments();
        if(bundle!=null){
            message=bundle.getString(MESSAGE_KEY);
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        tvMessage= view.findViewById(R.id.tv_message);
        tvMessage.setText(message);
        return view;
    }


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated");

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
    }

    public void updateMessage(String message) {
        tvMessage.setText(message);
    }
}
