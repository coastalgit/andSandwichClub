package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {
        if (json == null)
            return null;

        Sandwich sandwich = new Sandwich();

        JSONObject jsonObjAll = null;
        try {
            jsonObjAll = new JSONObject(json);

            JSONObject joName = jsonObjAll.getJSONObject(Sandwich.fName);
            String sMainName = joName.getString(Sandwich.fMainName);
            sandwich.setMainName(sMainName);
            JSONArray jaAKA = joName.getJSONArray(Sandwich.fAlsoKnownAs);
            sandwich.setAlsoKnownAs(jsonArrayToList(jaAKA));

            String sOrigin = jsonObjAll.getString(Sandwich.fPlaceOfOrigin);
            sandwich.setPlaceOfOrigin(sOrigin);

            String sDesc = jsonObjAll.getString(Sandwich.fDescription);
            sandwich.setDescription(sDesc);

            String sImage = jsonObjAll.getString(Sandwich.fImage);
            sandwich.setImage(sImage);

            JSONArray jaIngredients = jsonObjAll.getJSONArray(Sandwich.fIngredients);
            sandwich.setIngredients(jsonArrayToList(jaIngredients));

        } catch (JSONException e) {
            Log.e(TAG, "parseSandwichJson: "+Log.getStackTraceString(e) );
            sandwich = null;
        }

        return sandwich;
    }

    private static ArrayList<String> jsonArrayToList(JSONArray jsonArray){
        ArrayList<String> arrayList = null;
        if (jsonArray != null) {
            arrayList = new ArrayList<>();
            for (int i=0;i<jsonArray.length();i++){
                try {
                    arrayList.add(jsonArray.getString(i));
                } catch (JSONException e) {
                    Log.e(TAG, "jsonArrayToList: "+Log.getStackTraceString(e) );
                }
            }
        }
        return arrayList;
    }
}
