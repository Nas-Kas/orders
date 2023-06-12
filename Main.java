import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
    static ArrayList<Drink> drinkMenu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String priceText;
    static double price;

    public static void main (String [] args){
        Cupcake cupcake = new Cupcake();
        RedVelvet redvelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        Drink drink = new Drink();
        Milk milk = new Milk();
        Soda soda = new Soda();
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
/*      pt 1
        sc = new Scanner(System.in);
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = sc.nextLine();
        price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
 */
        cupcake.promptAndSetPrice(cupcake);
        cupcake.promptAndSetPrice(redvelvet);
        cupcake.promptAndSetPrice(chocolate);
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redvelvet);
        cupcakeMenu.add(chocolate);
        drink.promptAndSetPrice(drink);
        drink.promptAndSetPrice(milk);
        drink.promptAndSetPrice(soda);
        drinkMenu.add(drink);
        drinkMenu.add(milk);
        drinkMenu.add(soda);

        new Order(cupcakeMenu, drinkMenu);
    }
}

class Cupcake {
    public double price;

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void type(){
        System.out.println("Generic cupcake with vanilla frosting");
    }

    public void promptAndSetPrice(Cupcake cupcake){
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        Main.priceText = Main.sc.nextLine();
        Main.price = Double.parseDouble(Main.priceText);
        cupcake.setPrice(Main.price);
    }
}

class RedVelvet extends Cupcake {

    @Override
    public void type(){
        System.out.println("A red velvet based cupcake with chream cheese frosting");
    }
}

class Chocolate extends Cupcake {
    @Override
    public void type(){
        System.out.println("A chocolate based cupcake with chocolate frosting");
    }
}

class Drink {
    public double price;

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void type(){
        System.out.println("A bottle of water");
    }

    public void promptAndSetPrice(Drink drink){
        drink.type();
        System.out.println("How much would you like to charge for the drink? (Input a numerical number taken to 2 decimal places)");
        Main.priceText = Main.sc.nextLine();
        Main.price = Double.parseDouble(Main.priceText);
        drink.setPrice(Main.price);
    }
}

class Soda extends Drink{
    public void type(){
        System.out.println("A sugary bottle of soda");
    }
}

class Milk extends Drink{
    public void type(){
        System.out.println("A milky bottle of milk");
    }
}

