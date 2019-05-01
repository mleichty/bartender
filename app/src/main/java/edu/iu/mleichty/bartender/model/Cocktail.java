package edu.iu.mleichty.bartender.model;

public class Cocktail {

    private String glass;
    //    how do I declare the arrays?
//    private Array ingredients;
    private String name;
    private String photo;
    private String preparation;
//    private Array recipe;

    public Cocktail() {
        //need empty constructor for later
//        firebase needs this to create cocktails from db docs
    }

//    does cocktailName need to be changed to name?
    public Cocktail(String glass, String name, String photo,
                    String preparation) {
        this.glass = glass;
//        this.ingredients = ingredients;
        this.name = name;
        this.photo = photo;
        this.preparation = preparation;
//        this.recipe = recipe;
    }

    public String getGlass() {return glass;}

//    public String getIngredients() {return ingredients;}

//    need to be the same as in database
    public String getName() {return name;}

    public String getPhoto() {return photo;}

    public String getPreparation() {return preparation;}

//    public String getRecipe() {return recipe;}
}
