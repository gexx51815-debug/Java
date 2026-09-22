import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Agenda {

    String contactes[][] = new String[100][3];

    public void AfegirContacte() {

        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();

        String telefon = scanner.nextLine();

        String correu = scanner.nextLine();

        try {
            FileWriter fw = new FileWriter("contactes.txt", true);

            fw.write(nom + ";" + telefon + ";" + correu + "\n");

            fw.close();

        } catch (Exception e) {
            System.out.println("Error al escriure en el fitxer: " + e.getMessage());
        }
    }

    public void LlistarContactes() {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("contactes.txt")
            );

            String linea;
            int i = 0;

            while ((linea = br.readLine()) != null) {

                this.contactes[i] = linea.split(";");

                System.out.println(
                        "Nom: " + this.contactes[i][0]
                        + ", Telefon: " + this.contactes[i][1]
                        + ", Correu: " + this.contactes[i][2]
                );

                i++;
            }

            br.close();

        } catch (Exception e) {
            System.out.println("El fitxer encara no existeix.");
        }
    }

    public void CercarContactePerNom(String nom) {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("contactes.txt")
            );

            String linea;
            boolean trobat = false;

            while ((linea = br.readLine()) != null) {

                String dades[] = linea.split(";");

                if (dades[0].equalsIgnoreCase(nom)) {

                    System.out.println(
                            "Nom: " + dades[0]
                            + ", Telefon: " + dades[1]
                            + ", Correu: " + dades[2]
                    );

                    trobat = true;
                }
            }

            if (!trobat) {
                System.out.println("No s'ha trobat el contacte.");
            }

            br.close();

        } catch (Exception e) {
            System.out.println("El fitxer encara no existeix.");
        }
    }

    public void Menu() {

        Scanner scanner = new Scanner(System.in);

        int menu = 1;

        do {

            System.out.println();
            System.out.println("1. Afegir contacte");
            System.out.println("2. Llistar contactes");
            System.out.println("3. Cercar contacte per nom");
            System.out.println("4. Sortir");
            System.out.print("Selecciona una opcio: ");

            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {

                case 1:
                    AfegirContacte();
                    break;

                case 2:
                    LlistarContactes();
                    break;

                case 3:
                    System.out.print("Introdueix el nom");
                    String nom = scanner.nextLine();

                    CercarContactePerNom(nom);
                    break;

                case 4:
                    System.out.println("Sortint");
                    break;

                default:
                    System.out.println("Opcio no valida");
            }

        } while (menu != 4);
    }
    
}