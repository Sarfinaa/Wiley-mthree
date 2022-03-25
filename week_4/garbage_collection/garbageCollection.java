package week_4.garbage_collection;

public class garbageCollection {
    int a;

    garbageCollection(int a) {
        this.a = a;
    }

    public void finalize() throws Throwable {
        System.out.println("Collector is Evoked!!!");
    }

    public static void main(String[] args) {
        garbageCollection g = new garbageCollection(1);
        garbageCollection g1 = new garbageCollection(2);

        g = null;
        g1 = null;
        System.gc();
    }
}
// Island of isolation (Exception- memory leakage)