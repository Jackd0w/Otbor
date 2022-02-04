package FifthProblem;

import java.util.Scanner;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ItemService {

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
        safe.setVolume(volume);

        for (int i = 0; i < sortedList.size(); i++) {
            int sumVolume = sortedList.get(i).getSize() * sortedList.get(i).getNumber();
            if (safe.getVolume() >= sumVolume) {
                resultList.add(new Item(sortedList.get(i).getName(), sortedList.get(i).getNumber(),
                        sortedList.get(i).getSize(), sortedList.get(i).getPrice()));
                safe.setVolume(safe.getVolume() - sumVolume);
            } else {
                int newNumber = safe.getVolume() / sortedList.get(i).getSize();
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

public class Menu {
    private final String startMessage =
            "\n1. Get a set of items\n" +
                    "2. Sort items by price\n" +
                    "3. Put the items with the maximum price in the safe\n" +
                    "4. Exit\n";

    private final Scanner scanner;
    private final ItemService service;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.service = new ItemService();
    }

    public void mainMenu() {
        int choice;
        int volume;
        while (true) {
            choice = getAnswerFromMenu(startMessage, 4);
            switch (choice) {
                case 1:
                    service.printItemList();
                    break;
                case 2:
                    service.printSortedListByPrice(service.sortByPrice());
                    break;
                case 3:
                    setAModelOfTheSafe();
                    service.printItemInTheSafeWithMaxPrice(service.putItemInTheSafeWithMaxPrice
                            (service.sortByPrice(), getVolumeFromConsole()));
                    break;
                case 4:
                    return;
            }
        }
    }
}
