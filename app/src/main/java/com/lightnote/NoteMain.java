package com.lightnote;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NoteMain extends AppCompatActivity {

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
    }

    //Search note
    protected void search(String str){
        Toast.makeText(this, "Search hit!", Toast.LENGTH_SHORT).show();
    }

    //Add note
    protected void addNote(){
        Toast.makeText(this, "Add note.", Toast.LENGTH_SHORT).show();
    }

}

