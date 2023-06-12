import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Object> order = new ArrayList<>();
    LocalDate nowDate = LocalDate.now();
    LocalTime nowTime = LocalTime.now();
    int itemNumber = 0;
    static String placeOrder;
    boolean ordering = true;

    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){

    }

    public void printCupcakes(ArrayList<Cupcake> cupcakeMenu){
        for(Cupcake c: cupcakeMenu){
            System.out.println(itemNumber);
            System.out.println("Price: " + c.price);
            c.type();
            itemNumber += 1;
        }
        System.out.println("CUPCAKES!");
    }

    public void printDrinks(ArrayList<Drink> drinkMenu){
        for(Drink d: drinkMenu){
            System.out.println(itemNumber);
            System.out.println("Price: " + d.price);
            d.type();
            itemNumber += 1;
        }
        System.out.println("DRINKS!");
    }

    public static void Main(String [] args){
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        ArrayList<Drink> drinkMenu = new ArrayList<>();
        Order o = new Order(cupcakeMenu, drinkMenu);
        System.out.println("Hello customer would you like to place an order? (Y or N)");
        placeOrder = sc.nextLine();
        placeOrder.toLowerCase();
        if(placeOrder.equals('y')){

        }else{
            System.out.println("Have a nice day then");
        }

        order.add(LocalDate.now());
        order.add(LocalTime.now());
        System.out.println("here is the menu");
        o.printCupcakes(cupcakeMenu);
        o.printDrinks(drinkMenu);

        while(o.ordering){
            System.out.println("What do you want to order Please use the number associated with each item to order.");
            int orderChoice = sc.nextInt();
            sc.nextLine();
            if(orderChoice == 1){
                order.add(cupcakeMenu.get(1));
            }else if(orderChoice == 2){
                order.add(cupcakeMenu.get(2));
            }else if(orderChoice <= 6){
                System.out.println("Item :" + orderChoice + " Added to order");
                order.add(cupcakeMenu.get(orderChoice));
            }else{
                System.out.println("Sorry we dont seem to have that on the menu");
            }
            System.out.println("Would you like to continue ordering(Y/N)");
            placeOrder = sc.next();

            if(!placeOrder.equalsIgnoreCase("Y")){
                o.ordering = false;
            }
        }

        System.out.println(order.get(0).toString());
        double subtotal = 0.0;
        for(int i = 2; i < order.size(); i++){
            if(order.get(i).equals(cupcakeMenu.get(0))){
                if(order.get(i).equals(cupcakeMenu.get(0))){
                    cupcakeMenu.get(0).type();
                    System.out.println(cupcakeMenu.get(0).getPrice());
                    subtotal = subtotal + cupcakeMenu.get(0).getPrice();
                }else if(order.get(i).equals(cupcakeMenu.get(1))){
                    cupcakeMenu.get(1).type();
                    System.out.println(cupcakeMenu.get(1).getPrice());
                    subtotal = subtotal + cupcakeMenu.get(1).getPrice();
                }else if(order.get(i).equals(cupcakeMenu.get(2))){
                    cupcakeMenu.get(2).type();
                    System.out.println(cupcakeMenu.get(2).getPrice());
                    subtotal = subtotal + cupcakeMenu.get(2).getPrice();
                }else if(order.get(i).equals(drinkMenu.get(0))){
                    drinkMenu.get(0).type();
                    System.out.println(drinkMenu.get(0).getPrice());
                    subtotal = subtotal + drinkMenu.get(0).getPrice();
                }else if(order.get(i).equals(drinkMenu.get(1))){
                    drinkMenu.get(1).type();
                    System.out.println(drinkMenu.get(1).getPrice());
                    subtotal = subtotal + drinkMenu.get(1).getPrice();
                }else if(order.get(i).equals(drinkMenu.get(2))){
                    drinkMenu.get(2).type();
                    System.out.println(drinkMenu.get(2).getPrice());
                    subtotal = subtotal + drinkMenu.get(2).getPrice();
                }
            }
        }
        System.out.println(subtotal);
        new CreateFile();
        new WriteToFile(order);

    }
}

class CreateFile {
    public CreateFile(){
        try{
            File salesData = new File("salesdata.txt");
            if(salesData.createNewFile()){
                System.out.println("file created succesfully: " + salesData.getName());
            }else{
                System.out.println("File error or file already exists");
            }
        }catch(IOException e){
            System.out.println("An error occurred");
        }
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try{
            FileWriter fw = new FileWriter("salesdata.txt", true);
            PrintWriter saleswriter = new PrintWriter(fw);
            for(Object o : order){
                System.out.println(o);
            }
            saleswriter.close();
            System.out.println("Wrote to file successfully");
        }catch (IOException e){
            System.out.println("Error writing to file");
        }
    }
}
