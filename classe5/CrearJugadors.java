package classe5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearJugadors {
    public static void main(String[] args) {
        String[] nom = {"Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5", "jugador6"};
        int[] punts = {0, 0, 0, 0, 0, 0};
        File fitxer = new File("FitxerJugadors.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fitxer))) {
            for (int i = 0; i < nom.length; i++)
            {
                Judagors jugador = new Judagors(nom[i], punts[i]);
                oos.writeObject(jugador);
            }
            System.out.println("Jugadors guardats en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}