package academy.devdojo.maratonajava.javacore.Qstring.test;

public class ToStringTest01 {
    /**
     * toString():
     *
     *     Método herdado de Object usado para obter uma representação textual do objeto.
     *
     *     Todo objeto Java possui toString(), pois todo objeto herda de Object.
     *
     *     Exemplo:
     *
     *         Aluno aluno = new Aluno();
     *         System.out.println(aluno);
     *
     *     O println chama toString() automaticamente.
     *
     *     Sem sobrescrever:
     *
     *         academy.devdojo.Aluno@5e2de80c
     *
     *     Sobrescrevendo:
     *
     *         @Override
     *         public String toString() {
     *             return "Aluno{" +
     *                     "nome='" + nome + '\'' +
     *                     ", idade=" + idade +
     *                     '}';
     *         }
     *
     *     Agora o objeto pode ser representado como:
     *
     *         Aluno{nome='João', idade=15}
     *
     *     IMPORTANTE:
     *
     *         toString() não altera o objeto.
     *         Ele apenas retorna uma String que representa o estado do objeto.
     *
     *     Quando usamos:
     *
     *         System.out.println(aluno);
     *
     *     É como se fizéssemos:
     *
     *         System.out.println(aluno.toString());
     *
     *     @Override:
     *
     *         Indica que estamos sobrescrevendo o toString() herdado de Object.
     *
     *     Retorno:
     *
     *         String → toString() sempre retorna uma String.
     */
}
