package hackerRankChallenges;

interface Food {
    public String getType();
}
class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}
class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("pizza"))
            return new Pizza();
        else if (order.equalsIgnoreCase("cake"))
            return new Cake();
        return null;
    }
}

    public class FactoryMethod {
        public static void main(String[] args) {
            FoodFactory foodFactory = new FoodFactory();
            Food food = foodFactory.getFood("pizza");
            System.out.println(food.getType());

            food = foodFactory.getFood("cake");
            System.out.println(food.getType());

        }
    }