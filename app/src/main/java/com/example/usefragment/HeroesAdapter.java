package com.example.usefragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.
        Adapter<HeroesAdapter.ViewHolder> {
    private ArrayList<Heroes> heroes;
    private Context context;

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, final int position) {
        holder.tvName.setText(getHeroes().get(position).getHeroName());
        holder.tvDetail.setText(getHeroes().get(position).getHeroDetail());

        Glide.with(context).load(getHeroes().get(position).getHeroImage()).into(holder.ivHero);

        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, DetailsHero.class);
                intent.putExtra("data1", getHeroes().get(position).getHeroName());
                intent.putExtra("data2", getHeroes().get(position).getHeroDetail());
                intent.putExtra("imageV", getHeroes().get(position).getHeroImage());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHero;
        TextView tvName, tvDetail;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.iv_ahmaddahlan);
            tvName = itemView.findViewById(R.id.tv_namaad);
            tvDetail = itemView.findViewById(R.id.tv_deskripsiad);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
