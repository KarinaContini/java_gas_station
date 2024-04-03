/*<Gabriella Kaku><2234530> - <Karina Contini><2230591> - <Matthew Bernett><2110962>*/
public abstract class Products implements Comparable<Products> {
    // Class Products is the super class and Chocolate, Sandwiches, Coffee and Gas inherit from it
    private final int productId;
    //lastProductId is static and incremented for every product
    private static int lastProductId= 0;
    private final double price;
    private final String itemName;
    public Products(String itemName, double price){
        productId = ++ lastProductId;
        this.price = price;
        this.itemName = itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getProductId() {
        return productId;
    }

    //Override the toString method from the Product Class
    @Override
    public String toString() {
        return "Product ID "+ productId + " - " + this.itemName + " - Price: $" + this.price ;
    }

    //Implements the compareTo method that override it from the Comparable<Products> interface
    //Gas and Coffee are no more obligate to implement it
    @Override
    public int compareTo(Products product) {
        return 0;
    }
}
