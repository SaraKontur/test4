package com.example.test4;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StorageHelper {
    private static final String PREFS_NAME = "TestStorage";
    private static final String TESTS_KEY = "SavedTests";

    public static void saveTest(Context context, Test test) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();

        List<Test> testList = getTests(context);
        testList.add(test);

        String json = gson.toJson(testList);
        editor.putString(TESTS_KEY, json);
        editor.apply();
    }

    public static List<Test> getTests(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(TESTS_KEY, null);

        Type type = new TypeToken<ArrayList<Test>>() {}.getType();
        return json != null ? gson.fromJson(json, type) : new ArrayList<>();
    }
}