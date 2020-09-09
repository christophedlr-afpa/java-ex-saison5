import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int     option;
        boolean exit = false;
        Main    m    = new Main();

        do {
            System.out.println("1. 5.2b");
            System.out.println("2. 5.10");
            System.out.print("Choisissez votre option : ");
            option = Integer.parseInt(m.reader.readLine());

            if (option == 1) {
                m.algo52b();
                exit = true;
            } else if (option == 2) {
                m.algo510();
                exit = true;
            } else {
                System.out.println("Choix invalide");
            }
        } while (!exit);
    }

    public void algo52b() throws IOException {
        int randomNumber;
        int number        = -1;
        int numberTesting = 0;

        randomNumber = (int) (Math.random() * (100 - 1)) + 1;

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
        System.out.println("Il vous aura fallut " + numberTesting + " essais pour y arriver");
    }

    public void algo510() throws IOException {
        int           price           = -1;
        int           amountPay       = 0;
        int           total           = 0;
        int           totalTemp       = 0;
        int           numberTenEuros  = 0;
        int           numberFiveEuros = 0;
        int           numberOneEuros  = 0;
        int           x               = 0;
        List<Integer> listPrice;

        listPrice = new ArrayList<Integer>();

        while (price != 0) {
            System.out.print("Donnez un prix : ");
            price = Integer.parseInt(reader.readLine());
            listPrice.add(price);
        }

        while (listPrice.size() != 0) {
            total += listPrice.get(x);
            listPrice.remove(x);
        }

        System.out.println("Vous devez payer " + total + " €");
        System.out.print("Combien donnez-vous : ");
        amountPay = Integer.parseInt(reader.readLine());
        totalTemp = amountPay - total;

        while (totalTemp > 0) {
            int tempTenEuros = totalTemp / 10;
            numberTenEuros += tempTenEuros;
            totalTemp -= (numberTenEuros * 10);

            int tempFiveEuros = totalTemp / 5;
            numberFiveEuros += tempFiveEuros;
            totalTemp -= (numberFiveEuros * 5);

            int tempOneEuros = totalTemp;
            numberOneEuros += tempOneEuros;
            totalTemp -= numberOneEuros;
        }

        System.out.println("Le marchand vous a rendu " +
                numberTenEuros + " billets de 10 €, " +
                numberFiveEuros + " billets de 5€, " +
                numberOneEuros + " pièces de 1 €"
        );
    }

    public void algo511() throws IOException {
        int horseStarting = 0;
        int horsePlayed   = 0;
        int x             = 1;
        int y             = 1;
        int n             = 1;
        int p             = 1;
        int result        = 1;

        System.out.print("Nombre de chevaux partant : ");
        horseStarting = Integer.parseInt(reader.readLine());

        System.out.print("Nombre de chevaux joués : ");
        horsePlayed = Integer.parseInt(reader.readLine());

        for (int i = 1; i < horseStarting+1; i++) {
            n *= i;
        }

        for (int i = 1; i < (horseStarting-horsePlayed)+1; i++) {
            result *= i;
        }

        x = n/result;

        for (int i = 1; i < horsePlayed+1; i++) {
            p *= i;
        }

        y = n/(p*result);

        System.out.println("Dans l'ordre : une chance sur "+x+" de gagner");
        System.out.println("Dans le désordre : une chance sur "+y+" de gagner");
    }
}
