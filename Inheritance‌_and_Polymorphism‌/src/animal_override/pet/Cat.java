package animal_override.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthday) {
        super(name, birthday);
    }

    public String climbTree() {
        return "我会爬树";
    }

    @Override
    public String shout() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        return "猫，名字：" + getName() + "，生日：" + getBirthday().format(fmt);
    }
}