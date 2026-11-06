package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}
