import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

/*<Gabriella Kaku><2234530> - <Karina Contini><2230591> - <Matthew Bernett><2110962>*/
public abstract class GasStationManager {

    //Instantiate the list of Products
    private static ArrayList<Products> listProducts = new ArrayList<>();

    public static void startManagement() throws InvalidCalories {
        //Receive the hard coded data
        listProducts = DataProvider.initializeProducts();
        Scanner userInput = new Scanner(System.in);
        String option = "";
        //Options from the menu
        do {
            System.out.println("\n\t--- Menu ---");
            System.out.println("1- Add a chocolate bar: ");
            System.out.println("2- Add a sandwich:");
            System.out.println("3- Add gas: ");
            System.out.println("4- Add coffee :");
            System.out.println("5- Display all chocolate bars :");
            System.out.println("6- Compare two chocolate bars and display the healthier :");
            System.out.println("7- Display all sandwiches :");
            System.out.println("8- Compare two sandwiches and display the cheapest :");
            System.out.println("9- Sell an edible item :");
            System.out.println("10- Sell gas :");
            System.out.println("11- Sell coffee :");
            System.out.println("12- Display how much gas do we have in tanks :");
            System.out.println("13- Display all products :");
            System.out.println("14- Exit :");
            option = userInput.nextLine();

            switch (option) {
                case "1":
                    addChocolate();
                    break;
                case "2":
                    addSandwich();
                    break;
                case "3":
                    addGas();
                    break;
                case "4":
                    addCoffee();
                    break;
                case "5":
                    displayChocolate();
                    break;
                case "6":
                    compareChocolates();
                    break;
                case "7":
                    displaySandwich();
                    break;
                case "8":
                    compareSandwiches();
                    break;
                case "9":
                    sellEdible();
                    break;
                case "10":
                    sellGas();
                    break;
                case "11":
                    sellCoffee();
                    break;
                case "12":
                    displayGaugeInTanks();
                    break;
                case "13":
                    displayAllProducts();
                    break;
                case "14":
                    System.out.println("Exit program.");
                    break;
                default:
                    System.out.println(" Unknown selection, please try again");
                    break;
            }
        } while (!option.equals("14"));
        //It will run until the user choose 14 - Exit
    }

    private static void addChocolate(){
        double calories = 0;
        double price = 0;
        LocalDate expiryDate = null;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the name of the chocolate:");
        String name = userInput.nextLine();

        //validate the input for price as a number
        while(true){
            System.out.println("Enter the chocolate price:");
            try{
                price = userInput.nextDouble();
                break;
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }

        //validate the date type
        while(true){
            System.out.println("Enter the chocolate expiry date (yyyy-MM-dd):");
            userInput.nextLine();
            String date = userInput.nextLine();
            try{
                expiryDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CANADA));
                if (expiryDate.isBefore(LocalDate.now())) {
                    System.out.println("Invalid expiry date. It must be in the future.");
                    userInput.nextLine();
                    continue;
                }
                break;
            }
            catch(DateTimeParseException ex) {
                System.out.println("Invalid input type. It must be a date.");
                userInput.nextLine();
            }
        }

        //validate the calories. If it is out of range, it will catch the exception
        while(true){
            System.out.println("Enter the number of calories (0 to 3000):");
            try{
                calories = userInput.nextDouble();
                try {
                    Chocolate chocolate = new Chocolate(price, expiryDate, calories,name);
                    listProducts.add(chocolate);
                    System.out.println(chocolate);
                }
                catch (InvalidCalories e) {
                    System.out.println(e + "! Must be between 0 and 3000");
                    userInput.nextLine();
                    continue;
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
            break;
        }

    }
    private static void addSandwich(){
        double calories = 0;
        double price = 0;
        LocalDate expiryDate = null;
        Scanner userInput = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the size of the sandwich (small, medium, large):");
            String size = userInput.nextLine();
            //allow 3 options for size: small, medium and large
            if ("small".equals(size) || "medium".equals(size) || "large".equals(size)) {
                while(true) {
                    System.out.println("Enter the main ingredient (chicken, meat, vegie):");
                    String mainIngredient = userInput.nextLine();
                    //allow 3 options for main ingredient: chicken, meat, vegie
                    if ("chicken".equals(mainIngredient) || "meat".equals(mainIngredient) || "vegie".equals(mainIngredient)) {

                        //validate the input for price as a number
                        while(true){
                            System.out.println("Enter the sandwich price:");
                            try{
                                price = userInput.nextDouble();
                                break;
                            }
                            catch(InputMismatchException ex) {
                                System.out.println("Invalid input type. It must be a number.");
                                userInput.nextLine();
                            }
                        }
                        //validate the date type
                        while(true){
                            System.out.println("Enter the sandwich expiry date (yyyy-MM-dd):");
                            userInput.nextLine();
                            String date = userInput.nextLine();
                            try{
                                expiryDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CANADA));
                                if (expiryDate.isBefore(LocalDate.now())) {
                                    System.out.println("Invalid expiry date. It must be in the future.");
                                    userInput.nextLine();
                                    continue;
                                }
                                break;
                            }
                            catch(DateTimeParseException ex) {
                                System.out.println("Invalid input type. It must be a date.");
                                userInput.nextLine();
                            }
                        }
                        //validate the calories. If it is out of range, it will catch the exception
                        while(true){
                            System.out.println("Enter the number of calories (0 to 3000):");
                            try{
                                calories = userInput.nextDouble();
                                try {
                                    Sandwiches sandwich = new Sandwiches(price, expiryDate, calories, size, mainIngredient);
                                    listProducts.add(sandwich);
                                    System.out.println(sandwich);
                                }
                                catch (InvalidCalories e) {
                                    System.out.println(e + "! Must be between 0 and 3000");
                                    userInput.nextLine();
                                    continue;
                                }
                            }
                            catch(InputMismatchException ex) {
                                System.out.println("Invalid input type. It must be a number.");
                                userInput.nextLine();
                            }
                            break;
                        }
                        break;
                    }
                    else {
                        System.out.println("Invalid input. Please enter a valid ingredient.");
                    }
                }
                break;
            }
            else {
                System.out.println("Invalid input. Please enter a valid size.");
            }
        }
    }

    //There is only one product for gas. The add method will add liters to the tank
    private static void addGas() {
        double liters = 0;
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println("Enter the amount of gas in liters to add:");
            try{
                liters = userInput.nextDouble();
                ((Gas)listProducts.get(0)).addGas(liters);
                System.out.println("Successfully added gas.");
                System.out.println(listProducts.get(0)+"\n");
                break;
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }

    //Polymorphism
    private static void displayChocolate(){
        System.out.println("\n\tList of Chocolates\n");
        if (!listProducts.isEmpty()){
            for (Object o : listProducts) {
                if (o instanceof Chocolate){
                    System.out.println(o);
                }
            }
        } else {
            System.out.println("There are no registered chocolate bars.\n");
        }
    }
    //Compare two Chocolate objects and return the healthier one (based on calories)
    private static void compareChocolates(){
        Scanner userInput = new Scanner(System.in);
        Chocolate healthierChocolate = null;
        while(true){
            int chocolateId=0;
            System.out.println("Enter the id of first chocolate that you want to compare:");
            try{
                chocolateId = userInput.nextInt();
                Chocolate choco1 = findChocolateById(chocolateId);
                if(choco1 != null){
                    while(true){
                        int chocolateId2=0;
                        System.out.println("Enter the id of the other chocolate:");
                        try{
                            chocolateId2 = userInput.nextInt();
                            Chocolate choco2 = findChocolateById(chocolateId2);
                            if(choco2 != null){
                                int result = choco1.compareTo(choco2);
                                if (result < 0) {
                                    healthierChocolate = choco1;
                                } else if (result > 0) {
                                    healthierChocolate = choco2;
                                } else {
                                    System.out.println("Both have the same number of calories.");
                                }
                                if(healthierChocolate != null){
                                    System.out.println("The healthier chocolate is: " + healthierChocolate);
                                }
                                break;
                            }
                            else{
                                System.out.println("There is no chocolate with this id.");
                            }
                        }
                        catch(InputMismatchException ex) {
                            System.out.println("Invalid input type. It must be a number.");
                            userInput.nextLine();
                        }
                    }
                    break;
                }
                else{
                    System.out.println("There is no chocolate with this id.");
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }

    }
    //Polymorphism
    private static void displaySandwich(){
        System.out.println("\n\tList of Sandwiches\n");
        if (!listProducts.isEmpty()){
            for (Object o : listProducts) {
                if (o instanceof Sandwiches){
                System.out.println(o);
                }
            }
        } else {
            System.out.println("There are no registered Sandwiches.\n");
        }
    }
    private static void addCoffee(){
        double coffeePrice = 0;
        String coffeeSize = "";
        Scanner userInput = new Scanner(System.in);


        System.out.println("Enter the name of the coffee:");
        String coffeeName = userInput.nextLine();

        while(true) {
            System.out.println("Enter the size of the sandwich (small, medium, large):");
            coffeeSize = userInput.nextLine();
            //allow 3 options for size: small, medium and large
            if ("small".equals(coffeeSize) || "medium".equals(coffeeSize) || "large".equals(coffeeSize)) {
                break;
            }
            else {
                System.out.println("Invalid input. Please enter a valid size.");
            }
        }

        //validate the input for price as a number
        while(true){
            System.out.println("Enter the coffee price:");
            try{
                coffeePrice = userInput.nextDouble();
                Coffee coffee = new Coffee(coffeePrice,coffeeName, coffeeSize);
                listProducts.add(coffee);
                System.out.println(coffee);
                break;
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }

    //Compare two Sandwiches objects and return the cheapest one
    private static void compareSandwiches(){
        Scanner userInput = new Scanner(System.in);
        Sandwiches cheapestSand = null;
        while(true){
            int sandwichId=0;
            System.out.println("Enter the id of first sandwich that you want to compare:");
            try{
                sandwichId = userInput.nextInt();
                Sandwiches sand1 = findSandById(sandwichId);
                if(sand1 != null){
                    while(true){
                        int sandwichId2=0;
                        System.out.println("Enter the id of the other sandwich:");
                        try{
                            sandwichId2 = userInput.nextInt();
                            Sandwiches sand2 = findSandById(sandwichId2);
                            if(sand2 != null){
                                int result = sand1.compareTo(sand2);
                                if (result < 0) {
                                    cheapestSand = sand1;
                                } else if (result > 0) {
                                    cheapestSand = sand2;
                                } else {
                                    System.out.println("Both have the same price.");
                                }
                                if(cheapestSand != null){
                                    System.out.println("The cheapest sandwich is: " + cheapestSand);
                                }
                                break;
                            }
                            else{
                                System.out.println("There is no sandwich with this id.");
                            }
                        }
                        catch(InputMismatchException ex) {
                            System.out.println("Invalid input type. It must be a number.");
                            userInput.nextLine();
                        }
                    }
                    break;
                }
                else{
                    System.out.println("There is no sandwich with this id.");
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }




    }
    private static Chocolate findChocolateById(int id) {
        for (Products product : listProducts) {
            if (product instanceof Chocolate && product.getProductId() == id) {
                return (Chocolate)product;
            }
        }
        return null;
    }
    //Casting
    private static Sandwiches findSandById(int id) {
        for (Products product : listProducts) {
            if (product instanceof Sandwiches && product.getProductId() == id) {
                return (Sandwiches)product;
            }
        }
        return null;
    }

    //Polymorphism with interface
    //Remove Chocolate or Sandwich objects from the list
    private static void sellEdible(){
        Scanner userInput = new Scanner(System.in);
        while(true){
            Edible edible = null;
            System.out.println("Enter the id of the edible product that you want to buy:");
            try{
                int edibleId = userInput.nextInt();
                for (Products product : listProducts) {
                    if (product instanceof Edible && product.getProductId() == edibleId) {
                        edible = (Edible) product;
                    }
                }
                if(edible != null){
                    System.out.println("Sold! " + edible + "\n");
                    listProducts.remove(edible);
                    break;
                }
                else{
                    System.out.println("There is no edible product with this id.");
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }
    //Remove liters from the tank (property of gas object)
    private static void sellGas() {
        double liters = 0;
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println("Enter the amount of gas in liters that you want to buy:");
            try{
                liters = userInput.nextDouble();
                try {
                    ((Gas)listProducts.get(0)).removeGas(liters);
                    System.out.println(liters + " liters of gas sold successfully. Sale amount: $" + ((Gas) listProducts.get(0)).getSaleAmount(liters));
                    System.out.println(listProducts.get(0)+"\n");
                    break;
                }
                catch (InvalidAmountOfGas e) {
                    System.out.println(e);
                    userInput.nextLine();
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }
    //Remove object Coffee from the list
    private static void sellCoffee(){
        Scanner userInput = new Scanner(System.in);
        while(true){
            int coffeeId=0;
            System.out.println("Enter the id of the coffee that you want to buy:");
            try{
                coffeeId = userInput.nextInt();
                Coffee coffee = findCoffeeById(coffeeId);
                if(coffee != null){
                    listProducts.remove(coffee);
                    System.out.println("Coffee sold!");
                    break;
                }
                else{
                    System.out.println("There is no coffee with this id.");
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }
    //Casting
    private static Coffee findCoffeeById(int id) {
        for (Products product : listProducts) {
            if (product instanceof Coffee && product.getProductId() == id) {
                return (Coffee)product;
            }
        }
        return null;
    }
    //Polymorphism
    private static void displayGaugeInTanks(){
        System.out.println("\n\tGas\n");
        if (!listProducts.isEmpty()){
            for (Object o : listProducts) {
                if (o instanceof Gas){
                    System.out.println(o);
                }
            }
        } else {
            System.out.println("There are no registered gas.\n");
        }
    }
    //Polymorphism
    private static void displayAllProducts(){
        System.out.println("\n\tList of Products\n");
        if (!listProducts.isEmpty()){
            for (Object o : listProducts) {
                System.out.println(o);
            }
        } else {
            System.out.println("There are no registered products.\n");
        }
    }


    /*
    private static void sellChocolate(){
        Scanner userInput = new Scanner(System.in);
        while(true){
            int chocolateId=0;
            System.out.println("Enter the id of the chocolate bar that you want to buy:");
            try{
                chocolateId = userInput.nextInt();
                Chocolate choco = findChocolateById(chocolateId);
                if(choco != null){
                    listProducts.remove(choco);
                    System.out.println("Chocolate bar sold!");
                    break;
                }
                else{
                    System.out.println("There is no chocolate with this id.");
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }
    private static void sellSandwich(){
        Scanner userInput = new Scanner(System.in);
        while(true){
            int sandwichId=0;
            System.out.println("Enter the id of the sandwich that you want to buy:");
            try{
                sandwichId = userInput.nextInt();
                Sandwiches sand = findSandById(sandwichId);
                if(sand != null){
                   listProducts.remove(sand);
                   System.out.println("Sandwich sold!");
                    break;
                }
                else{
                    System.out.println("There is no sandwich with this id.");
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }


    private static void sellEdible(){
        Scanner userInput = new Scanner(System.in);
        int choice = 0;
        while(true){
            System.out.println("Would you like to buy chocolate(1) or sandwich(2)\n Enter the number 1 or 2:");
            try{
                choice = userInput.nextInt();
                if (choice != 1 && choice != 2){
                    System.out.println("Choose between 1 or 2!");
                }
                else{
                    if(choice==1){
                        sellChocolate();
                    } else {
                        sellSandwich();
                    }
                    break;
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid input type. It must be a number.");
                userInput.nextLine();
            }
        }
    }

     */

}

