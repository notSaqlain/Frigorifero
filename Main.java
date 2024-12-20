import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
                    System.out.print("0) Prodotti disponibili \n1) Prodotti scaduti\n");
                    int temp = scanner.nextInt();
                    int prod;
                    if (temp == 0) {
                        System.out.print("Scrivi l'indice di prodotto da prelevare: ");
                        prod = scanner.nextInt();
                        System.out.println("Il prodotto " + prodotti.get(prod) + " prelevato!");
                        prodotti.remove(prod);
                    } else if (temp == 1) {
                        System.out.print("Scrivi l'indice di prodotto scaduto da prelevare: ");
                        prod = scanner.nextInt();
                        System.out.println("Il prodotto scaduto " + scaduti.get(prod) + " prelevato!");
                        scaduti.remove(prod);
                    }
                    break;

                case 3:
                    System.out.println("Prodotti disponibili:");
                    for (int i = 0; i < prodotti.size(); i++) {
                        System.out.println(i + ") " + prodotti.get(i));
                    }
                    System.out.println();

                    System.out.println("Prodotti scaduti:");
                    for (int i = 0; i < scaduti.size(); i++) {
                        System.out.println(i + ") " + scaduti.get(i));
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Prodotti Scaduti: ");
                    for (Frigorifero S : scaduti) {
                        System.out.println(S);
                    }
                    break;

                case 5:
                    Map<Integer, Integer> quantita = new HashMap<>();

                    for (Frigorifero f : prodotti) {
                        quantita.put(f.getId(), quantita.getOrDefault(f.getId(), 0) + 1);
                    }

                    for (Map.Entry<Integer, Integer> entry : quantita.entrySet()) {
                        System.out.println("ID: " + entry.getKey() + " => Numero di prodotti: " + entry.getValue());
                    }
                    
                    quantita.clear();

                    for (Frigorifero f : scaduti) {
                        quantita.put(f.getId(), quantita.getOrDefault(f.getId(), 0) + 1);
                    }

                    for (Map.Entry<Integer, Integer> entry : quantita.entrySet()) {
                        System.out.println("ID: " + entry.getKey() + " => Numero di prodotti scaduti: " + entry.getValue());
                    }

                    break;

                case 6:
                    salva(prodotti, "Prodotti.csv");
                    salva(scaduti, "Scaduti.csv");
                    System.out.println("Prodotti salvati con successo!");
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

    public static void salva(ArrayList<Frigorifero> lista, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            
            writer.write("ID | Nome | Calorie | Data di Scadenza\n");

            for (Frigorifero prodotto : lista) {
                writer.write(prodotto.getId() + " | " + prodotto.getDes() + " | " +
                             prodotto.getCal() + " | " + prodotto.getExpiryDate() + "\n");
            }
            
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del file: " + e.getMessage());
        }
    }
}
