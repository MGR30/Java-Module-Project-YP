package model;

/**
 * Товар
 */
public class Product {
    private String name;
    private double price;

    /**
     * Конструктор
     *
     * @param name  наименование товара
     * @param price цена товара
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Получить наименование товара
     *
     * @return наименование товара
     */
    public String getName() {
        return name;
    }

    /**
     * Установить наименование товара
     *
     * @param name наименование товара
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить цену товара
     *
     * @return цена товара
     */
    public double getPrice() {
        return price;
    }

    /**
     * Установить цену товара
     *
     * @param price цена товара
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
