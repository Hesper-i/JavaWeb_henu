package book;

public class Book {
    private String name;
    private float price;
    private String author;
    private String publisher;
    private int stock;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Book() {
    }

    public Book(String name, float price, String author, String publisher, int stock) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.stock = stock;
    }
}
