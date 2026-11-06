package academy.devdojo.maratonajava.javacore.ZZClambdas.dominio;

public class LambdaDefinicao {
    /*
     * Lambda:
     *
     *     Uma lambda é uma forma curta de representar um comportamento
     *     que pode ser passado para um método.
     *
     *     Sintaxe:
     *
     *         (parametros) -> expressão
     *
     *     Exemplos:
     *
     *         nome -> nome.length()
     *         (a, b) -> a + b
     *         () -> System.out.println("Olá")
     *
     *     A lambda normalmente é usada com uma interface funcional.
     *
     *     Function:
     *
     *         Function<String, Integer> tamanho = s -> s.length();
     *
     *         String → tipo de entrada
     *         Integer → tipo de retorno
     *         s → parâmetro
     *         s.length() → comportamento
     *
     *     Para executar:
     *
     *         tamanho.apply("Java");
     *
     *     Principais interfaces:
     *
     *         Predicate<T>  → T → boolean
     *         Consumer<T>   → T → void
     *         Function<T,R> → T → R
     *         Supplier<T>   → () → T
     *
     *     Exemplo:
     *
     *         list.forEach(nome -> System.out.println(nome));
     *
     *     O forEach percorre a lista e a lambda define
     *     o que será feito com cada elemento.
     *
     *     Ideia principal:
     *
     *         Lambda = comportamento que pode ser passado
     *                  para outro código.
     */
}
