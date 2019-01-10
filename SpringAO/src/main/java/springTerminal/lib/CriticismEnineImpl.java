package springTerminal.lib;

import springTerminal.interfaces.CriticismEngine;

public class CriticismEnineImpl implements CriticismEngine {
    private String[] criticismPool;
    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    public String[] getCriticismPool() {
        return criticismPool;
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
