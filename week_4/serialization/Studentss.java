package week_4.serialization;

import java.io.Serializable;

public class Studentss implements Serializable {
    // The default serialVersionUID. Else a generated one would have been inserted.
    private static final long serialVersionUID = 1L;
    int rollNumber;
    String name;

    public Studentss(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }
}