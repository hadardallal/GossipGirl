package com.example.matala1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;



public class MainActivity extends AppCompatActivity {

    private CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Character> characterList = new ArrayList<>();
        characterList.add(new Character("Serena van der Woodsen", "She is an it girl who frequently receives media attention. She is romantically involved with Dan throughout the series.", R.drawable.sarina));
        characterList.add(new Character("Blair Waldorf", "She is the queen bee of Constance Billard. She is best friends with Serena and highly focused on status, wealth and academic achievement.", R.drawable.blair));
        characterList.add(new Character("Daniel Humphrey", "an outcast student at St. Jude's School for Boys. Dan initially does not fit in with the Upper East Side teenagers as he lives in Brooklyn and is not a legacy student, but rather attends St. Jude's with a partial scholarship.", R.drawable.dan));
        characterList.add(new Character("Nate Archibald", "He is a student at St. Jude's, Blair's childhood boyfriend, and the UES golden boy.", R.drawable.nate));
        characterList.add(new Character("Jenny Humphrey", "She is a student at Constance Billard's and Dan's younger sister. Jenny dreams of becoming a fashion designer, and begins as one of Blair's minions in order to gain status.", R.drawable.jenny));
        characterList.add(new Character("Chuck Bass", "He is a student at St. Jude's. He is the son of one of New York's most successful real estate moguls. Decadent and amoral, Chuck is mainly interested in women and alcohol.", R.drawable.chak));
        characterList.add(new Character("Lily van der Woodsen", "Serena and Eric's mother and a three-time divorcée. A former photographer, Lily has become one of the UES's most influential socialites.", R.drawable.lily));
        characterList.add(new Character("Rufus Humphrey", "Dan and Jenny's father. A former rockstar as the lead singer for the band Lincoln Hawk and a 1990s one-hit wonder, Rufus now owns a gallery in Brooklyn.", R.drawable.rufus));
        characterList.add(new Character("Vanessa Abrams", "Dan's childhood best friend who is home-schooled. Vanessa wants to become a documentary filmmaker.", R.drawable.venesa));
        characterList.add(new Character("Eric van der Woodsen", "Serena's younger brother. Both Serena and Eric are children from Lily's first marriage to William van der Woodsen.", R.drawable.eric));


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CharacterAdapter(characterList, this);
        recyclerView.setAdapter(adapter);

        EditText searchEditText = findViewById(R.id.search_edit_text);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}



