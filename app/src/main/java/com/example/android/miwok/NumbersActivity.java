/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer sound ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> wordss = new ArrayList<Word>();
        wordss.add(new Word("one", "lutti" ,R.drawable.number_one, R.raw.number_one));
        wordss.add(new Word("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        wordss.add(new Word("three", "tolookosu",R.drawable.number_three, R.raw.number_three));
        wordss.add(new Word("four", "oyyisa",R.drawable.number_four, R.raw.number_four));
        wordss.add(new Word("five", "massokka",R.drawable.number_five, R.raw.number_five));
        wordss.add(new Word("six", "temmokka",R.drawable.number_six, R.raw.number_six));
        wordss.add(new Word("seven", "kenekaku",R.drawable.number_seven, R.raw.number_seven));
        wordss.add(new Word("eight", "kawinta",R.drawable.number_eight, R.raw.number_eight));
        wordss.add(new Word("nine", "wo’e",R.drawable.number_nine, R.raw.number_nine));
        wordss.add(new Word("ten", "na’aacha",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, wordss, R.color.category_numbers );

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word item = wordss.get(position);
                sound = MediaPlayer.create(NumbersActivity.this ,item.getmSoundResId());
                sound.start();

            }
        });
    }
}
