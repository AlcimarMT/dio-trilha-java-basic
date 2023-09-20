import edu.calling.CallingApp;
import edu.galery.Galery;
import edu.internet.MobileBrowser;
import edu.music.CustomPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppManagement extends OperationalSystem{
    private List<String> possibleOptions;
    private List<String> getPossibleOptions(){
        return this.possibleOptions;
    }
    private String getASingleOption(int position){
        try{
            return this.possibleOptions.get(position);}
        catch (IndexOutOfBoundsException e){
            throw new RuntimeException("A posição não é válida.",e);}
    }
    private String currentApp;

    private void setCurrentApp(String currentApp) {
        this.currentApp = currentApp;
    }

    private String getCurrentApp(){
        return this.currentApp;
    }

    public AppManagement(){
        possibleOptions = new ArrayList<>();
        possibleOptions.add("CallingApp");
        possibleOptions.add("Galery");
        possibleOptions.add("MobileBrowser");
        possibleOptions.add("CustomPlayer");

    }

    public String introduction(){
        String myMessage;
        myMessage = "Os seguintes apps estão disponíveis:";
        myMessage += "\n";
        for (int i = 0; i<this.getPossibleOptions().size(); i++){
            myMessage = myMessage+ "    "+this.getPossibleOptions().get(i) +"    \n";
        }
        myMessage = myMessage + "------------sair------------";
        return myMessage;
    }

    public void stringValidator(String userInput){
        List<String> myOptions = this.getPossibleOptions();
        for (String element: myOptions) {
            if (userInput.equalsIgnoreCase(element)) {
                this.setCurrentApp(element);
                this.appTastingTray();
            }
        }
        System.out.println("Opção não encontrada.\n\n");
    }


    private void appTastingTray (){
        String inputParser = this.getCurrentApp();
        switch (inputParser){
            case "CallingApp":
                CallingApp callApp = new CallingApp();
                callApp.beginOperation();
                break;
            case "Galery":
                Galery galApp = new Galery();
                galApp.beginOperation();
                break;
            case "MobileBrowser":
                MobileBrowser mobApp = new MobileBrowser();
                mobApp.beginOperation();
                break;
            case "CustomPlayer":
                CustomPlayer playApp = new CustomPlayer();
                playApp.beginOperation();
                break;
        }


    }

    public static void main(String [] args){
        AppManagement mngApp = new AppManagement();
        System.out.println(mngApp.introduction());
    }
}
