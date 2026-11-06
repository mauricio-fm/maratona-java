package academy.devdojo.maratonajava.introducao.projetos;

public class SistemaAcademia {
    public static void main(String[] args) {
        String nomeCliente = "Maurício";
        int idadeCliente = 14;
        char plano = 'P';
        boolean exameMedico = true;
        int mesesRestantes = 12;
        int energia = 100;

        if(idadeCliente <= 14 || exameMedico == true){
            System.out.println("Matricula Aprovada");
        }else{
            System.out.println("Matricula Negada");
        }

        switch (plano){
            case 'P':
                System.out.println("Plano Prata - R$50");
                break;
            case 'G':
                System.out.println("Plano Gold - R$80");
                break;
            case 'V':
                System.out.println("Plano Vip - R$120");
                break;
        }

        for (int meses = 1; mesesRestantes<=12 ; meses++) {
            if(meses > mesesRestantes){
                break;
            }
            System.out.println("Mes" + meses);
        }

        while (energia > 0){
            System.out.println("Energia: " + energia);
            energia -= 10;
        }
    }
}
