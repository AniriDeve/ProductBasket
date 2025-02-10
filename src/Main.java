public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Батон", 150, 3,0.2);
        basket.clear();
        basket.add("Молоко", 100);
        basket.add("Масло", 200, 2);
        basket.add("Сыр", 300, 5, 0.5);
        basket.print();
    }
}
