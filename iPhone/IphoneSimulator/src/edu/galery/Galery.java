package edu.galery;

import edu.music.CustomPlayer;

import java.util.Scanner;

public class Galery {
    public void beginOperation() {
        boolean continueFlag = true;
        Scanner scanner = new Scanner(System.in);
        String responseToApp;
        while(continueFlag){
            System.out.println("Apresentando figuras e fotos.");
            System.out.println("----Pressione enter para ver outra foto, ou digite Home para voltar ao início.----");
            responseToApp = scanner.nextLine();
            if (responseToApp.equalsIgnoreCase("Home")) break;

        }
    }
    public static void main(String [] args){
        Galery galApp = new Galery();
        galApp.beginOperation();
    }
}
