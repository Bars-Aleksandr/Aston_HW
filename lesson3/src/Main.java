//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        1. Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена,
//                состояние бронирования покупателем.
//
//        Конструктор класса должен заполнять эти поля при создании объекта.
//        Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
//        2. Создать массив из 5 товаров.
//        createArrayProduct();
        printArrayProducts(createArrayProduct());
//        3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
//        времени их работы и стоимости.
        Park park = new Park();
        Park.Attraction surprice = park.new Attraction("8:00", "22:00", 2.5);
    }

    private static void printArrayProducts(Product[] arrayProduct) {
        for (Product product : arrayProduct) {
            System.out.println("__________________________________");
            product.printProductInfo();
            System.out.println("-----------------------------------");
        }
    }

    private static Product[] createArrayProduct() {
        Product[] products = new Product[5];
        products[0] = new Product("Lada Vesta", "11/01/2021", "Lada LTD", "Russia", 45000, true);
        products[1] = new Product("Audi A4", "21/01/1998", "Audi", "Germany", 15000, false);
        products[2] = new Product("Geely Atlas", "12/12/2020", "BelGee", "Belarus", 40000, true);
        products[3] = new Product("Lada Vesta", "11/01/2020", "Lada LTD", "Russia", 40000, true);
        products[4] = new Product("Geely Atlas", "12/12/2025", "BelGee", "Belarus", 50000, true);
        return products;
    }
}
