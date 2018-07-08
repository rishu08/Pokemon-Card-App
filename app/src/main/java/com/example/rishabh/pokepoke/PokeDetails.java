package com.example.rishabh.pokepoke;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class PokeDetails implements Parcelable {

    String name ;
    ArrayList<Abilities> abilities;
    int weight,height,order,base_experience;
    Sprites sprites;
    ArrayList<stats> stats;
    ArrayList<types> types;

    public PokeDetails(String name, ArrayList<Abilities> abilities, int weight, int height, int order, int base_experience, Sprites sprites, ArrayList<com.example.rishabh.pokepoke.stats> stats, ArrayList<com.example.rishabh.pokepoke.types> types) {
        this.name = name;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.order = order;
        this.base_experience = base_experience;
        this.sprites = sprites;
        this.stats = stats;
        this.types = types;
    }

    protected PokeDetails(Parcel in) {
        name = in.readString();
        weight = in.readInt();
        height = in.readInt();
        order = in.readInt();
        base_experience = in.readInt();
    }

    public static final Creator<PokeDetails> CREATOR = new Creator<PokeDetails>() {
        @Override
        public PokeDetails createFromParcel(Parcel in) {
            return new PokeDetails(in);
        }

        @Override
        public PokeDetails[] newArray(int size) {
            return new PokeDetails[size];
        }
    };

    public String getName() {
        return name;
    }

    public ArrayList<Abilities> getAbilities() {
        return abilities;
    }

    public int getWeight() {
        return weight;

    }

    public int getHeight() {
        return height;
    }

    public int getOrder() {
        return order;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public ArrayList<com.example.rishabh.pokepoke.stats> getStats() {
        return stats;
    }

    public ArrayList<com.example.rishabh.pokepoke.types> getTypes() {
        return types;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(weight);
        dest.writeInt(height);
        dest.writeInt(order);
        dest.writeInt(base_experience);
    }
}
