import random

class Bag:

    def __init__(self):
        self.items = [ None, 3, None, 3, 3, None ]

    def removeItem(self):
        for i in range(len(self.items)):
            if self.items[i] is not None:
                x = self.items[i]
                self.items[i] = None
                return x
        raise Exception("La bolsa esta vacia")

    def removeRandom(self):
        pos = random.randint(0,len(self.items))
        n = self.items.count(None)
        if n==len(self.items):
            raise Exception("Bolsa vacia")
        while self.items[pos]==None:
            pos += 1
            if pos==len(self.items):
                pos = 0
        t = self.items[pos]
        self.items[pos]=None
        return t

    def size(self):
        return len(self.items)-self.items.count(None)
    
    def add(self, item):
        for i in range(len( self.items)):
            if self.items[i] is None:
                self.items[i] = item
                return
        raise Exception("La bolsa esta llena")


if __name__ == "__main__":
    b = Bag()

    ant = b.size()
    b.add("Hola")
    pos = b.size()
    assert( "Hola" in b.items )
    assert( pos-ant == 1 )

    b.add("Hola")
    b.add("Hola")
    b.add("Hola")