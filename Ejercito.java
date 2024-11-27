import java.util.*;
<<<<<<< HEAD
public class Ejercito {
    private String nombre;
    private List<Soldado> soldados;
    private static Random random = new Random();
    public Ejercito(String nombre) {
        this.nombre = nombre;
        this.soldados = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void generarSoldados(Set<String> posicionesOcupadas, int filasTablero, int columnasTablero) {
        int numeroDeSoldados = 3;
        for (int i = 0; i < numeroDeSoldados; i++) {
            String tipoSoldado = elegirTipoSoldado();
            String nombreSoldado = tipoSoldado + "_" + nombre + "_" + i;
            int fila, columna;
            do {
                fila = random.nextInt(filasTablero);
                columna = random.nextInt(columnasTablero);
            } while (posicionesOcupadas.contains(fila + "," + columna));
            posicionesOcupadas.add(fila + "," + columna);
            Soldado soldado = crearSoldado(tipoSoldado, nombreSoldado, fila, columna);
            soldados.add(soldado);
        }
    }
    private String elegirTipoSoldado() {
        String[] tipos = {"Arquero", "Caballero", "Espadachin", "Lancero"};
        return tipos[random.nextInt(tipos.length)];
    }
    private Soldado crearSoldado(String tipo, String nombre, int fila, int columna) {
        switch (tipo) {
            case "Arquero":
                int flechas = random.nextInt(10) + 1; 
                return new Arquero(nombre, random.nextInt(3) + 1, fila, columna, flechas);
            case "Caballero":
                return new Caballero(nombre, random.nextInt(3) + 3, fila, columna);
            case "Espadachin":
                int longitudEspada = random.nextInt(5) + 1; 
                return new Espadachin(nombre, random.nextInt(2) + 3, fila, columna, longitudEspada);
            case "Lancero":
                int longitudLanza = random.nextInt(4) + 1; 
                return new Lancero(nombre, random.nextInt(2) + 1, fila, columna, longitudLanza);
            default:
                throw new IllegalArgumentException("Tipo de soldado no válido: " + tipo);
        }
    }
    public void imprimirEjercito() {
        System.out.println("\n" + nombre);
        for (Soldado soldado : soldados) {
            System.out.println(soldado);
        }
    }
    public List<Soldado> getSoldados() {
        return soldados;
    }
}
=======

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
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
