<<<<<<< HEAD
public abstract class Soldado {
    protected String nombre;
    protected int puntosDeVida;
    protected int fila;
    protected int columna;
    public Soldado(String nombre, int puntosDeVida, int fila, int columna) {
=======
public class Soldado {
    protected String nombre;
    protected int puntosDeVida, numEjercito;
    protected int fila;
    protected int columna;

    public Soldado(String nombre, int puntosDeVida, int fila, int columna) {
        numEjercito=Ejercito.getNumEjercitos();
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.fila = fila;
        this.columna = columna;
    }
<<<<<<< HEAD
    public abstract void accionEspecial();
=======

    public int getNumEjercito() {
        return numEjercito;
    }
    
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }
<<<<<<< HEAD
    public String getNombre() {
        return nombre;
    }
    public int getPuntosDeVida() {
        return puntosDeVida;
    }
    public void incrementarVida(int cantidad) {
        this.puntosDeVida += cantidad;
    }
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
=======

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void incrementarVida(int cantidad) {
        this.puntosDeVida += cantidad;
    }

>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    @Override
    public String toString() {
        return "Soldado{" +
               "nombre='" + nombre + '\'' +
               ", puntosDeVida=" + puntosDeVida +
               ", posición=(" + fila + ", " + columna + ")" +
               '}';
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
