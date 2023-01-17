package view;

import controller.ComplexController;
import controller.FractionController;
import logger.LogWriter;

import java.util.Scanner;

public class CalcView {
    private ComplexController compController;
    private FractionController fracController;
    private LogWriter logger = new LogWriter();

    public CalcView(ComplexController compController, FractionController fracController) {
        this.compController = compController;
        this.fracController = fracController;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    public void run() {
        Commands com = Commands.NONE;
        while (true) {
            try {
                String command = prompt("Select calculator (FRACTION / COMPLEX): ");
                if (command.equals("")) throw new RuntimeException("Wrong command!");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case FRACTION:
                        command = prompt("Select operation: ");
                        com = Commands.valueOf(command.toUpperCase());
                        switch (com) {
                            case SUM:
                                String input1 = prompt("Enter first fraction: ");
                                fracController.validateInputFraction(input1);
                                String input2 = prompt("Enter second fraction: ");
                                fracController.validateInputFraction(input2);
                                String answer = fracController.sum(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                            case DIFF:
                                input1 = prompt("Enter first fraction: ");
                                fracController.validateInputFraction(input1);
                                input2 = prompt("Enter second fraction: ");
                                fracController.validateInputFraction(input2);
                                answer = fracController.diff(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                            case MULT:
                                input1 = prompt("Enter first fraction: ");
                                fracController.validateInputFraction(input1);
                                input2 = prompt("Enter second fraction: ");
                                fracController.validateInputFraction(input2);
                                answer = fracController.mult(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                            case DIV:
                                input1 = prompt("Enter first fraction: ");
                                fracController.validateInputFraction(input1);
                                input2 = prompt("Enter second fraction: ");
                                fracController.validateInputFraction(input2);
                                answer = fracController.div(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                        }
                        break;
                    case COMPLEX:
                        command = prompt("Select operation: ");
                        com = Commands.valueOf(command.toUpperCase());
                        switch (com) {
                            case SUM:
                                String input1 = prompt("Enter first complex: ");
                                String input2 = prompt("Enter second complex: ");
                                String answer = compController.sum(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                            case DIFF:
                                input1 = prompt("Enter first complex: ");
                                input2 = prompt("Enter second complex: ");
                                answer = compController.diff(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                            case MULT:
                                input1 = prompt("Enter first complex: ");
                                input2 = prompt("Enter second complex: ");
                                answer = compController.mult(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                            case DIV:
                                input1 = prompt("Enter first complex: ");
                                input2 = prompt("Enter second compelx: ");
                                compController.validateDivider(input2);
                                answer = compController.div(input1, input2).toString();
                                logger.writeOperation(input1, input2, command, answer);
                                System.out.println(answer);
                                break;
                        }
                        break;
                    case HELP:
                        System.out.println("For help read README.md!");
                }
            } catch (Exception e) {
                logger.writeException(e.getMessage());
                System.out.println("Error! " + e.getMessage());
            }
        }
    }
}
