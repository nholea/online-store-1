package gradle.java;

import java.util.Scanner;

public class ProductsToChooseExplore {
    String DESCRIPTION_TV = "DESCRIPTION: With this panoramic television, your friday nights will be boring no more. The screen is composed of 14 million pixels. Thanks to its low energy consumption design, your bills will stay low.";
    String DESCRIPTION_PIANO = "DESCRIPTION: Tired of your noisy neighbourgh? Play this untuned musical keyboard for two hours at home and your neighbour will be ready to move to a building far away from you.";
    public void productsToChooseExplore(){
        System.out.println("Which product would you like to explore?");
        String option1 = "1 - \uD83D\uDCFA";
        String option2 = "2 - \uD83C\uDFB9";
        System.out.println(option1);
        System.out.println(option2);

        Scanner myObj = new Scanner(System.in);
        String object = myObj.nextLine();

        if(object.equals("1")){
            System.out.println(DESCRIPTION_TV);
        } else if (object.equals("2")) {
            System.out.println(DESCRIPTION_PIANO);
        } else System.out.println("Sorry, the product doesn't exist");

    }
}
