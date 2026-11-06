package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

/**
 * Por exemplo
 *
 * 183 processos e 2164 threads
 * fazendo essas tarefas
 *
 * existem threads dos tipos
 *  Daemon x User
 *  A diferença é
 *      o Java encerra o proprama quando todas as threads to tipo User
 *      sao terminadas
 *
 *      Ja a as do tipo Daemon nao tem tanta prioridade assim
 *
 *      Por exemplo, se um programa ta rodando e as tarefas da User
 *      acabaram mas as da Daemon ainda nao acabaram, o programa e
 *      encerrado independente da thread Daemon ta rodando ou nao
 */

class ThreadExample extends Thread {
    private char c;
    public ThreadExample(char c) {
        this.c = c;
    }

    @Override
    public void run() { // o codigo que estiver aqui dentro sera execultado pela thread separada
        // Obtém o nome da thread que está executando o código.
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0) { // calcula o resto da divisão inteira da variável i
                System.out.println();
            }
        }
    }
}

class ThreadExampleRunnable implements Runnable {
    private char c;
    public ThreadExampleRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0) {
                System.out.println();
            }
            try {
                Thread.sleep(2000); // faz a thread atual pausar sua execucao por um determinado tempo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/// Threads permitem executar tarefas de forma concorrente.
/// TODO evite por boas maneiras, usar thread, prefira concorrencia
public class ThreadBasicsTest {
    public static void main(String[] args) {
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');
        // o run usa a mesma thread, nesses exemplos foram a thread main que fizeram tudo
        // a sequencia que sera execultado e a JVM que escolhe
        Thread t1 = new Thread(new ThreadExampleRunnable('A'), "T1A"); // voce pode dar nomes as threads
        Thread t2 = new Thread(new ThreadExampleRunnable('B'), "T2B"); // os nomes definidos aqui, e oque vai aparecer no console
        Thread t3 = new Thread(new ThreadExampleRunnable('C'), "T3C");
        Thread t4 = new Thread(new ThreadExampleRunnable('D'), "T4D");
        // Essas Threads que criamos sao threads de User
        // por ser start, ela nunca vai entrar no metodo run para isso ela teria que ser run tambem
        // voce pode alterear a ordem de execulcao de uma thread, MAX e prioridade 10, MIN e 1 e NORM 5
        // nao e garantido a prioridade, e como uma indicação, voce nao deve desenvolver o codigo baseado nessa prioridade
        t4.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
//        t1.start(); // voce nao pode dar start duas vezes na mesma thread pois gera um IllegalThreadStateException
        System.out.println("############################ " + Thread.currentThread().getName());

        /**
         * Estados das threads
         *
         *                      Walting/
         *                      Blocked
         *                 /               \
         *  New  -->   Runnable   <-->   Running -->  Dead
         *
         *  - Quando voce da um start() ela passa a ser Runnable (sendo execultada)
         *  - E ai ela fica pronta para mudar de estado para Running
         *  - Depois ela pode voltar a ser Runnable ou a thread pode ser bloqueada(colocar para dormi)
         *  - Voce nunca pode voltar de Walting para Running direto, deve ir primeiro para Runnable
         *  - Quando voce execulta a thread t1, ela fica em Running, quando voce passa a ver a t2
         *  Significa que a t1 saiu de Running, voltou para Runnable. E quando todas as Threads
         *  terminan, ela fica Dead, depois que uma thread morre, nao tem como reultilizar, so
         *  criando outra, uma thread tambem nao pode passar de Walting para Dead direto, ela
         *  tem que passar por Runnable, Running e ai sim Dead
         *  - A thread main e a que execulta tudo, as outras threads como a t1, t2 etc
         *  execulta os metodos, nesse caso elas execulta o metodo (run), a thread main e
         *  quem execulta as outras duas threads
         *
         */

    }
}
