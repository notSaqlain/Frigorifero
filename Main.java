import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        ArrayList<Frigorifero> prodotti = new ArrayList<>();
        ArrayList<Frigorifero> scaduti = new ArrayList<>();
        System.out.println(today);
        Scanner scanner = new Scanner(System.in);

        int choice = 1;

        do {
            Menu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nome: ");
                    scanner.nextLine();
                    String des = scanner.nextLine();

                    System.out.println("ID: ");
                    int id = scanner.nextInt();

                    System.out.println("Calorie: ");
                    int cal = scanner.nextInt();

                    System.out.println("Data di scadenza: ");
                    System.out.print("Giorno: ");
                    int d = scanner.nextInt();
                    System.out.print("Mese: ");
                    int m = scanner.nextInt();
                    System.out.print("Anno: ");
                    int y = scanner.nextInt();

                    LocalDate expiryDate = LocalDate.of(y, m, d);

                    Frigorifero F = new Frigorifero(id, des, cal, expiryDate);

                    if (today.isBefore(expiryDate)) {
                        prodotti.add(F);
                    } else {
                        scaduti.add(F);
                    }

                    System.out.println("Prodotto aggiunto con successo.");

                    break;
                case 2:
                    System.out.print("0) Prodotti disponibili \n 1) Prodotti scaduti");
                    int temp = scanner.nextInt();
                    int prod;
                    if (temp == 0) {
                        System.out.print("Scrivi l'indice di prodotto da prelevare: ");
                        prod = scanner.nextInt();
                        System.out.println("il prodotto " + prodotti.get(prod) + " prelevato!");
                        prodotti.remove(prod);
                    } else if (temp == 1) {
                        System.out.print("Scrivi l'indice di prodotto scaduto da prelevare: ");
                        prod = scanner.nextInt();
                        System.out.println("il prodotto scaduto " + scaduti.get(prod) + " prelevato!");
                        scaduti.remove(prod);
                    }
                    break;
                case 3:
                    System.out.println("Prodotti disponibili:");
                    for (int i = 0; i < prodotti.size(); i++) {
                        System.out.println(i + ") " + prodotti.get(i));
                    }

                    System.out.println("Prodotti scaduti:");
                    for (int i = 0; i < scaduti.size(); i++) {
                        System.out.println(i + ") " + scaduti.get(i));
                    }

                    break;
                case 4:
                    System.out.println("Prodotti Scaduti: ");
                    for (Frigorifero S : scaduti) {
                        System.out.println(S);
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void Menu() {
        System.out.println("0) Esci");
        System.out.println("1) Inserisci un nuovo prodotto");
        System.out.println("2) Preleva un prodotto");
        System.out.println("3) Stampa tutti i prodotti");
        System.out.println("4) Stampa i prodotti scaduti");
        System.out.println("5) Num di confez. per prodotto");
        System.out.println("6) Salva");
    }

}
