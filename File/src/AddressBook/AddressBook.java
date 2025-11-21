package AddressBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private static final String FILE_NAME = "address_book.dat";
    private List<Address> addresses;

    public AddressBook() {
        addresses = loadFromFile();
    }

    public List<Address> getAddresses() {
        return addresses;
    }


    private List<Address> loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Address>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(addresses);
        } catch (IOException e) {
            System.out.println("保存地址簿失败: " + e.getMessage());
        }
    }

    public void listAddresses() {
        if (addresses.isEmpty()) {
            System.out.println("地址簿为空。");
        } else {
            System.out.println("序号 | 姓名 | 省份 | 城市 | 邮政编码 | 详细地址");
            System.out.println("------------------------------------------------------------");
            for (int i = 0; i < addresses.size(); i++) {
                System.out.printf("%d | %s\n", i + 1, addresses.get(i));
            }
            System.out.println("------------------------------------------------------------");
            System.out.printf("共[%d]条数据.\n", addresses.size());
        }
    }

    public void addAddress(Address address) {
        addresses.add(address);
        saveToFile();
        System.out.println("地址添加成功。");
    }

    public List<Address> searchByName(String name) {
        List<Address> results = new ArrayList<>();
        for (Address address : addresses) {
            if (address.getName().equals(name)) {
                results.add(address);
            }
        }
        return results;
    }

    public void deleteAddress(int index) {
        if (index >= 0 && index < addresses.size()) {
            addresses.remove(index);
            saveToFile();
            System.out.println("地址删除成功。");
        } else {
            System.out.println("无效的序号。");
        }
    }

    public void updateAddress(int index, Address newAddress) {
        if (index >= 0 && index < addresses.size()) {
            addresses.set(index, newAddress);
            saveToFile();
            System.out.println("地址修改成功。");
        } else {
            System.out.println("无效的序号。");
        }
    }
}
