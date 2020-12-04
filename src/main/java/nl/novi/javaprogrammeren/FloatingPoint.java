package nl.novi.javaprogrammeren;

//https://introcs.cs.princeton.edu/java/91float
//https://introcs.cs.princeton.edu/java/91float/FloatingPoint.java.html
//https://algs4.cs.princeton.edu/code/

/******************************************************************************
 *  Compilation:  javac FloatingPoint.java
 *  Execution:    java FloatingPoint
 *
 *  Various examples of IEEE 754 binary floating point calculations.
 *
 *  % java FloatingPoint
 *
 ******************************************************************************/

import java.math.BigDecimal;

public class FloatingPoint {

    public static void main(String[] args) {
        boolean b;
        double d, d1, d2, d3;
        float f;

        // IEEE 754 bit representation of -7.25
        d = -7.25;
        
        System.out.print("IEEE 754 representation of -7.25  = ");
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(d)));

        // Double.doubleToLongBits() doesn't print the leading 0s
        d = .00625;
        System.out.print("IEEE 754 representation of .00625 = ");
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(d)));


        // The values 0.9200000000000001 and 0.9200000000000002 are not representable
        System.out.println("0.9200000000000001 = " + new BigDecimal(0.9200000000000001));
        System.out.println("0.9200000000000002 = " + new BigDecimal(0.9200000000000002));
        b = (0.9200000000000001 == 0.9200000000000002);
        System.out.println("0.9200000000000001 == 0.9200000000000002: " + b);


        // 0.1 + 0.2 doesn't equal 0.3
        System.out.println("0.1       = " + 0.1);
        System.out.println("0.1       = " + new BigDecimal(0.1));
        System.out.println("0.2       = " + new BigDecimal(0.2));
        System.out.println("0.3       = " + new BigDecimal(0.3));
        System.out.println("0.4       = " + new BigDecimal(0.4));
        System.out.println("0.1 + 0.2 = " + new BigDecimal(0.1 + 0.2));
        System.out.println("0.1 + 0.3 = " + new BigDecimal(0.1 + 0.3));
        b = (0.1 + 0.2 == 0.3);
        System.out.println("0.1 + 0.2 == 0.3: " + b);

        // 0.1 + 0.3 equals 0.4
        b = (0.1 + 0.3 == 0.4);
        System.out.println("0.1 + 0.3 == 0.4: " + b);

        // 0.1 + 0.1 + 0.1 = 0.30000000000000004
        d1 = 0.1 + 0.1 + 0.1;
        System.out.println("0.1 + 0.1 + 0.1 = " + d1);

        // 0.3 is not representable, but doesn't equal 0.1 + 0.1 + 0.1
        d2 = 0.3;
        if (d1 == d2) System.out.println("0.1 + 0.1 + 0.1 == 0.3");
        else          System.out.println("0.1 + 0.1 + 0.1 != 0.3");

        // 0.1 is not representable, but 0.1 + 0.1 + 0.1 + 0.1 + 0.1 does equal 0.5
        b = (0.1 + 0.1 + 0.1 + 0.1 + 0.1 == 0.5);
        System.out.println("0.1 + 0.1 + 0.1 + 0.1 + 0.1 == 0.5: " + b);

        // 3 * 0.1 doesn't equal 0.3
        b = (3 * 0.1 == 0.3);
        System.out.println("3 * 0.1 == 0.3: " + b);

        // 1138/1000.0 doesn't equal 0.001*1138
        b = ((1138/1000.0) == (0.001*1138));
        System.out.println("1138/1000.0 == 0.001*1138: " + b);

        // sqrt(x) * sqrt(x) does not equal |x|
        b = (Math.sqrt(2.0) * Math.sqrt(2.0) == 2.0);
        System.out.println("Math.sqrt(2) * Math.sqrt(2) == 2: " + b);

        // 3.0 / 7.0 is represented differently in float and double
        f = (float) (3.0 / 7.0);
        d = 3.0 / 7.0;
        b = (f == d);
        System.out.println("3.0 / 7.0 == (float) (3.0 / 7.0): " + b);

        // floating point addition is not associative
        d1 =  1.0E50;
        d2 = -1.0E50;
        d3 = 17.0E00;
        b = ((d1 + d2) + d3) == (d1 + (d2 + d3));
        System.out.println("((1.0E50 + -1.0E50) + 17) == (1.0E50 + (-1.0E50 + 17)): " + b);

        // floating point multiplication and division are not associative
        b = ((2.0 * 0.1) / 3.0) == (2.0 * (0.1 / 3.0));
        System.out.println("((2.0 * 0.1) / 3.0) == (2.0 * (0.1 / 3.0)): " + b);

        // sin^2(theta) + cos^2(theta) != 1  (though the identity holds for many values of theta)
        double theta = 0.53454545535453;   // 0.53454545535453001914305559694184921681880950927734375
        b = (Math.sin(theta) * Math.sin(theta) + Math.cos(theta) * Math.cos(theta)) == 1.0;
        System.out.println("sin^2(" + theta + ") + cos^2(" + theta + ") == 1.0: " + b);

        // special values
        System.out.println("Double.POSITIVE_INFINITY = " + Double.POSITIVE_INFINITY);
        System.out.println("Double.NEGATIVE_INFINITY = " + Double.NEGATIVE_INFINITY);
        System.out.println("Double.NaN               = " + Double.NaN);

        // getting Infinity and -Infinity
        System.out.println(" 1.0/0.0           = " + (1.0/0.0));
        System.out.println("-1.0/0.0           = " + (-1.0/0.0));
        System.out.println("Math.sqrt(1.0/0.0) = " + (Math.sqrt(1.0)/0.0));
        System.out.println("1E200 * 1E200  = " + ( 1E200 * 1E200));
        System.out.println("-1E200 * 1E200 = " + (-1E200 * 1E200));

        // getting NaN = not a number
        System.out.println("0.0 / 0.0         = " + (0.0 / 0.0));
        System.out.println("Math.sqrt(-3.0)   = " + (Math.sqrt(-3.0)));
        System.out.println("1.0/0.0 - 1.0/0.0 = " + (1.0/0.0 - 1.0/0.0));
        System.out.println("0.0 * 1.0/0.0     = " + (0.0/0.0 * 1.0/0.0));
        System.out.println("1.0 % 0.0         = " + (1.0 % 0.0));
        System.out.println("(1.0/0.0) % 1.0   = " + ((1.0/0.0) % 1.0));

        // getting 0 and -0
        System.out.println("1E-200 / 1E200 = " + (1E-200 / 1E200));
        System.out.println("-1E-200 / 1E200 = " + (-1E-200 / 1E200));

        // machine precision for double = 2^(-53) + 2^(-105) = 1.11022302462515678694266454965700950366517665087069677287701097156968899071216583251953125E-16

        // 2^-53
        d = 1.0 / (1L << 53);
        b = (1.0 == (1.0 + d));
        System.out.println("1 + 2^-53 == 1: " + b);

        // 2^-53 + 2^-105
        d1 = d + (2*d)*d;
        b = (1.0 == (1.0 + d1));
        System.out.println("1 + 2^-53 + 2^-105 == 1: " + b);
        System.out.println("Machine precision for double = 2^(-53) + 2^(-105) = " + d1);

        // 2^-53 + 2^-106 == 2^-53
        d2 = d + d*d;
        b = (d == d2);
        System.out.println("2^-53 + 2^-106 == 2^-53: " + b);

        // smallest positive integer not representable as a double = 2^53 + 1
        d1 = 1L << 53;
        d2 = d1 + 1;
        System.out.println("2^53     = " + (long) d1);
        System.out.println("2^53 + 1 = " + (long) d2);

        // 10^-21 is not representable; result of Math.pow is within 1 ulp of true answer
        System.out.println("1E-21             = " + 1.0E-21);
        System.out.println("Math.pow(10, -21) = " + Math.pow(10, -21));

        // Math.cos(pi/2) doesn't exactly equal zero
        System.out.println("Math.cos(Math.PI/2) = " + Math.cos(Math.PI/2));
    }
}
