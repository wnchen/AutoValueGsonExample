package com.scuchina.wenbchen.autovaluegsontest.custom;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class PersonBean {

	public abstract String status();

	public abstract String reason();

	public abstract String localizedMessage();

	public abstract Person person();

	public static TypeAdapter<PersonBean> typeAdapter(Gson gson) {
		return new AutoValue_PersonBean.GsonTypeAdapter(gson);
	}

	public static Builder builder() {
		return new AutoValue_PersonBean.Builder();
	}

	@AutoValue.Builder
	public abstract static class Builder {
		public abstract Builder status(String status);

		public abstract Builder reason(String reason);

		public abstract Builder localizedMessage(String localizedMessage);

		public abstract Builder person(Person person);

		public abstract PersonBean build();
	}
}