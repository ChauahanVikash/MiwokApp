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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> wordss = new ArrayList<Word>();
        wordss.add(new Word("one", "lutti" ,R.drawable.number_one));
        wordss.add(new Word("two", "otiiko",R.drawable.number_two));
        wordss.add(new Word("three", "tolookosu",R.drawable.number_three));
        wordss.add(new Word("four", "oyyisa",R.drawable.number_four));
        wordss.add(new Word("five", "massokka",R.drawable.number_five));
        wordss.add(new Word("six", "temmokka",R.drawable.number_six));
        wordss.add(new Word("seven", "kenekaku",R.drawable.number_seven));
        wordss.add(new Word("eight", "kawinta",R.drawable.number_eight));
        wordss.add(new Word("nine", "wo’e",R.drawable.number_nine));
        wordss.add(new Word("ten", "na’aacha",R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, wordss);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
