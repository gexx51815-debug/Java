import java.io.File;
import java.util.Scanner;

public class VerDir {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String path = "c:\\";
            path = sc.nextLine();

            File dir = new File(path);

            if (!dir.isDirectory()) {
                System.out.println("No es un directorio");
                return;
            }

            System.out.println("Es un directorio y su ruta absoluta es: "
                    + dir.getAbsolutePath());

            File[] files = dir.listFiles();

            if (files == null) {
                System.out.println("No se puede acceder al contenido.");
                return;
            }

            int totalElementos = 0;
            long totalBytes = 0;

            System.out.println("Contenido de la carpeta:");

            for (File file : files) {

                totalElementos++;

                if (file.isDirectory()) {

                    System.out.println(
                        "[CARPETA] " + file.getName()
                        + " | Tamaño: " + file.length() + " bytes"
                        + " | Escribible: " + file.canWrite()
                    );

                } else {

                    System.out.println(
                        "[ARCHIVO] " + file.getName()
                        + " | Tamaño: " + file.length() + " bytes"
                        + " | Escribible: " + file.canWrite()
                    );

                    totalBytes += file.length();
                }
            }

            System.out.println("--------------------------------");
            System.out.println("Total de elementos: " + totalElementos);
            System.out.println("Tamaño total de archivos: "
                    + totalBytes + " bytes");
        }
    }
}