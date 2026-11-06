package academy.devdojo.maratonajava.introducao.projetos;

public class ControleDeSenha {
    public static void main(String[] args) {
        String senha = "0000";

        switch (senha){
            case "1234":
                System.out.println("1234 - senha correta");
                break;
            case "0000":
                System.out.println("0000 - senha padrao");
                break;
            default:
                System.out.println("senha invalida");
                break;
        }
    }
}
