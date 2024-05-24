import java.util.List;
import java.util.Scanner;

import helper.InputHelper;
import model.Product;
import service.Calculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPerson = InputHelper.inputNumberOfPerson(scanner);
        List<Product> products = InputHelper.inputProducts(scanner);

        Calculator calculator = new Calculator(products, numberOfPerson);
        double calculated = calculator.calculate();
        String calculatingString = String.format("%.2f", calculated);

        System.out.println("Каждый должен заплатить по: " +
                calculatingString +
                " рубл" +
                InputHelper.endingOfTheWord((int) Math.floor(calculated), "ей", "ь", "я"));

        scanner.close();
    }
}