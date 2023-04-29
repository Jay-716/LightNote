package com.lightnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteMainItemListAdapter extends RecyclerView.Adapter<NoteMainListItemHolder> {

    private List<NoteMainNoteListItem> itemList;
    private OnItemClickListener clickListenerr;

    public NoteMainItemListAdapter(List<NoteMainNoteListItem> itemList) {
        this.itemList = itemList;
    }

    public interface OnItemClickListener {
        void OnItemClick(NoteMainNoteListItem item);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListenerr = listener;
    }

    @NonNull
    @Override
    public NoteMainListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_main_note_list_item, parent, false);
        return new NoteMainListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteMainListItemHolder holder, int position) {
        NoteMainNoteListItem item = itemList.get(position);

        holder.itemName.setText(item.getTitle());
        holder.itemDescription.setText(item.getDescription());
        holder.itemView.setOnClickListener(view -> {
            if (clickListenerr != null) {
                clickListenerr.OnItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
