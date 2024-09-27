package clients;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dog extends Animal {
    private static final Logger LOGGER = Logger.getLogger(Dog.class.getName());

    public Dog(String nickName, Owner owner, LocalDate birthDate, Illness illness, int movementStatistics) {
        super(nickName, owner, birthDate, illness, movementStatistics);
    }

    public Dog() {
        super();
    }

    @Override
    public void fly(int meters) {
        int result = movementStatistics;
        LOGGER.log(Level.INFO, "Собака по имени {0} может летать только во снах! Статистика подвижности: {1}", new Object[]{nickName, result});
    }

    @Override
    public void swim(int meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Метры не могут быть отрицательными");
        }
        int result = updateMovementStatistics(meters);
        LOGGER.log(Level.INFO, "Собака по имени {0} не плавает! Статистика подвижности: {1}", new Object[]{nickName, result});
    }

    @Override
    public String toString() {
        return String.format("nickName='%s', birthDate=%s, owner=%s, illness=%s, movementStatistics=%.2f",
                nickName, birthDate, owner, illness, movementStatistics);
    }

    private int updateMovementStatistics(int meters) {
        return movementStatistics += meters;
    }
}