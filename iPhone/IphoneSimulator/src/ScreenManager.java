import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ScreenManager {
    public static void main(String[] args) {
        AppManagement managerApp = new AppManagement();

        boolean keepGoing = true;
        Scanner scanner = new Scanner(System.in);
        String answerOfScanner;
        while(keepGoing){
            System.out.println(managerApp.introduction());
            answerOfScanner = scanner.nextLine();
            managerApp.stringValidator(answerOfScanner);
            if (answerOfScanner.equalsIgnoreCase("sair")) break;
        }
        scanner.close();
        System.out.println("O programa acabou. Tenha um ótimo dia aonde e quando estiver. ");
    }
}