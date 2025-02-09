class Person{    
    //properties in the person class 
    //1. Name , 2. Age , 3.locality , 4.phoneNo
    private String name;
    private int age;
    private String locality;
    private String phone;
    //default constructor
    Person(){
       this.name = "Sahil GOndaliya";
       this.age = 20;
       this.locality = "Rajkot";
       this.phone = "9624816350";
    }

    //parameterized constructor
    Person(String name, int age, String locality , String phone){
        this.name = name;
        this.age = age;
        this.locality = locality;
        this.phone = phone;
    }

    Person(Person newPerson)
    {
        this(newPerson.name , newPerson.age , newPerson.locality , newPerson.phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}

class Ass1 {
    public static void main(String[] args) {
        //default constructor
        Person p1 = new Person();
        // System.out.println(p1.getAge + " "+p1.locality +" "+ p1.name +" " + p1.phone);
        //parameterized constructor
        Person p2 = new Person("Yogesh Gondaliya", 18, "Rajkot" , "9989912345" );
        // System.out.println(p2.name+" "+p2.age+" " +p2.locality+" "+p2.phone);  
        //copy constructor
        // p2 = new Person(p1);
        // System.out.println(p2.name);
        System.out.println(p1.getAge());
        p1.setAge(40);
        System.out.println(p1.getAge() + " " + p1.getName());
        p1.getAge();
        
        p2.getAge();

    }
}