package com.company;

public class Controller {
    private final Model model;

    public Controller() {
        model = new Model();
    }

    public void setCircle(int x, int y) //put 0 in array
    {
        model.setCircle(x, y);
    }

    public void setCross(int x, int y)  //put 1 in array
    {
        model.setCross(x, y);
    }

    public boolean isCircleWinner() {
        return model.isCircleWinner();
    }

    public boolean isCrossWinner() {
        return model.isCrossWinner();
    }
}
