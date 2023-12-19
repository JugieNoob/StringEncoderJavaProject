import java.util.Base64;

public class Decoder {

    static String output = "";

    // Outputting information about the decoder to the console.

    static void outputInfo(String input, String output, String encoder){
        System.out.println("String: " + input +  "\n" + "Output: " + output + "\n" + "Encoder: " + encoder);
    }

    // Conveting Base64 to a string

    public static void Base64(String text)
    {
        output = new String(Base64.getDecoder().decode(text));
        main.setOutput(output);
        outputInfo(text, output, "Base64");
    }


    // Converting Decimal ASCII to a string 

    public static void DAscii(String text)
    {
        String[] asciiarray = text.trim().split(" ");
        for (int i = 0; i < asciiarray.length; i++)
        {
            char dectostring = (char)Integer.parseInt(asciiarray[i]);
            System.out.println(dectostring);
            output = main.outputfield.getText() + dectostring;
            output.trim();
            main.setOutput(output);
        }
    }

    // Converting Binary ASCII to a string 

    public static void Binary(String text)
    {
        String[] binaryarray = text.trim().split(" ");
        for (int i = 0; i < binaryarray.length; i++)
        {
            int bintodec = Integer.valueOf(binaryarray[i], 2);
            char dectostring = (char)bintodec;
            System.out.println(dectostring);
            output = main.outputfield.getText() + dectostring;
            output.trim();
            main.setOutput(output);
        }
       
    }

    // Decodes a string using the Caesar Cipher

    public static void CaesarCipher(String text)
    {
        output = "";
            for (int i = 0; i < text.length(); i++) {
                char getChar = (text.charAt(i));  
                getChar -= 1; 

                if (getChar != 31)
                {
                    output = String.valueOf(getChar);
                }
                else
                {
                    output = " ";
                }
                
                main.setOutput(main.outputfield.getText() + "" + output);

            }  
            outputInfo(text, main.outputfield.getText(), "Caesar Chipher");
    }
    
    // Reverses the string and outputs the value.

    public static void Reverse(String text)
    {
        var output = "";
        for (int i = 0; i < text.length(); i++)
        {
            char getChar = text.charAt(i);
            output =  getChar + output;
        }
        main.setOutput(main.outputfield.getText() + "" + output);

        outputInfo(text, main.outputfield.getText(), "Reverse");
    }

}
