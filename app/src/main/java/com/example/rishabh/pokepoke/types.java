package com.example.rishabh.pokepoke;

import android.os.Parcel;
import android.os.Parcelable;

public class types implements Parcelable {

    int slot;
    type type;

    public types(int slot, com.example.rishabh.pokepoke.type type) {
        this.slot = slot;
        this.type = type;
    }

    protected types(Parcel in) {
        slot = in.readInt();
    }

    public static final Creator<types> CREATOR = new Creator<types>() {
        @Override
        public types createFromParcel(Parcel in) {
            return new types(in);
        }

        @Override
        public types[] newArray(int size) {
            return new types[size];
        }
    };

    public int getSlot() {
        return slot;
    }

    public com.example.rishabh.pokepoke.type getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(slot);
    }
}
