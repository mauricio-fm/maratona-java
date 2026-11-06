package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Gato extends Animal {
    private String color;

    public Gato(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void meow() {
        System.out.println("Miau!");
    }
}
