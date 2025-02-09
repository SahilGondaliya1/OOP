//Create a Vehicle class with speed and fuelCapacity.
//Create a Car class that extends Vehicle.
//Override a method in Car to display different behavior.
class Vehicle 
{    
    protected String type;
    protected double price;
    Vehicle()
    {
        //
    }
    Vehicle(String type,int price){
        this.type = type;
        this.price = price;
    }

    void printDetails(){
        System.out.println(this.price + " " + this.type);
    }

    
}
class Car extends Vehicle{
    Car(String type , int price){
        super(type, price);                
    }

    void priceDetail(){
        System.out.println(super.type + super.price);
    }
}
public class Ass2 {
    public static void main(String[] args)
    {
        Car c1 = new Car("road" , 120200);
        c1.printDetails();
    }
}

