public class DataTypes {
    public static void main(String[] args) {
        System.out.println("            Default Values");
        int[] a = new int[1];
        System.out.println("int: " + a[0]);
        short[] b = new short[1];
        System.out.println("short: " + b[0]);
        byte[] c = new byte[1];
        System.out.println("byte: " + c[0]);
        long[] d = new long[1];
        System.out.println("long: " + d[0]);
        float[] e = new float[1];
        System.out.println("float: " + e[0]);
        double[] f = new double[1];
        System.out.println("double: " + f[0]);
        char[] g = new char[1];
        System.out.println("char: " + g[0]);
        boolean[] h = new boolean[1];
        System.out.println("boolean: " + h[0]);
        System.out.println("       After Variable Intialization");
        a[0] = 1;
        System.out.println("int: " + a[0]);
        b[0] = 1;
        System.out.println("short: " + b[0]);
        c[0] = 1;
        System.out.println("byte: " + c[0]);
        d[0] = 1;
        System.out.println("long: " + d[0]);
        e[0] = 1;
        System.out.println("float: " + e[0]);
        f[0] = 1;
        System.out.println("double: " + f[0]);
        g[0] = 'c';
        System.out.println("char: " + g[0]);
        h[0] = true;
        System.out.println("boolean: " + h[0]);
    }
}