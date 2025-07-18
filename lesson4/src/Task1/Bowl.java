package Task1;

public class Bowl {
    private int foodAmount =0;


    public Bowl(int foodAmount) {
        if (foodAmount >= 0) {
            this.foodAmount = foodAmount;
        }else {
            System.out.println("миску с отрицательным значением еды создать нельзя");
        }

    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFoodAmount(int foodAmount) {
        if (foodAmount >= 0) {
            this.foodAmount += foodAmount;
        } else {
            System.out.println("отрицательное количество еды добавить нельзя");
        }
    }
    public boolean  decreaseFoodAmount(int foodAmount){
        if (this.foodAmount >= foodAmount){
            this.foodAmount -= foodAmount;
            return true;
        } else {
            System.out.println("В миске не достаточно еды");
            return false;
        }
    }
}
