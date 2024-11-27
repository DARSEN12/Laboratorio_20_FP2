public class Espadachin extends Soldado {
    private int longitudDeEspada;
<<<<<<< HEAD
=======
    
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    public Espadachin(String nombre, int puntosDeVida, int fila, int columna, int longitudDeEspada) {
        super(nombre, puntosDeVida, fila, columna);
        this.longitudDeEspada = longitudDeEspada;
    }
<<<<<<< HEAD
    @Override
    public void accionEspecial() {
        System.out.println(nombre + " está creando un muro de escudos.");
    }
    @Override
    public String toString() {
        return "Espadachin{" +
               "nombre='" + nombre + '\'' +
               ", puntosDeVida=" + puntosDeVida +
               ", posición=(" + fila + ", " + columna + ")" +
               ", longitudDeEspada=" + longitudDeEspada +
               '}';
=======
    
    public void crearMuroDeEscudos() {
        System.out.println(nombre + " esta creando un muro de escudos");
    }
    
    @Override
    public String toString() {
        return "Espadachin{" +
                "nombre='" + nombre + '\'' +
                ", puntosDeVida=" + puntosDeVida +
                ", posición=(" + fila + ", " + columna + ")" +
                ", longitudDeEspada=" + longitudDeEspada +
                '}';
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    }
}
    

