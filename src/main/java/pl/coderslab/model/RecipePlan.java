package pl.coderslab.model;

public class RecipePlan {
    private String dayName;
    private String recipeName;
    private String recipeId;
    private String mealName;

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public RecipePlan() {
    }

    @Override
    public String toString() {
        return "RecipePlan{" +
                "dayName='" + dayName + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", recipeDescription='" + recipeId + '\'' +
                ", mealName='" + mealName + '\'' +
                '}';
    }
}
