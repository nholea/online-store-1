package gradle.java.domain;

public class Product {

  private final String image;
  private final String description;
  private final String featuredAttribute;
  private final double price;
  private final String reference;

  public Product(String image, String description, String featuredAttribute, Double price, String reference) {
    this.image = image;
    this.description = description;
    this.featuredAttribute = featuredAttribute;
    this.price = price;
    this.reference = reference;
  }

  public String showImage() {
    return image;
  }

  public String showDescription() {
    return description;
  }

  public String showFeaturedAttribute() {
    return featuredAttribute;
  }

  public Double showPrice() {
    return price;
  }

  public String showReference() {
    return reference;
  }
}
