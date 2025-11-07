package productmanager.manager;

import java.util.ArrayList;
import java.util.List;

public class ProductInventory {
    private final List<Product> products;

    public ProductInventory() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> listAll() {
        return new ArrayList<>(products);
    }

    public Product getProduct(String id) {
        if (id == null) return null;
        for (Product p : products) {
            if (id.equals(p.getId())) {
                return p;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (product == null) return;
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        if (product == null) return false;
        // 找到列表中与传入产品相同编号的产品对象并判断数量
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product.getId() != null && product.getId().equals(p.getId())) {
                if (p.getQuantity() == 0) {
                    products.remove(i);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public int getTotalQuantity() {
        int total = 0;
        for (Product p : products) {
            total += p.getQuantity();
        }
        return total;
    }

    public double getTotalAmount() {
        double sum = 0.0;
        for (Product p : products) {
            sum += p.getPrice() * p.getQuantity();
        }
        return sum;
    }
}
