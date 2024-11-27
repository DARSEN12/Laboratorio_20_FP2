import java.util.*;

public class Ejercito {
    private String nombre;
    private List<Soldado> soldados;
    private static Random random = new Random();

    public Ejercito(String nombre) {
        this.nombre = nombre;
        this.soldados = new ArrayList<>();
    }

    public void generarSoldados(Set<String> posicionesOcupadas, int filasTablero, int columnasTablero) {
        int numeroDeSoldados = random.nextInt(10) + 1; // Entre 1 y 10 soldados

        for (int i = 0; i < numeroDeSoldados; i++) {
            String tipoSoldado = elegirTipoSoldado();
            String nombreSoldado = tipoSoldado + "_" + nombre + "_" + i;
            int fila, columna;

            do {
                fila = random.nextInt(filasTablero);
                columna = random.nextInt(columnasTablero);
            } while (posicionesOcupadas.contains(fila + "," + columna));

            posicionesOcupadas.add(fila + "," + columna);

            Soldado soldado = crearSoldado(tipoSoldado, nombreSoldado, fila, columna);
            soldados.add(soldado);
        }
    }

    private String elegirTipoSoldado() {
        String[] tipos = {"Arquero", "Caballero", "Espadachin", "Lancero"};
        return tipos[random.nextInt(tipos.length)];
    }

    private Soldado crearSoldado(String tipo, String nombre, int fila, int columna) {
        switch (tipo) {
            case "Arquero":
                int flechas = random.nextInt(10) + 1; // Entre 1 y 10 flechas
                return new Arquero(nombre, random.nextInt(3) + 1, fila, columna, flechas);
            case "Caballero":
                return new Caballero(nombre, random.nextInt(3) + 3, fila, columna);
            case "Espadachin":
                int longitudEspada = random.nextInt(5) + 1; // Entre 1 y 5
                return new Espadachin(nombre, random.nextInt(2) + 3, fila, columna, longitudEspada);
            case "Lancero":
                int longitudLanza = random.nextInt(4) + 1; // Entre 1 y 4
                return new Lancero(nombre, random.nextInt(2) + 1, fila, columna, longitudLanza);
            default:
                throw new IllegalArgumentException("Tipo de soldado no válido: " + tipo);
        }
    }

    public void imprimirEjercito() {
        System.out.println("\n" + nombre);
        for (Soldado soldado : soldados) {
            System.out.println(soldado);
        }
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }
}
