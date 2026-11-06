package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Members;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.EmailDeliveryService;

import javax.swing.*;

public class ConditionTest1 {
    public static void main(String[] args) {
        Members members = new Members(); // "TODO" para ver Condition consulte a classe em Members do pacote ZZGconcorrencia
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");
        Thread itachi = new Thread(new EmailDeliveryService(members), "Itachi");
        kakashi.start();
        itachi.start();
        while (true) {
            String email = JOptionPane.showInputDialog("Entre com seu email"); // cria uma janela input para colocar dados
            if (email == null || email.isEmpty()) {
                members.close();
                 break;
            }
            members.addMemberEmail(email);
        }
    }
}
