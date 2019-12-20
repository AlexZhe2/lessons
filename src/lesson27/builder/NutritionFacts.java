package lesson27.builder;

public class NutritionFacts {

    private final int servings;
    private final int calories;
    private final int fat;


    public static class Builder {
        // обязательные параметры
        private final int servings;
        // необязательные параметры
        // инициализируются дефолтными значениями
        private int calories = 0;
        private int fat = 0;

        public Builder(int servings) {
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }
}
