# OOP
# lesson 1: Classes & Objects
    What is a class in Java?
    -> class is a named group of properties and functions.
    How does an object differ from a class?
    -> class is a template defining some sort of rules with defined properties and functions, And a object is a instance of a class meaning it follows all rules of class, 
        -> instance is what actually exist physically in the heap memory occupying some space, 
        -> class alone dont occupy the space, instace(object) does.
    What happens in memory when we create an object?
        -> when we create and object , refernce variable for object which instatiated the class gets stored in stack memory pointing to actual instance(object) of class in Heap memory.
        -> Box b1 ; // declaring the instance
            b1 = new Box(); //instantiated the class Box
            ->when declaring the object " Class_name reference_var; " ; Here object is not yet created , by this "ref_var" is stored in stact memory but it is not pointing to any object in the heap memory yet.
            ->after using "new" Keyword , we are allocating the memory to the "ref_var" of the object an instace of the class.
    How do we initialize objects using constructors?
        What is constructor?
        -> Constructor is a special type of method.
        -> a method which has to perform when an instance of a class is being created.
        How constructor is being initialized?
        -> when an instance of a class is created with "new" keyword followed by "Class_name()"
        a constructor method is called which has the same name as class.
        Two ways to initialize the objects using constructor
        ->  Person p1 = new Person(); // creating a instance of a person
            Identity i1 = new Identity(p1);//creatin a instsnce of identity 
            In this, we are creating a object a person by "new Person()" and object of Identity by "new Identity(p1)" in a Person p1 object.

    What is the difference between default, parameterized, and copy constructors?
    default constructor:
    -> new Class() : without any parameters 
        even if you dont specify the constructor java provides default constructor.

    -> new Class(Parameters..) : with parameters
        constructor that takes arguments to initialize the object with specified value.

    -> new CLass(new Object of CLass) : with another instance of a class
        constructor that makes copy of the existing constructor, which takes object of a same class as an argument.
            It takes a reference to another object of the same class as a parameter.

        ex. Box b1 = new Box(b0); //b0 is existing object.

    How does the this keyword work in a class?
    ->this keyword referse to the current object of a class.
    ->It helps distinguish between the parameters and instance variables.

Code Exercise:
    Create a Person class with name and age.
    Add a constructor to initialize values.
    Create multiple objects and print their details.

# LESSON 2 : ENCAPSULATION (Data Hiding & Protection)


1.  Whats the purpose of the Encapsulation?
    ->"The purpose of encapsulation is to protect data and control access to it. Instead of allowing direct access to variables, we hide them using private access modifiers and provide controlled access through getters and setters.
    This ensures:
    Data Security – Prevents unintended modifications.
    Data Consistency – Allows validation before changing values.
    Better Maintainability – We can update the internal implementation without affecting other parts of the code.
2.  Why should class variables be private?
    ->We make class variables private to enforce encapsulation, which is key to data security, consistency, and maintainability. If instance variables were public, they could be modified from anywhere in the program, leading to uncontrolled changes and potential data corruption.

    ->Take a Bank class with a public balance variable—anyone could directly change it, even setting it to a negative value, which is illogical. By making balance private, we restrict direct access and allow changes only through controlled methods like getters and setters, where we can apply validation and business rules. This not only prevents unintended modifications but also makes the code more secure, maintainable, and scalable.

3.  What will happen if we make all variables public?
    ->If we are making all the variables public , we are making them accessible to everyone , allowing accessibility and modification , might lead to data inconstistancy.
    ->for example we are having a "public variables" and they are being used at different parts of code , if we dacide to add check or validation on variable it would be difficult to maintain the code base or  if things go wrong its hard to debug whole codebase.
    ->it would be much better if we have control over varibles then we can predict or find where the bug lies , if it is caused by varibles.
4.  How do getters and setters control access to private variables?
    GETTER method allows user to get the state of varibles using method,
        ex. public return_type getVar()
            {
                return var;
            }
    SETTER method could control validation of values instead of  assigning it directly to the varible.
        ex. public void setVar(data_type var_name)
            {
                inst_var = var_name;
            }
        we can add validation in the SETTER method to ensure data consistency & security.
5.  Can we modify a private variable without using a setter?
    -> No, we can not modify private varibles directly from outside class , private restricted varibles to its own class.
        but there are some way to modify the private varibles
        1. Inside the class Itself:
             we can change them using constructors, methods within the class.
             -> like using constructors we can set private varibles
             -> and using methods (not necessorily setter ) within the same class as private varibles are allowed to modify the variable.
       * 2.using REFLECTION:
             -> Java allows bypassing access modifiers using reflection, which can forcibly change private variables. However, this is not recommended for normal development because it breaks encapsulation and security.
        3.Inner classes:
             -> If a private variable exists in an outer class, an inner class can still access and modify it directly

6.  What is immutable data, and how does it relate to encapsulation?
    immutable data means , it can't be modified after assignment and encapsulation allows controlled access over data. Encapsulation restricts the data access and immutability prevents unintended modification making data more secure.

    Code Exercise:
    Modify your Person class:
    Make age private.
    Create getter and setter methods for age.
    Try accessing age directly—what happens?
        -WHEN TRIED TO ACCESS DIRECTLY IT SHOWS MESSAGW THAT THE SPECIFIC VARIABLE OF OBJECT IS NOT VISIBLE.

#   3. Inheritance (Code Reusability & Hierarchy)
1.  How does inheritance reduce code duplication?
    ->Inheritance allows classes to aquire properties of other class. A class can aquire properties of a class in which it has most common features instead of redefining them in each class.

    ex. A weapon class can be inherited by sword and knife class, weapon class coontains properties that every weapon would have , damage and attack() , now sword and knife , can inherit the base class as weapon class to ,use properties of weapon. this reduces code redundancy.
    
2.  What does the extends keyword do in Java?
    -> extend keyword lets subclasses to inherit the parent class.
    ex.class ChildCLass extends ParentCLass{
        //code
        }   
3.  What is the super keyword, and how does it work?
    super keyword used to refer the immediate parent class and it allows class to access parent memmbers and coonstructors.
    1.  Access parent members:
    -> while sub class have overridden or hidden member , super keyword is used to directly refer to the parent class's version of member.
    2.constructor:
    -> helps to use parent class constructor using , super().

4.  How does constructor chaining work in inheritance?
    -> Constructor chaining refers to the process of calling constuctor of parent class from the constructor of child(subclass) class ensuring that the parent class is properly initialized before the execution of subclass as subclass have inherited properties of parent class.
    -> A child class is build up on the parent class structure by adding or using some features to parent class, So its important that the structure of parent class before the subclass inherits it.
    -> As, constructor initialized imporant parts of the class,
    -> subclass needs to ensure that it's parent classs' initialize before certain initialization in subclass. If this don't happen , subclass might have some missing values , features which are dependent on the parent class.
    -> if subclass is not calling constructor of parent classs explicitly in its constructor then JAVA would automatically call an "no-argument" constructor of a parent class.
    -> If valid "no-argument" constructor is not present then it would show compilation error.
    >   class Vehicle 
        {    
            private String type;
            private double price;
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
               //its not explicitly calling parent constructor.
               //so JAVA will implicitly call "Vehicle()"       
            }
       > }
       >this is error when no Vehicle() found on implicit call
       > -> Implicit super constructor Vehicle() is undefined. Must explicitly invoke another constructor

        at Car.<init>(Ass2.java:18)
        at Ass2.main(Ass2.java:25)


5.  Can a subclass override a method from its parent class?
    -> yes subclass can overrided a method from its parent class , allowing modification of behavior of method according to the subclass.
    ->the method in subclass should have same name ,return type , parameters as the parent's version of method.
    -> when that method is called on the object of subclass, method of parent's version is overridden by the subclass version.  
    ->its useful as allows to modify the inherited behavior.

6.  What happens if a method is private in the parent class—can it be inherited?
    -> private keyword restricts the members of parent class to be inherited , limiting its scope to its own class.
    -> If you inherit the parent class to subclass even though subclass would not inherit the private methods .
    -> And If you declare the method with same signature in subclass as private method in parent class its not "overridding" its just creating a new independent method of subclass.

    Code Exercise:
    Create a Vehicle class with speed and fuelCapacity.
    Create a Car class that extends Vehicle.
    Override a method in Car to display different behavior.


# 