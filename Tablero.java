import java.util.*;

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

        // Inicializar el tablero vacío
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ".";
            }
        }

        // Colocar soldados del primer ejército
        for (Soldado soldado : ejercito1.getSoldados()) {
            tablero[soldado.getFila()][soldado.getColumna()] = "E1";
        }

        // Colocar soldados del segundo ejército
        for (Soldado soldado : ejercito2.getSoldados()) {
            tablero[soldado.getFila()][soldado.getColumna()] = "E2";
        }

        // Imprimir el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
