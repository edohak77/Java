package springTerminal.lib;

import springTerminal.interfaces.CriticismEngine;

public aspect JudgeAspect {
    public JudgeAspect() {
    }

    pointcut inputung() : execution(* springTerminal.lib.ScanInput.input());
    after() returning() : inputing(){
        System.out.println(criticismEngine);
    }
    public CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine){
        this.criticismEngine = criticismEngine;
    }
}
