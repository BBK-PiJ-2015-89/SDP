package j.singleton;

public interface Database {
    public String get(String key);
    public String set(String key, String value);
}
