package com.example.compass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClosetTabFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClosetTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class StreamingTabFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_streaming_tab, container, false);

        return view;
    }
}
