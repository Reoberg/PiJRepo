import java.util.Scanner;

public class Exercise18 {
    // Mail Server
final static char validationSymbol = '@';
final static String mailFromCommand = "MAIL FROM:";
final static String rcptoCommand = "RCP TO:";
final static String dataCommand = "DATA";

    private static boolean mailCommandValidation(String input){
        int commandLength = mailFromCommand.length();
        if (commandLength > input.length()){
            return false;
        }
        else {
            return input.substring(0, commandLength).equals(mailFromCommand);
        }

    }
    private static boolean rcptoCommandValidation(String input){
        int commandLength = rcptoCommand.length();
        if (commandLength > input.length()){
            return false;
        }
        else{
            return input.substring(0, commandLength).equals(rcptoCommand);
        }

    }
    private static boolean dataCommandValidation(String input){
        int commandLength = dataCommand.length();
        if (commandLength > input.length()){
            return false;
        }
        else{
            return input.substring(0, commandLength).equals(dataCommand);
        }

    }

    private static boolean emailValidation(String input, String command){
        boolean valid = false;
        char current;
        String inputWithoutCommand;
        if (command.length()> input.length()){
            valid = false;
        }
        else{
            inputWithoutCommand = input.substring(command.length());
            for(int i=0; i < inputWithoutCommand.length(); i++)
            {
                current = inputWithoutCommand.charAt(i);
                if (current == validationSymbol && i != 0 && i != inputWithoutCommand.length()-1){
                    valid = true;
                }
            }
        }

      return valid;
    }
    public static void main(String[] args) {
        boolean isMailFromCommandValid,isRcpToCommandValid,isDataCommandValid,isEmailValid;
        String fromToMail ="", rcpToMail="",dataString="";
        boolean checker = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to My Mail Server! ");

        while (!checker){
            boolean fromToChecker = false,rcptoChecker = false, dataChecker=false;
            System.out.println("Enter a promt at form of MAIL FROM: <email-address> (needs to be contain @): ");

            //<editor-fold desc="FROM TO: Email Checker">
            while (!fromToChecker){
                String firstInput = scanner.next();
                isMailFromCommandValid = mailCommandValidation(firstInput);
                isEmailValid = emailValidation(firstInput,mailFromCommand);
                if (isMailFromCommandValid && isEmailValid){
                    fromToMail = firstInput.substring(mailFromCommand.length());
                    fromToChecker = true;
                    System.out.println("OK");
                }
                else {
                    if (isEmailValid){
                        System.out.println("Invalid command!");
                    }
                    else if (isMailFromCommandValid){
                        System.out.println("Invalid email!");
                    }
                    else {
                        System.out.println("Invalid command and email!");
                    }

                }

            }
            //</editor-fold>

            //<editor-fold desc="RCP TO: Email Checker">
            while (!rcptoChecker){
                String secondInput = scanner.next();
                isRcpToCommandValid = rcptoCommandValidation(secondInput);
                isEmailValid = emailValidation(secondInput,rcptoCommand);
                if (isRcpToCommandValid && isEmailValid){
                    rcpToMail = secondInput.substring(rcptoCommand.length());
                    rcptoChecker = true;
                    System.out.println("OK");
                }
                else {
                    if (isEmailValid){
                        System.out.println("Invalid command!");
                    }
                    else if (isRcpToCommandValid){
                        System.out.println("Invalid email!");
                    }
                    else {
                        System.out.println("Invalid command and email!");
                    }

                }
            }
            //</editor-fold>

            //<editor-fold desc="Data Checker">
            while (!dataChecker){
                String thirdInput = scanner.next();
                isDataCommandValid = dataCommandValidation(thirdInput);
                isEmailValid = emailValidation(thirdInput,dataCommand);
                if (isDataCommandValid && isEmailValid){
                    dataChecker = true;
                    System.out.println("Sending email... \n" +
                            "from: " + fromToMail +
                            "\n to: " + rcpToMail +
                            "\n" + dataString + "\n DONE.."
                    );
                }
                else {
                    if (isEmailValid){
                        System.out.println("Invalid command!");
                    }
                    else if (isDataCommandValid){
                        System.out.println("Invalid email!");
                    }
                    else {
                        System.out.println("Invalid command and email!");
                    }

                }
            }
            //</editor-fold>


        }



    }






}
