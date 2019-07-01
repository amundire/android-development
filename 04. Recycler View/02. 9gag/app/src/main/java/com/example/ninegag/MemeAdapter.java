package com.example.ninegag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class MemeAdapter extends RecyclerView.Adapter<MemeItemViewHolder>{

    public MemeAdapter(MemeItemViewHolder.MemeItemDownListener downListener, MemeItemViewHolder.MemeItemUpListener upListener, MemeItemViewHolder.MemeItemShareListener shareListener, MemeItemViewHolder.MemeItemCommentListener commentListener, MemeItemViewHolder.AdItemBuyListener adItemBuyListener) {
        this.downListener = downListener;
        this.upListener = upListener;
        this.commentListener = commentListener;
        this.shareListener = shareListener;
        this.buyListener = adItemBuyListener;
    }

    private MemeItemViewHolder.MemeItemDownListener downListener;
    private MemeItemViewHolder.MemeItemUpListener upListener;
    private MemeItemViewHolder.MemeItemCommentListener commentListener;
    private MemeItemViewHolder.MemeItemShareListener shareListener;
    private MemeItemViewHolder.AdItemBuyListener buyListener;

    private MemeItem[] memes = new MemeItem[]{
            new MemeItem(R.drawable.meme01, "kek1", "1212141", "192", false, false),
            new MemeItem(R.drawable.meme02, "haha", "122222", "19", false, false),
            new MemeItem(R.drawable.meme03, "LULW", "123333", "1921", false, false),
            new MemeItem(R.drawable.meme04, "hehexd", "124444", "1921", false, false),
            new MemeItem(R.drawable.meme05, "OMEGALUL", "125555", "1926", false, false),
            new MemeItem(R.drawable.meme06, "KekChamp", "1266661", "155", false, false),
            new MemeItem(R.drawable.meme07, "OkayChamp", "121771", "772", false, false),
            new MemeItem(R.drawable.meme08, "hahahaha", "121771", "772", false, false),
            new MemeItem(R.drawable.meme09, "true", "121771", "772", false, false),
            new MemeItem(R.drawable.meme10, "omgs", "121771", "772", false, false),
            new MemeItem(R.drawable.meme11, "so funi xd", "121771", "772", false, false),
    };



    @NonNull
    @Override
    public MemeItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        MemeItemViewHolder holder = null;
        View v;
        switch (position){
            case 2:
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_meme, viewGroup, false);
            holder = new MemeItemViewHolder(v, upListener, downListener, commentListener, shareListener, null);
            break;
            case 0:
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_ad, viewGroup, false);
            holder = new MemeItemViewHolder(v, null, null, null, null, buyListener);
            break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemeItemViewHolder memeItemViewHolder, int position) {
        MemeItem memeItem = memes[position];
        memeItemViewHolder.image.setImageResource(memeItem.imageSrc);
        if (getItemViewType(position) == 2) {
            memeItemViewHolder.txt_title.setText(memeItem.title);
            memeItemViewHolder.txt_comments.setText(memeItem.comments + " Comments");
            memeItemViewHolder.txt_points.setText(memeItem.points + " Points");
            if (memeItem.isDownvoted) {
                memeItemViewHolder.btnUpvote.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up_arrow, 0, 0, 0);
                memeItemViewHolder.btnDownvote.setCompoundDrawablesWithIntrinsicBounds(R.drawable.down_arrow_pressed, 0, 0, 0);
                memeItemViewHolder.btnUpvote.setEnabled(true);
                memeItemViewHolder.btnDownvote.setEnabled(false);
            } else if (memeItem.isUpvoted) {
                memeItemViewHolder.btnDownvote.setCompoundDrawablesWithIntrinsicBounds(R.drawable.down_arrow, 0, 0, 0);
                memeItemViewHolder.btnUpvote.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up_arrow_pressed, 0, 0, 0);
                memeItemViewHolder.btnDownvote.setEnabled(true);
                memeItemViewHolder.btnUpvote.setEnabled(false);
            }
            memeItemViewHolder.setDataItem(memeItem);
        } else {
            MemeItem adItem = new MemeItem(memeItem.imageSrc, memeItem.title, null, null, null, null);
            memeItemViewHolder.setDataItem(adItem);
            memeItemViewHolder.txt_comments = null;
            memeItemViewHolder.txt_points = null;
        }

    }

    @Override
    public int getItemCount() {
        return memes.length;
    }

    @Override
    public int getItemViewType(int position){
        if(position == 10){
            return 0;
        } else {
            return 2;
        }
    }
}
