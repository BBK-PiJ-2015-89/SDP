package j.singleton;

import java.util.HashMap;
import java.util.Map;

public class MyDatabase implements Database {
    private Map<String, String> db;

    private MyDatabase() {
        db = new HashMap<>();
    }

    @Override
    public String get(String key) {
        return db.get(key);
    }

    @Override
    public String set(String key, String value) {
        db.put(key, value);
        return value;
    }

    //// Static methods below ////

    // In Java, we use private static variables to hold a single
    // instance of an object. We then use the getInstance static
    // method to retrieve the instance of the object.

    // Reference to singleton object. The reference is initially
    // null. We lazily construct the singleton instance when requested.
    private static MyDatabase instance = null;

    // getInstance lazily constructs the singleton instance when
    // invoked. If the instance already exists, we return the
    // same instance.
    public static MyDatabase getInstance() {
        if (instance == null) {
            instance = new MyDatabase();
        }
        return instance;
    }
}
