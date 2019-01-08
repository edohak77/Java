package instigate.oopOnFullPower.enums;

public enum AnimalSize {


    SMALL(10),
    LOW(50),
    BIG(100),
    BIGGER(200);

    int size;

    AnimalSize(int size) {
        this.size = size;
    }
}
