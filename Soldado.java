public abstract class Soldado {
    protected String nombre;
    protected int puntosDeVida;
    protected int fila;
    protected int columna;

    public Soldado(String nombre, int puntosDeVida, int fila, int columna) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.fila = fila;
        this.columna = columna;
    }

    public abstract void accionEspecial();

    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void incrementarVida(int cantidad) {
        this.puntosDeVida += cantidad;
    }

    @Override
    public String toString() {
        return "Soldado{" +
               "nombre='" + nombre + '\'' +
               ", puntosDeVida=" + puntosDeVida +
               ", posición=(" + fila + ", " + columna + ")" +
               '}';
    }
}
