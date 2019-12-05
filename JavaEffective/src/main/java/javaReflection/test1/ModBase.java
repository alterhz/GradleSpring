package javaReflection.test1;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModBase implements ISerilizable {

    private Class ioSerializerClass = null;

    private Method writeTo = null;

    private Method readFrom = null;

    public ModBase() {
        Class thisClass = this.getClass();

        String thisClassName = thisClass.getName();

        String ioSerializerClassName = thisClassName + "IOSerializer";

        //System.out.println("ioSerializerClassName:" + ioSerializerClassName);

        try {
            ioSerializerClass = Class.forName(ioSerializerClassName);

            writeTo = ioSerializerClass.getDeclaredMethod("write", OutputStream.class, thisClass);
            readFrom = ioSerializerClass.getDeclaredMethod("read", InputStream.class, thisClass);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeTo(OutputStream outputStream) {
        try {
            writeTo.invoke(ioSerializerClass, outputStream, this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFrom(InputStream inputStream) {
        try {
            readFrom.invoke(ioSerializerClass, inputStream, this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    void start() {
        {
            String superClassName = this.getClass().getGenericSuperclass().getTypeName();

            System.out.println("GenericSuperclass:" + superClassName);
        }

        {
            String thisClassName = this.getClass().getName();

            System.out.println("thisClassName:" + thisClassName);

            String ioClassName = thisClassName + "Serilizer";
        }
    }
}
