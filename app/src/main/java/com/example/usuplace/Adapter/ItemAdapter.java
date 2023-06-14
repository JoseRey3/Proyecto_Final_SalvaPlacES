package com.example.usuplace.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.usuplace.Domain.CategoryDomain;
import com.example.usuplace.Domain.ItemDomain;
import com.example.usuplace.R;
import com.example.usuplace.activites.ItemDetail;
import com.example.usuplace.activites.MainActivity;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends FirestoreRecyclerAdapter<ItemDomain, ItemAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param option
     */

    private FirestoreRecyclerOptions<ItemDomain> itemList;
    private Context context;

    public ItemAdapter(@NonNull FirestoreRecyclerOptions<ItemDomain> option) {
        super(option );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position, @NonNull ItemDomain itemDomain) {


        holder.lugar.setText(itemDomain.getLugar());
        //holder.addres_place.setText(item.get(position).getAddres());
        holder.direccion.setText(itemDomain.getDireccion());
        String url = itemDomain.getImg();
        String descripcion = itemDomain.getDescripcion();

        int drawablaResourceId =
                holder.img.getResources().getIdentifier(itemDomain.getImg(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide
                .with(holder.img.getContext())
                .load(url)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemDetail.class);
                intent.putExtra("lugar", itemDomain.getLugar());
                intent.putExtra("direccion", itemDomain.getDireccion());
                intent.putExtra("descripcion", itemDomain.getDescripcion());
                intent.putExtra("url", itemDomain.getImg());
                v.getContext().startActivity(intent);
            }
        });

        /* int drawablaResourceId = holder.itemView.getResources().getIdentifier(item.get(position).getPic(),
              "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawablaResourceId)
                .into(holder.image_place);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemDetail.class);
            intent.putExtra("Object", itemDomain.getImg());
            context.startActivity(intent);
        });*/
    }



    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    public void clearData() {
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView lugar, direccion;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lugar = itemView.findViewById(R.id.lugar);
            direccion = itemView.findViewById(R.id.direccion);
            img = itemView.findViewById(R.id.img);
        }
    }

}
