package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class GuideInfoActivity extends AppCompatActivity {
    private Guide guide;
    TextView nameTV;
    TextView countryTV;
    TextView cityTV;
    TextView themeTV;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_info);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("Guide Name");
        String country = intent.getExtras().getString("Guide Country");
        String city = intent.getExtras().getString("Guide City");
        String theme = intent.getExtras().getString("Guide Theme");

        guide = new Guide(name, country, city, theme, null, null);

        nameTV = findViewById(R.id.name);
        countryTV = findViewById(R.id.country);
        cityTV = findViewById(R.id.city);
        themeTV = findViewById(R.id.theme);

        nameTV.setText(guide.getName());
        countryTV.setText(guide.getCountry());
        cityTV.setText(guide.getCity());
        themeTV.setText(guide.getTheme());

        showChatList();


        findViewById(R.id.chatting_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                intent.putExtra("Guide Name", guide.getName());
                startActivity(intent);
                finish();
            }
        });
    }
    private void showChatList() {

        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
        databaseReference.child("chat").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
