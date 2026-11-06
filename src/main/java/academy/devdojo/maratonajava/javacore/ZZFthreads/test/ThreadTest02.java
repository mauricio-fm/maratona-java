package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

class ThreadExampleRunnable2 implements Runnable {
    private String s;
    public ThreadExampleRunnable2(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(s);
            if (i % 100 == 0) {
                System.out.println();
            }
//            Thread.yield(); // diz para a thread dar uma pausa, da a vez para outra thread
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

//voce pode criar uma thread diretamente como uma inner class
public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadExampleRunnable2("KA"));
        Thread thread2 = new Thread(new ThreadExampleRunnable2("Me"));
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread1.join();
        // o join cria uma barreira que nao deixa pular para uma proxima, sem termina
        // a execucao na thread atual, aqui, equanto a thread (thread1) nao termina, a thread (thread2) nao execulta
        // a thread main que e quem controla tudo da um join na thread 1, se voce tirar o join, execulta sem ordem
        thread2.start();
    }
}
