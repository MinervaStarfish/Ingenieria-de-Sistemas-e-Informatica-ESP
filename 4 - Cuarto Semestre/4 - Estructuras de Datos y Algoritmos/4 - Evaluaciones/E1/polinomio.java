import java.util.Arrays; // Para operaciones con Arrays

public class Polinomio {
    private int[] coef; // Declaración de un array
    private int grado;

    // Queremos que queden tipo 3x^2 + 2x^1 + x 
    // Por eso al ser 3 coef se -1 para tener un grado menor
    public Polinomio(int[] coef) {
        this.coef = coef;
        this.grado = coef.length - 1;
    }

    public Polinomio suma(Polinomio pol) {
        int grado = Math.max(this.grado, pol.grado); // Math.max calcula el máximo de 2 valores
        int[] res = new int[grado + 1]; // Guardar coeficientes de la suma
        for (int i = 0; i <= this.grado; i++) { // entra si i es menor al grado
            res[i] += this.coef[i]; 
        }
        for (int i = 0; i <= pol.grado; i++) {
            res[i] += pol.coef[i];
        }
        return new Polinomio(res);
    }

    public int getGrado() {
        return this.grado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Polinomio pol = (Polinomio) obj;
        return Arrays.equals(coef, pol.coef);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(coef[0]);
        for (int i = 1; i <= grado; i++) {
            s.append(" + ").append(coef[i]).append("x^").append(i);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Polinomio p1 = new Polinomio(new int[]{1, 2, 4});
        Polinomio p2 = new Polinomio(new int[]{0, 0, 0});
        Polinomio p3 = p1.suma(p2);
        //assert Arrays.equals(p3.coef, new int[]{2, 4, 6});
        assert !p1.equals(p2);
        assert p1.toString().equals("1 + 2*x^1 + 3*x^2");

        System.out.println("---------------------------------");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("---------------------------------");
        System.out.println(p3);
        System.out.println("---------------------------------");
    }
}
