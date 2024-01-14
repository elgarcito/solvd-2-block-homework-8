package com.solvd.essay.patterns.facadePattern;

public class ExternalInfoFactory {
    private Client client;
    private LabVisitor labVisitor;

    public ExternalInfoFactory(){
        client=new Client();
        labVisitor=new LabVisitor();
    }

    public void obtainLabVisitorInfo(LabVisitor labVisitor){
        labVisitor.obtainExternalInfo(labVisitor);
    }


    public void obtainClientInfo(Client client){
        client.obtainExternalInfo(client);
    }
}
