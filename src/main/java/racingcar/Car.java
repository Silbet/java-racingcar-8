package racingcar;

public class Car {
    private String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
        this.movedDistance = 0;
    }

    public void moveForward() {
        this.movedDistance++;
    }

}
