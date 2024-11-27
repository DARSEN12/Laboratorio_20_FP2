import java.util.Scanner;

public class JuegoDeBatalla {
    private final Ejercito ejercito1;
    private final Ejercito ejercito2;
    private final Tablero tablero;
    private final Scanner scanner;

    public JuegoDeBatalla(Tablero tablero, Ejercito ejercito1, Ejercito ejercito2) {
        this.tablero = tablero;
        this.ejercito1 = ejercito1;
        this.ejercito2 = ejercito2;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("¡Bienvenidos al juego de batalla!");
        System.out.println("Ejército 1:");
        ejercito1.getSoldados().forEach(System.out::println);
        System.out.println("\nEjército 2:");
        ejercito2.getSoldados().forEach(System.out::println);

        boolean juegoActivo = true;
        boolean turnoJugador1 = true;

        while (juegoActivo) {
            tablero.mostrarTablero();
            System.out.println("\nEs el turno del jugador " + (turnoJugador1 ? "1" : "2"));

            Ejercito ejercitoActual = turnoJugador1 ? ejercito1 : ejercito2;
            Ejercito ejercitoOponente = turnoJugador1 ? ejercito2 : ejercito1;

            System.out.println("\nSoldados disponibles:");
            for (int i = 0; i < ejercitoActual.getSoldados().size(); i++) {
                System.out.println((i + 1) + ". " + ejercitoActual.getSoldados().get(i));
            }

            System.out.print("Selecciona el soldado a mover (número): ");
            int seleccion = scanner.nextInt() - 1;

            if (seleccion < 0 || seleccion >= ejercitoActual.getSoldados().size()) {
                System.out.println("Selección inválida. Pierdes tu turno.");
                turnoJugador1 = !turnoJugador1;
                continue;
            }

            Soldado soldadoSeleccionado = ejercitoActual.getSoldados().get(seleccion);

            System.out.print("Ingresa la nueva fila: ");
            int nuevaFila = scanner.nextInt();
            System.out.print("Ingresa la nueva columna: ");
            int nuevaColumna = scanner.nextInt();

            if (tablero.esMovimientoValido(soldadoSeleccionado, nuevaFila, nuevaColumna)) {
                Soldado oponente = tablero.obtenerSoldadoEnPosicion(nuevaFila, nuevaColumna);

                if (oponente != null) {
                    if (soldadoSeleccionado.getNumEjercito() != oponente.getNumEjercito()){
                        System.out.println("¡Batalla entre " + soldadoSeleccionado.getNombre() + " y " + oponente.getNombre() + "!");
                        Soldado ganador = Batalla.enfrentar(soldadoSeleccionado, oponente);

                        if (ganador == soldadoSeleccionado) {
                            tablero.limpiarPosicion(oponente.fila, oponente.columna);
                            ejercitoOponente.getSoldados().remove(oponente);
                        } else {
                            tablero.limpiarPosicion(soldadoSeleccionado.fila, soldadoSeleccionado.columna);
                            ejercitoActual.getSoldados().remove(soldadoSeleccionado);
                        }
                    } else
                        System.out.println("No se puede enfrentar a un soldado del mismo equipo");
                } else {
                    tablero.moverSoldado(soldadoSeleccionado, nuevaFila, nuevaColumna);
                }
            } else {
                System.out.println("Movimiento inválido. Pierdes tu turno.");
            }

            if (ejercito1.getSoldados().isEmpty()) {
                System.out.println("\n¡El jugador 2 ha ganado la batalla!");
                juegoActivo = false;
            } else if (ejercito2.getSoldados().isEmpty()) {
                System.out.println("\n¡El jugador 1 ha ganado la batalla!");
                juegoActivo = false;
            } else {
                turnoJugador1 = !turnoJugador1;
            }
        }

        System.out.println("Juego terminado.");
    }
}
