import java.time.LocalDate;
import java.util.ArrayList;
/*<Gabriella Kaku><2234530> - <Karina Contini><2230591> - <Matthew Bernett><2110962>*/
public abstract class DataProvider {

    //Initialize the list of products
    public static ArrayList<Products> initializeProducts() throws InvalidCalories {
        ArrayList<Products> listProducts = new ArrayList<>();

        listProducts.add(new Gas(3, 500));

        listProducts.add(new Coffee(1, "expresso","medium"));
        listProducts.add(new Coffee(7, "capuccino","large"));
        listProducts.add(new Coffee(5, "capuccino","small"));

        listProducts.add(new Sandwiches(10, LocalDate.of(2024, 4, 13),30,"small", "meat"));
        listProducts.add(new Sandwiches(15, LocalDate.of(2024, 8, 19),50,"large", "chicken"));
        listProducts.add(new Sandwiches(25, LocalDate.of(2025, 1, 5),10,"small", "vegie"));

        listProducts.add(new Chocolate(3, LocalDate.of(2024, 4, 5),15,"Kit Kat"));
        listProducts.add(new Chocolate(5, LocalDate.of(2024, 1, 10),18,"Twix"));
        listProducts.add(new Chocolate(4, LocalDate.of(2024, 2, 12),20,"Crunch"));

        return listProducts;
    }
}
