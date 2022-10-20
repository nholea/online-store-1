package gradle.java.domain;

public class Product {

  private final String image;
  private final String shortDescription;
  private final String longDescription;
  private final String highlightedAttribute;
  private final double price;
  private final String reference;


  public String showImage() {
    return image;
  }

  public String showShortDescription() {
    return shortDescription;
  }

  public String showLongDescription() {
    return longDescription;
  }

  public String showHighlightedAttribute() {
    return highlightedAttribute;
  }

  public double showPrice() {
    return price;
  }

  public String showReference() {
    return reference;
  }

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
