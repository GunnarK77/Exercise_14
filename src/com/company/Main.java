package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class todos{
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public todos(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }
}



public class Main {

    public static void main(String[] args) {
        System.out.println("JSON with GSON example");

        serializeSimple();
        deserializeSimple();
    }
    static void serializeSimple(){

        todos thing = new todos("walk the dog", true, 0, 3, "dog");
        Gson gson = new Gson();
        todos thing2 = new todos("Pay the bills", false, 1, 1,"bills" );
        ArrayList list = new ArrayList();
        list.add(thing);
        list.add(thing2);
        String json = gson.toJson(list);

        System.out.println(json);

        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(list,writer);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void deserializeSimple(){
        String person2Json = "{ \"name\": \"Gunnar\", \"email\": \"Gunar@gmail.com\", \"age\": 17, \"isDev\": true }";

        Gson gson = new Gson();
        todos person2 = gson.fromJson(person2Json,todos.class);

        System.out.println(person2.getClass());
    }


}
