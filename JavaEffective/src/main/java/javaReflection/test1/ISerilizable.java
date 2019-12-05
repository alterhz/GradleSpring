package javaReflection.test1;

import java.io.InputStream;
import java.io.OutputStream;

public interface ISerilizable {
    void writeTo(OutputStream out);

    void readFrom(InputStream in);
}
