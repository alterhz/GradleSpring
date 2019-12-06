package javaReflection.test1;

import java.io.InputStream;
import java.io.OutputStream;

public class ModGameIOSerializer {

    static int writeCount = 0;
    static int readCount = 0;
    /**
     *
     * 取得属性值
     * @param classInstance 实例
     */
    public static void write(OutputStream out, ModGame classInstance) {
        writeCount++;
        //System.out.println("ModHumanSerilizer.write(OutputStream out, ModHuman classInstance)");
    }

    /**
     *
     * 设置属性值
     * @param classInstance 实例
     *
     */
    public static void read(InputStream in, ModGame classInstance) {
        readCount++;
        //System.out.println("ModHumanSerilizer.read(InputStream in, ModHuman classInstance)");
    }

    public static void printDebug() {
        System.out.println("writeCount:" + writeCount + ",readCount:" + readCount);
    }

}
