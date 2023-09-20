package edu.internet;

import edu.music.CustomPlayer;

import java.util.Scanner;

public class MobileBrowser {

    public void beginOperation() {
        boolean continueFlag = true;
        Scanner scanner = new Scanner(System.in);
        String responseToApp;
        while(continueFlag){
            System.out.println("Acessando a internet.");
            System.out.println("----Pressione enter para ir a outro website, ou digite Home para voltar ao início.----");
            responseToApp = scanner.nextLine();
            if (responseToApp.equalsIgnoreCase("Home")) break;

        }
    }
    public static void main(String [] args){
        MobileBrowser mobApp = new MobileBrowser();
        mobApp.beginOperation();
    }
}
