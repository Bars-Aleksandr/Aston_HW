package Task1;

public class Dog extends Animal {
    private static int dogAmount = 0;
    public Dog(String name) {
        super(name);
        dogAmount++;
    }
    @Override
    public void run(int distance){
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println("Собачки по " + distance + " м. не бегают");
        }
    }
    @Override
    public void swim(int distance){
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println("Собачки по " + distance + " м. не плавают");
        }
    }
}
