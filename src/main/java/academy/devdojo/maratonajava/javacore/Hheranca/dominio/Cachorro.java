package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Cachorro extends Animal{
    private String race;

    public Cachorro(String name, int age, String race) {
        super(name, age); ///uma forma menor de pegar atributos da super-classe
        this.race = race;//so para o atributo da classe atual
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void bark() {
        System.out.println("Au Au!");
    }
}
