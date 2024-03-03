import java.util.Scanner;

public class LabAssignment2 {
    
    public static void main(String[] args) {
        int deciVal, convertVal;
        //decimal input
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Input decimal value: ");
        int userInput = inputScanner.nextInt();
        deciVal = userInput;
        //base input; will reset input until value is in domain (2,16)
        System.out.print("\nInput converting value: ");
        userInput = inputScanner.nextInt();
        while(userInput > 16 || userInput < 2){
            System.out.println("Invalid entry. Please reenter a base 16 or less: ");
            userInput = inputScanner.nextInt();
        }
        convertVal = userInput;
        
        //output print line
        System.out.print("\nThe equivalent base-" + convertVal + " value of decimal " + deciVal + " is: ");
        System.out.print(convert(deciVal, convertVal));
        inputScanner.close();
    }

    public static String convert(int decimal, int base){
        //array has all values from 0-F to cover base 1-16.
        char[] binaryChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder output = new StringBuilder("");
        boolean neg = false;
        //check case for negative values
        if(decimal < 0){
            decimal = Math.abs(decimal);
            neg = true;
        }

        
        output.append(String.valueOf(binaryChar[(decimal % base)]));
        decimal /= base;


        while(decimal > 0){
            output.append(String.valueOf(binaryChar[(decimal % base)]));
            decimal /= base;
        }


        if(neg == true){
            return "-" + output.reverse().toString();
        }else{
            return output.reverse().toString();
        }
    }
}