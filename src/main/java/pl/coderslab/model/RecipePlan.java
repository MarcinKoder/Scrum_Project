package pl.coderslab.model;

public class RecipePlan {
    private int id;
    private int recipeId;
    private String mealName;
    private int order;
    private int dayNameId;
    private int planId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDayNameId() {
        return dayNameId;
    }

    public void setDayNameId(int dayNameId) {
        this.dayNameId = dayNameId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public RecipePlan() {
    }

    public RecipePlan(int recipeId, String mealName, int order, int dayNameId, int planId) {
        this.recipeId = recipeId;
        this.mealName = mealName;
        this.order = order;
        this.dayNameId = dayNameId;
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "RecipePlan{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", mealName='" + mealName + '\'' +
                ", order=" + order +
                ", dayNameId=" + dayNameId +
                ", planId=" + planId +
                '}';
    }
}
