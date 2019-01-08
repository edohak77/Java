package instigate.oopOnFullPower.absract;

import instigate.oopOnFullPower.enums.AnimalSize;
import instigate.oopOnFullPower.interfaces.AnimalBody;
import instigate.oopOnFullPower.interfaces.AnimalHead;
import instigate.oopOnFullPower.interfaces.FishTail;

public class SeaAnimal extends AnyAnimal {
    static int seaAnimalsCounter = 0;
    private FishTail fishTail;

    public SeaAnimal(AnimalHead head, AnimalBody body, AnimalSize animalSize, FishTail fishTail) {
        super(head, body, animalSize);
        this.fishTail = fishTail;
        seaAnimalsCounter++;
    }

    @Override
    public void action() {
        head.voice();
        body.isBody();
        fishTail.diving();
    }

    public static int getSeaAnimalsCounter() {
        return seaAnimalsCounter;
    }
}
