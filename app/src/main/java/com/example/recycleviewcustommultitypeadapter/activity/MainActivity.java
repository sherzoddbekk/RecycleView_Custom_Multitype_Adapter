package com.example.recycleviewcustommultitypeadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recycleviewcustommultitypeadapter.R;
import com.example.recycleviewcustommultitypeadapter.adapter.CustomAdapter;
import com.example.recycleviewcustommultitypeadapter.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }
    void initView(){
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }
    private void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
    private  List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            if(i == 0 || i == 5 || i == 16 || i ==25){
                members.add(new Member("Sherzod" + i, "Jurabekov" + i ,false));
            } else
            {
                members.add(new Member("Sherzod" + i, "Jurabekov" + i ,true));
            }
        }
        return members;
    }
}