package edu.music;

import java.util.Scanner;

public class CustomPlayer implements DefaultPlayer, CarouselAlbumPictures{

    public void beginOperation() {
        boolean continueFlag = true;
        Scanner scanner = new Scanner(System.in);
        String responseToApp;
        while(continueFlag){
            System.out.println("Tocando música.");
            System.out.println("----Pressione enter para tocar uma música, ou digite Home para voltar ao início.----");
            responseToApp = scanner.nextLine();
            if (responseToApp.equalsIgnoreCase("Home")) break;

        }
    }
    public static void main(String [] args){
        CustomPlayer playApp = new CustomPlayer();
        playApp.beginOperation();
    }
}
