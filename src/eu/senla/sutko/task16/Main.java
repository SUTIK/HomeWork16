package eu.senla.sutko.task16;

import eu.senla.sutko.task16.orders.Order;
import eu.senla.sutko.task16.products.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int idProd ;
    public static void main(String[] args) {
        try {
            while (true){
                Scanner sc = new Scanner(System.in);
                System.out.println("1 - Работа с товарами");
                System.out.println("2 - Работа с заказами");
                System.out.println("3 - Выход");
                int i = sc.nextInt();
                if (i==1){
                    while (true){
                        System.out.println("Операции с товарами:");
                        System.out.println("1 - Посмотреть все товары");
                        System.out.println("2 - Добавить товар");
                        System.out.println("3 - Удалить товар");
                        System.out.println("4 - Выход");
                        int i1 = sc.nextInt();
                        if (i1==1){
                            System.out.println(readProduct());
                        }else if (i1==2){
                            //добавляем продукт
                            addProduct();
                        }
                         else if (i1 != 3) {
                            if (i1 == 4) {
                                break;
                            } else System.out.println("Неверная комманда");
                        }

                    }
                }else if (i==2){
                    while (true){
                        System.out.println("Операции с заказами:");
                        System.out.println("1 - Посмотреть все заказы");
                        System.out.println("2 - Добавить заказ");
                        System.out.println("3 - Удалить заказ");
                        System.out.println("4 - Выход");
                        int i1 = sc.nextInt();
                        if (i1==1){
                            System.out.println(readOrder());
                        }else if (i1==2){}
                        else if (i1==3){}
                        else if(i1==4){break; }
                        else System.out.println("Неверная комманда");
                    }
                }else if (i==3){break;}
                else System.out.println("Неверная комманда");

            }
        }catch (Exception ex){

        }

    }







    private static List<Product> readProduct() {
        List<Product> productList = new ArrayList<>();
        //читаем из файла и создаем обьекты Товар, которые запихиваем в наш productList
        try {
            File file = new File("C:\\Users\\Sergey\\IdeaProjects\\HomeWork16\\src\\eu\\senla\\sutko\\task16\\product.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] s = line.split("/");
                Product prod1 = new Product(Integer.parseInt(s[0]), s[1], getDate(s[2]));
                productList.add(prod1);
                return productList;
            }

        } catch (Exception ex) { ex.getMessage(); }

        return productList;
    }



    private static List<Order> readOrder(){
        List<Order> orderList = new ArrayList<>();
        try{
            File file = new File("C:\\Users\\Sergey\\IdeaProjects\\HomeWork16\\src\\eu\\senla\\sutko\\task16\\order.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] s = line.split("/");
                Order order1 =new Order(Integer.parseInt(s[0]),getProductList(s[1]),getDate(s[2]));
                orderList.add(order1);
            }

        }
        catch (Exception ex){ ex.getMessage();
        }
        return orderList;
    }


    private static String[] getProductList (String s1){
        String[] splitProd = s1.split(",");
        return splitProd;
    }


    private static LocalDate getDate(String s) {
        String[] split = s.split("-");
        return  LocalDate.of(Integer.parseInt(split[2]) ,Integer.parseInt(split[1]),Integer.parseInt(split[0]));
    }

    private static void addProduct(){
        List<Product> l = new ArrayList<>(readProduct());
        for (Product i:l) {
             idProd = i.getId();
        }
       int id= idProd+1;
       System.out.println("Введите название продукта");
        Scanner scanner = new Scanner(System.in);
        String nameProd = scanner.nextLine();
        System.out.println("Введите дату в фотрмате 21-03-2021");
        String dateProd=scanner.nextLine();
        String newProduct = "\n"+id+"/"+nameProd+"/"+dateProd;
        try{
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\HomeWork16\\src\\eu\\senla\\sutko\\task16\\product.txt", true))) {
                bw.write(newProduct);
            }
            System.out.println("Добавлено "+newProduct);

        }catch (Exception ex){ex.getMessage();}
    }

}
