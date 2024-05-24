package service;

import java.util.List;

import model.Product;

/**
 * Калькулятор
 */
public class Calculator {
    private List<Product> products;
    private int numberOfPerson;
    private double totalCost;

    /**
     * Конструктор
     *
     * @param products       список товаров
     * @param numberOfPerson количество гостей
     */
    public Calculator(List<Product> products, int numberOfPerson) {
        this.products = products;
        this.numberOfPerson = numberOfPerson;
    }

    /**
     * Расчитать плату по чеку на кждого гостя
     *
     * @return количество денег для оплаты
     */
    public double calculate() {
        System.out.println("Добавленные товары: \n");
        for (Product product : products) {
            totalCost += product.getPrice();
            System.out.println(product.getName() + product.getPrice());
        }
        return totalCost / numberOfPerson;
    }
}
