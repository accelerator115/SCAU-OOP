package productmanager.manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private final ProductInventory inventory = new ProductInventory();
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public int displayMenu() {
        System.out.println();
        System.out.println("1. 查询产品");
        System.out.println("2. 产品入库");
        System.out.println("3. 产品出库");
        System.out.println("4. 产品删除");
        System.out.println("5. 产品列表");
        System.out.println("0. 退出");
        System.out.print("请选择：");
        String line = scanner.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void findProduct() {
        System.out.print("请输入产品编号：");
        String id = scanner.nextLine().trim();
        Product p = inventory.getProduct(id);
        if (p == null) {
            System.out.println("产品不存在");
        } else {
            printHeader();
            printProductLine(p);
        }
    }

    public void entryProduct() {
        System.out.print("请输入入库产品编号：");
        String id = scanner.nextLine().trim();
        Product p = inventory.getProduct(id);
        if (p != null) {
            System.out.print("产品已存在，请输入入库数量：");
            int q = readInt();
            p.setQuantity(p.getQuantity() + q);
            System.out.println("产品增加数量成功");
        } else {
            System.out.print("请输入产品名称：");
            String name = scanner.nextLine().trim();
            System.out.print("请输入产品价格：");
            double price = readDouble();
            System.out.print("请输入产品数量：");
            int quantity = readInt();
            LocalDate launch = LocalDate.now();
            Product np = new Product(id, name, launch, quantity, price);
            inventory.addProduct(np);
            System.out.println("新增产品成功");
        }
    }

    public void reduceProduct() {
        System.out.print("请输入出库产品编号：");
        String id = scanner.nextLine().trim();
        Product p = inventory.getProduct(id);
        if (p == null) {
            System.out.println("产品不存在");
            return;
        }
        System.out.print("请输入出库数量：");
        int q = readInt();
        if (q <= p.getQuantity()) {
            p.setQuantity(p.getQuantity() - q);
            System.out.println("产品出库成功");
        } else {
            System.out.println("库存数量不足");
        }
    }

    public void removeProduct() {
        System.out.print("请输入要删除的产品编号：");
        String id = scanner.nextLine().trim();
        Product p = inventory.getProduct(id);
        if (p == null) {
            System.out.println("产品不存在");
            return;
        }
        System.out.print("确认删除该产品？(Y/N)：");
        String ans = scanner.nextLine().trim();
        if ("Y".equalsIgnoreCase(ans)) {
            boolean ok = inventory.removeProduct(p);
            if (ok) {
                System.out.println("删除成功");
            } else {
                System.out.println("库存数量不为0，不能删除");
            }
        } else {
            System.out.println("已取消删除");
        }
    }

    public void listProduct() {
        List<Product> list = inventory.listAll();
        Collections.sort(list); // 按 id 升序（Product 实现了 Comparable）
        printList(list);
        printTotals(list);

        System.out.println();
        System.out.print("1. 按名称升序/2.按价格升序/3.按库存数量降序/0.直接返回，你的选择：");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "0":
                return;
            case "1":
                // 内部类实现排序（按名称升序）
                class NameComparator implements Comparator<Product> {
                    @Override
                    public int compare(Product o1, Product o2) {
                        String n1 = o1.getName() == null ? "" : o1.getName();
                        String n2 = o2.getName() == null ? "" : o2.getName();
                        return n1.compareTo(n2);
                    }
                }
                Collections.sort(list, new NameComparator());
                printList(list);
                printTotals(list);
                break;
            case "2":
                // 匿名内部类实现排序（按价格升序）
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Double.compare(o1.getPrice(), o2.getPrice());
                    }
                });
                printList(list);
                printTotals(list);
                break;
            case "3":
                // Lambda 表达式实现排序（按库存数量降序）
                Collections.sort(list, (a, b) -> Integer.compare(b.getQuantity(), a.getQuantity()));
                printList(list);
                printTotals(list);
                break;
            default:
                System.out.println("无效选择");
        }
    }

    public void start() {
        while (true) {
            int opt = displayMenu();
            switch (opt) {
                case 1:
                    findProduct();
                    break;
                case 2:
                    entryProduct();
                    break;
                case 3:
                    reduceProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    listProduct();
                    break;
                case 0:
                    System.out.println("退出程序");
                    return;
                default:
                    System.out.println("无效选项，请重试");
            }
        }
    }

    private int readInt() {
        while (true) {
            String s = scanner.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("输入不合法，请输入整数：");
            }
        }
    }

    private double readDouble() {
        while (true) {
            String s = scanner.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("输入不合法，请输入数字：");
            }
        }
    }

    private void printHeader() {
        System.out.printf("%-6s\t%-12s\t%-8s\t%-8s\t%-10s\t%-12s%n",
                "编号", "名称", "价格", "库存数量", "库存金额", "上架日期");
    }

    private void printProductLine(Product p) {
        double amount = p.getPrice() * p.getQuantity();
        String date = p.getLaunchDate() == null ? "" : p.getLaunchDate().format(df);
        System.out.printf("%-6s\t%-12s\t%8.2f\t%8d\t%10.2f\t%-12s%n",
                p.getId(), p.getName(), p.getPrice(), p.getQuantity(), amount, date);
    }

    private void printList(List<Product> list) {
        printHeader();
        for (Product p : list) {
            printProductLine(p);
        }
    }

    private void printTotals(List<Product> list) {
        int totalQty = 0;
        double totalAmt = 0.0;
        for (Product p : list) {
            totalQty += p.getQuantity();
            totalAmt += p.getPrice() * p.getQuantity();
        }
        System.out.printf("合计数量：%d，合计金额：%.2f%n", totalQty, totalAmt);
    }
}
