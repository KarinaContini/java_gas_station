import java.time.LocalDate;
/*<Gabriella Kaku><2234530> - <Karina Contini><2230591> - <Matthew Bernett><2110962>*/
public class Sandwiches extends Products implements Edible{
    // Class Chocolate inherits from Products Class and implements the Edible interface
    private final LocalDate expiryDate;
    private final double calories;
    private final String size;
    private final String mainIngredient;
    public Sandwiches(double price, LocalDate expiryDate, double calories, String size, String mainIngredient) throws InvalidCalories {
        super("sandwich",price);
        this.expiryDate = expiryDate;
        //If calories has an invalid value, it will throw the exception, that will be handled in the driver class
        if (validateCalories(calories)) {
            this.calories = calories;
        }
        else {
            throw new InvalidCalories("Unexpected value: " + calories);
        }
        this.size = size;
        this.mainIngredient = mainIngredient;
    }

    //override the methods getCalories() and getExpiryDate() from the Edible interface
    public double getCalories() {
        return calories;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    //Validate calories between 0 and 3000
    private boolean validateCalories(double calories){
       return calories > 0 && calories < 3000;
    }

    //Override the method compareTo from the Comparable<Products> interface
    @Override
    public int compareTo(Products sand2) {
        if (this.getPrice() < sand2.getPrice()) {
            return -1;
        } else if (this.getPrice() > sand2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    //Override the toString method from the Product Class
    @Override
    public String toString() {
        return super.toString() + " - details: "+ this.mainIngredient+ ", size: "+this.size+" with "+this.calories +" calories, expiring on "+this.getExpiryDate();
    }

}
