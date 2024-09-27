package clients;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cat extends Animal {

    private static final Logger LOGGER = Logger.getLogger(Cat.class.getName());

    Double discount;

    public Cat(String nickName, Owner owner, LocalDate birthDate, Illness illness, Double discount, int movementStatistics) {
        super(nickName, owner, birthDate, illness, movementStatistics);
        this.discount = Objects.requireNonNullElse(discount, 10D);
    }

    public Cat() {
        super();
        this.discount = 10D;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void meow() {
        LOGGER.log(Level.INFO, "Мяяяу!");
    }

    @Override
    public String toString() {
        return String.format("%s Discount(%.2f)", super.toString(), discount);
    }

    @Override
    public void toGo(int meters) {
        int result = movementStatistics += meters;
        LOGGER.log(Level.INFO, "Котёнок по имени {0} прошёл {1} метров. Статистика подвижности: {2}", new Object[]{nickName, meters, result});
    }

    @Override
    public void fly(int meters) {
        int result = movementStatistics;
        LOGGER.log(Level.INFO, "Котёнок по имени {0} не может летать! Статистика подвижности: {1}", new Object[]{nickName, result});
    }

    @Override
    public void swim(int meters) {
        int result = movementStatistics;
        LOGGER.log(Level.INFO, "Котёнок по имени {0} не любит воду и никуда не поплыл! Статистика подвижности: {1}", new Object[]{nickName, result});
    }
}