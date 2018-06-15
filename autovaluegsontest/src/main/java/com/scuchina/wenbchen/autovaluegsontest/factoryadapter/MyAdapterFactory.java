package com.scuchina.wenbchen.autovaluegsontest.factoryadapter;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

@GsonTypeAdapterFactory
public abstract class MyAdapterFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
       return new AutoValueGson_MyAdapterFactory();
    }
}
