package prim;

import java.util.Random;

/**
 * Erstellt von  sebsch on 20.01.17.
 */
public class Primchecker {

    private Random r;
    private Integer maxInt;


    public Primchecker() {
        System.out.println("[Info] Primchecker initialisiert.");
        r = new Random();
        maxInt = 200000000;
    }


    public Boolean isPrim(int n) {

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public Integer getRandomPrim() {
        Integer n;

        do {
            n = r.nextInt(this.maxInt + 1) ;
        } while (!this.isPrim(n));

        System.out.println(n.toString() + " ist Prim! \n\tBeende. ");
        return n;
    }
}
