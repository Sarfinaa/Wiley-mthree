class Parent {
    String firstname;
    final String lastname;

    Parent() {
        this.firstname = "Karan";
        this.lastname = "Seth";
    }

    Parent(String firstname) {
        this();
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return String.format("Firstname: %s %nLastname: %s", this.firstname, this.lastname);
    }
}

class Child extends Parent {
    Child() {
        super();
    }

    Child(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        System.out.println("CHILD OBJECT::");
        return super.toString();
    }
}

public class Overriiding {
    public static void main(String[] args) {
        Parent parent = new Parent("Karan");
        Child child = new Child("ABC");
        System.out.println(parent);
        System.out.println(child);

    }
}