public class Basket {

    private static int count = 0;
    private String items;
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1_000_000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = contains(name);

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + "; количество - " + count + "; цена за 1 шт. - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight;
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void clear() {
        items = "";
        count = 0;
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общая стоимость корзины: " + getTotalPrice() + " рублей");
            System.out.println("Общий вес корзины: " + getTotalWeight() + " кг.");
        }
    }
}
