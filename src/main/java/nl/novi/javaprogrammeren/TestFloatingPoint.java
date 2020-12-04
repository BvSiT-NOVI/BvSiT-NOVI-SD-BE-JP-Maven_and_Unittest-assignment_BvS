package nl.novi.javaprogrammeren;

public class TestFloatingPoint {
    public static void main(String[] args) {
        // Example 1
        float originalPrice = 400000.00f;

        float x = 0.085f;
        String xBits= Integer.toBinaryString(Float.floatToIntBits(x));
        System.out.println( xBits );//111101101011100001010001111011
        //A float is saved with 32 bits. Edu shows the binary string with leading zeros:
        System.out.println( fixedLengthBinaryString(xBits,32) ); //00111101101011100001010001111011



        if (false){
            // to make the price more attractive, we'll reduce it to $399999.95
            float reducedPrice = originalPrice - 0.05f;
            System.out.println( String.format("discount 0.05: %.20f", 0.05f) );
            System.out.println( String.format("reducedPrice: %.20f", reducedPrice) );
            float discount = originalPrice - reducedPrice;
            System.out.println( String.format("discount: %.20f", discount) );
            // Display discount amount
            System.out.println("De korting is: " + discount);
        }

    }

    public static String fixedLengthBinaryString(String binaryString,int numDigits){
        //https://dirask.com/posts/Java-convert-int-to-binary-String-with-leading-zeros-OpBXq1#:~:text=In%20java%20simples%20way%20to,replace%20all%20spaces%20with%200.
        return String.format("%0"+ (numDigits - binaryString.length())+"d%s",0,binaryString );
    }

}
