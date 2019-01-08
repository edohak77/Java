package instigate.oopOnFullPower.absract;

import instigate.oopOnFullPower.absract.AnyAnimal;
import instigate.oopOnFullPower.enums.AnimalSize;
import instigate.oopOnFullPower.interfaces.AnimalBody;
import instigate.oopOnFullPower.interfaces.AnimalHead;
import instigate.oopOnFullPower.interfaces.AnimalLeg;

public class GroundAnimals extends AnyAnimal {
    static int groundAnimalcounter = 0;
    private AnimalLeg leg;

    public GroundAnimals(AnimalHead head, AnimalBody body, AnimalSize animalSize ,AnimalLeg leg) {
        super(head, body, animalSize);
        this.leg = leg;
        groundAnimalcounter++;
    }

    @Override
    public void action() {
        head.voice();
        body.isBody();
        leg.go();
    }
    public AnimalSize getSize(){
        return super.animalSize;
    }

    public static int getGroundAnimalcounter() {
        return groundAnimalcounter;
    }
}
