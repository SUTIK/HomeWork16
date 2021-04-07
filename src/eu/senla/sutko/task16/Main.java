package eu.senla.sutko.task16;

import eu.senla.sutko.task16.orders.Order;
import eu.senla.sutko.task16.products.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {


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
                            //показываем список

                            for (Product p:readProduct()
                                 ) {
                                System.out.println(p);
                            }
                        }
                        else if (i1==2){
                            //добавляем продукт
                            addProduct();
                        }
                         else if (i1 == 3) {
                            //удаляем продукт
                            deleteProduct();

                        }
                         else if (i1 == 4) {
                            break;
                        }
                         else { System.out.println("Неверная комманда");}


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
                           // System.out.println(readOrder());
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



    private static void deleteProduct(){
        List<Product>pr=new ArrayList<>(readProduct());
        System.out.println("Введите id продукта");
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        Iterator<Product> iterator = pr.iterator();
        while(iterator.hasNext()) {
            Product nextProd = iterator.next();//получаем следующий элемент
            if (nextProd.getDate().equals(i1)) {
                iterator.remove();
            }
        }


      // for (Product i:readProduct()) {
      //     if (i.getId()==i1){
      //         pr.remove(i);
      //     }
      // }

            for(Product r:pr)
            {
                try { BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\HomeWork16\\src\\eu\\senla\\sutko\\task16\\product.txt",true));
                    String sum=String.valueOf(r.getId())+"/"+r.getName()+"/"+String.valueOf(r.getDate());
                    out.write(sum+"\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }





    private static List<Product> readProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\Sergey\\IdeaProjects\\HomeWork16\\src\\eu\\senla\\sutko\\task16\\product.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[]s = line.split("/");
                Product prod1 = new Product(Integer.parseInt(s[0]),s[1],getDate(s[2]) );
                productList.add(prod1);
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }


    private static List<Order> readOrer() {
        List<Order> orderList = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\Sergey\\IdeaProjects\\HomeWork16\\src\\eu\\senla\\sutko\\task16\\order.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[]s = line.split("/");
                Order order1 = new Order(Integer.parseInt(s[0]),getProductList(s[1]),getDate(s[2]));
                orderList.add(order1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return orderList;
    }


    //сплит пробуктов в заказе
    private static String[] getProductList (String s1){
        String[] splitProd = s1.split(",");
        return splitProd;
    }

    //сплит даты
    private static LocalDate getDate(String s) {
        String[] split = s.split("-");
        return  LocalDate.of(Integer.parseInt(split[2]) ,Integer.parseInt(split[1]),Integer.parseInt(split[0]));
    }

    private static void addProduct(){
        int idProd=0 ;
        for (Product i:readProduct()) {
             idProd = i.getId();
        }
       int id= idProd+1;
       System.out.println("Введите название продукта");
        Scanner scanner = new Scanner(System.in);
        String nameProd = scanner.nextLine();
        System.out.println("Введите дату в фотрмате 21-03-2021");
        String dateProd=scanner.nextLine();
        String newProduct = id+"/"+nameProd+"/"+dateProd;
        try{
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\HomeWork16\\src\\eu\\senla\\sutko\\task16\\product.txt", true))) {
            bw.write(newProduct+"\r\n");
            }
            System.out.println("Добавлено "+newProduct);

        }catch (Exception ex){ex.getMessage();}
    }

}
