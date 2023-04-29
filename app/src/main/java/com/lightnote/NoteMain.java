package com.lightnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NoteMain extends AppCompatActivity implements NoteMainItemListAdapter.OnItemClickListener {

    //Prevent return to start activity
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_main);

        ImageView avatar = findViewById(R.id.avatar);
        avatar.setImageResource(R.drawable.avatar);

        setListeners();
    }

    private void setListeners(){
        //Search event
        EditText searchBar = findViewById(R.id.searchbar);
        searchBar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == 66){
                    search(searchBar.getText().toString());
                    return true;
                }
                return false;
            }
        });

        //Add note event
        LinearLayout addnote = findViewById(R.id.addnote);
        addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
            }
        });

        //Initialize note list and add click event listener
        RecyclerView recyclerView = findViewById(R.id.maincontent);
        List<NoteMainNoteListItem> items = new ArrayList<NoteMainNoteListItem>();
//        items.add(new NoteMainNoteListItem("test title 1", "This is title 1"));
//        items.add(new NoteMainNoteListItem("test title 2", "This is title 2"));
//        items.add(new NoteMainNoteListItem("test title 3", "This is title 3"));
//        items.add(new NoteMainNoteListItem("test title 4", "This is title 4"));
        for (int i = 0; i < 20; i++) {
            items.add(new NoteMainNoteListItem("test title " + i, "This is title " + i));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NoteMainItemListAdapter adapter = new NoteMainItemListAdapter(items);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    //Search note
    protected void search(String str){
        Toast.makeText(this, "Search hit!", Toast.LENGTH_SHORT).show();
    }

    //Add note
    protected void addNote(){
        Toast.makeText(this, "Add note.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnItemClick(NoteMainNoteListItem item) {
        Toast.makeText(this, "Clicked item " + item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}

