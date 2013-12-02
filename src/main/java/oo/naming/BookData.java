package oo.naming;

public class BookData {

    /** ISBN */
    public String _id;
    public String _name;
    public int _year;

    public BookData(String id, String name, int year) {
        this._id = id;
        this._name = name;
        this._year = year;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getYear() {
        return _year;
    }
}
