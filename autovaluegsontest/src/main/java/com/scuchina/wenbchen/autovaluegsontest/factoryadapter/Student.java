package com.scuchina.wenbchen.autovaluegsontest.factoryadapter;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Student {

    @SerializedName("name")
    public abstract String name();

    @SerializedName("id")
    public abstract int id();

    @SerializedName("email")
    public abstract String email();

    public static TypeAdapter<Student> typeAdapter(Gson gson) {
        return new AutoValue_Student.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Student.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder id(int id);

        public abstract Builder email(String email);

        public abstract Student build();
    }
}
