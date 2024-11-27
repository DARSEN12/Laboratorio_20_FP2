import java.util.*;

public class Ejercito {
    private static final Random random = new Random();
    private final List<Soldado> soldados;
    private static int numEjercitos=0;

    public Ejercito() {
        numEjercitos++;
        this.soldados = new ArrayList<>();
        generarSoldados();
    }

    public static int getNumEjercitos() {
        return numEjercitos;
    }
    
    private void generarSoldados() {
        int cantidadSoldados = 5;
        for (int i = 0; i < cantidadSoldados; i++) {
            int tipoSoldado = random.nextInt(3); 
            String nombre = generarNombre(tipoSoldado, i);
            int fila = random.nextInt(10); 
            int columna = random.nextInt(10);

            switch (tipoSoldado) {
                case 0: 
                    soldados.add(new Espadachin(nombre, random.nextInt(2) + 3, fila, columna, random.nextInt(50) + 50));
                    break;
                case 1: 
                    soldados.add(new Arquero(nombre, random.nextInt(3) + 1, fila, columna, random.nextInt(10) + 5));
                    break;
                case 2: 
                    soldados.add(new Caballero(nombre, random.nextInt(3) + 3, fila, columna));
                    break;
            }
        }
    }

    private String generarNombre(int tipo, int indice) {
        String tipoSoldado = switch (tipo) {
            case 0 -> "Espadachin";
            case 1 -> "Arquero";
            case 2 -> "Caballero";
            default -> "Soldado";
        };
        return tipoSoldado + "X" + indice;
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }
}
