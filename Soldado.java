public class Soldado {
    protected String nombre;
    protected int puntosDeVida, numEjercito;
    protected int fila;
    protected int columna;

    public Soldado(String nombre, int puntosDeVida, int fila, int columna) {
        numEjercito=Ejercito.getNumEjercitos();
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.fila = fila;
        this.columna = columna;
    }

    public int getNumEjercito() {
        return numEjercito;
    }
    
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
