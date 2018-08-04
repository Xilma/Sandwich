package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE_URL ="image";
    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        //Instantiate object of Sandwich class
        Sandwich sandwich = null;

        try {
           JSONObject jsonObject = new JSONObject(json);

           JSONObject sandwichName = jsonObject.getJSONObject(NAME);

           String mainName = sandwichName.getString(MAIN_NAME);

           //alsoKnownAs array
            JSONArray jsonAlsoArray = sandwichName.getJSONArray(ALSO_KNOWN_AS);

            List<String> alsoKnownAs = new ArrayList<>();
            //iterate through array
            for(int i = 0; i < jsonAlsoArray.length(); i++){
                alsoKnownAs.add(jsonAlsoArray.getString(i));
            }

            String placeOfOrigin = jsonObject.getString(PLACE_OF_ORIGIN);

            String description = jsonObject.getString(DESCRIPTION);

            String image = jsonObject.getString(IMAGE_URL);

            //ingredients array
            JSONArray jsonIngArray = jsonObject.getJSONArray(INGREDIENTS);

            List<String> ingredientList = new ArrayList<>();
            //iterate through array
            for(int i = 0; i < jsonIngArray.length(); i++){
                ingredientList.add(jsonIngArray.getString(i));
            }

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredientList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }

}
