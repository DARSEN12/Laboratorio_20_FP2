public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(10, 10);

        Ejercito ejercito1 = new Ejercito("Ejército 1");
        Ejercito ejercito2 = new Ejercito("Ejército 2");

        tablero.agregarEjercito(ejercito1);
        tablero.agregarEjercito(ejercito2);

        ejercito1.imprimirEjercito();
        ejercito2.imprimirEjercito();

        tablero.mostrarTablero(ejercito1, ejercito2);
    }
}
