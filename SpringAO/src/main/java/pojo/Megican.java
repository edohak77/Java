package pojo;

import interfaces.MindReader;

public class Megican implements MindReader {
    private String thougthts;

    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteers`s thoughts");
        this.thougthts = thoughts;
    }

    @Override
    public String getToughth() {
        return thougthts;
    }
}
