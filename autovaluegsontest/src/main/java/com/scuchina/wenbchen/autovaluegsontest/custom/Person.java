package com.scuchina.wenbchen.autovaluegsontest.custom;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@AutoValue
public abstract class Person{

	@SerializedName("name")
	public abstract String name();

	@SerializedName("userRoleUpdatedTs")
	public abstract long userRoleUpdatedTs();

	@SerializedName("id")
	public abstract String id();

	@SerializedName("status")
	public abstract String status();

	public static TypeAdapter<Person> typeAdapter(Gson gson) {
		return new AutoValue_Person.GsonTypeAdapter(gson);
	}
}