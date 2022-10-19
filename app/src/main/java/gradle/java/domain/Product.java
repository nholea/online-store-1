package gradle.java.domain;

public class Product {

  public final String image;
  public final String shortDescription;
  public final String longDescription;
  public final String highlightedAttribute;
  public final double price;
  public final String reference;


  public Product(String image, String shortDescription, String longDescription,
    String highlightedAttribute, Double price, String reference) {
    this.image = image;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
    this.highlightedAttribute = highlightedAttribute;
    this.price = price;
    this.reference = reference;
  }

}
