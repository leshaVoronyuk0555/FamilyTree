import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void writeObject(Serializable obj,String filePath) throws IOException;
    Object readObject(String filePath);
}
