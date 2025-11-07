package productmanager.manager;

import java.time.LocalDate;
import java.util.Objects;

public class Product implements Comparable<Product>, Cloneable {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private LocalDate launchDate;

    public Product(String id, String name, LocalDate launchDate, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.launchDate = launchDate;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public int compareTo(Product other) {
        if (other == null) return 1;
        if (this.id == null && other.id == null) return 0;
        if (this.id == null) return -1;
        if (other.id == null) return 1;
        return this.id.compareTo(other.id);
    }

    @Override
    public Product clone() {
        // 深克隆：复制 String（新的实例）和 LocalDate（通过 of 创建新实例）
        String idCopy = this.id == null ? null : new String(this.id);
        String nameCopy = this.name == null ? null : new String(this.name);
        LocalDate dateCopy = null;
        if (this.launchDate != null) {
            dateCopy = LocalDate.of(launchDate.getYear(), launchDate.getMonth(), launchDate.getDayOfMonth());
        }
        return new Product(idCopy, nameCopy, dateCopy, this.quantity, this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", launchDate=" + launchDate +
                '}';
    }
}
