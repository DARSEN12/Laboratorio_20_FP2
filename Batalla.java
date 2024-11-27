import java.util.*;
<<<<<<< HEAD
public class Batalla {
    protected Random random;
    public Batalla() {
        this.random = new Random();
    }
    protected void ejecutarAtaque(Soldado atacante, Soldado defensor) {
        int daño = random.nextInt(3) + 1; 
        defensor.incrementarVida(-daño);
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " causando " + daño + " de daño. Vida restante de " + defensor.getNombre() + ": " + Math.max(0, defensor.getPuntosDeVida()));
    }
    protected boolean estaEliminado(Soldado soldado) {
        return soldado.getPuntosDeVida() <= 0;
=======

public class Batalla {
    private static final Random random = new Random();

    public static Soldado enfrentar(Soldado soldado1, Soldado soldado2) {
        int vidaTotal = soldado1.getPuntosDeVida() + soldado2.getPuntosDeVida();
        double probabilidadSoldado1 = (double) soldado1.getPuntosDeVida() / vidaTotal;
        double probabilidadSoldado2 = (double) soldado2.getPuntosDeVida() / vidaTotal;

        System.out.printf("%s (%.2f%%) vs %s (%.2f%%)%n",
                soldado1.getNombre(), probabilidadSoldado1 * 100,
                soldado2.getNombre(), probabilidadSoldado2 * 100);

        double resultado = random.nextDouble(); 

        if (resultado < probabilidadSoldado1) {
            soldado1.incrementarVida(1); 
            System.out.println(soldado1.getNombre() + " gano la batalla.");
            return soldado1;
        } else {
            soldado2.incrementarVida(1); 
            System.out.println(soldado2.getNombre() + " gano la batalla.");
            return soldado2;
        }
>>>>>>> ab8b095bed20f7cef1f015b6c6557be3b224d211
    }
}
