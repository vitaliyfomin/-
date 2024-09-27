package clients;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Animal {

    private static final Logger LOGGER = Logger.getLogger(Animal.class.getName());

    protected String nickName;
    protected Owner owner;
    protected LocalDate birthDate;
    protected Illness illness;
    protected int movementStatistics;

    public Animal(String nickName, Owner owner, LocalDate birthDate, Illness illness, int movementStatistics) {
        this.nickName = nickName;
        this.owner = owner;
        this.birthDate = birthDate;
        this.illness = illness;
        this.movementStatistics = movementStatistics;
    }

    public Animal() {
        this("Кличка", new Owner("Хозяин"), LocalDate.now(), new Illness("Болеет"), 0);
    }

    public void lifeCycle() {
        wakeUp("12:00");
        hunt();
        eat();
        sleep();
    }

    private void wakeUp() {
        wakeUp("12:00");
    }

    private void wakeUp(String time) {
        LOGGER.info(String.format("Животное %s проснулось в %s", nickName, time));
    }

    private void hunt() {
        LOGGER.info("Животное охотится!");
    }

    private void eat() {
        LOGGER.info("Животное ест!");
    }

    private void sleep() {
        LOGGER.info("Животное уснуло!");
    }

    protected void updateMovementStatistics(int meters, String action) {
        LOGGER.info(String.format("Животное %s %s. Статистика подвижности: %d",
                nickName, action, movementStatistics += meters));
    }

    public void toGo(int meters) {
        updateMovementStatistics(meters, "прошло " + meters + " метров");
    }

    public void fly(int meters) {
        updateMovementStatistics(meters, "пролетело " + meters + " метров");
    }

    public void swim(int meters) {
        updateMovementStatistics(meters, "проплыло " + meters + " метров");
    }

    @Override
    public String toString() {
        return String.format("nickName = %s, bd = %s, owner = %s, illness = %s, Статистика движений = %s ",
                nickName, birthDate, owner, illness, movementStatistics);
    }

    public String getNickName() {
        return nickName;
    }
}