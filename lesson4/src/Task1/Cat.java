package Task1;

public class Cat extends Animal {
    private static int countCat = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        countCat++;
    }

    public boolean isFull() {
        return isFull;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println("Коты по " + distance + " м. не бегают");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты плавать не умеют");
    }

    public void catEating(Bowl bowl, int amount) {
       if (bowl.decreaseFoodAmount(amount) && (amount >= 0)){
           this.isFull = true;
       }else if (amount < 0){
           System.out.println("Котику столько не съесть");
       }
    }
}
