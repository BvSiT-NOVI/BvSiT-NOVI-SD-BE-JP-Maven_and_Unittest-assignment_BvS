package nl.novi.javaprogrammeren;

import java.text.NumberFormat;
import java.util.Locale;

public class BadMoney {

    public static void main(String[] args) {
        //https://stackoverflow.com/questions/3730019/why-not-use-double-or-float-to-represent-currency

        double x1 = 0.3;
        double x2 = 0.1 + 0.1 + 0.1;
        System.out.println(x1 == x2);

        x1 = 1.0;
        x2 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 +0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        x2 = 10 * 0.1;
        System.out.println(x1 == x2);


        System.out.println(0.33333334326744080000f * 3.0f);
        //0,33333334326744080000

        float y = 1.0E00f;

        float x = 1f/3;

        System.out.println("1f/3 ="+ String.format("%.20f", x)); //0,33333334326744080000
        System.out.println("3 * (1f/3) ="+ String.format("%.20f",3 * x));//Toch 1,00000000000000000000 ?? //int i * float f => float(i) * f
        System.out.println("3d * (1f/3) ="+ String.format("%.20f",3d * x));//1,00000002980232240000 ?? //double d * float f => d  * (double) f
        System.out.println("3.0 * (1f/3) ="+ String.format("%.20f",3.0 * x)); //1,00000002980232240000 // 3.0 is default type double

        //Hoe kan dit? Literal zou default een double worden, dus preciezer zou je zeggen?
        x=100000/3;
        System.out.println( String.format("%.20f",  x) ); //33333,00000000000000000000
        x=100000f/3;//Implicit casting: float forces 3 also to be cast to float
        System.out.println( String.format("%.20f", x) ); //33333,33203125000000000000

        //Antwoord: Nee, bij 100000/3 wordt er geen cast naar double uitgevoerd want deling bestaat alleen uit integers.
        //De cast naar float vindt pas plaats na de integer deling.
        x=100000/3; //int division throwing away reminder 1. So this would be equivalent to x=99999/3
        System.out.println( String.format("%.20f",  x) ); //33333,00000000000000000000
        x=100000f/3;//Implicit casting: float forces 3 also to be cast to float
        System.out.println( String.format("%.20f", x) ); //33333,33203125000000000000

        // Example 1
        float originalPrice = 400000.00f;
        // to make the price more attractive, we'll reduce it to $399999.95
        float reducedPrice = originalPrice - 0.05f;
        System.out.println( String.format("discount 0.05: %.20f", 0.05f) );
        System.out.println( String.format("reducedPrice: %.20f", reducedPrice) );
        float discount = originalPrice - reducedPrice;
        System.out.println( String.format("discount: %.20f", discount) );
        // Display discount amount
        System.out.println("De korting is: " + discount);

        // Example 2
        // The amount you have in the bank: $12,345,678.12
        float moneyInBank = 12345678.12f;
        int count;    // count number of iterations
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.GERMANY);  // for output formatting.

        // Display the original amount
        System.out.println( "Originele aantal geld in de bank: "
                + fmt.format(moneyInBank) + ".");

        System.out.println( String.format("moneyInBank: %.20f", moneyInBank) );
        System.out.println( String.format("moneyInBank: %.20f", moneyInBank + .10f) );


        // Add a dime to the principal a thousand times
        for (count = 1; count <= 1000; count = count + 1) {
            moneyInBank = moneyInBank + .10f;
            if (count % 100==0){
                //System.out.println( String.format("moneyInBank: %.20f", moneyInBank) );
            }
        }

        // The result should be 100 dollars larger.
        System.out.println( "Het nieuwe aantal geld in de bank: "
                + fmt.format(moneyInBank) + ".");

        // Example 3
        double floatNumber = 4.35;
        int integerNumber = (int) (100 * floatNumber);
        System.out.println("Uitkomst van de berekening: " + integerNumber);

    }
}
