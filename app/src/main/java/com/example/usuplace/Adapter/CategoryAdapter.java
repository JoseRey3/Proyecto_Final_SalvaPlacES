package com.example.usuplace.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.usuplace.Domain.CategoryDomain;
import com.example.usuplace.R;
import com.example.usuplace.activites.ItemDetail;
import com.example.usuplace.activites.MainActivity;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CategoryAdapter extends FirestoreRecyclerAdapter<CategoryDomain, CategoryAdapter.ViewHolder>{

    private Context context;


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CategoryAdapter(@NonNull FirestoreRecyclerOptions<CategoryDomain> options) {
        super(options);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull CategoryDomain categoryDomain) {
        holder.category.setText(categoryDomain.getCategory());

        holder.category.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("category", categoryDomain.getCategory());
                v.getContext().startActivity(intent);
            }
        });
        /*String url = categoryDomain.getImgCat();

        int drawablaResourceId =
                holder.imgCat.getResources().getIdentifier(categoryDomain.getImgCat(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide
                .with(holder.imgCat.getContext())
                .load(url)
                .into(holder.imgCat);

        holder.category.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("category", categoryDomain.getCategory());
                startActivity(intent);
            }

        });*/
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(inflate);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category);
        }
    }

}
