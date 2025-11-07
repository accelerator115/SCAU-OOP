// java
package productmanager;

import productmanager.manager.ProductManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 简易产品管理程序 启动 ===");
        System.out.println("暂无数据，请先使用产品入库功能添加产品。");
        ProductManager manager = new ProductManager();
        try {
            manager.start();
        } catch (Exception e) {
            System.err.println("程序发生未处理的异常，正在退出。");
            e.printStackTrace();
        } finally {
            System.out.println("=== 程序已退出 ===");
        }
    }
}
