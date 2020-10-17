package com.example.android.miwok;

public class Word {

    private  String mEnglishTranslation ;
    private  String mMiwokTranslation ;
    private  int mImageResourceId ;
    private  boolean img = false ;
    private int mSoundResId ;


    public Word(String englishTranslation ,String miwokTranslation ,int imageResourceId ,int soundResId){
        mEnglishTranslation = englishTranslation ;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        img = true ;
        mSoundResId = soundResId;
    }

    public Word(String englishTranslation ,String miwokTranslation ,int soundResId ){
        mEnglishTranslation = englishTranslation ;
        mMiwokTranslation = miwokTranslation;
        mSoundResId = soundResId;
    }

    public int getmSoundResId() {
        return mSoundResId;
    }
    public boolean isImg() { return img; }
    public int getImageResourceId() { return mImageResourceId; }
    public String getmEnglishTranslation() {
        return mEnglishTranslation;
    }
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }
}
