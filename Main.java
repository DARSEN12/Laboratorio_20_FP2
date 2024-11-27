public class Main {
    public static void main(String[] args) {
        Ejercito ejercito1 = new Ejercito();
        Ejercito ejercito2 = new Ejercito();
        Tablero tablero = new Tablero();

        tablero.colocarEjercitos(ejercito1, ejercito2); 

        JuegoDeBatalla juego = new JuegoDeBatalla(tablero, ejercito1, ejercito2);
        juego.iniciar();
    }
}

