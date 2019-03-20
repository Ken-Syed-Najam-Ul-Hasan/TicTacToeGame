package com.company;

public class Controller {
    private Model M;

    public Controller()
    {
        M=new Model();
    }
    public boolean setCircle(int x,int y) //put 0 in array
    {
        return M.setCircle(x,y);
    }
    public boolean setCross(int x,int y)  //put 1 in array
    {
        return M.setCross(x,y);
    }
    public boolean isCircleWinner()
    {
       return M.isCircleWinner();
    }
    public boolean isCrossWinner()
    {
        return M.isCrossWinner();
    }
}
