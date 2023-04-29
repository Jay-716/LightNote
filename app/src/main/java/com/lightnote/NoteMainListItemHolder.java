package com.lightnote;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteMainListItemHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemDescription;
    public View itemView;

    public NoteMainListItemHolder(@NonNull View itemView) {
        super(itemView);

        this.itemView = itemView;
        itemName = itemView.findViewById(R.id.note_item);
        itemDescription = itemView.findViewById(R.id.note_item_description);
    }
}
