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

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {



    private MediaPlayer mMediaPlayer;

    private AudioManager audioManager;


    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (i == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
            else if(i == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;
        }
        audioManager.abandonAudioFocus(audioFocusChangeListener);

    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> family = new ArrayList<Word>();

        family.add(new Word("father", "әpә",R.drawable.family_father,R.raw.family_father   ));
        family.add(new Word("mother", "әṭa",R.drawable.family_mother,R.raw.family_mother   ));
        family.add(new Word("son", "angsi",R.drawable.family_son,R.raw.family_son   ));
        family.add(new Word("daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter   ));
        family.add(new Word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother   ));
        family.add(new Word("younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother   ));
        family.add(new Word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister  ));
        family.add(new Word("younger sister", "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister   ));
        family.add(new Word("grandmother ", "ama",R.drawable.family_grandmother,R.raw.family_grandmother   ));
        family.add(new Word("grandfather", "paapa",R.drawable.family_grandfather,R.raw.family_grandfather   ));

        WordAdapter familyAdapter = new WordAdapter(this , family,R.color.category_family);
        ListView familyList = (ListView)findViewById(R.id.list);
        familyList.setAdapter(familyAdapter);

        familyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word item = family.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this ,item.getmSoundResId());

                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });
    }
}
