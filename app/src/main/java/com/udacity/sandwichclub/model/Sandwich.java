package com.udacity.sandwichclub.model;

import java.util.List;

public class Sandwich {

    //region Example JSON:
    /*
        {
           "name":{
              "mainName":"Bosna",
              "alsoKnownAs":[
                 "Bosner"
              ]
           },
           "placeOfOrigin":"Austria",
           "description":"Bosna
                    is a spicy Austrian fast food dish, said to have originated in either Salzburg or Linz.
                    It is now popular all over western Austria and southern
                    Bavaria.",
           "image":"https://upload.wikimedia.org/wikipedia/commons/c/ca/Bosna_mit_2_Bratw%C3%BCrsten.jpg",
           "ingredients":[
              "White
                    bread",
              "Bratwurst",
              "Onions",
              "Tomato ketchup",
              "Mustard",
              "Curry powder"
           ]
        }
    */
    //endregion

    public static String fName = "name";
    public static String fMainName = "mainName";
    public static String fAlsoKnownAs = "alsoKnownAs";
    public static String fPlaceOfOrigin = "placeOfOrigin";
    public static String fDescription = "description";
    public static String fImage = "image";
    public static String fIngredients = "ingredients";

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
