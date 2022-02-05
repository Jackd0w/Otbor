package FifthProblem;

import java.util.Scanner;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static FifthProblem.ItemList.createItemDatabase;



class ItemInfo {

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

    public List<Item> putItemInTheSafeWithMaxPrice(List<Item> sortedList, int size) {
        List<Item> resultList = new ArrayList<>();
        safe.setSize(size);

        for (int i = 0; i < sortedList.size(); i++) {
            int sumSize = sortedList.get(i).getSize() * sortedList.get(i).getNumber();
            if (safe.getSize() >= sumSize) {
                resultList.add(new Item(sortedList.get(i).getName(), sortedList.get(i).getNumber(),
                        sortedList.get(i).getSize(), sortedList.get(i).getPrice()));
                safe.setSize(safe.getSize() - sumSize);
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

public class Menu {
    private final String startMessage =
            "\n1. Get a set of items\n" +
                    "2. Sort items by price\n" +
                    "3. Put the items with the maximum price in the safe\n" +
                    "4. Exit\n";

    private final Scanner scanner;
    private final ItemInfo info;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.info = new ItemInfo();
    }

    private void errorMenu(String errorMessage) {
        System.out.println(errorMessage);
        scanner.nextLine();
    }

    private void setAModelOfTheSafe() {
        System.out.println("Input the Safe Model: ");
        String model = scanner.nextLine();
    }

    private void setStateOfSafe() {
        System.out.println("Input the Safe Model: ");
        String model = scanner.nextLine();
    }

    private boolean isNumber1(String str) {
        if (str.isBlank()) {//  if (str == null || str.isEmpty())
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private int getSizeFromUser() {
        int volumeInt;
        String volumeStr;
        while (true) {
            System.out.println("Input a volume of the safe :");
            volumeStr = scanner.nextLine();
            if (isNumber1(volumeStr)) {
                volumeInt = Integer.parseInt(volumeStr);

                if (volumeInt >= info.findMinVolumeFromItemList() && volumeInt > 0) {
                    return volumeInt;
                } else {
                    errorMenu("Input a volume of the safe more than " +
                            +info.findMinVolumeFromItemList()
                            + "\n press any key to continue");
                }
            } else {
                errorMenu("Please input only digits .\n Input a volume of the safe more than " +
                        +info.findMinVolumeFromItemList()
                        + "\n press any key to continue");
            }
        }
    }

    public int getAnswerFromMenu(String message, int input_size) {
        String answer;
        int result;
        while (true) {
            System.out.println(message);
            if (scanner.hasNextLine()) {
                answer = scanner.nextLine();
                if (isNumber1(answer)) {
                    result = Integer.parseInt(answer);
                    if (result <= input_size && result > 0) {
                        return result;
                    } else {
                        errorMenu("Please input digits from 1 to "
                                + input_size + "\npress any key to continue");
                    }
                } else {
                    errorMenu("Please input only digits "
                            + "\npress any key to continue");
                }
            }
        }
    }

    public void mainMenu() {
        int choice;
        int volume;
        while (true) {
            choice = getAnswerFromMenu(startMessage, 4);
            switch (choice) {
                case 1:
                    info.printItemList();
                    break;
                case 2:
                    info.printSortedListByPrice(info.sortByPrice());
                    break;
                case 3:
                    setStateOfSafe();
                    info.printItemInTheSafeWithMaxPrice(info.putItemInTheSafeWithMaxPrice
                            (info.sortByPrice(), getSizeFromUser()));
                    break;
                case 4:
                    return;
            }
        }
    }
}
