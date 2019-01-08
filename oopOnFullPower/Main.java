package instigate.oopOnFullPower;

import instigate.oopOnFullPower.absract.GroundAnimals;
import instigate.oopOnFullPower.absract.SeaAnimal;
import instigate.oopOnFullPower.animals.groundAnimals.horse.HorseBody;
import instigate.oopOnFullPower.animals.groundAnimals.horse.HorseHead;
import instigate.oopOnFullPower.animals.groundAnimals.horse.HorseLeg;
import instigate.oopOnFullPower.animals.groundAnimals.human.HumanBody;
import instigate.oopOnFullPower.animals.groundAnimals.human.HumanHead;
import instigate.oopOnFullPower.animals.groundAnimals.human.HumanLeg;
import instigate.oopOnFullPower.animals.groundAnimals.wolf.WolfBody;
import instigate.oopOnFullPower.animals.groundAnimals.wolf.WolfHead;
import instigate.oopOnFullPower.animals.groundAnimals.wolf.WolfLeg;
import instigate.oopOnFullPower.animals.seaAnimals.acule.AculeBody;
import instigate.oopOnFullPower.animals.seaAnimals.acule.AculeHead;
import instigate.oopOnFullPower.animals.seaAnimals.acule.AculeTail;
import instigate.oopOnFullPower.animals.seaAnimals.kit.KitBody;
import instigate.oopOnFullPower.animals.seaAnimals.kit.KitHead;
import instigate.oopOnFullPower.animals.seaAnimals.kit.KitTail;
import instigate.oopOnFullPower.enums.AnimalSize;

public class Main {
    public static void main(String[] args) {
        //----------------ground Animals objectes----------------------
        //wolf
        WolfHead wolfHead = new WolfHead();
        WolfBody wolfBody = new WolfBody();
        WolfLeg wolfLeg = new WolfLeg();
        //Human
        HumanHead humanHead = new HumanHead();
        HumanBody humanBody = new HumanBody();
        HumanLeg humanLeg = new HumanLeg();
        //Horse
        HorseHead horseHead =new HorseHead();
        HorseBody horseBody = new HorseBody();
        HorseLeg horseLeg = new HorseLeg();

        //------------sea animals objects -----------------------------
        //Acule
        AculeHead aculeHead = new AculeHead();
        AculeBody aculeBody = new AculeBody();
        AculeTail aculeTail = new AculeTail();
        //Kit
        KitHead kitHead = new KitHead();
        KitBody kitBody = new KitBody();
        KitTail kitTail = new KitTail();

        //Born Animals
        GroundAnimals wolf = new GroundAnimals(wolfHead,wolfBody, AnimalSize.LOW,wolfLeg);
        GroundAnimals mutant = new GroundAnimals(wolfHead,humanBody,AnimalSize.BIG,horseLeg);
        GroundAnimals kentavr = new GroundAnimals(humanHead,horseBody,AnimalSize.LOW,horseLeg);

        SeaAnimal acule = new SeaAnimal(aculeHead, aculeBody,AnimalSize.BIG,aculeTail);
        SeaAnimal seamutant = new SeaAnimal(aculeHead,kitBody,AnimalSize.BIGGER,kitTail);
        SeaAnimal acvamen = new SeaAnimal(humanHead,kitBody,AnimalSize.LOW,aculeTail);

        //my animals is action
        wolf.action();
        System.out.println("---------------------------");
        mutant.action();
        System.out.println("---------------------------");
        kentavr.action();
        System.out.println("---------------------------");
        acule.action();
        System.out.println("---------------------------");
        seamutant.action();
        System.out.println("---------------------------");
        acvamen.action();

        //inResults
        System.out.println("**************************************************");
        System.out.println("ALL any animal is: " + GroundAnimals.getAllAnimalsCount());
        System.out.println("Ground animals is: " + GroundAnimals.getGroundAnimalcounter());
        System.out.println("SeaAnimal is: " + SeaAnimal.getSeaAnimalsCounter());

    }
}
