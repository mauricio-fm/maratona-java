package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

/// Classes Internas ou InnerClass, é uma classe dentro de outra

// a classe de dentro (Inner) pode acessar atributos da de fora de forma direta, mas a de fora nao pode acessar de forma direta atributos da de dentro, por exemplo

/**
 *  void teste() {
 *         Inner inner = new Inner();
 *
 *         System.out.println(inner.idade);
 *     }
 *
 *      aqui voce cria um objeto do tipo Inner, quando a Outer que acessar, ela usa a referencia do objeto Inner
 *      para acessar atributo idade de inner
 */
public class OuterClassesTest01 {
    private String name = "Monkey D. Luffy";

    // Inner pertence a uma instância de OuterClassTest01. Por isso, ela consegue acessar até atributos private da classe externa
    class Inner { // OuterClassTest01 contem Inner dentro dela
        public void printOuterClassAttributes() {
            System.out.println(name);
            System.out.println(this); // o this sempre se refere a classe que ele se encontra, ate em classesInternas
        }
    }

    public static void main(String[] args) {
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        OuterClassesTest01.Inner inner = outerClass.new Inner(); //  OuterClassTest01.Inner e o tipo + variavel outerClass.new Inner() cria uma classe Inner ligada ao outerClass
        inner.printOuterClassAttributes();
    }
}
