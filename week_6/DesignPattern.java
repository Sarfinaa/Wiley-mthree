package week_6;

interface MyWrapper {
    void printType();
}

class MyInteger implements MyWrapper {
    public void printType() {
        System.out.println("Integer");
    }
}

class MyDouble implements MyWrapper {
    public void printType() {
        System.out.println("Double");
    }
}

class MyCharacter implements MyWrapper {
    public void printType() {
        System.out.println("Character");
    }
}

class MyBoolean implements MyWrapper {
    public void printType() {
        System.out.println("Boolean");
    }
}

class MyWrapperFactory {
    private boolean checkInteger(String type) {
        return type.matches("^[+-]?[0-9]+");

    }

    private boolean checkCharacter(String type) {
        return type.matches("[a-zA-Z]");

    }

    private boolean checkDouble(String type) {
        return type.matches("^[+-]?[0-9]+.[0-9]+");

    }

    private boolean checkBoolean(String type) {
        return type.matches("true|false");

    }

    public MyWrapper createMyWrapper(String type) {
        MyWrapper wrapper = null;
        if (type == null || type.length() == 0)
            throw new IllegalArgumentException("String is empty!!!");
        if (checkCharacter(type))
            wrapper = new MyCharacter();
        else if (checkDouble(type))
            wrapper = new MyDouble();
        else if (checkBoolean(type))
            wrapper = new MyBoolean();
        else if (checkInteger(type))
            wrapper = new MyInteger();
        else
            throw new IllegalArgumentException("Invalid type");
        return wrapper;
    }
}

public class DesignPattern {
    public static void main(String[] args) {
        MyWrapperFactory myFactory = new MyWrapperFactory();
        try {
            myFactory.createMyWrapper("1").printType();
            myFactory.createMyWrapper("1.1").printType();
            myFactory.createMyWrapper("a").printType();
            myFactory.createMyWrapper("true").printType();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}