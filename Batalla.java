import java.util.*;
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
    }
}

