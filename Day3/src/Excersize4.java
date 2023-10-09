import java.util.Objects;
import java.util.Scanner;
public class Excersize4 {
    final String add = "+";
    final String sub = "-";
    final String mul = "*";
    final String div = "/";
    private String currentOp;
    private  void NumberAndOperandFinder (String[] input){
        for (int i=0; i < input.length; i++){
           String current =  input[i];
           if (Objects.equals(current, add) || Objects.equals(current, sub) || Objects.equals(current, mul) || Objects.equals(current, div)){
               currentOp = current;
           }
           else {
               System.out.println("Operand is wrong!");
               break;
           }
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a operation you want to do (Ex: 24+5)");

        String input = scanner.next();
        float firstNum,secondNum;
        //NumberAndOperandFinder(input);
        String operation;
        operation = "";
        switch (operation){

        }
    }
}
