import java.time.LocalDate;

/*<Gabriella Kaku><2234530> - <Karina Contini><2230591> - <Matthew Bernett><2110962>*/
public class Chocolate extends Products implements Edible{
    // Class Chocolate inherits from Products Class and implements the Edible interface
    private final LocalDate expiryDate;
    private final double chocolateCalories;
    private final String name;
    public Chocolate(double price, LocalDate expiryDate, double calories, String name) throws InvalidCalories {
        super("chocolate", price);
        this.expiryDate = expiryDate;

        //If calories has an invalid value, it will throw the exception, that will be handled in the driver class
        if (validateCalories(calories)) {
            this.chocolateCalories = calories;
        }
        else {
            throw new InvalidCalories("Unexpected value: " + calories);
        }
        this.name = name;
    }

    //override the methods getCalories() and getExpiryDate() from the Edible interface
    public double getCalories() {
        return chocolateCalories;
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
    public int compareTo(Products choco2) {
        //Casting to access the method getCalories()
        if (this.getCalories() < ((Chocolate)choco2).getCalories()) {
            return -1;
        } else if (this.getCalories() > ((Chocolate)choco2).getCalories()) {
            return 1;
        } else {
            return 0;
        }
    }

    //Override the toString method from the Product Class
    @Override
    public String toString() {
        return super.toString() + " - details: "+this.name+" with "+this.chocolateCalories +" calories, expiring on "+this.getExpiryDate();
    }

}



