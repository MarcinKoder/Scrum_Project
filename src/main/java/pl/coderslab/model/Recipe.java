package pl.coderslab.model;

import java.sql.Date;

public class Recipe {
    private int id;
    private String name;
    private String ingredients;
    private String description;
    private String created;
    private String updated;
    private int preparation_time;
    private String preparation;
    private int admin_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getPreparation_time() {
        return preparation_time;
    }

    public void setPreparation_time(int preparation_time) {
        this.preparation_time = preparation_time;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public Recipe() {
    }

    public Recipe(String name, String ingredients, String description, String created, String updated, int preparation_time, String preparation, int admin_id) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.preparation_time = preparation_time;
        this.preparation = preparation;
        this.admin_id = admin_id;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", preparation_time=" + preparation_time +
                ", preparation='" + preparation + '\'' +
                ", admin_id=" + admin_id +
                '}';
    }
}
