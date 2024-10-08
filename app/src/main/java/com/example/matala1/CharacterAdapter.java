package com.example.matala1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import android.graphics.Color;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

    public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
        private List<Character> characterList;
        private List<Character> characterListFull;
        private Context context;

        public CharacterAdapter(List<Character> characterList, Context context) {
            this.characterList = new ArrayList<>(characterList);
            this.characterListFull = new ArrayList<>(characterList);
            this.context = context;
        }

        @NonNull
        @Override
        public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_item, parent, false);
            return new CharacterViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
            Character character = characterList.get(position);
            holder.nameTextView.setText(character.getName());
            holder.descriptionTextView.setText(character.getDescription());
            holder.imageView.setImageResource(character.getImageResource());
            holder.itemView.setOnClickListener(v -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                TextView title = new TextView(context);
                title.setText(character.getName());
                title.setPadding(20, 20, 20, 20);
                title.setTextSize(20);
                title.setTextColor(Color.WHITE);
                title.setGravity(Gravity.START);
                builder.setCustomTitle(title);;
                builder.setMessage(character.getDescription());
                builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

                AlertDialog dialog = builder.create();
                dialog.show();
            }
            );
        }

        @Override
        public int getItemCount() {
            return characterList.size();
        }

        public void filter(String text) {
            characterList.clear();
            if (text.isEmpty()) {
                characterList.addAll(characterListFull);
            } else {
                for (Character character : characterListFull) {
                    if (character.getName().toLowerCase().contains(text.toLowerCase())) {
                        characterList.add(character);
                    }
                }
            }
            notifyDataSetChanged();
        }

        static class CharacterViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView nameTextView;
            TextView descriptionTextView;

            public CharacterViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                nameTextView = itemView.findViewById(R.id.name_text_view);
                descriptionTextView = itemView.findViewById(R.id.description_text_view);
            }
        }
    }

