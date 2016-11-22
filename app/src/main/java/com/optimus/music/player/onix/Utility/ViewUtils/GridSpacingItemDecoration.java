package com.optimus.music.player.onix.Utility.ViewUtils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by apricot on 12/11/15.
 */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spanCount, spacing;
    private  boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge){
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view) +1;
        int column = position % spanCount;

        if(includeEdge) {
            outRect.left = spacing - column * spacing / spanCount;
            outRect.right = (column + 1) * spacing / spanCount;
            if (position < spanCount){
                outRect.top = spacing;
            }

            outRect.bottom = spacing;
        }

        else{
            outRect.left = column * spacing / spanCount;
            outRect.right = spacing - (column + 1) * spacing / spanCount;
            if (position >= spanCount){
                outRect.top = spacing;
            }
        }
    }
}