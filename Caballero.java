public class Caballero extends Soldado {
    private String armaActual;
    private boolean montado;
<<<<<<< HEAD
=======

>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    public Caballero(String nombre, int puntosDeVida, int fila, int columna) {
        super(nombre, puntosDeVida, fila, columna);
        this.armaActual = "espada";
        this.montado = false;
    }
<<<<<<< HEAD
=======

>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    public void montar() {
        if (!montado) {
            montado = true;
            armaActual = "lanza";
<<<<<<< HEAD
            System.out.println(nombre + " se ha montado y ahora usa una lanza.");
        } else {
            System.out.println(nombre + " ya está montado.");
        }
    }
=======
            System.out.println(nombre + " se ha montado y ahora usa una lanza");
        } else {
            System.out.println(nombre + " ya esta montado.");
        }
    }

>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    public void desmontar() {
        if (montado) {
            montado = false;
            armaActual = "espada";
            System.out.println(nombre + " se ha desmontado y ahora usa una espada.");
        } else {
<<<<<<< HEAD
            System.out.println(nombre + " ya está desmontado.");
        }
    }
    @Override
    public void accionEspecial() {
        int ataques = montado ? 3 : 2;
        System.out.println(nombre + " realiza " + ataques + " ataques con su " + armaActual + ".");
    }
=======
            System.out.println(nombre + " ya esta desmontado.");
        }
    }

    public void envestir() {
        int ataques = montado ? 3 : 2;
        System.out.println(nombre + " realiza " + ataques + " ataques con su " + armaActual);
    }

>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    @Override
    public String toString() {
        return "Caballero{" +
               "nombre='" + nombre + '\'' +
               ", puntosDeVida=" + puntosDeVida +
               ", posición=(" + fila + ", " + columna + ")" +
               ", armaActual='" + armaActual + '\'' +
               ", montado=" + montado +
               '}';
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
