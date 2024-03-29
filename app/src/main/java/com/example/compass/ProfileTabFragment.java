package com.example.compass;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileTabFragment extends Fragment {
    CircleImageView imageView;
    Button profile_modified;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile_tab, null);

        imageView = (CircleImageView)view.findViewById(R.id.circleImageView);
        profile_modified = (Button)view.findViewById(R.id.info_newProfile);

        profile_modified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        return view;
    }
    @Override
    public void onActivityResult(int requstCode, int resultCode, Intent data) {
        if (requstCode != 1 || resultCode != -1) {
            return;
        }

        Uri dataUri = data.getData();
        imageView.setImageURI(dataUri);

    }
}
