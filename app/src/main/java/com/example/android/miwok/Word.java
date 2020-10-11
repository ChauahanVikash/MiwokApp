package com.example.android.miwok;

public class Word {
    private  String mEnglishTranslation ;
    private  String mMiwokTranslation ;
    public Word(String englishTranslation ,String miwokTranslation  ){
        mEnglishTranslation = englishTranslation ;
        mMiwokTranslation = miwokTranslation;
    }

    public String getmEnglishTranslation() {
        return mEnglishTranslation;
    }
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }
}
