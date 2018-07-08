package com.example.rishabh.pokepoke;

import android.os.Parcel;
import android.os.Parcelable;

class Sprites implements Parcelable {

    String back_female,back_shiny_female,back_default,front_female,front_shiny_female,back_shiny,front_default,front_shiny;

    public Sprites(String back_female, String back_shiny_female, String back_default, String front_female, String front_shiny_female, String back_shiny, String front_default, String front_shiny) {
        this.back_female = back_female;
        this.back_shiny_female = back_shiny_female;
        this.back_default = back_default;
        this.front_female = front_female;
        this.front_shiny_female = front_shiny_female;
        this.back_shiny = back_shiny;
        this.front_default = front_default;
        this.front_shiny = front_shiny;
    }

    protected Sprites(Parcel in) {
        back_female = in.readString();
        back_shiny_female = in.readString();
        back_default = in.readString();
        front_female = in.readString();
        front_shiny_female = in.readString();
        back_shiny = in.readString();
        front_default = in.readString();
        front_shiny = in.readString();
    }

    public static final Creator<Sprites> CREATOR = new Creator<Sprites>() {
        @Override
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        @Override
        public Sprites[] newArray(int size) {
            return new Sprites[size];
        }
    };

    public String getBack_female() {
        return back_female;
    }

    public String getBack_shiny_female() {
        return back_shiny_female;
    }

    public String getBack_default() {
        return back_default;
    }

    public String getFront_female() {
        return front_female;
    }

    public String getFront_shiny_female() {
        return front_shiny_female;
    }

    public String getBack_shiny() {
        return back_shiny;
    }

    public String getFront_default() {
        return front_default;
    }

    public String getFront_shiny() {
        return front_shiny;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(back_female);
        dest.writeString(back_shiny_female);
        dest.writeString(back_default);
        dest.writeString(front_female);
        dest.writeString(front_shiny_female);
        dest.writeString(back_shiny);
        dest.writeString(front_default);
        dest.writeString(front_shiny);
    }
}
