package com.solvd.essay.patterns.strategyPattern;

public class Context {
    private StrategyBatch strategyBatch;

    public Context(StrategyBatch strategyBatch){
        this.strategyBatch=strategyBatch;
    }

    public String executeStrategy(Long id){
        return strategyBatch.findBatchById(id);
    }
}
