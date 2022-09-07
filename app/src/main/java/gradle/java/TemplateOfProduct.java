package gradle.java;

import java.util.ArrayList;

public class TemplateOfProduct {
    ArrayList<Product> productFromTemplateOfProducts = new ArrayList<>();

    private ArrayList<Product> TemplateOfProducts(){

        String imageTV = "\uD83D\uDCFA";
        String descriptionTV = "Glamorous panoramic television, 13 inches";
        String featuredAttributeTV = "With this panoramic television, your friday nights will be boring no more.";
        Double priceTV = 300.99;
        String referenceTV = "W2C";

        String imagePiano = "\uD83C\uDFB9";
        String descriptionPiano = "Untuned musical keyboard, 4 octaves";
        String featuredAttributePiano = "Tired of your noisy neighbourgh? Play this untuned musical keyboard for two hours at home and your neighbour will be ready to move to a building far away from you.";
        Double pricePiano = 1003.00;
        String referencePiano = "X4A";

        Product productTV = new Product(imageTV, descriptionTV, featuredAttributeTV, priceTV, referenceTV);
        Product productPiano = new Product(imagePiano, descriptionPiano, featuredAttributePiano, pricePiano, referencePiano);

        for (){

            return productFromTemplateOfProducts;
        }
    }
}
