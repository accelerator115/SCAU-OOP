package AddressBook;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--- 功能选项 ---");
            System.out.println("1. 地址列表");
            System.out.println("2. 查找地址");
            System.out.println("3. 增加地址");
            System.out.println("4. 删除地址");
            System.out.println("5. 修改地址");
            System.out.println("0. 退出");
            System.out.println("----------------");
            System.out.print("请输入选项号: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            switch (choice) {
                case 1 -> addressBook.listAddresses();
                case 2 -> {
                    System.out.print("输入要查找的姓名: ");
                    String name = scanner.nextLine();
                    List<Address> results = addressBook.searchByName(name);
                    if (results.isEmpty()) {
                        System.out.println("未找到匹配的地址。");
                    } else {
                        System.out.println("序号 | 姓名 | 省份 | 城市 | 邮政编码 | 详细地址");
                        System.out.println("------------------------------------------------------------");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.printf("%d | %s\n", i + 1, results.get(i));
                        }
                        System.out.println("------------------------------------------------------------");
                        System.out.printf("共[%d]条数据.\n", results.size());
                    }
                }
                case 3 -> {
                    System.out.println("请输入地址的各项数据:");
                    System.out.print("姓名: ");
                    String name = scanner.nextLine();
                    System.out.print("省份: ");
                    String province = scanner.nextLine();
                    System.out.print("城市: ");
                    String city = scanner.nextLine();
                    System.out.print("邮政编码: ");
                    String postalCode = scanner.nextLine();
                    System.out.print("详细地址: ");
                    String detailAddress = scanner.nextLine();
                    addressBook.addAddress(new Address(name, province, city, postalCode, detailAddress));
                }
                case 4 -> {
                    System.out.print("输入要删除地址的姓名: ");
                    String name = scanner.nextLine();
                    List<Address> results = addressBook.searchByName(name);
                    if (results.isEmpty()) {
                        System.out.println("未找到匹配的地址。");
                    } else {
                        System.out.println("序号 | 姓名 | 省份 | 城市 | 邮政编码 | 详细地址");
                        System.out.println("------------------------------------------------------------");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.printf("%d | %s\n", i + 1, results.get(i));
                        }
                        System.out.println("------------------------------------------------------------");
                        System.out.print("输入选择的地址序号: ");
                        scanner.nextLine(); // 清除换行符
                        int selectedIndex =  scanner.nextInt() - 1;
                        if (selectedIndex >= 0 && selectedIndex < results.size()) {
                            Address selectedAddress = results.get(selectedIndex);
                            int originalIndex = addressBook.getAddresses().indexOf(selectedAddress);
                            addressBook.deleteAddress(originalIndex);
                        } else {
                            System.out.println("无效的序号。");
                        }
                    }
                }
                case 5 -> {
                    System.out.print("输入要修改地址的姓名: ");
                    String name = scanner.nextLine();
                    List<Address> results = addressBook.searchByName(name);
                    if (results.isEmpty()) {
                        System.out.println("未找到匹配的地址。");
                    } else {
                        System.out.println("序号 | 姓名 | 省份 | 城市 | 邮政编码 | 详细地址");
                        System.out.println("------------------------------------------------------------");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.printf("%d | %s\n", i + 1, results.get(i));
                        }
                        System.out.println("------------------------------------------------------------");
                        System.out.print("输入选择的地址序号: ");
                        int selectedIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // 清除换行符
                        if (selectedIndex >= 0 && selectedIndex < results.size()) {
                            Address oldAddress = results.get(selectedIndex);
                            int originalIndex = addressBook.getAddresses().indexOf(oldAddress);
                            System.out.println("输入需要修改地址的各项数据(直接回车表示不修改该项数据):");
                            System.out.print("姓名 (原值: " + oldAddress.getName() + "): ");
                            String newName = scanner.nextLine();
                            System.out.print("省份 (原值: " + oldAddress.getProvince() + "): ");
                            String newProvince = scanner.nextLine();
                            System.out.print("城市 (原值: " + oldAddress.getCity() + "): ");
                            String newCity = scanner.nextLine();
                            System.out.print("邮政编码 (原值: " + oldAddress.getPostalCode() + "): ");
                            String newPostalCode = scanner.nextLine();
                            System.out.print("详细地址 (原值: " + oldAddress.getDetailAddress() + "): ");
                            String newDetailAddress = scanner.nextLine();

                            Address newAddress = new Address(
                                    newName.isEmpty() ? oldAddress.getName() : newName,
                                    newProvince.isEmpty() ? oldAddress.getProvince() : newProvince,
                                    newCity.isEmpty() ? oldAddress.getCity() : newCity,
                                    newPostalCode.isEmpty() ? oldAddress.getPostalCode() : newPostalCode,
                                    newDetailAddress.isEmpty() ? oldAddress.getDetailAddress() : newDetailAddress
                            );
                            addressBook.updateAddress(originalIndex, newAddress);
                        } else {
                            System.out.println("无效的序号。");
                        }
                    }
                }

                case 0 -> {
                    System.out.println("程序已退出。");
                    return;
                }
                default -> System.out.println("无效的选项，请重新输入。");
            }
        }
    }
}
