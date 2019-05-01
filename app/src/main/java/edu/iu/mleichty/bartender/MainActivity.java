package edu.iu.mleichty.bartender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

//this isn't in his?
import edu.iu.mleichty.bartender.adapter.CocktailAdapter;
import edu.iu.mleichty.bartender.model.Cocktail;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference cocktailRef = db.collection("cocktails");

    private CocktailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect rv to adapter, add to separate method
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        //pass query to Firestore
        Query query = cocktailRef.orderBy("name");
        //this is how get query into adapter
        FirestoreRecyclerOptions<Cocktail> options = new FirestoreRecyclerOptions.Builder<Cocktail>()
                .setQuery(query, Cocktail.class)
                .build();

        adapter = new CocktailAdapter(options, getApplicationContext());

        //reference to rv
        RecyclerView rView = findViewById(R.id.r_view);
        //performance
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(adapter);
    }

    //need to tell adapter when to listen for db changes
    @Override
    protected  void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

////    what does this need to be?
//    List<Cocktail> = cocktailList;
////    why isn't this showing up as an option? Do I need to create the adapter first?
//    RecyclerView mCocktailsRecycler;
//    CocktailAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        I don't know what any of these mean lol
//        find the correct layout (don't need FAB)

//        "wire up" the RecyclerView widget

//        make new Adapter object

//        set up for RecyclerView

//        set the adapter for the RV
//    }
}
