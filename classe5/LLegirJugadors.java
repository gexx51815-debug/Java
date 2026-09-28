package classe5;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
public class LLegirJugadors {
    public static void main(String[] args) {
        File fitxer = new File("FitxerJugadors.txt");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitxer))) {
            while (true)
            {
                Judagors jugador = (Judagors) ois.readObject();
                System.out.println("Nom: " + jugador.getNom() + ", Punts: " + jugador.getPunts());
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitxer))) {
            for (int i = 0; i < 6; i++)
            {
                Judagors jugador = (Judagors) ois.readObject();
                System.out.println("Nom: " + jugador.getNom() + ", Punts: " + jugador.getPunts());
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
}