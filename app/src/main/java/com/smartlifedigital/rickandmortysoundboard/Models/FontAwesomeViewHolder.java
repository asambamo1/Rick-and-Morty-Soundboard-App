package com.smartlifedigital.rickandmortysoundboard.Models;

import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
import com.smartlifedigital.rickandmortysoundboard.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FontAwesomeViewHolder {
    @Bind(R.id.item_icon) public IconTextView itemIcon;
    @Bind(R.id.item_name) public TextView itemName;

    public FontAwesomeViewHolder(View view) {
        ButterKnife.bind(this, view);
    }
}

