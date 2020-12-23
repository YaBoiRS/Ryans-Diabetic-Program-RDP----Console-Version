//Made by Ryan Scott
//Used to make output simpler and cleaner

public class GUIManager {

    void startApp() {
        // Print program start
        System.out.println("=============================================");
        System.out.println("=============== W E L C O M E ===============");
        System.out.println("=============================================\n");
    }

    static void startTitle(String name, String lastName) {
        // Print program start
        System.out.println("=============== W E L C O M E ===============");
        System.out.println(" === " + name + " " + lastName +  " === ");
        System.out.println("=============================================\n");
    }

    void finishTitle() {
        // Print program finish
        System.out.println("=============================================");
        System.out.println("=============== G O O D B Y E ===============");
        System.out.println("=============================================\n");
    }

    void startSection(String userName, String sctn) {
        // Print section start
        System.out.println("=========================================");
        System.out.println(" === " + userName + " === " + sctn + " === ");
        System.out.println("=========================================\n");
    }

    void printUsername(String name) {
        // Print section start
        System.out.println(" === Username - " + name + " === ");
    }

    void br(){
        System.out.println("=========================================");
    }
    void brBlank(){
        System.out.println("\n");
    }

}