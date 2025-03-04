class Person
{
    String name;
    int age;
    String address;
 
    public Person(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public void printInfo()
    {
        System.out.println("Person Information:");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Address: "+ this.address);
    }
}
 