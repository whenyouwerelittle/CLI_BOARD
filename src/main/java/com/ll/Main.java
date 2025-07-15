package com.ll;

public class Main {
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
    }
}

/*
package com.ll;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App().run();
        // new App(sc).run(); // container 사용전
        Container.close();
    }
}*/
