package instigate.oopOnFullPower.absract;

import instigate.oopOnFullPower.enums.AnimalSize;
import instigate.oopOnFullPower.interfaces.Animal;
import instigate.oopOnFullPower.interfaces.AnimalBody;
import instigate.oopOnFullPower.interfaces.AnimalHead;

public abstract class AnyAnimal implements Animal {
    static int allAnimalsCount = 0;
    protected AnimalHead head;
    protected AnimalBody body;
    protected AnimalSize animalSize;

    public AnyAnimal(AnimalHead head, AnimalBody body, AnimalSize animalSize) {
        this.head = head;
        this.body = body;
        this.animalSize = animalSize;
        allAnimalsCount ++;
    }

    public static int getAllAnimalsCount() {
        return allAnimalsCount;
    }
}
