package gradle.java;

public class Product {
    private final String image;
    private final String description;
    private final String featuredAttribute;
    private final double price;
    private final String reference;

    public Product(String image, String description, String featuredAttribute, Double price, String reference){
        this.image = image;
        this. description = description;
        this.featuredAttribute = featuredAttribute;
        this.price = price;
        this.reference = reference;


    }

    String showImage(){
        return image;
    }

    String showDescription(){
        return description;
    }

    String showFeaturedAttribute(){
        return featuredAttribute;
    }

    Double showPrice(){
        return price;
    }

    String showReference(){
        return reference;
    }
}
