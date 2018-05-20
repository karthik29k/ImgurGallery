package com.karthik.aiainsurance.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.karthik.aiainsurance.R;
import com.karthik.aiainsurance.domain.ImageDetails;
import com.karthik.aiainsurance.domain.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.String.valueOf;


public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> {

    @BindView(R.id.textViewtitle)
    TextView title;
    @BindView(R.id.textViewdate)
    TextView date;
    @BindView(R.id.textViewmoreimages)
    TextView viewmoreimages;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.ChildViews)
    LinearLayout childViews;

    private List<Item> itemList;

    public CustomRecyclerViewAdapter(List<Item> cList) {
        this.itemList = cList;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.title.setText(item.getTitle());
        holder.date.setText(valueOf(item.getDatetime()));
        if(item.getImages() != null)
            holder.viewmoreimages.setText("1 of " + valueOf(item.getImages().size()));


        if(item.getImages() != null && !item.getImages().isEmpty()){
            int index = 0;
            for( ImageDetails imageDetails: item.getImages() ) {
                inflateChildViews(holder.childViews, imageDetails,item, ""+(index++)+" of "+ valueOf(item.getImages().size()));
            }
        } else{
                if( item.getImages() != null)
                    Picasso.get().load(item.getImages().get(0).getLink()).into(holder.image);
        }

    }

    @Override
    @NonNull
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_view,parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private void inflateChildViews(LinearLayout parent, ImageDetails img, Item item, String totaimg){
        View childviews = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_view,null, false);
        ButterKnife.bind(this, childviews);

        // set title
        title.setText(item.getTitle());
        // set date
        date.setText(valueOf(item.getDatetime()));
        // set image
        Picasso.get().load(img.getLink()).into(image);
        // set image text
        viewmoreimages.setText(totaimg);

        parent.addView(childviews);

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewtitle)
        TextView title;
        @BindView(R.id.textViewdate)
        TextView date;
        @BindView(R.id.textViewmoreimages)
        TextView viewmoreimages;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.ChildViews)
        LinearLayout childViews;

        /**
         * Constructor.
         *
         * @param view view
         */
        public CustomViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}