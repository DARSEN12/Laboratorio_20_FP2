import java.util.*;
<<<<<<< HEAD
public class Tablero {
    private int filas;
    private int columnas;
    private Set<String> posicionesOcupadas;
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.posicionesOcupadas = new HashSet<>();
    }
    public void agregarEjercito(Ejercito ejercito) {
        ejercito.generarSoldados(posicionesOcupadas, filas, columnas);
    }
    public void mostrarTablero(Ejercito ejercito1, Ejercito ejercito2) {
        System.out.println("\nTablero:");
        String[][] tablero = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ".";
            }
        }
        for (Soldado soldado : ejercito1.getSoldados()) {
            tablero[soldado.getFila()][soldado.getColumna()] = "E1";
        }
        for (Soldado soldado : ejercito2.getSoldados()) {
            tablero[soldado.getFila()][soldado.getColumna()] = "E2";
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
=======

public class Tablero {
    private final String[][] tablero;
    private final int filas = 10;
    private final int columnas = 10;

    private Ejercito ejercito1; 
    private Ejercito ejercito2; 

    public Tablero() {
        tablero = new String[filas][columnas];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = "-"; 
            }
        }
    }

    public void colocarEjercitos(Ejercito ejercito1, Ejercito ejercito2) {
        this.ejercito1 = ejercito1; 
        this.ejercito2 = ejercito2; 
    
        colocarEjercito(ejercito1); 
        colocarEjercito(ejercito2); 
    }

    private void colocarEjercito(Ejercito ejercito) {
        for (Soldado soldado : ejercito.getSoldados()) {
            int fila = soldado.fila;
            int columna = soldado.columna;

            if (tablero[fila][columna].equals("-")) {
                tablero[fila][columna] = soldado.getNumEjercito() + obtenerTipoSoldado(soldado);
            } else {
                reubicarSoldado(soldado);
            }
        }
    }

    private void reubicarSoldado(Soldado soldado) {
        Random random = new Random();
        int nuevaFila, nuevaColumna;
        do {
            nuevaFila = random.nextInt(filas);
            nuevaColumna = random.nextInt(columnas);
        } while (!tablero[nuevaFila][nuevaColumna].equals("-"));
    
        soldado.mover(nuevaFila, nuevaColumna);
        tablero[nuevaFila][nuevaColumna] = soldado.getNumEjercito() + obtenerTipoSoldado(soldado);
    }
    
    private String obtenerTipoSoldado(Soldado soldado) {
        if (soldado instanceof Espadachin) return "E";
        if (soldado instanceof Arquero) return "A";
        if (soldado instanceof Caballero) return "C";
        return "S"; 
    }

    public void mostrarTablero() {
        for (String[] fila : tablero) {
            for (String celda : fila) {
                System.out.print(celda + " ");
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
            }
            System.out.println();
        }
    }
<<<<<<< HEAD
}
=======

    public boolean esMovimientoValido(Soldado soldado, int nuevaFila, int nuevaColumna) {
        return nuevaFila >= 0 && nuevaFila < filas &&
               nuevaColumna >= 0 && nuevaColumna < columnas &&
               (tablero[nuevaFila][nuevaColumna].equals("-") || !tablero[nuevaFila][nuevaColumna].startsWith("1")
                || !tablero[nuevaFila][nuevaColumna].startsWith("2"));
    }
    
    public Soldado obtenerSoldadoEnPosicion(int fila, int columna) {
        for (Soldado soldado : ejercito1.getSoldados()) {
            if (soldado.fila == fila && soldado.columna == columna) {
                return soldado;
            }
        }
        for (Soldado soldado : ejercito2.getSoldados()) {
            if (soldado.fila == fila && soldado.columna == columna) {
                return soldado;
            }
        }
        return null;
    }
    
    public void moverSoldado(Soldado soldado, int nuevaFila, int nuevaColumna) {
        tablero[soldado.fila][soldado.columna] = "-"; 
        tablero[nuevaFila][nuevaColumna] = soldado.getNumEjercito() + obtenerTipoSoldado(soldado); 
        soldado.mover(nuevaFila, nuevaColumna);
    }

    public void limpiarPosicion(int fila, int columna) {
        tablero[fila][columna] = "-";
    }
}
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
