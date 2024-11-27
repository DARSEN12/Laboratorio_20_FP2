import java.util.*;
public class BatallaEntreEjercitos {
    public static void enfrentarEjercitos(Ejercito ejercito1, Ejercito ejercito2) {
        List<Soldado> soldados1 = new ArrayList<>(ejercito1.getSoldados());
        List<Soldado> soldados2 = new ArrayList<>(ejercito2.getSoldados());

        int turno = 1;
        while (!soldados1.isEmpty() && !soldados2.isEmpty()) {
            System.out.println("\nTurno " + turno);

            Soldado soldado1 = soldados1.get(0);
            Soldado soldado2 = soldados2.get(0);
            
                Soldado ganador = Batalla.enfrentar(soldado1, soldado2);
                if (ganador == soldado1) {
                    soldados2.remove(0); 
                } else {
                    soldados1.remove(0); 
                }

            

            turno++;
        }

        if (soldados1.isEmpty()) {
            System.out.println("\nEl Ejercito 2 ha ganado la batalla!");
        } else {
            System.out.println("\nEl Ejercito 1 ha ganado la batalla!");
        }
    }
}
