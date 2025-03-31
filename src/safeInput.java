import java.util.Scanner;
public class safeInput {
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retValue = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                if (retValue >= low && retValue <= high) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("You did not enter an integer.");
                pipe.next();
            }
            pipe.nextLine();
        }
        return retValue;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String yesOrNo;
        boolean result = false;
        boolean done = false;

        do {
            System.out.print(prompt + "(Y/N):");
            yesOrNo = pipe.nextLine();
            if (yesOrNo.equalsIgnoreCase("Y")) {
                result = true;
                done = true;
            } else if (yesOrNo.equalsIgnoreCase("N")) {
                result = false;
                done = true;

            } else {

                System.out.println("You did not enter Y or N.");

            }
        }
        while (!done);

        return result;
    }
}
