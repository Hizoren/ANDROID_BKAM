package com.example.hichampc.bkam_android.ma.bkam.android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hichampc.bkam_android.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by HICHAM PC on 16/03/2015.
 */
public class BKAMAdapter extends RecyclerView.Adapter<BKAMAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Information> data = Collections.emptyList();

    public BKAMAdapter(Context context, List<Information> data) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (getPosition() == 0) {
                context.startActivity(new Intent(context, Accueil.class));
            }
            if (getPosition() == 1) {
                context.startActivity(new Intent(context, BankMaghrib.class));
            }
            if (getPosition() == 2) {
                context.startActivity(new Intent(context, PoletiqueMonetique.class));
            }
            if (getPosition() == 3) {
                context.startActivity(new Intent(context, SupervisionBancaire.class));
            }
            if (getPosition() == 4) {
                context.startActivity(new Intent(context, MoyenPaiement.class));
            }
            if (getPosition() == 5) {
                context.startActivity(new Intent(context, BilletMonnaie.class));
            }
            if (getPosition() == 6) {
                context.startActivity(new Intent(context, Reglementation.class));
            }
            if (getPosition() == 7) {
                context.startActivity(new Intent(context, StatistiqueMonetaire.class));
            }

        }
    }
}
