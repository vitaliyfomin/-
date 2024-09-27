package clients;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sparrow extends Animal {
    private static final Logger LOGGER = Logger.getLogger(Sparrow.class.getName());

    public Sparrow(String nickName, Owner owner, LocalDate birthDate, Illness illness, int movementStatistics) {
        super(nickName, owner, birthDate, illness, movementStatistics);
    }

    public Sparrow() {
        super();
    }

    public void moveByJumping(int meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Метры не могут иметь отрицательных значений");
        }
        int updatedStatistics = updateMovementStatistics(meters);
        LOGGER.log(Level.INFO, "Воробей по имени {0} переместилось прыжками на {1} метров. Статистика подвижности: {2}",
                new Object[]{getNickName(), meters, updatedStatistics});
    }

    @Override
    public void toGo(int meters) {
        LOGGER.log(Level.INFO, "Воробей {0} птица особенная, ходить не умеет, но может прыгать moveByJumping(). Статистика подвижности: {1}",
                new Object[]{getNickName(), movementStatistics});
    }

    @Override
    public void swim(int meters) {
        LOGGER.log(Level.INFO, "Воробей по имени {0} не плавает! Статистика подвижности: {1}",
                new Object[]{getNickName(), movementStatistics});
    }

    private int updateMovementStatistics(int meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Метры не могут иметь отрицательных значений");
        }
        return movementStatistics += meters;
    }

    @Override
    public String getNickName() {
        return nickName;
    }
}