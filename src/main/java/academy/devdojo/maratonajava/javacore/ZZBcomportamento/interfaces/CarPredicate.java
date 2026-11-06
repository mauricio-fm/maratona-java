package academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

@FunctionalInterface
public interface CarPredicate {
    // lambdas sao anonimas, lambdas tambem sao chamadas de functions, para usar lambda, precisa de uma interface funcional como essa, com um metodo abstrato sem corpo
    boolean test(Car car); // e um contrato que vai definir como a lambda deve ser
//    boolean test(Car car); // interface funcional nao podem terem dois metodos
    //(parametro) -> <expressao>, parametros sao as entradas que a funcao precisa para execultar o trabalho, expressao e acao ou logica que serao execultados caso as condicoes passadas sejam verdadeiras
    //(Car car) -> car.getColor.equals("green");
    /**
     * em resumo, lambdas e uma funcao anonima, ela e uma funcao que possui logica e parametro, mas nao
     * tem nome e nao precisa estar dentro da classe para existir
     */
}
