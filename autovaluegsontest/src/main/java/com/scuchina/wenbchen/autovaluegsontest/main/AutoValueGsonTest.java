package com.scuchina.wenbchen.autovaluegsontest.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scuchina.wenbchen.autovaluegsontest.custom.PersonBean;
import com.scuchina.wenbchen.autovaluegsontest.custom.PersonBeanTypeAdapter;
import com.scuchina.wenbchen.autovaluegsontest.factoryadapter.MyAdapterFactory;
import com.scuchina.wenbchen.autovaluegsontest.factoryadapter.Student;
import com.scuchina.wenbchen.autovaluegsontest.manualadapter.ClassItem;

import java.io.IOException;

public class AutoValueGsonTest {

    public static void main(String[] args) throws IOException {
        String classJson = "{\n" +
                "  \"name\" : \"math\",\n" +
                "  \"id\" : 12345,\n" +
                "  \"instructor\" : \"Teacher Chen\"\n" +
                "}";
        String studentJson = "{\n" +
                "  \"name\" : \"Wenbin Chen\",\n" +
                "  \"id\" : 1,\n" +
                "  \"email\" : \"wenbchen@wvu.edu\"\n" +
                "}";
        Gson gson = new Gson();
        ClassItem manualClassItem = ClassItem.typeAdapter(gson).fromJson(classJson);
        Gson gson2 = new GsonBuilder()
                .registerTypeAdapterFactory(MyAdapterFactory.create())
                .create();
        Student student = gson2.fromJson(studentJson, Student.class);
        ClassItem classItem = gson2.fromJson(classJson, ClassItem.class);
        System.out.println(manualClassItem.name());
        System.out.println(classItem.name());
        System.out.println(student.name());



        Gson simplifiedGson = createBaseSharedGsonBuilder().create();
        GsonBuilder gsonBuilder = createBaseSharedGsonBuilder();
        gsonBuilder.registerTypeAdapter(PersonBean.class, new PersonBeanTypeAdapter(simplifiedGson));
        Gson customedGson = gsonBuilder.create();
        String personBeanJson = "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"reason\": “OK”,\n" +
                "    \"localizedMessage\": “Status OK”,\n" +
                "    “person”: {\n" +
                "        “3408241989”: {\n" +
                "            \"userRoleUpdatedTs\": 1531149931364,\n" +
                "            \"name\": “Person One”,\n" +
                "            “id”: \"3408241989\",\n" +
                "            \"status\": \"active\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String personBeanJson2 = "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"reason\": \"ok\",\n" +
                "    \"localizedMessage\": \"Status OK\",\n" +
                "    \"person\": {\n" +
                "        \"3408241989\": {\n" +
                "            \"userRoleUpdatedTs\": 1531149931364,\n" +
                "            \"name\": \"Person One\",\n" +
                "            \"id\": \"3408241989\",\n" +
                "            \"status\": \"active\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        PersonBean personBean = customedGson.fromJson(personBeanJson2, PersonBean.class);
        System.out.println(personBean.localizedMessage());


    }

    static GsonBuilder createBaseSharedGsonBuilder() {
        return new GsonBuilder()
                .disableHtmlEscaping()
                .registerTypeAdapterFactory(MyAdapterFactory.create());
    }
}
