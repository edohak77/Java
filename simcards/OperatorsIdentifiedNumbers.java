package instigate.simcards;

import java.util.ArrayList;
import java.util.List;

public class OperatorsIdentifiedNumbers {
    private static List<String>bellineNumbersIdList;
    private List<String>mtsNumbersIdList;

    public OperatorsIdentifiedNumbers() {
        bellineNumbersIdList = new ArrayList<>();
        bellineNumbersIdList.add("+37499");
        bellineNumbersIdList.add("+37491");
        bellineNumbersIdList.add("+37443");
        bellineNumbersIdList.add("099");
        bellineNumbersIdList.add("091");
        bellineNumbersIdList.add("043");

        mtsNumbersIdList = new ArrayList<>();
        mtsNumbersIdList.add("+37493");
        mtsNumbersIdList.add("+37494");
        mtsNumbersIdList.add("+37477");
        mtsNumbersIdList.add("093");
        mtsNumbersIdList.add("094");
        mtsNumbersIdList.add("077");
    }

    public static List<String> getBellineNumbersIdList() {
        return bellineNumbersIdList;
    }

    public List<String> getMtsNumbersIdList() {
        return mtsNumbersIdList;
    }
}
