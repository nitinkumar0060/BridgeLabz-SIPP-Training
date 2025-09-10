import java.util.*;

interface MealPlan {
    String getMealType();
    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    private String mealType;
    public VegetarianMeal(String mealType) { this.mealType = mealType; }
    public String getMealType() { return mealType; }
    public boolean isValid() { return mealType.toLowerCase().contains("vegetable"); }
}

class VeganMeal implements MealPlan {
    private String mealType;
    public VeganMeal(String mealType) { this.mealType = mealType; }
    public String getMealType() { return mealType; }
    public boolean isValid() { return !mealType.toLowerCase().contains("dairy"); }
}

class KetoMeal implements MealPlan {
    private String mealType;
    public KetoMeal(String mealType) { this.mealType = mealType; }
    public String getMealType() { return mealType; }
    public boolean isValid() { return mealType.toLowerCase().contains("protein"); }
}

class HighProteinMeal implements MealPlan {
    private String mealType;
    public HighProteinMeal(String mealType) { this.mealType = mealType; }
    public String getMealType() { return mealType; }
    public boolean isValid() { return mealType.toLowerCase().contains("high-protein"); }
}

class Meal<T extends MealPlan> {
    private T plan;
    public Meal(T plan) { this.plan = plan; }
    public T getPlan() { return plan; }
    public void showMeal() {
        System.out.println("Meal Type: " + plan.getMealType());
    }
}

class MealGenerator {
    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {
        if (plan.isValid()) {
            return new Meal<>(plan);
        } else {
            throw new IllegalArgumentException("Invalid meal plan: " + plan.getMealType());
        }
    }
}

public class MealApp {
    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> meals = new ArrayList<>();

        VegetarianMeal veg = new VegetarianMeal("Mixed Vegetable Curry");
        VeganMeal vegan = new VeganMeal("Tofu Stir Fry");
        KetoMeal keto = new KetoMeal("Grilled Chicken Protein Bowl");
        HighProteinMeal hp = new HighProteinMeal("High-Protein Lentil Soup");

        meals.add(MealGenerator.generateMeal(veg));
        meals.add(MealGenerator.generateMeal(vegan));
        meals.add(MealGenerator.generateMeal(keto));
        meals.add(MealGenerator.generateMeal(hp));

        for (Meal<? extends MealPlan> meal : meals) {
            meal.showMeal();
        }
    }
}
