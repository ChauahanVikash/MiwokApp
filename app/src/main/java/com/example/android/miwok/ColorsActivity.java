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
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private AudioManager audioManager ;

    private MediaPlayer mMediaPlayer;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

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

        final ArrayList<Word> colors = new ArrayList<Word>();

        colors.add(new Word("red", "weṭeṭṭi",R.drawable.color_red  ,R.raw.color_red   ));
        colors.add(new Word("mustard yellow", "chiwiiṭә" ,R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow   ));
        colors.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow   ));
        colors.add(new Word("green", "chokokki",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown   ));
        colors.add(new Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray   ));
        colors.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black   ));
        colors.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white  ));

        WordAdapter colorAdapter = new WordAdapter(this ,colors ,R.color.category_colors);
        ListView colorList =  (ListView)findViewById(R.id.list);
        colorList.setAdapter(colorAdapter);
        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word item = colors.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this ,item.getmSoundResId());
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
