package javaReflection.test1;

public class Main {

    static ModBase modHuman = new ModHuman();
    static ModBase modGame = new ModGame();

    public static void main(String[] args) {
        // 预热
        System.out.println("before");
        test();

        // 比较测试
        System.out.println("test");
        test();
    }

    static void test() {
        long startTime = System.nanoTime();
        long startTime1 = System.currentTimeMillis();
        int i=0;
        for (; i<1000000; ++i) {
            modHuman.writeTo(null);
            modHuman.readFrom(null);
        }

        long humanTime = System.nanoTime();
        long humanTime1 = System.currentTimeMillis();

        int j = 0;
        for (; j<1000000; ++j) {
            modGame.writeTo(null);
            modGame.readFrom(null);
        }

        long gameTime = System.nanoTime();
        long gameTime1 = System.currentTimeMillis();

        ModHumanIOSerializer.printDebug();
        ModGameIOSerializer.printDebug();

        System.out.println("i:" + i);
        System.out.println("j:" + j);

        System.out.println("humanTime nano:" + (humanTime - startTime));
        System.out.println(" gameTime nano:" + (gameTime - humanTime));

        System.out.println("humanTime:" + (humanTime1 - startTime1));
        System.out.println(" gameTime:" + (gameTime1 - humanTime1));
    }
}
