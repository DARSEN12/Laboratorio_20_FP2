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
        mostrarEstadisticasIniciales();     
        while (!ejercito1.getSoldados().isEmpty() && !ejercito2.getSoldados().isEmpty()) {
            turno();
        }
        mostrarResumenFinal();
    }
    private void mostrarEstadisticasIniciales() {
        System.out.println("\n--- Estadísticas Iniciales ---");
        calcularEstadisticas(ejercito1);
        calcularEstadisticas(ejercito2);
    }  
    private void turno() {
        Soldado soldado1 = seleccionarSoldadoAleatorio(ejercito1.getSoldados());
        Soldado soldado2 = seleccionarSoldadoAleatorio(ejercito2.getSoldados());
        System.out.println("\nTurno: " + soldado1.getNombre() + " vs " + soldado2.getNombre());
        ejecutarAtaque(soldado1, soldado2);
        if (estaEliminado(soldado2)) {
            System.out.println(soldado2.getNombre() + " ha caído.");
            ejercito2.getSoldados().remove(soldado2);
            return;
        }
        ejecutarAtaque(soldado2, soldado1);
        if (estaEliminado(soldado1)) {
            System.out.println(soldado1.getNombre() + " ha caído.");
            ejercito1.getSoldados().remove(soldado1);
        }
    }
    private Soldado seleccionarSoldadoAleatorio(List<Soldado> soldados) {
        return soldados.get(random.nextInt(soldados.size()));
    }
    private void mostrarResumenFinal() {
        System.out.println("\n--- Resumen Final de la Batalla ---");
        String ganador = determinarGanador();
        calcularEstadisticas(ejercito1);
        calcularEstadisticas(ejercito2);
        System.out.println("\n¡La batalla ha terminado!");
        System.out.println("Ganador: " + ganador);
    }
    private String determinarGanador() {
        if (ejercito1.getSoldados().isEmpty() && ejercito2.getSoldados().isEmpty()) {
            return "Empate";
        } else if (ejercito1.getSoldados().isEmpty()) {
            return ejercito2.getNombre();
        } else {
            return ejercito1.getNombre();
        }
    }
    private void calcularEstadisticas(Ejercito ejercito) {
        List<Soldado> soldados = ejercito.getSoldados();
        if (soldados.isEmpty()) {
            System.out.println("\n" + ejercito.getNombre() + " no tiene soldados sobrevivientes.");
            return;
        }
        Soldado soldadoConMayorVida = soldados.stream()
                .max(Comparator.comparingInt(Soldado::getPuntosDeVida))
                .orElse(null);
        double promedioVida = soldados.stream()
                .mapToInt(Soldado::getPuntosDeVida)
                .average()
                .orElse(0);
        soldados.sort(Comparator.comparingInt(Soldado::getPuntosDeVida).reversed());
        System.out.println("\n--- Estadísticas de " + ejercito.getNombre() + " ---");
        System.out.println("Promedio de puntos de vida: " + promedioVida);
        System.out.println("Soldado con mayor vida: " + (soldadoConMayorVida != null ? soldadoConMayorVida : "N/A"));
        System.out.println("Ranking de soldados por nivel de vida:");
        soldados.forEach(System.out::println);
    }
}
