package academy.devdojo.maratonajava.introducao.projetos;

public class Bateria {
    public static void main(String[] args) {
        int bateria = 100;

        while (bateria > 0){
            System.out.println("Bateria em: " + bateria);
            bateria = bateria - 5;

            if(bateria == 20){
                System.out.println("bateria baixa");
            }else{
                continue;
            }
        }
    }
}
