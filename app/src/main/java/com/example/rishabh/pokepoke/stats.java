package com.example.rishabh.pokepoke;

import android.os.Parcel;
import android.os.Parcelable;

public class stats implements Parcelable{
    stat stat;
    int effort;
    int base_stat;

    public stats(com.example.rishabh.pokepoke.stat stat, int effort, int base_stat) {
        this.stat = stat;
        this.effort = effort;
        this.base_stat = base_stat;
    }

    protected stats(Parcel in) {
        effort = in.readInt();
        base_stat = in.readInt();
    }

    public static final Creator<stats> CREATOR = new Creator<stats>() {
        @Override
        public stats createFromParcel(Parcel in) {
            return new stats(in);
        }

        @Override
        public stats[] newArray(int size) {
            return new stats[size];
        }
    };

    public com.example.rishabh.pokepoke.stat getStat() {
        return stat;
    }

    public int getEffort() {
        return effort;
    }

    public int getBase_stat() {
        return base_stat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(effort);
        dest.writeInt(base_stat);
    }
}
