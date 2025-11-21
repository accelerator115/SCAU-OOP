package GenericArrayUtil;

import GenericArrayUtil.util.ArrayUtil;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] iArray= {1, 1, 2, 2, 3, null, 3, 4, 4, 5, 6, 7, null, null};
        String[] sArray= {"Java", "C++", "C", "Python", "JavaScript", "C++"};

        Integer[] iArrayResult=ArrayUtil.removeDuplicates(iArray);
        Arrays.stream(iArray).toList().forEach(e->System.out.print(e+" "));
        System.out.println();
        Arrays.stream(iArrayResult).toList().forEach(e->System.out.print(e+" "));
        System.out.println();

        System.out.println(ArrayUtil.<Integer>max(iArrayResult));
        System.out.println(ArrayUtil.<Integer>min(iArrayResult));

        String[] sArrayResult=ArrayUtil.removeDuplicates(sArray);
        Arrays.stream(sArray).toList().forEach(e->System.out.print(e+" "));
        System.out.println();
        Arrays.stream(sArrayResult).toList().forEach(e->System.out.print(e+" "));
        System.out.println();

        System.out.println(ArrayUtil.<String>max(sArrayResult));
        System.out.println(ArrayUtil.<String>min(sArrayResult));
    }
}
