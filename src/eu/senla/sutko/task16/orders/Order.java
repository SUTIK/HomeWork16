package eu.senla.sutko.task16.orders;

import java.time.LocalDate;
import java.util.Arrays;

public class Order {
    public int getIdOrder() {
        return idOrder;
    }

    public String[] getProductList() {
        return productList;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    private int idOrder;
    private String[] productList;
    private LocalDate dateOrder;

    public Order(int idOrder, String[] productList, LocalDate dateOrder) {
        this.idOrder = idOrder;
        this.productList = productList;
        this.dateOrder = dateOrder;
    }

    @Override
    public String toString() {
        return "Заказ" +
                " ID-" + idOrder +
                " Продукты в нем:" + Arrays.toString(productList) +
                " Дата " + dateOrder
                ;
    }
}



