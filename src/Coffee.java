/*<Gabriella Kaku><2234530> - <Karina Contini><2230591> - <Matthew Bernett><2110962>*/
public class Coffee extends Products{
    // Class Chocolate inherits from Products Class and implements the Edible interface

    private final String size;
    private final String name;
    public Coffee(double price, String name, String size){
        super("coffee", price);
        this.size = size;
        this.name = name;
    }
    //Override the toString method from the Product Class
    @Override
    public String toString() {
        return super.toString() + " - details: "+this.name +", size: " + this.size;
    }

}
