package edu.iu.mleichty.bartender.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.List;

import edu.iu.mleichty.bartender.MainActivity;
//Why did I need to add this??
import edu.iu.mleichty.bartender.R;
import edu.iu.mleichty.bartender.model.Cocktail;

//Adapter is what gets data from Firebase into RecyclerView
//In normal RV adapter, need to pass class name of view holder but also need to pass model class for Firestore
public class CocktailAdapter extends FirestoreRecyclerAdapter<Cocktail, CocktailAdapter.CocktailHolder> {

    private Context mContext;

    //this is created from the second warning after implement methods, creates another constructor matching super
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     * @param applicationContext
     */
    public CocktailAdapter(@NonNull FirestoreRecyclerOptions<Cocktail> options, Context applicationContext) {
        super(options);
        mContext = applicationContext;
    }

    //these are implemented from warning after create CocktailHolder class
    //this has a third parameter which means we don't have to keep data here, comes from Firestore
    //tells adapter what we want to put in each view in card layout
    @Override
    protected void onBindViewHolder(@NonNull CocktailHolder holder, int position, @NonNull Cocktail model) {
        holder.textViewName.setText(model.getName());
        holder.textViewDesc.setText(model.getPreparation());
        holder.textViewCat.setText(model.getGlass());
        //how do I set the src attribute of the Image View? setImageResource needs an integer?
//        holder.imageViewPhoto.setImageResource("https://storage.googleapis.com/sp19-30500-cocktail-images/".model.getPhoto());
        String url = "https://storage.googleapis.com/sp19-30500-cocktail-images/";
//        not sure what to add in .with parameter
        Glide.with(mContext)
                .load(url + model.getPhoto())
                .into(holder.imageViewPhoto);

        Log.d("GLIDEEEEEEEEEE", url + model.getPhoto());
    }

    //tell adapter which layout to inflate
    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is the layout for our single items in the rv
        //parent is view group which is basically recycler view where we get content from
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktail_item,
                parent, false);
        return new CocktailHolder(v);
    }

    //need viewholder and create as inner class
    class CocktailHolder extends RecyclerView.ViewHolder {
        //create varaibles we have in cocktail item layout
        TextView textViewName;
        TextView textViewDesc;
        TextView textViewCat;
        //Image
        ImageView imageViewPhoto;

        //constructor that matches super, comes from warning
        public CocktailHolder(@NonNull View itemView) {
            super(itemView);
            //assign variables here, itemView is basically card itself
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewDesc = itemView.findViewById(R.id.text_view_desc);
            textViewCat = itemView.findViewById(R.id.text_view_cat);
            imageViewPhoto = itemView.findViewById(R.id.text_view_photo);
        }
    }



    //    List<Cocktail> mCocktailList;
//    MainActivity mMainActivity;
//
//    //    do these need to be defined? why do I need to add data type if already defined above?
//    public CocktailAdapter(@NonNull FirestoreRecyclerOptions<Cocktail> options) {
//        super(options);
//    }
//
//    //    do I need to write an onCreateViewHolder function similar to friendly eats for this?
////    CocktailAdapter.ListItemHolder.onCreateViewHolder()
//    @Override
//    public ViewHolder onCreateViewHolder() {
//
//    }
//    //    onBindViewHolder()
//    @Override
//    public void onBindViewHolder() {
//
//    }
////        getItemCount()
//
//    public class ListItemHolder extends RecyclerView.ViewHolder implements onClickListener {
//
//    }
}
