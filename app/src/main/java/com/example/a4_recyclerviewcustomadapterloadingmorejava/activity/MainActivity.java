package com.example.a4_recyclerviewcustomadapterloadingmorejava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.a4_recyclerviewcustomadapterloadingmorejava.R;
import com.example.a4_recyclerviewcustomadapterloadingmorejava.adapter.CustomAdapter;
import com.example.a4_recyclerviewcustomadapterloadingmorejava.listener.OnBottomRechedListener;
import com.example.a4_recyclerviewcustomadapterloadingmorejava.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int num = 0;
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members, new OnBottomRechedListener(){
            @Override
            public void onBottomRechedListner(int position) {
                Log.d("@@@", "position" + position);
                Toast toast;
                Context context = getApplicationContext();
                CharSequence text = "Hello toast!" + (num++);
                int duration = Toast.LENGTH_SHORT;

                 toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        recyclerView.setAdapter(adapter);
    }


    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        members.add(new Member());

        for (int i = 0; i < 120 ; i++){
            Random random = new Random();
            int num = random.nextInt() % 2;

            if (num == 0) {
                members.add(new Member("Odilbek" + i, "+997 97 775 17 79", true));
            } else {
                members.add(new Member("Odiljon" + i, "+997 97 775 17 79", false));
            }
        }

        members.add(new Member());
        return members;
    }

}