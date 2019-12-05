package javaReflection.test1;

public class Main {
    public static void main(String[] args) {
        ModBase modBase = new ModHuman();
        //modBase.start();

        modBase.writeTo(null);
        modBase.readFrom(null);
    }
}
