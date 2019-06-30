package com.example.spinner;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

class GalleryAdapter extends RecyclerView.Adapter<GalleryItemViewHolder>{

    private GalleryItemViewHolder.GalleryItemListener clickListener;

    public GalleryAdapter(GalleryItemViewHolder.GalleryItemListener clickListener){
        this.clickListener = clickListener;
    }

    private ImageItem[] images = new ImageItem[]{
            new ImageItem(R.drawable.stock, "guy"),
            new ImageItem(R.drawable.stocktwo, "guy1"),
            new ImageItem(R.drawable.stockthree, "guy2"),
            new ImageItem(R.drawable.stockthree, "guy2"),
            new ImageItem(R.drawable.stocktwo, "guy1"),
            new ImageItem(R.drawable.stock, "guy"),
            new ImageItem(R.drawable.stock, "guy"),
            new ImageItem(R.drawable.stocktwo, "guy1"),
            new ImageItem(R.drawable.stockthree, "guy2"),
            new ImageItem(R.drawable.stockthree, "guy2"),
            new ImageItem(R.drawable.stocktwo, "guy1"),
            new ImageItem(R.drawable.stock, "guy"),
    };

    @NonNull
    @Override
    public GalleryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_image, viewGroup, false);
        GalleryItemViewHolder holder = new GalleryItemViewHolder(v, clickListener);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GalleryItemViewHolder galleryItemViewHolder, int position) {
        ImageItem imageItem = images[position];
        galleryItemViewHolder.image.setImageResource(imageItem.imageSrc);
        galleryItemViewHolder.txt_description.setText(imageItem.description);
        galleryItemViewHolder.setDataItem(imageItem);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
