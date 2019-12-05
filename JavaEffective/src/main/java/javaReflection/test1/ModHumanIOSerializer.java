package javaReflection.test1;

import java.io.InputStream;
import java.io.OutputStream;

public class ModHumanIOSerializer {

    /**
     *
     * 取得属性值
     * @param classInstance 实例
     */
    public static void write(OutputStream out, ModHuman classInstance) {
        System.out.println("ModHumanSerilizer.write(OutputStream out, ModHuman classInstance)");
    }

    /**
     *
     * 设置属性值
     * @param classInstance 实例
     *
     */
    public static void read(InputStream in, ModHuman classInstance) {
        System.out.println("ModHumanSerilizer.read(InputStream in, ModHuman classInstance)");
    }

}
