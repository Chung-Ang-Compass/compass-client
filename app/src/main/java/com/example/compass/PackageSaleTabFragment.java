package com.example.compass;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PackageSaleTabFragment extends Fragment {
    ArrayList<Integer> packages;
    FloatingActionButton writeBtn;

    public PackageSaleTabFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View thisFragmentView = inflater.inflate(R.layout.fragment_package_sale_tab, container, false);
        
        // 패키지 데이터 삽입 하는 곳
        packages = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            packages.add(R.drawable.package_image_temp);
        }


        // 커스텀 아답타 생성
        PackageSaleGridViewAdapter adapter = new PackageSaleGridViewAdapter(
                getContext(),
                R.layout.package_sale_griditem,       // GridView 항목의 레이아웃 package_sale_griditem.xml
                packages                              // 데이터
        );
        GridView gv = (GridView)thisFragmentView.findViewById(R.id.gridView1);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

        // Inflate the layout for this fragment
        return thisFragmentView;
    }
}