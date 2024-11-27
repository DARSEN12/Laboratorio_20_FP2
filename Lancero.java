public class Lancero extends Soldado {
    private int longitudDeLanza;

    public Lancero(String nombre, int puntosDeVida, int fila, int columna, int longitudDeLanza) {
        super(nombre, puntosDeVida, fila, columna);
        this.longitudDeLanza = longitudDeLanza;
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " utiliza 'Schiltrom', aumentando su defensa.");
        incrementarVida(1); 
    }

    @Override
    public String toString() {
        return "Lancero{" +
               "nombre='" + nombre + '\'' +
               ", puntosDeVida=" + puntosDeVida +
               ", posición=(" + fila + ", " + columna + ")" +
               ", longitudDeLanza=" + longitudDeLanza +
               '}';
    }
}

