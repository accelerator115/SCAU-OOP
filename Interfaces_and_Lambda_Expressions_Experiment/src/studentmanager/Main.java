package studentmanager;

import studentmanager.data.Student;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("20190201", "David", "Software Engineering"),
                new Student("20190202", "Edward", "Software Engineering"),
                new Student("20190101", "Zed", "Computer Science"),
                new Student("20190102", "Bob", "Computer Science"),
                new Student("20190103", "Charlie", "Computer Science"),
                new Student("20190301", "Fred", "Data Science"),
        };

        System.out.println("原始输出:");
        printArray(students);

        Arrays.sort(students, (a, b) -> a.getId().compareTo(b.getId()));
        System.out.println("\n按学号排序后输出:");
        printArray(students);

        Arrays.sort(students, (a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("\n按姓名排序后输出:");
        printArray(students);

        Arrays.sort(students, (a, b) -> b.getMajor().compareTo(a.getMajor())); // 专业降序
        System.out.println("\n按专业排序后输出:");
        printArray(students);
    }

    private static void printArray(Student[] arr) {
        for (Student s : arr) {
            System.out.println(s);
        }
    }
}
