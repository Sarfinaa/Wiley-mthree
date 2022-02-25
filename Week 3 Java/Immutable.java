class Immutable1 {
    private final int data;

    Immutable1(int data) {
        this.data = data;
    }

    public final Immutable1 setData(int data) {
        return new Immutable1(data);
    }

    public int getData() {
        return data;
    }
}

public class Immutable {
    public static void main(String[] args) {
        Immutable1 a = new Immutable1(4);
        System.out.println("Hash Code before change:" + a.hashCode());
        a = a.setData(40);
        System.out.println("Hash Code after change:" + a.hashCode());

    }
}
