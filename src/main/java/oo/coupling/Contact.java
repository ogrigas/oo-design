package oo.coupling;

public class Contact {
    public enum Type {
        EMAIL, PHONE, POST
    }

    private final Type type;
    private final String details;

    public Contact(Type type, String details) {
        this.type = type;
        this.details = details;
    }

    public Type getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }
}
