package com.scuchina.wenbchen.autovaluegsontest.custom;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Set;

public class PersonBeanTypeAdapter implements JsonDeserializer<PersonBean> {

    private static final String STATUS = "status";
    private static final String REASON = "reason";
    private static final String LOCALIZED_MESSAGE = "localizedMessage";
    private static final String PERSON = "person";
    private final Gson gson;

    public PersonBeanTypeAdapter(Gson simplifiedGson) {
        this.gson = simplifiedGson;
    }


    @Override
    public PersonBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject asJsonObject = json.getAsJsonObject();
        String status = asJsonObject.get(STATUS).getAsString();
        String reason = asJsonObject.get(REASON).getAsString();
        String localizedMessage = asJsonObject.get(LOCALIZED_MESSAGE).getAsString();
        JsonElement jsonElement = asJsonObject.get(PERSON);
        JsonObject personJsonObject = jsonElement.getAsJsonObject();
        Set<String> keySet = personJsonObject.keySet();
        Person person = null;
        if (keySet.size() != 1) {
            throw new IllegalArgumentException("wrong json for adding person");
        }
        for (String key : keySet) {
            JsonElement temp = personJsonObject.get(key);
            person = gson.fromJson(personJsonObject.get(key), Person.class);
        }
        return PersonBean.builder()
                .status(status)
                .reason(reason)
                .localizedMessage(localizedMessage)
                .person(person)
                .build();
    }
}
