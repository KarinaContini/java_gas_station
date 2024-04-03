/*<Gabriella Kaku><2234530> - <Karina Contini><2230591> - <Matthew Bernett><2110962>*/
public class Gas extends Products {
    // Class Chocolate inherits from Products Class and implements the Edible interface
    private double litersInTanks;
    public Gas(double price, double litersInTanks){
        super("gas", price);
        this.litersInTanks = litersInTanks;
    }

    public void addGas(double litersAdded) {
        litersInTanks += litersAdded;
    }

    //If try to sell more liters that available in the tanks, it will throw the exception, that will be handled in the driver class
    public void removeGas(double litersSold) throws InvalidAmountOfGas {
        if (litersInTanks >= litersSold){
            litersInTanks -= litersSold;

        }
        else {
            throw new InvalidAmountOfGas("Amount of liters that you want to buy ("+ litersSold+") is bigger than the current amount in the tanks ("+ litersInTanks+").");
        }
    }

    public double getSaleAmount(double litersSold)
    {
        return this.getPrice() * litersSold;
    }

    //Override the toString method from the Product Class
    @Override
    public String toString() {
        return super.toString() + " (value per liter) - details: Premium with " + litersInTanks + " liters in the tanks." ;
    }
}
