package com.example.usuplace.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.SearchView;

import com.example.usuplace.Adapter.CategoryAdapter;
import com.example.usuplace.Adapter.ItemAdapter;
import com.example.usuplace.Domain.CategoryDomain;
import com.example.usuplace.Domain.ItemDomain;
import com.example.usuplace.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewItem, recyclerViewCategory;
    CategoryAdapter mCategoryAdapter;
    ItemAdapter mItemAdapter;
    private FirebaseFirestore  mFirestore;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //searchView = findViewById(R.id.searchView);
        mFirestore = FirebaseFirestore.getInstance();

        /*//category
        recyclerViewCategory= findViewById(R.id.recyclerViewCategory);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Query query =mFirestore.collection("categoria");

        FirestoreRecyclerOptions<CategoryDomain> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions
                        .Builder<CategoryDomain>()
                        .setQuery(query, CategoryDomain.class)
                        .build();
        mCategoryAdapter = new CategoryAdapter(firestoreRecyclerOptions);
        mCategoryAdapter.notifyDataSetChanged();
        recyclerViewCategory.setAdapter(mCategoryAdapter);*/

        //lugares
        recyclerViewItem= findViewById(R.id.recyclerViewItem);
        recyclerViewItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Query queryPlace = mFirestore.collection("lugares");
        FirestoreRecyclerOptions<ItemDomain> option =
                new FirestoreRecyclerOptions
                        .Builder<ItemDomain>()
                        .setQuery(queryPlace, ItemDomain.class)
                        .build();
        mItemAdapter = new ItemAdapter(option);
        mItemAdapter.notifyDataSetChanged();
        recyclerViewItem.setAdapter(mItemAdapter);
        //search_view();
    }

    /*private void search_view() {
        //Configurar el filtro de búsqueda
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                filterItems(newText);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItems(newText);
                return false;
            }
        });
    }*/

    /*private void filterItems(String s) {
        Query queryPlace;
        queryPlace = mFirestore.collection("lugares");
        FirestoreRecyclerOptions<ItemDomain> options =
                new FirestoreRecyclerOptions.Builder<ItemDomain>()
                        .setQuery(queryPlace.orderBy("lugar")
                                .startAt(s).endAt(s+"~")
                                , ItemDomain.class).build();
        mItemAdapter = new ItemAdapter(options);
        mItemAdapter.startListening();
        recyclerViewItem.setAdapter(mItemAdapter);
    }

    /*private void filterCategoria() {
        String textoExtra=  getIntent().getStringExtra("category");
            Query queryPlace;
            queryPlace = mFirestore.collection("lugares")
                    .whereEqualTo("category", textoExtra);
            FirestoreRecyclerOptions<ItemDomain> options =
                    new FirestoreRecyclerOptions
                            .Builder<ItemDomain>()
                            .setQuery(queryPlace, ItemDomain.class)
                            .build();
            mItemAdapter = new ItemAdapter(options);
            mItemAdapter.startListening();
            recyclerViewItem.setAdapter(mItemAdapter);
    }
*/

    @Override
    protected void onStart() {
        super.onStart();
        //mCategoryAdapter.startListening();
        mItemAdapter.startListening();
    }
    /*public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Manejar los clics en los elementos del menú
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_profile:
                        // Acción para "Perfil"
                        return true;
                    case R.id.menu_logout:
                        // Acción para "Cerrar Sesión"
                        Intent intentc = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intentc);
                        finish(); // Finalizar la actividad actual
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Mostrar el menú desplegable
        popupMenu.show();
    }*/

    public void openMainActivity(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openIntro(View view) {
        Intent intent = new Intent(MainActivity.this, IntroActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}