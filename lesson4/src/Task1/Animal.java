package Task1;

public abstract class Animal {
    private final String name;
    private static int countAnimal = 0;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        if (distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println("Дистанция не может быть отрицательной или равняться нулю");
        }
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + " м.");
    }

}
