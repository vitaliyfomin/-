import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

interface Walkable {
    void toGo(int meters);
}
interface Flyable {
    void fly(int meters);
}

interface Swimmable {
    void swim(int meters);
}

interface Runnable {
    void run(int meters);
}

class Owner {
    String fullName;

    Owner(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}

class Illness {
    String title;

    Illness(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Illness{" +
                "title='" + title + '\'' +
                '}';
    }
}

abstract class Animal {
    String nickName;
    LocalDate birthDate;
    Owner owner;
    Illness illness;
    int movementStatistics;
    List<String> actions = new ArrayList<>();

    Animal(String nickName, Owner owner, LocalDate birthDate, Illness illness, int movementStatistics) {
        this.nickName = nickName;
        this.owner = owner;
        this.birthDate = birthDate;
        this.illness = illness;
        this.movementStatistics = movementStatistics;
    }

    abstract void move();

    abstract void makeSound();

    void sleep() {
        actions.add(nickName + " спит.");
    }

    void eat() {
        actions.add(nickName + " ест.");
    }

    void printInfo() {
        actions.add("Информация о " + getClass().getSimpleName() + ":");
        actions.add("nickName='" + nickName + "', birthDate=" + birthDate +
                ", owner=" + owner + ", illness=" + illness +
                ", movementStatistics=" + movementStatistics);
        actions.add("-------------------");
    }

    @Override
    public String toString() {
        return String.join("\n", actions);
    }

    void toGo(int meters) {
        updateMovementStatistics(meters, "прошло " + meters + " метров");
    }

    protected void updateMovementStatistics(int meters, String action) {
        actions.add(String.format("Животное %s %s. Статистика подвижности: %d",
                nickName, action, movementStatistics += meters));
    }
}

class Cat extends Animal implements Walkable {
    double discount;

    Cat(String nickName, Owner owner, LocalDate birthDate, Illness illness, double discount, int movementStatistics) {
        super(nickName, owner, birthDate, illness, movementStatistics);
        this.discount = discount;
    }

    @Override
    void move() {
        actions.add("Кошка двигается.");
        movementStatistics += 10;
    }

    @Override
    void makeSound() {
        actions.add("Мяу!");
    }

    void specialAction() {
        actions.add("Кошка мурлычет.");
    }

    @Override
    public void toGo(int meters) {
        updateMovementStatistics(meters, "прошло " + meters + " метров");
    }
}

class Dog extends Animal implements Walkable, Runnable {
    Dog(String nickName, Owner owner, LocalDate birthDate, Illness illness, int movementStatistics) {
        super(nickName, owner, birthDate, illness, movementStatistics);
    }

    @Override
    void move() {
        actions.add("Собака двигается.");
        movementStatistics += 5;
    }

    @Override
    void makeSound() {
        actions.add("Гав!");
    }

    void specialAction() {
        actions.add("Собака виляет хвостом.");
    }

    @Override
    public void toGo(int meters) {
        updateMovementStatistics(meters, "прошло " + meters + " метров");
    }

    @Override
    public void run(int meters) {
        updateMovementStatistics(meters, "пробежало " + meters + " метров");
    }
}

class Sparrow extends Animal implements Flyable, Walkable {
    Sparrow(String nickName, Owner owner, LocalDate birthDate, Illness illness, int movementStatistics) {
        super(nickName, owner, birthDate, illness, movementStatistics);
    }

    @Override
    void move() {
        actions.add("Воробей двигается.");
        movementStatistics += 20;
    }

    @Override
    void makeSound() {
        actions.add("Чирик-чирик!");
    }

    void specialAction() {
        actions.add("Воробей машет крыльями.");
    }

    @Override
    public void fly(int meters) {
        updateMovementStatistics(meters, "пролетело " + meters + " метров");
    }

    @Override
    public void toGo(int meters) {
        updateMovementStatistics(meters, "прошло " + meters + " метров");
    }
}

public class Main {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Сергей Валерьевич");
        Illness illness1 = new Illness("Лишай");
        Cat cat = new Cat("Гав", owner1, LocalDate.parse("2021-10-03"), illness1, 0.5, 10);

        Owner owner2 = new Owner("Алексей Максимович");
        Illness illness2 = new Illness("Лишай");
        Dog dog = new Dog("Чаппи", owner2, LocalDate.parse("2023-10-04"), illness2, 0);

        Owner owner3 = new Owner("Клавдия Петровна");
        Illness illness3 = new Illness("Болят лапки");
        Sparrow sparrow = new Sparrow("Облачко", owner3, LocalDate.parse("2023-10-04"), illness3, 0);

        cat.move();
        cat.makeSound();
        cat.sleep();
        cat.eat();
        cat.specialAction();
        if (cat instanceof Walkable) {
            ((Walkable) cat).toGo(5); // Пример вызова метода toGo
        }
        if (cat instanceof Flyable) {
            ((Flyable) cat).fly(10); // Пример вызова метода fly
        }
        if (cat instanceof Swimmable) {
            ((Swimmable) cat).swim(3); // Пример вызова метода swim
        }

        dog.move();
        dog.makeSound();
        dog.sleep();
        dog.eat();
        dog.specialAction();
        if (dog instanceof Walkable) {
            ((Walkable) dog).toGo(8); // Пример вызова метода toGo
        }
        if (dog instanceof Flyable) {
            ((Flyable) dog).fly(15); // Пример вызова метода fly
        }
        if (dog instanceof Swimmable) {
            ((Swimmable) dog).swim(2); // Пример вызова метода swim
        }
        if (dog instanceof Runnable) {
            ((Runnable) dog).run(10); // Пример вызова метода run
        }

        sparrow.move();
        sparrow.makeSound();
        sparrow.sleep();
        sparrow.eat();
        sparrow.specialAction();
        if (sparrow instanceof Walkable) {
            ((Walkable) sparrow).toGo(15); // Пример вызова метода toGo
        }
        if (sparrow instanceof Flyable) {
            ((Flyable) sparrow).fly(25); // Пример вызова метода fly
        }
        if (sparrow instanceof Swimmable) {
            ((Swimmable) sparrow).swim(0); // Пример вызова метода swim
        }

        // Print information at the end
        cat.printInfo();
        dog.printInfo();
        sparrow.printInfo();

        System.out.println(cat);
        System.out.println(dog);
        System.out.println(sparrow);
    }
}
