package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        try {
            divisao(1,0);
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static int divisao(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Invalid argument, the argument passed cannot be 0.");
            //e recomendado que voce use a excecao mais especifica possivel, como a IllegalArgumentException
        }
        return a/b;
    }
}
