package com.company;

public class Model {
    private int arr[][];

    public Model(){
        this.arr=new int[3][3];
    }
    public boolean isCircleWinner()
    {
        if(arr[0][0]==-1&&arr[0][1]==-1&&arr[0][2]==-1)
        {
            return true;
        }
        else if(arr[1][0]==-1&&arr[1][1]==-1&&arr[1][2]==-1)
        {
            return true;
        }
        else if(arr[2][0]==-1&&arr[2][1]==-1&&arr[2][2]==-1)
        {
            return true;
        }
        else if(arr[0][0]==-1&&arr[1][1]==-1&&arr[2][2]==-1)
        {
            return true;
        }
        else if(arr[0][2]==-1&&arr[1][1]==-1&&arr[2][0]==-1)
        {
            return true;
        }
        else if(arr[0][0]==-1&&arr[1][0]==-1&&arr[2][0]==-1)
        {
            return true;
        }
        else if(arr[0][1]==-1&&arr[1][1]==-1&&arr[2][1]==-1)
        {
            return true;
        }
        else if(arr[0][2]==-1&&arr[1][2]==-1&&arr[2][2]==-1)
        {
            return true;
        }
        return false;
    }

    public boolean isCrossWinner()
    {
        if(arr[0][0]==1&&arr[0][1]==1&&arr[0][2]==1)
        {
            return true;
        }
        else if(arr[1][0]==1&&arr[1][1]==1&&arr[1][2]==1)
        {
            return true;
        }
        else if(arr[2][0]==1&&arr[2][1]==1&&arr[2][2]==1)
        {
            return true;
        }
        else if(arr[0][0]==1&&arr[1][1]==1&&arr[2][2]==1)
        {
            return true;
        }
        else if(arr[0][2]==1&&arr[1][1]==1&&arr[2][0]==1)
        {
            return true;
        }
        else if(arr[0][0]==1&&arr[1][0]==1&&arr[2][0]==1)
        {
            return true;
        }
        else if(arr[0][1]==1&&arr[1][1]==1&&arr[2][1]==1)
        {
            return true;
        }
        else if(arr[0][2]==1&&arr[1][2]==1&&arr[2][2]==1)
        {
            return true;
        }
        return false;
    }
    public boolean setCircle(int r,int c) //put 0 in array
    {
        try{
            arr[r][c]=-1;
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean setCross(int r,int c)  //put 1 in array
    {
        try{
            arr[r][c]=1;
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

}
