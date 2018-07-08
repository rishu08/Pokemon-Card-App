package com.example.rishabh.pokepoke;

import android.os.Parcel;
import android.os.Parcelable;

class Abilities implements Parcelable{
    int slot;
    ability ability;

    public Abilities(int slot, com.example.rishabh.pokepoke.ability ability) {
        this.slot = slot;
        this.ability = ability;
    }

    protected Abilities(Parcel in) {
        slot = in.readInt();
    }

    public static final Creator<Abilities> CREATOR = new Creator<Abilities>() {
        @Override
        public Abilities createFromParcel(Parcel in) {
            return new Abilities(in);
        }

        @Override
        public Abilities[] newArray(int size) {
            return new Abilities[size];
        }
    };

    public int getSlot() {
        return slot;
    }

    public com.example.rishabh.pokepoke.ability getAbility() {
        return ability;
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
