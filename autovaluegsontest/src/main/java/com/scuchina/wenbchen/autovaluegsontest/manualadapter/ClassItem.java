package com.scuchina.wenbchen.autovaluegsontest.manualadapter;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class ClassItem {

    @SerializedName("name")
    public abstract String name();

    @SerializedName("id")
    public abstract int id();

    @SerializedName("instructor")
    public abstract String instructor();

    public static Builder builder() {
        return new AutoValue_ClassItem.Builder();
    }

    public static TypeAdapter<ClassItem> typeAdapter(Gson gson) {
        return new AutoValue_ClassItem.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder id(int id);

        public abstract Builder instructor(String instructor);

        public abstract ClassItem build();
    }
}
