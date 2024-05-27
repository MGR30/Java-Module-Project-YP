package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Product;

/**
 * Хелпер при работе с информацией введенной в консоль
 */
public class InputHelper {
    private InputHelper() {
    }

    /**
     * Ввод информации о количестве гостей
     *
     * @param scanner сканер работающий в консоли
     * @return количество гостей на которых необходимо расчитать чек
     */
    public static int inputNumberOfPerson(Scanner scanner) {
        System.out.println("На какое количество человек нужно разделить счет:");
        int numberOfPerson = 0;
        boolean exitLoop = false;
        while (!exitLoop) {
            try {
                numberOfPerson = scanner.nextInt();
                if (numberOfPerson <= 1) {
                    System.out.println("Некорректное значение. Количество человек должно быть больше 1");
                    continue;
                }
                exitLoop = true;
                //break;
            } catch (Exception e) {
                printError();
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return numberOfPerson;
    }

    /**
     * Ввод информации о товарах из консоли
     *
     * @param scanner сканер работающий в консоли
     * @return список товаров
     */
    public static List<Product> inputProducts(Scanner scanner) {
        List<Product> products = new ArrayList<>();
        while (true) {
            System.out.println("Введите название товара и его стоимость");
            String productInfo = scanner.nextLine();
            if (productInfo.equalsIgnoreCase("Завершить")) {
                break;
            }
            addNewProduct(products, productInfo);
        }
        return products;
    }

    private static void addNewProduct(List<Product> products, String productInfo) {
        String[] strings = productInfo.split(" ");
        if (strings.length <= 1) {
            printError();
            return;
        }
        String productName = "";
        double price;
        try {
            price = Double.parseDouble(strings[strings.length - 1]);
            if (price < 0) {
                printError();
                return;
            }
            for (int i = 0; i < strings.length - 1; i++) {
                productName += strings[i] + " ";
            }
        } catch (Exception e) {
            printError();
            return;
        }
        products.add(new Product(productName, price));
        System.out.println("Товар успешно добавлен");
    }

    /**
     * Подобрать окончание слова в зависимости от числа
     *
     * @param numb         число
     * @param firstEnding  первое окончание
     * @param secondEnding второе окончание
     * @param thirdEnding  третье окончание
     * @return нужное окончание
     */
    public static String endingOfTheWord(int numb, String firstEnding, String secondEnding, String thirdEnding) {
        int module = numb % 100;
        if (module < 11 || module > 14) {
            module = numb % 10;
            if (module == 1) {
                return secondEnding;
            }
            if (module >= 2 && module <= 4) {
                return thirdEnding;
            }
        }
        return firstEnding;
    }

    private static void printError() {
        System.out.println("Некорректное значение, попробуйте еще раз");
    }
}
