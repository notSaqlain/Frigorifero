import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        Menu();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                break;
        }
        scanner.close();
    }

    public static void Menu(){
        System.out.println("1) Inserisci un nuovo prodotto");
        System.out.println("2) Preleva un prodotto");
        System.out.println("3) Stampa tutti i prodotti");
        System.out.println("4) Stampa i prodotti scaduti");
        System.out.println("5) num di confez. per prodooto");
        System.out.println("6) Salva");

    }

}