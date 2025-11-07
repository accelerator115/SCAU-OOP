package animal_override.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dog extends Pet {
    public Dog(String name, LocalDate birthday) {
        super(name, birthday);
    }

    public String guard() {
        return "我能警戒";
    }

    @Override
    public String shout() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        return "狗，名字：" + getName() + "，生日：" + getBirthday().format(fmt);
    }
}