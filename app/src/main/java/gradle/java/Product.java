package gradle.java;

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

  String getImage() {
    return image;
  }

  String getDescription() {
    return description;
  }

  String getFeaturedAttribute() {
    return featuredAttribute;
  }

  Double getPrice() {
    return price;
  }

  String getReference() {
    return reference;
  }
}
