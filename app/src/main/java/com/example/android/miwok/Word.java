package com.example.android.miwok;

public class Word {

    private  String mEnglishTranslation ;
    private  String mMiwokTranslation ;
    private  int mImageResourceId ;

    public Word(String englishTranslation ,String miwokTranslation ,int imageResourceId ){
        mEnglishTranslation = englishTranslation ;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }

    public Word(String englishTranslation ,String miwokTranslation  ){
        mEnglishTranslation = englishTranslation ;
        mMiwokTranslation = miwokTranslation;
    }



    public int getImageResourceId() { return mImageResourceId; }
    public String getmEnglishTranslation() {
        return mEnglishTranslation;
    }
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }
}
