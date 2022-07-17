package com.adjusted.vaadin.groceryapp.ui.views;

public class TestClassDem extends AbstactTestClass {

    private  int variable;

    public TestClassDem(int variable) {
        super(variable);
        this.variable = variable;
    }

    public TestClassDem() {
        super(0);
        System.out.println("sadasdasd");
    }



    public int getVariable() {
        return variable;
    }

    public void setVariable(int variable) {
        this.variable = variable;
    }

    @Override
    public int getNumber() {
        return 5;
    }
}
