package javaReflection.test1;

import java.io.InputStream;
import java.io.OutputStream;

public class ModGame extends ModBase {
    @Override
    public void writeTo(OutputStream outputStream) {
        ModGameIOSerializer.write(outputStream, this);
    }

    @Override
    public void readFrom(InputStream inputStream) {
        ModGameIOSerializer.read(inputStream, this);
    }
}
