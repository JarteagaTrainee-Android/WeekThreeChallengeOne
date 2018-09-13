package com.applaudostudio.weekthreechallengeone.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CardItem implements Parcelable {
    private int mCardImgRs;
    private int mColorBarRs;
    private int mLogo;
    private String mCardPlaName;
    private String mDescription;
    private String mPhone;
    private String mSiteUrl;
    private String mLatitude;

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String mLatitude) {
        this.mLatitude = mLatitude;
    }

    public String getLongitud() {
        return mLongitud;
    }

    public void setLongitud(String mLongitud) {
        this.mLongitud = mLongitud;
    }

    private String mLongitud;


    public int getCardImgRs() {
        return mCardImgRs;
    }

    public void setCardImgRs(int mCardImgRs) {
        this.mCardImgRs = mCardImgRs;
    }

    public int getColorBarRs() {
        return mColorBarRs;
    }

    public void setColorBarRs(int mColorBarRs) {
        this.mColorBarRs = mColorBarRs;
    }

    public int getLogo() {
        return mLogo;
    }

    public void setLogo(int mLogo) {
        this.mLogo = mLogo;
    }

    public String getCardPlaName() {
        return mCardPlaName;
    }

    public void setCardPlaName(String mCardPlaName) {
        this.mCardPlaName = mCardPlaName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getSiteUrl() {
        return mSiteUrl;
    }

    public void setSiteUrl(String mSiteUrl) {
        this.mSiteUrl = mSiteUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCardImgRs);
        dest.writeInt(this.mColorBarRs);
        dest.writeInt(this.mLogo);
        dest.writeString(this.mCardPlaName);
        dest.writeString(this.mDescription);
        dest.writeString(this.mPhone);
        dest.writeString(this.mSiteUrl);
        dest.writeString(this.mLatitude);
        dest.writeString(this.mLongitud);
    }

    public CardItem() {
    }

    protected CardItem(Parcel in) {
        this.mCardImgRs = in.readInt();
        this.mColorBarRs = in.readInt();
        this.mLogo = in.readInt();
        this.mCardPlaName = in.readString();
        this.mDescription = in.readString();
        this.mPhone = in.readString();
        this.mSiteUrl = in.readString();
        this.mLatitude = in.readString();
        this.mLongitud = in.readString();
    }

    public static final Parcelable.Creator<CardItem> CREATOR = new Parcelable.Creator<CardItem>() {
        @Override
        public CardItem createFromParcel(Parcel source) {
            return new CardItem(source);
        }

        @Override
        public CardItem[] newArray(int size) {
            return new CardItem[size];
        }
    };
}
