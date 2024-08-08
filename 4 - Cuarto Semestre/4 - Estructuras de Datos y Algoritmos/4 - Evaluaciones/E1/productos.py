class Ingrediente:

    def __init__(self, nombre:str, peso:float, calorias:float):
        self._nombre = nombre
        self._peso = peso
        self._calorias = calorias

    def __str__(self):
        return f"Ingrediente: {self._nombre}, peso={self._peso}, calorias={self._calorias}"
    
    def __eq__(self, other):
        if other is None:
            return False
        if isinstance(other, Ingrediente):
            return self._nombre==other._nombre and self._peso==other._peso
        return False


class Producto:

    def __init__(self, nombre:str, ingredientes:list[Ingrediente]):
        self._nombre = nombre
        self._ingredientes = ingredientes

    def getPeso(self) -> float:
        total = 0
        for i in self._ingredientes:
            total += i._peso
        return total

    def getCalorias(self) -> float:
        total = 0
        for i in self._ingredientes:
            total += i._calorias
        return total

    def __eq__(self, other):
        if other is None:
            return False
        if isinstance(other, Producto):
            return self._ingredientes == other._ingredientes
        return False

    def __str__(self):
        s = f"Producto: {self._nombre}, Ingredientes:\n"
        s += "\n".join([ str(i) for i in self._ingredientes])
        return s


if __name__ == "__main__":
    print("Ejercicio ADT Producto")

    galletas = Producto("Galletas", [
       Ingrediente("harina", 20, 10),
       Ingrediente("azucar", 30, 20),
       Ingrediente("huevos", 25, 40),
    ])
    assert( galletas.getPeso() == 75 )
    assert( galletas.getCalorias() == 70 )

    p1 = Producto("Galletas", [
       Ingrediente("harina", 20, 10),
       Ingrediente("azucar", 30, 20),
       Ingrediente("huevos", 25, 40),
    ])
    p2 = Producto("Galletas", [
       Ingrediente("harina", 10, 10),
       Ingrediente("huevos", 25, 40),
    ])

    assert( galletas == p1 )
    assert( p1 != p2 )

    print(galletas)