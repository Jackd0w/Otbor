package FifthProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import FifthProblem.ItemList;

import static FifthProblem.ItemList.createItemDatabase;


public class ItemBase {
    private final Safe safe;
    private final List<Item> items;
    private final Scanner scanner;

    {
        safe = new Safe();
        items = createItemDatabase();
        scanner = new Scanner(System.in);
    }

    public void printItemList() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public List<Item> sortByPrice() {
        return items.stream()
                .sorted((o1, o2) -> o2.getPrice() - o1.getPrice())
                .collect(Collectors.toList());
    }

    public void printSortedListByPrice(List<Item> sortedListByPrice) {
        sortedListByPrice.forEach(System.out::println);
    }

    public int findMinVolumeFromItemList() {
        return items.stream()
                .sorted((o1, o2) -> o1.getSize() - o2.getSize())
                .collect(Collectors.toList()).get(0).getSize();
    }

    public List<Item> putItemInTheSafeWithMaxPrice(List<Item> sortedList, int volume) {
        List<Item> resultList = new ArrayList<>();
        safe.setSize(volume);

        for (int i = 0; i < sortedList.size(); i++) {
            int sumVolume = sortedList.get(i).getSize() * sortedList.get(i).getNumber();
            if (safe.getSize() >= sumVolume) {
                resultList.add(new Item(sortedList.get(i).getName(), sortedList.get(i).getNumber(),
                        sortedList.get(i).getSize(), sortedList.get(i).getPrice()));
                safe.setSize(safe.getSize() - sumVolume);
            } else {
                int newNumber = safe.getSize() / sortedList.get(i).getSize();
                if (newNumber > 0) {
                    resultList.add(new Item(sortedList.get(i).getName(), newNumber,
                            sortedList.get(i).getSize(), sortedList.get(i).getPrice()));
                    break;
                }
            }
        }
        return resultList;
    }

    public void printItemInTheSafeWithMaxPrice(List<Item> resultList) {
        resultList.forEach(System.out::println);
    }
}
