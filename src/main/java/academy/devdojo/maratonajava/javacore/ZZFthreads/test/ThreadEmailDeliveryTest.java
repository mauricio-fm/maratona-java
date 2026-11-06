package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Members;
import academy.devdojo.maratonajava.javacore.ZZFthreads.service.EmailDeliveryService;

import javax.swing.*;

public class ThreadEmailDeliveryTest {
    public static void main(String[] args) {
        Members members = new Members();
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
