import java.util.*;
public class BatallaEntreEjercitos extends Batalla {
    private Ejercito ejercito1;
    private Ejercito ejercito2;

    public BatallaEntreEjercitos(Ejercito ejercito1, Ejercito ejercito2) {
        super();
        this.ejercito1 = ejercito1;
        this.ejercito2 = ejercito2;
    }

    public void iniciar() {
        System.out.println("¡La batalla entre ejércitos comienza!");

        while (!ejercito1.getSoldados().isEmpty() && !ejercito2.getSoldados().isEmpty()) {
            turno();
        }

        determinarGanador();
    }

    private void turno() {
        Soldado soldado1 = seleccionarSoldadoAleatorio(ejercito1.getSoldados());
        Soldado soldado2 = seleccionarSoldadoAleatorio(ejercito2.getSoldados());

        System.out.println("\nTurno: " + soldado1.getNombre() + " vs " + soldado2.getNombre());

        // Soldado 1 ataca
        ejecutarAtaque(soldado1, soldado2);
        if (estaEliminado(soldado2)) {
            System.out.println(soldado2.getNombre() + " ha caído.");
            ejercito2.getSoldados().remove(soldado2);
            return;
        }

        // Soldado 2 ataca
        ejecutarAtaque(soldado2, soldado1);
        if (estaEliminado(soldado1)) {
            System.out.println(soldado1.getNombre() + " ha caído.");
            ejercito1.getSoldados().remove(soldado1);
        }
    }

    private Soldado seleccionarSoldadoAleatorio(List<Soldado> soldados) {
        return soldados.get(random.nextInt(soldados.size()));
    }

    private void determinarGanador() {
        System.out.println("\n¡La batalla ha terminado!");

        if (ejercito1.getSoldados().isEmpty() && ejercito2.getSoldados().isEmpty()) {
            System.out.println("¡Es un empate! Ambos ejércitos han caído.");
        } else if (ejercito1.getSoldados().isEmpty()) {
            System.out.println("¡" + ejercito2.getNombre() + " ha ganado la batalla!");
        } else {
            System.out.println("¡" + ejercito1.getNombre() + " ha ganado la batalla!");
        }

        calcularEstadisticas(ejercito1);
        calcularEstadisticas(ejercito2);
    }

    private void calcularEstadisticas(Ejercito ejercito) {
        List<Soldado> soldados = ejercito.getSoldados();
        if (soldados.isEmpty()) {
            System.out.println(ejercito.getNombre() + " no tiene soldados sobrevivientes.");
            return;
        }

        Soldado soldadoConMayorVida = soldados.stream().max((s1, s2) -> Integer.compare(s1.getPuntosDeVida(), s2.getPuntosDeVida())).orElse(null);
        double promedioVida = soldados.stream().mapToInt(Soldado::getPuntosDeVida).average().orElse(0);

        System.out.println("\nEstadísticas de " + ejercito.getNombre() + ":");
        System.out.println("Soldado con mayor vida: " + soldadoConMayorVida);
        System.out.println("Promedio de puntos de vida: " + promedioVida);
    }
}
