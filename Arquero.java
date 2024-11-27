public class Arquero extends Soldado {
    private int numeroDeFlechas;
<<<<<<< HEAD
=======

>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    public Arquero(String nombre, int puntosDeVida, int fila, int columna, int numeroDeFlechas) {
        super(nombre, puntosDeVida, fila, columna);
        this.numeroDeFlechas = numeroDeFlechas;
    }
<<<<<<< HEAD
    @Override
    public void accionEspecial() {
        if (numeroDeFlechas > 0) {
            numeroDeFlechas--;
            System.out.println(nombre + " disparó una flecha. Flechas restantes: " + numeroDeFlechas);
=======

    public void dispararFlecha() {
        if (numeroDeFlechas > 0) {
            numeroDeFlechas--;
            System.out.println(nombre + " disparo una flecha. Flechas restantes: " + numeroDeFlechas);
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
        } else {
            System.out.println(nombre + " no tiene flechas disponibles.");
        }
    }
<<<<<<< HEAD
=======

>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
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
