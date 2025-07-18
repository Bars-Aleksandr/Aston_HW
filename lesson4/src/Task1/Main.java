package Task1;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Rock");
        cat.run(201);
        cat.run(-100);
        cat.swim(1);
        Bowl bowl = new Bowl(100);
        System.out.println(bowl.getFoodAmount());
        bowl.addFoodAmount(-1);
        cat.catEating(bowl, 10);
        cat.catEating(bowl, 110);
        System.out.println("В миске " + bowl.getFoodAmount() + " еды");
        bowl.addFoodAmount(50);

        System.out.println("котики кушают \n");
        Cat[] cats = new Cat[3];
        for (int i = 0; i < cats.length; i++){
            cats[i] = new Cat("cat" + i);
            cats[i].catEating(bowl, 50);
            if (cats[i].isFull()){
                System.out.println("Котик " + cats[i].getName() + " сыт");
            } else {
                System.out.println("Котик " + cats[i].getName() + " голоден");
            }
        }

        cats[2].catEating(bowl, -10);

    }
}