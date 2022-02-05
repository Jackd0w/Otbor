package FifthProblem;
import java.util.ArrayList;
import java.util.List;


class Item {

    String name;
    int number;
    int size;
    int price;

    public Item(String name, int number, int size, int price) {
        this.name = name;
        this.number = number;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}


public class ItemList {

    public static List<Item> createItemDatabase() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Something",2, 125,15));
        items.add(new Item("Something else", 1, 58,25));
        items.add(new Item("Something №3", 1, 200,35));
        items.add(new Item("Anything valuable", 5, 2000,90));
        items.add(new Item("Money", 1, 20,150));
        return items;
    }


}