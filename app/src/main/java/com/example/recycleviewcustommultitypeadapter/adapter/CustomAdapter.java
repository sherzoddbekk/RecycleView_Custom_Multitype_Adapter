package com.example.recycleviewcustommultitypeadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewcustommultitypeadapter.R;
import com.example.recycleviewcustommultitypeadapter.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);
        if (member.isAvailable()){
            return TYPE_AVAILABLE_YES;
        }
        return TYPE_AVAILABLE_NOT;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_yes,parent,false);
            return new CustomViewYesHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_no,parent,false);
        return new CustomViewNoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof CustomViewYesHolder){
            TextView first_name = ((CustomViewYesHolder) holder).first_name;
            TextView last_name = ((CustomViewYesHolder) holder).last_name;
            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());
        }
        if (holder instanceof CustomViewNoHolder){
            TextView first_name = ((CustomViewNoHolder) holder).first_name;
            TextView last_name = ((CustomViewNoHolder) holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
    class CustomViewYesHolder extends RecyclerView.ViewHolder{

        TextView first_name;
        TextView last_name;
        public CustomViewYesHolder(@NonNull View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.textViewFirstNameYes);
            last_name = itemView.findViewById(R.id.textViewLastNameYes);
        }
    }
    class CustomViewNoHolder extends RecyclerView.ViewHolder{
        TextView first_name;
        TextView last_name;
        public CustomViewNoHolder(@NonNull View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.textViewFirstNameNo);
            last_name  = itemView.findViewById(R.id.textViewLastNameNo);
        }
    }

}
