import java.util.List;
// ARREGLAR
public class Ingrediente {
    private String nombre;
    private double peso;
    private double calorias;

    public Ingrediente(String nombre, double peso, double calorias) {
        this.nombre = nombre;
        this.peso = peso;
        this.calorias = calorias;
    }

    public double getPeso() {
        return peso;
    }

    public double getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {
        return "Ingrediente: " + nombre + ", peso=" + peso + ", calorias=" + calorias;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ingrediente other = (Ingrediente) obj;
        return nombre.equals(other.nombre) && peso == other.peso;
    }
}

public class Producto {
    private String nombre;
    private List<Ingrediente> ingredientes;

    public Producto(String nombre, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public double getPeso() {
        double total = 0;
        for (Ingrediente i : ingredientes) {
            total += i.getPeso();
        }
        return total;
    }

    public double getCalorias() {
        double total = 0;
        for (Ingrediente i : ingredientes) {
            total += i.getCalorias();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Producto: ").append(nombre).append(", Ingredientes:\n");
        for (Ingrediente i : ingredientes) {
            s.append(i.toString()).append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Producto other = (Producto) obj;
        return ingredientes.equals(other.ingredientes);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio ADT Producto");

        Producto galletas = new Producto("Galletas", List.of(
            new Ingrediente("harina", 20, 10),
            new Ingrediente("azucar", 30, 20),
            new Ingrediente("huevos", 25, 40)
        ));
        assert galletas.getPeso() == 75;
        assert galletas.getCalorias() == 70;

        Producto p1 = new Producto("Galletas", List.of(
            new Ingrediente("harina", 20, 10),
            new Ingrediente("azucar", 30, 20),
            new Ingrediente("huevos", 25, 40)
        ));
        Producto p2 = new Producto("Galletas", List.of(
            new Ingrediente("harina", 10, 10),
            new Ingrediente("huevos", 25, 40)
        ));

        assert galletas.equals(p1);
        assert !p1.equals(p2);

        System.out.println(galletas);
    }
}
