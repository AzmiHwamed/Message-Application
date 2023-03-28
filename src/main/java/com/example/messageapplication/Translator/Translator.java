package com.example.messageapplication.Translator;

import com.example.messageapplication.Models.Root;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Translator {
    public static String translate(String fromLang, String toLang, String text) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://microsoft-translator-text.p.rapidapi.com/translate?to%5B0%5D="+toLang+"&api-version=3.0&profanityAction=NoAction&textType=plain"))
                .header("content-type", "application/json")
                .header("X-RapidAPI-Key", "317452c237mshfeed0a0ac43e9c5p14da22jsn6762b69b5444")
                .header("X-RapidAPI-Host", "microsoft-translator-text.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("[\r {\r\"Text\": \""+text+"\"\r}\r]"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray object = (JsonArray) parser.parse(response.body().toString());
        Root emp[] = gson.fromJson(object, Root[].class);
        return emp[0].translations.get(0).text;
    }

}