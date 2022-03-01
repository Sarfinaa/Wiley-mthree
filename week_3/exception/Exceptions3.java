package week_3.exception;

class PhoneNumber {
    String countryCode;
    String phNo;

    PhoneNumber(String countryCode, String phNo) {
        this.countryCode = countryCode;
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return countryCode + "-" + phNo;
    }
}

class IndianPhoneNumber extends PhoneNumber {
    IndianPhoneNumber(String phNo) {
        super("+91", phNo);
    }
}

class Triplet {
    boolean a;
    boolean dot;
    boolean space;

    Triplet() {
    }

    Triplet(boolean a, boolean dot, boolean space) {
        this.a = a;
        this.dot = dot;
        this.space = space;
    }
}

class Pair {
    boolean len;
    boolean containDigit;

    Pair() {
    };

    Pair(boolean len, boolean containDigit) {
        this.len = len;
        this.containDigit = containDigit;
    }
}

class DigPair {
    boolean len;
    boolean onlyDigit = true;

    DigPair() {
    }

    DigPair(boolean len, boolean onlyDigit) {
        this.len = len;
        this.onlyDigit = onlyDigit;
    }
}

class Info {
    private String email;
    private String password;
    String firstName;
    String lastName;
    IndianPhoneNumber phoneNumbers;

    @Override
    public String toString() {
        return "Info [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
                + ", phoneNumbers=" + phoneNumbers + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public IndianPhoneNumber getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(IndianPhoneNumber phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    Info(String email, String password, String firstName, String lastName, IndianPhoneNumber phoneNumbers) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }

    public DigPair checkPhone(IndianPhoneNumber phoneNo) {
        String phone = phoneNo.phNo;
        DigPair pair = new DigPair();
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                pair.onlyDigit = false;
                break;
            }
        }
        pair.len = phone.length() == 10;
        return pair;

    }

    public Pair checkPass(String pass) {
        Pair pair = new Pair();
        int digc = 0;
        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isDigit(c)) {
                digc++;
                break;
            }
        }
        pair.len = (pass.length() >= 8 && pass.length() <= 16);
        pair.containDigit = digc == 1;
        return pair;
    }

    public Triplet checkEmail(String email) {
        Triplet triplet = new Triplet();
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c == '.')
                triplet.dot = true;
            else if (c == '@')
                triplet.a = true;
            else if (c == ' ')
                triplet.space = true;

        }
        return triplet;

    }

    public boolean containAlpha(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)))
                return false;
        }
        return true;
    }

    public void validation() {
        if (!containAlpha(firstName)) {
            throw new IllegalArgumentException("Firstname does not contain only Alphabets ");
        } else if (!containAlpha(lastName)) {
            throw new IllegalArgumentException("LastName does not contain only Alphabets ");

        }
        if (!checkPass(password).len) {
            throw new IllegalArgumentException("password length is less than 8 or greater than 16");

        } else if (!checkPass(password).containDigit) {
            throw new IllegalArgumentException("password does not contain digits");
        }
        if (!checkEmail(email).a) {
            throw new IllegalArgumentException("Email does not contain @");

        } else if (!checkEmail(email).dot)
            throw new IllegalArgumentException("Email does not dot");
        else if (checkEmail(email).space) {
            throw new IllegalArgumentException("Email contains space");

        }
        if (!checkPhone(phoneNumbers).onlyDigit) {
            throw new IllegalArgumentException("Phone number contains letters other than digit");

        } else if (!checkPhone(phoneNumbers).len) {
            throw new IllegalArgumentException("Phone number contains digit greater than 10");

        }
    }
}

public class Exceptions3 {
    public static void main(String[] args) {
        IndianPhoneNumber phoneNumbers = new IndianPhoneNumber("9878656789");
        Info info = new Info("hello@gmail.com", "abc1", "karan", "seth", phoneNumbers);
        Info info1 = new Info("hello@gmail.com", "abcdefgh1", "karan", "seth", phoneNumbers);

        try {
            info.validation();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println(info1);
    }

}