class Billetera:

    def __init__(self, titular, cuenta):
        self._titular = titular
        self._cuenta = cuenta
        self._saldo = 0

    def depositar(self, monto):
        self._saldo += monto

    def pagar(self, dest, monto):
        self._saldo -= monto
        dest.depositar(monto)

    def __eq__(self, other):
        if other is None:
            return False
        if isinstance(other, Billetera):
            return self._saldo==other._saldo
        return False

    def __str__(self):
        return f"Billetera: titular={self._titular}, cuenta={self._cuenta}, saldo={self._saldo}"

if __name__ == "__main__":
    b1 = Billetera("Juanito", "123-123")
    b2 = Billetera("Anita", "453-234")
    assert(b1==b2)
    assert(b1._saldo == 0)
    b1.depositar(1000)
    assert(b1._saldo == 1000)
    b1.pagar(b2, 700)
    assert(b1._saldo == 300)
    assert(b2._saldo == 700)
    assert(b1!=b2)

    print(b1)
    print(b2)