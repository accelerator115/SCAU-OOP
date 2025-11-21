package GenericArrayUtil.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {
    // 删除数组中重复的非 null 元素，保持原顺序，返回新数组
    public static <T> T[] removeDuplicates(T[] array) {
        if (array == null) {
            return null;
        }
        List<T> unique = new ArrayList<>();
        for (T element : array) {
            if (element != null && !unique.contains(element)) {
                unique.add(element);
            }
        }
        T[] result = Arrays.copyOf(array, unique.size());
        for (int i = 0; i < unique.size(); i++) {
            result[i] = unique.get(i);
        }
        return result;
    }

    // 返回数组中的最大元素，若数组为空或全为 null 则返回 null
    public static <T extends Comparable<T>> T max(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (T element : array) {
            if (element != null && element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    // 返回数组中的最小元素，若数组为空或全为 null 则返回 null
    public static <T extends Comparable<T>> T min(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];
        for (T element : array) {
            if (element != null && element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
}
