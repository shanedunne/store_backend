package utils;

/**
 * An interface that declares some methods which will be implemented in classes that implement this interface.
 */
public interface ISerializer {
    void save() throws Exception;
    void load() throws Exception;
    String fileName();
}
