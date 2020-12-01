package nl.novi.javaprogrammeren;

import java.text.NumberFormat;
import java.util.Locale;

public class BadMoney {

    public static void main(String[] args) {
        //https://stackoverflow.com/questions/3730019/why-not-use-double-or-float-to-represent-currency
        float x = 1f/3;
        System.out.println("1/3 ="+ String.format("%.10f", x)); //0,3333333433
        System.out.println("3 * (1f/3) ="+ String.format("%.10f",3 * x));//Toch 1,0000000000 ??

        //Hoe kan dit? Literal zou default een double worden, dus preciezer zou je zeggen?
        x=100000/3;
        System.out.println( String.format("%.20f", x) ); //33333,00000000000000000000
        x=100000f/3;
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
                System.out.println( String.format("moneyInBank: %.20f", moneyInBank) );
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
