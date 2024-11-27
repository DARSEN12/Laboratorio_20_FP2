public class Arquero extends Soldado {
    private int numeroDeFlechas;

    public Arquero(String nombre, int puntosDeVida, int fila, int columna, int numeroDeFlechas) {
        super(nombre, puntosDeVida, fila, columna);
        this.numeroDeFlechas = numeroDeFlechas;
    }

    public void dispararFlecha() {
        if (numeroDeFlechas > 0) {
            numeroDeFlechas--;
            System.out.println(nombre + " disparo una flecha. Flechas restantes: " + numeroDeFlechas);
        } else {
            System.out.println(nombre + " no tiene flechas disponibles.");
        }
    }

    @Override
    public String toString() {
        return "Arquero{" +
               "nombre='" + nombre + '\'' +
               ", puntosDeVida=" + puntosDeVida +
               ", posición=(" + fila + ", " + columna + ")" +
               ", numeroDeFlechas=" + numeroDeFlechas +
               '}';
    }
}
