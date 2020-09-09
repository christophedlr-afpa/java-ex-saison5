import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int option;
        boolean exit =false;
        Main m = new Main();

        do {
            System.out.println("1. 5.2b");
            System.out.print("Choisissez votre option : ");
            option = Integer.parseInt(m.reader.readLine());

            if (option == 1) {
                m.algo52b();
                exit = true;
            } else {
                System.out.println("Choix invalide");
            }
        } while (!exit);
    }

    public void algo52b() throws IOException {
        int randomNumber;
        int number = -1;
        int numberTesting = 0;

        randomNumber = (int)(Math.random()*(100-1))+1;

        while (number != randomNumber) {
            numberTesting += +1;
            System.out.print("Choisissez un nombre entre 1 et 100 : ");
            number = Integer.parseInt(reader.readLine());

            if (number > randomNumber) {
                System.out.println("Plus petit !");
            } else if (number < randomNumber) {
                System.out.println("Plus grand !");
            }
        }

        System.out.println("Vous avez trouvé, bravo !");
        System.out.println("Il vous aura fallut "+numberTesting+" essais pour y arriver");
    }
}
