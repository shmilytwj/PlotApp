package com.example.curvedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    private int change=1;
    private double Largen=1;
    private double Lessen=1;
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String getStrFunction() {
        return strFunction;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setStrFunction(String strFunction) {
        this.strFunction = strFunction;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public double getLargen() {
        return Largen;
    }

    public void setLargen(double largen) {
        Largen = largen;
    }

    public double getLessen() {
        return Lessen;
    }

    public void setLessen(double lessen) {
        Lessen = lessen;
    }

    String strFunction;
    String str;

    @Override
    protected void onDraw(Canvas canvas) {
        Rect rect=new Rect();
        rect.left=0;
        rect.top=0;
        rect.right = getWidth();
        rect.bottom=getHeight();

        Axis axis=new Axis(rect);
        axis.setChange(getChange());
        axis.setLargen(getLargen());
        axis.setLessen(getLessen());
        axis.draw(canvas);
        if(strFunction!="" || strFunction.length()!=0) {
            Plot plot = new Plot(axis, strFunction, "x");
            plot.draw(canvas);
        }
        if(str!="" || str.length()!=0) {
            Plot plot = new Plot(axis, str, "x");
            plot.draw(canvas);
        }


    }
}
