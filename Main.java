import java.util.Scanner;
import java.util.function.Predicate;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GUIManager ui = new GUIManager();

        String name = "Ryan";
        String lastName = "Scott";
        float carbRatio = 8;
        float corrFactor = 2;

        // System.out.println("Please enter your first name");
        // name = sc.nextLine();
        // ui.brBlank();

        // System.out.println("Please enter your last name");
        // lastName = sc.nextLine();
        // ui.brBlank();

        String userName = (name + " " + lastName);

        // System.out.println("Please enter Insulin to Carb Ratio (1 unit for 10g carbs,
        // enter the number 10)");
        // carbRatio = sc.nextInt();
        // ui.brBlank();

        // System.out.println("Please enter Correction Factor (13 mmol/L to 7mmol/L with
        // a correction factor of 2, enter 3)");
        // corrFactor = sc.nextInt();
        // ui.brBlank();

        ui.startApp();
        ui.brBlank();

        menu(sc, ui, userName, carbRatio, corrFactor);

    }

    public static void menu(Scanner sc, GUIManager ui, String userName, float carbRatio, float corrFactor) {
        String section = "Main Manu";
        ui.startSection(userName, section);

        System.out.println("Please enter the number for your choice: ");
        System.out.println("1. Insulin for Food");
        System.out.println("2. High Blood Sugar Correction");
        System.out.println("3. Insulin for Food & High BS Correction");
        System.out.println("4. Insulin for Keetones");
        System.out.println("5. Exit Program");

        int choice = sc.nextInt();
        ui.brBlank();

        switch (choice) {

            case 1:
                section = "Insulin for Food";
                ui.startSection(userName, section);

                System.out.println("Please enter the grams of carbs for your meal (e.g. 150)");
                float carbAmnt = sc.nextFloat();
                ui.brBlank();

                float result = foodInsulin(carbAmnt, carbRatio);
                ui.brBlank();

                System.out.println("For " + carbAmnt + "g with a carb to insulin ratio of " + carbRatio);
                System.out.println("You will need to take " + Math.ceil(result) + " units of your fast acting insulin");
                ui.brBlank();
                if (Math.ceil(result) != result) {
                    System.out.println(Math.ceil(result) + " was rounded up from " + result);
                } else {
                    System.out.println(result + " was actual reault and not rounded");
                }
                ui.brBlank();

                System.out.println("Would you like to exit? Y/N");
                String leave = sc.next();

                if (leave.toLowerCase().equals("y")) {
                    ui.brBlank();
                    endApp(ui, userName);
                } else if (leave.toLowerCase().equals("n")) {
                    ui.brBlank();
                    menu(sc, ui, userName, carbRatio, corrFactor);
                } else {
                    System.out.println("ERROR! incorrect input, returning to menu");
                    ui.brBlank();
                    menu(sc, ui, userName, carbRatio, corrFactor);
                }
                break;

            case 2:
                section = "High Blood Sugar Correction";
                ui.startSection(userName, section);

                System.out.println("Please enter your current blood sugar level in mmol/L (e.g. 11.4)");
                float bsLevel = sc.nextFloat();
                ui.brBlank();

                result = bsInsuliin(bsLevel, corrFactor);
                ui.brBlank();

                System.out.println(
                        "For a blood suger level of " + bsLevel + "mmol/L and a correction factor of " + corrFactor);
                System.out.println("You will need to take " + Math.ceil(result)
                        + " units of your fast acting insulin to get to 6mmol/L");
                ui.brBlank();
                if (Math.ceil(result) != result) {
                    System.out.println(Math.ceil(result) + " was rounded up from " + result);
                } else {
                    System.out.println(result + " was actual reault and not rounded");
                }
                ui.brBlank();

                System.out.println("Would you like to exit? Y/N");
                leave = sc.next();

                if (leave.toLowerCase().equals("y")) {
                    ui.brBlank();
                    endApp(ui, userName);
                } else if (leave.toLowerCase().equals("n")) {
                    ui.brBlank();
                    menu(sc, ui, userName, carbRatio, corrFactor);
                } else {
                    System.out.println("ERROR! incorrect input, returning to menu");
                    ui.brBlank();
                    menu(sc, ui, userName, carbRatio, corrFactor);
                }
                break;

            case 3:
                section = "Insulin for Food & High BS Correction";
                ui.startSection(userName, section);

                System.out.println("Please enter the grams of carbs for your meal (e.g. 150)");
                carbAmnt = sc.nextFloat();
                ui.brBlank();

                float result1 = foodInsulin(carbAmnt, carbRatio);
                ui.brBlank();

                System.out.println("Please enter your current blood sugar level in mmol/L (e.g. 11.4)");
                bsLevel = sc.nextFloat();
                ui.brBlank();

                float result2 = bsInsuliin(bsLevel, corrFactor);
                ui.brBlank();

                result = result1 + result2;

                ui.br();
                System.out.println("Blood Sugar Level - " + bsLevel + "mmol/L");
                System.out.println("Correction Factor - " + corrFactor);
                System.out.println("Carbs in Food - " + carbAmnt + "g");
                System.out.println("Carb to Insulin Ratio - " + carbRatio);
                ui.br();
                System.out.println("The insulin required for your food would be " + result1 + " units");
                System.out.println("The insulin required for your correction would be " + result2 + " units");
                System.out.println(
                        "In total, you will need to take " + Math.ceil(result) + " units of your fast acting insulin");
                ui.brBlank();
                if (Math.ceil(result) != result) {
                    System.out.println(Math.ceil(result) + " was rounded up from " + result);
                } else {
                    System.out.println(result + " was actual reault and not rounded");
                }
                ui.brBlank();

                System.out.println("Would you like to exit? Y/N");
                leave = sc.next();

                if (leave.toLowerCase().equals("y")) {
                    ui.brBlank();
                    endApp(ui, userName);
                } else if (leave.toLowerCase().equals("n")) {
                    ui.brBlank();
                    menu(sc, ui, userName, carbRatio, corrFactor);
                } else {
                    System.out.println("ERROR! incorrect input, returning to menu");
                    ui.brBlank();
                    menu(sc, ui, userName, carbRatio, corrFactor);
                }
                break;

            case 4:
                section = "Insulin for Keetones";
                ui.startSection(userName, section);
                ui.br();
                System.out.println("!!!!!!!! WARNING !!!!!!!!");
                System.out.println("keetones can be dangerous");
                System.out.println("please double check theese results by calling a doctor");
                System.out.println("or by checking your diabetic handbook (if given)");
                ui.br();
                ui.brBlank();

                System.out.println("Please enter your current blood ketone level in mmol/L (e.g. 1.2)");
                float ktnAmnt = sc.nextFloat();
                ui.brBlank();

                System.out.println("Please enter your current blood sugar level in mmol/L (e.g. 11.4)");
                bsLevel = sc.nextFloat();
                ui.brBlank();

                System.out.println("Please enter your (TDD) Total Daily Dose of insulin (e.g. 11.4)");
                bsLevel = sc.nextFloat();
                ui.brBlank();

                carbAmnt = 0;

                ketInsuin(sc, ui, userName, bsLevel, ktnAmnt, carbAmnt, corrFactor);
                break;

            case 5:
                endApp(ui, userName);
                break;
        }

    }

    public static float foodInsulin(float carbAmnt, float carbRatio) {
        float result = (carbAmnt / carbRatio);
        return result;
    }

    public static float bsInsuliin(float bsLevel, float corrFactor) {
        float amnt = Math.abs(6 - bsLevel);
        System.out.println(amnt);

        float result = amnt / 2;

        return result;
    }

    public static void ketInsuin(Scanner sc, GUIManager ui, String userName, float bsLevel, float ktnAmnt, float carbRatio, float corrFactor) {

        int result;

        //Ketones
        Predicate<Float> ktComp1 = i -> (i < 1);
        Predicate<Float> ktComp2 = i -> (i >= 1 && i <= 1.4);
        Predicate<Float> ktComp3 = i -> (i >= 1.5 && i <= 2.9);
        Predicate<Float> ktComp4 = i -> (i >= 3 ;

        //blood sugar
        Predicate<Float> bsComp1 = i -> (i < 4);
        Predicate<Float> bsComp2 = i -> (i >= 4 && i <= 9.9);
        Predicate<Float> bsComp3 = i -> (i >= 10 && i <= 15);
        Predicate<Float> bsComp3 = i -> (i > 15);

        //If keetones < 1
        if (ktComp1.test(ktnAmnt) == true) {
            noInsulin();
        }

        //If bloodsugar < 4
        if (bsComp1.test(bsLevel) == true) {
            noInsulin();
        }

        //if (keetones >= 1 and <= 1.4) and (bloodsugar >=4 and <= 9.9)
        if (ktComp2.test(ktnAmnt) == true && bsComp2.test(bsLevel) == true) {
            noInsulin();
        }

        //if (keetones >= 1 and <= 1.4) and (bloodsugar >= 10 and <= 15) or (keetones >= 1 and <= 1.4) and (bloodsugar >= 15)
        if (ktComp2.test(ktnAmnt) == true && bsComp3.test(bsLevel) == true || ktComp2.test(ktnAmnt) == true && bsComp4.test(bsLevel) == true) {
            tdd10();
        }

        //if (keetones >= 1.5 and <= 2.9) and (bloodsugar >= 4 and <= 9.9) or (keetones >= 1.5 and <= 2.9) and (bloodsugar >= 10 and <= 15)
        if (ktComp3.test(ktnAmnt) == true && bsComp2.test(bsLevel) == true || ktComp3.test(ktnAmnt) == true && bsComp3.test(bsLevel) == true) {
            tdd10();
        }

        if (ktComp3.test(ktnAmnt) == true && bsComp4.test(bsLevel) == true || ktComp4.test(ktnAmnt) == true && bsComp3.test(bsLevel) == true || ktComp4.test(ktnAmnt) == true && bsComp4.test(bsLevel) == true) {
            tdd20();
        }

        

        // System.out.println("Would you like to exit? Y/N");
        // String leave = sc.next();

        // if (leave.toLowerCase().equals("y")) {
        //     ui.brBlank();
        //     endApp(ui, userName);
        // } else if (leave.toLowerCase().equals("n")) {
        //     ui.brBlank();
        //     menu(sc, ui, userName, carbRatio, corrFactor);
        // } else {
        //     System.out.println("ERROR! incorrect input, returning to menu");
        //     ui.brBlank();
        //     menu(sc, ui, userName, carbRatio, corrFactor);
        // }
    }

    public static void endApp(GUIManager ui, String userName) {
        System.out.println("Thsnkyou for using the application " + userName);
        ui.brBlank();
        ui.finishTitle();
        System.exit(0);
    }

    public static void noInsulin() {
        System.out.println("No Extra Insulin Required");
    }

    public static void tdd10() {

    }

    public static void tdd20() {

    }
}