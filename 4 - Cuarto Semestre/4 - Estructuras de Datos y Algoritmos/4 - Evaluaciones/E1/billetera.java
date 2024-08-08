public class Billetera {
    private String titular; // Dueño de la cuenta
    private String cuenta; // #Cuenta
    private int saldo; // Dinero

    public Billetera(String titular, String cuenta) {
        this.titular = titular;
        this.cuenta = cuenta;
        this.saldo = 0;
    }

    public void depositar(int monto) { // Método para agregar dinero a la cuenta
        saldo += monto;
    }

    public void pagar(Billetera dest, int monto) { // Método para transferencias
        saldo -= monto;
        dest.depositar(monto);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Billetera other = (Billetera) obj;
        return saldo == other.saldo;
    } 

    @Override
    public String toString() {
        return "Billetera: titular=" + titular + ", cuenta=" + cuenta + ", saldo=" + saldo;
    }

    public static void main(String[] args) {
        Billetera b1 = new Billetera("Juanito", "123-123");
        Billetera b2 = new Billetera("Anita", "453-234");
        assert b1.equals(b2); 
        assert b1.saldo == 0;
       
        b1.depositar(1000);
        //assert b1.saldo == 1000;
        b1.pagar(b2, 700);
       
        //assert b1.saldo == 300;
        //assert b2.saldo == 700;
        //assert !b1.equals(b2);

        System.out.println("-------------------------------------------");
        System.out.println(b1);
        System.out.println("-------------------------------------------");
        System.out.println(b2);
        System.out.println("-------------------------------------------");
    }
}
