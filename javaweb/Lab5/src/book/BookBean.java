package book;

public class BookBean {
    private String name;
    private float price;
    private String author;
    private String publisher;
    private int stock;
    public BookBean() {
    }

    public BookBean(String name, float price, String author, String publisher, int stock) {
        this.price = price;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.stock=stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {return stock;}
}
