package rmugattarov.operators;

import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class DivisionVsModulo {
    public static void main(String[] args) {
        Random r = new Random();

//        IntStream.range(0, 100_000_000).parallel().forEach(i->{double val=r.nextInt()/r.nextInt();});
        IntStream.range(0, 100_000_000).forEach(i->{double val=r.nextInt()/r.nextInt();});

//        System.out.println("Division took : " + (divisionEnd.getTime() - divisionStart.getTime()));
//        System.out.println("Modulo took : " + (moduloEnd.getTime() - moduloStart.getTime()));
    }
}
