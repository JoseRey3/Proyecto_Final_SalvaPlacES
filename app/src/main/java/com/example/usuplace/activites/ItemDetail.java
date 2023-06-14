package com.example.usuplace.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.usuplace.Adapter.ItemAdapter;
import com.example.usuplace.Domain.ItemDomain;
import com.example.usuplace.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.io.Serializable;

public class ItemDetail extends AppCompatActivity {

    private TextView lugar, direccion, descripcion, ofrece, price, url;
    private ItemDomain item;
    private FirebaseFirestore mFirestore;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        initView();
        setVariable();
    }

    private void setVariable() {
        mFirestore = FirebaseFirestore.getInstance();

        //String lugares = getIntent().getSerializableExtra("lugar");
        //Query queryPlace =mFirestore.collection("lugares")
               //.whereEqualTo("lugar", lugares);

        String lugares=  getIntent().getStringExtra("lugar");
        String direcciones=  getIntent().getStringExtra("direccion");
        String descripciones=  getIntent().getStringExtra("descripcion");
        String urls=  getIntent().getStringExtra("url");
        lugar.setText(lugares);
        direccion.setText(direcciones);
        descripcion.setText(descripciones);

        Glide
                .with(this)
                .load(urls)
                .into(img);

       /* item= (ItemDomain) getIntent().getSerializableExtra("Object");
        lugar.setText(item.getLugar());
        direccion.setText(item.getDireccion());
        descripcion.setText(item.getDescpcion());

        int drawablaResourceId = getResources().getIdentifier(item.getImg(), "drawable", getPackageName());
        Glide
                .with(this)
                .load(drawablaResourceId)
                .into(img);*/
    }

    private void initView() {
        lugar = findViewById(R.id.lugar);
        direccion = findViewById(R.id.direccion);
        descripcion = findViewById(R.id.descripcion);
        img = findViewById(R.id.img);
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(ItemDetail.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openIntro(View view) {
        Intent intent = new Intent(ItemDetail.this, IntroActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}