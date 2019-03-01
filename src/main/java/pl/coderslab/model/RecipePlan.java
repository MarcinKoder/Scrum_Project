package pl.coderslab.model;

public class RecipePlan {
    private int id;
    private Recipe recipe;
    private String mealName;
    private int order;
    private DayName dayName;
    private Plan plan;
    private String recipeName;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipePlan() {
    }


    public RecipePlan(int id, Recipe recipe, String mealName, int order, DayName dayName, Plan plan) {
        this.id = id;
        this.recipe = recipe;
        this.mealName = mealName;
        this.order = order;
        this.dayName = dayName;
        this.plan = plan;
    }


    public int getId() {
        return id;
    }


    public Recipe getRecipe() {
        return recipe;
    }


    public String getMealName() {
        return mealName;
    }


    public int getOrder() {
        return order;
    }


    public DayName getDayName() {
        return dayName;
    }


    public Plan getPlan() {
        return plan;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


    public void setMealName(String mealName) {
        this.mealName = mealName;
    }


    public void setOrder(int order) {
        this.order = order;
    }


    public void setDayName(DayName dayName) {
        this.dayName = dayName;
    }


    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}