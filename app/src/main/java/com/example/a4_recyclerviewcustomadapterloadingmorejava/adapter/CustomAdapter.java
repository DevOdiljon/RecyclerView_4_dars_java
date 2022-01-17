package com.example.a4_recyclerviewcustomadapterloadingmorejava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4_recyclerviewcustomadapterloadingmorejava.R;
import com.example.a4_recyclerviewcustomadapterloadingmorejava.listener.OnBottomRechedListener;
import com.example.a4_recyclerviewcustomadapterloadingmorejava.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM_HEADER = 0;
    private static final int TYPE_ITEM_TRUE = 1;
    private static final int TYPE_ITEM_FALSE = 2;
    private static final int TYPE_ITEM_FOOTER = 3;

    int tost = 15;

    RecyclerView recyclerView;
    Context context;
    List<Member> members;
    OnBottomRechedListener listener;

    public CustomAdapter(Context context, List<Member> members, OnBottomRechedListener listener) {
        this.context = context;
        this.members = members;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_ITEM_HEADER;
        if (isFooter(position)) return TYPE_ITEM_FOOTER;

        Member member = members.get(position);

        if (member.isActiv()){
            return TYPE_ITEM_TRUE;
        }
        return TYPE_ITEM_FALSE;
    }

    private boolean isFooter(int position) {
        return position == members.size() - 1;
    }

    private boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_TRUE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_true, parent, false);
            return new CustomViewHolderTRUE(view);
        }else if (viewType == TYPE_ITEM_HEADER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_header, parent, false);
            return new CustomViewHolderHEADER(view);
        }else if (viewType == TYPE_ITEM_FOOTER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_footer, parent, false);
            return new CustomViewHolderFOOTER(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_false, parent, false);
        return new CustomViewHolderFALSE(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == tost){
            listener.onBottomRechedListner(position);
            tost += 15;

//            if (position == members.size()) {
//                recyclerView.scrollToPosition(0);
//            }
        }

        Member member = members.get(position);
        if (holder instanceof CustomViewHolderTRUE) {
            TextView tv_true_name = ((CustomViewHolderTRUE) holder).name;
            TextView tv_true_tel = ((CustomViewHolderTRUE) holder).tel;

            tv_true_name.setText(member.getName());
            tv_true_tel.setText(member.getAbout());
        }
        if (holder instanceof CustomViewHolderFALSE) {
            TextView tv_false_name = ((CustomViewHolderFALSE) holder).tv_false_name;
            TextView tv_false_tel = ((CustomViewHolderFALSE) holder).tv_false_tel;

            tv_false_name.setText(member.getName());
            tv_false_tel.setText(member.getAbout());
        }
    }

    private class CustomViewHolderHEADER extends RecyclerView.ViewHolder {
        private View view;

        public CustomViewHolderHEADER(View v) {
            super(v);
        }
    }

    private class CustomViewHolderTRUE extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView tel;
        private View view;

        public CustomViewHolderTRUE(View v) {
            super(v);
            view = v;
            name = view.findViewById(R.id.tv_name_true);
            tel = view.findViewById(R.id.tv_tel_true);
        }
    }

    private class CustomViewHolderFALSE extends RecyclerView.ViewHolder {
        private TextView tv_false_name;
        private TextView tv_false_tel;
        private View view;

        public CustomViewHolderFALSE(View v) {
            super(v);
            view = v;
            tv_false_name = view.findViewById(R.id.tv_name_false);
            tv_false_tel = view.findViewById(R.id.tv_tel_false);
        }
    }
    private class CustomViewHolderFOOTER extends RecyclerView.ViewHolder {
        private View view;

        public CustomViewHolderFOOTER(View v) {
            super(v);
        }
    }
}
