package edu.calling;

import edu.BasicProgram;
import edu.music.CustomPlayer;

import java.util.Scanner;

public class CallingApp extends BasicProgram implements CallingSignatureMethods {
    public void beginOperation() {
        boolean continueFlag = true;
        Scanner scanner = new Scanner(System.in);
        String responseToApp;
        while(continueFlag){
            System.out.println("Realizando chamada telefônica.");
            System.out.println("----Pressione enter para interagir com alguma ligação, ou digite Home para voltar ao início.----");
            responseToApp = scanner.nextLine();
            if (responseToApp.equalsIgnoreCase("Home")) break;

        }
    }
    public static void main(String [] args){
        CallingApp callApp = new CallingApp();
        callApp.beginOperation();
    }
}
