import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private List<Object> items;

    public Bag() {
        items = new ArrayList<>();
        items.add(null);
        items.add(3);
        items.add(null);
        items.add(3);
        items.add(3);
        items.add(null);
    }

    public Object removeItem() throws Exception {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null) {
                Object x = items.get(i);
                items.set(i, null);
                return x;
            }
        }
        throw new Exception("La bolsa esta vacia");
    }

    public Object removeRandom() throws Exception {
        Random rand = new Random();
        int pos = rand.nextInt(items.size());
        int n = (int)items.stream().filter(item -> item == null).count();
        if (n == items.size()) {
            throw new Exception("Bolsa vacia");
        }
        while (items.get(pos) == null) {
            pos++;
            if (pos == items.size()) {
                pos = 0;
            }
        }
        Object t = items.get(pos);
        items.set(pos, null);
        return t;
    }

    public int size() {
        return items.size() - (int)items.stream().filter(item -> item == null).count();
    }

    public void add(Object item) throws Exception {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == null) {
                items.set(i, item);
                return;
            }
        }
        throw new Exception("La bolsa esta llena");
    }

    public static void main(String[] args) throws Exception {
        Bag b = new Bag();

        int ant = b.size();
        b.add("Hola");
        int pos = b.size();
        assert(b.items.contains("Hola"));
        assert(pos - ant == 1);

        b.add("Hola");
        b.add("Hola");
        b.add("Hola");
    }
}
