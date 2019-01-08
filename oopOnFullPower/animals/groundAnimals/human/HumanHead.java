package instigate.oopOnFullPower.animals.groundAnimals.human;

import instigate.oopOnFullPower.interfaces.AnimalHead;

public class HumanHead implements AnimalHead {
    @Override
    public void voice() {
        System.out.println("Human: - Hello!");
    }
}
