public class Train {
    private String name, product, origin, destination;
    private int weight, miles;
    boolean isEngine;

    //constructors
    public Train (String carName, String contents, String orig, String dest, int w, int m){
        name = carName; product = contents; origin = orig; destination = dest; weight = w; miles = m; isEngine = false;
    }//end trainCar constructor
    
    public Train (String engName, String dest){
        name = engName; product = ""; origin = ""; destination = dest; weight = 0; miles = 0; isEngine = true;
    } //end engine constructor

    public boolean isEngine(){
        return isEngine; 
    }//end method isEngine

    public String getDestination(){
        return destination;
    } //end method getDestination

    public int getMiles(){
        return miles;
    } //end method getMiles

    public int getWeight(){
        return weight;
    } //end method getWeight

    public void setMiles(int m){
        miles = m;
    } //end method setMiles

    public String toString(){
        if(isEngine())
            return name + " is leaving for " + destination + " with the following cars: ";
        else
            return name + " containing " + product + " weighing " + weight + "lbs with " + miles + " miles";
    } //end toString
}//end class Train
