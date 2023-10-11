import java.util.Objects;
import java.util.Scanner;
public class Excersize4 {
    // Command-line Calculator
    final static   char add = '+';
    final static char sub = '-';
    final static char mul = '*';
    final static char div ='/';
    private void findFirstNum(){

    }
    private void  findSecondNum(){

    }
    static String[] NumberAndOperandFinder (String input){
        for (int i=0; i < input.length(); i++){
           char current = input.charAt(i);
           if (Objects.equals(current, add) || Objects.equals(current, sub) || Objects.equals(current, mul) || Objects.equals(current, div)){
               String op = Character.toString(current);
               String firts = (input.substring(0,i));
               String second = (input.substring(i+1));
              // System.out.println(firts + op + second);
               return new String[] {firts,op,second};
           }
           else {
              // System.out.println("Operation is wrong!");
           }
        }
        return new String[] {};
    }
    static String removeSpaces(String str){
        StringBuffer st= new StringBuffer();
        for(char c:str.toCharArray()){
            if(c!=' ' && c!='\t'){
                st.append(c);
            }
        }
        return st.toString();
    }
    public static void main(String[] args) {

        String[] NumsAndOp;
        float firstNum = 0,secondNum = 0,result = 0;
        char currentOp ='0';
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter a operation you want to do (Ex: 24+5)");
        String asw = "Enter a operation you want to do (Ex: 24+5)";
        asw = removeSpaces(asw);
        System.out.println(asw);
        String input = scanner.next().replaceAll("\\s","");
        System.out.println(input);
        input = removeSpaces(input);
        System.out.println(input);
        NumsAndOp = NumberAndOperandFinder(input);
        if (NumsAndOp[0] != null) firstNum = Float.parseFloat(NumsAndOp[0]);
        if (NumsAndOp[1] != null) currentOp = NumsAndOp[1].charAt(0) ;
        if (NumsAndOp[2] != null) secondNum = Float.parseFloat(NumsAndOp[2]);

        if (currentOp != '0'){
            switch (currentOp){
                case add:
                   result = firstNum + secondNum;
                    System.out.println(result);
                   break;
                case sub:
                    result = firstNum - secondNum;
                    System.out.println(result);
                    break;
                case mul:
                    result = firstNum * secondNum;
                    System.out.println(result);
                    break;
                case div:
                    result = firstNum / secondNum;
                    System.out.println(result);
                    break;
                default:
                    System.out.println("Operation is wrong!");
            }

        }

    }
}
