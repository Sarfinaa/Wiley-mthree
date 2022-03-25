package week_6;

class MyNumber {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyNumber [value=" + value + "]";
    }

}

class Request {
    private MyNumber number;

    Request(MyNumber number) {
        this.number = number;
    }

    public MyNumber getNumber() {
        return this.number;
    }
}

abstract class Handler {
    protected Handler nextHandler;

    Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Request request) throws NumberFormatException {
        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

}

class NegativeNumberHandler extends Handler {
    NegativeNumberHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) throws NumberFormatException {
        if (request.getNumber().getValue().matches("^-[1-9][0-9]*")) {
            System.out.println("Negative  Number");
        } else {
            System.out.println("2");

            super.handle(request);
        }
    }
}

class PositiveNumberHandler extends Handler {
    PositiveNumberHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) throws NumberFormatException {
        if (request.getNumber().getValue().matches("^[+]?[1-9][0-9]*")) {
            System.out.println("Positive  Number");
        } else {
            System.out.println("4");
            super.handle(request);
        }
    }
}

class ZeroNumberHandler extends Handler {
    ZeroNumberHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) throws NumberFormatException {
        if (request.getNumber().getValue().equals("0")) {
            System.out.println("Zero Number");
        } else {
            System.out.println("3");

            super.handle(request);
        }
    }
}

class NotAnIntegerHandler extends Handler {
    NotAnIntegerHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) throws NumberFormatException {
        if (!request.getNumber().getValue().matches("^[+-]?[0-9]+")) {
            throw new NumberFormatException("Not a number");

        } else {
            System.out.println("1");

            super.handle(request);
        }
    }
}

class Chain {
    Handler firstHandler;

    Chain() {
        buildChain();
    }

    private void buildChain() {
        this.firstHandler = new NotAnIntegerHandler(
                new NegativeNumberHandler(new PositiveNumberHandler(new ZeroNumberHandler(null))));
    }

    public void initiateChain(Request request) throws NumberFormatException {
        firstHandler.handle(request);
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        MyNumber number = new MyNumber();
        number.setValue("-1");
        try {
            Request request = new Request(number);
            Chain carBuildingChain = new Chain();
            carBuildingChain.initiateChain(request);
            System.out.println(request.getNumber());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
