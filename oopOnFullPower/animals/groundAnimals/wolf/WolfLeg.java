package instigate.oopOnFullPower.animals.groundAnimals.wolf;

import instigate.oopOnFullPower.interfaces.AnimalLeg;

public class WolfLeg implements AnimalLeg {
    @Override
    public void go() {
        System.out.println("Wolf leg: - Wolf is go...");
    }
}
