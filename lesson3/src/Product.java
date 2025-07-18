public class Product {
    String name;
    String productionData;
    String manufacturer;
    String originCountry;
    int price;
    boolean bookingStatus;

    public Product(String name, String productionData, String manufacturer, String originCountry, int price, boolean bookingStatus) {
        this.name = name;
        this.productionData = productionData;
        this.manufacturer = manufacturer;
        this.originCountry = originCountry;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    void printProductInfo() {
        System.out.printf("название товара - %s\n " +
                "дата производства - %s\n " +
                "производитель - %s\n " +
                "страна происхождения - %s\n " +
                "цена - %d\n " +
                "состояние бронирования - %b\n", name, productionData, manufacturer, originCountry, price, bookingStatus);
    }

}
