package com.example.kangjisung.likeroom.CustomClass;

import android.content.Context;

/**
 * Created by Ahn on 2016-12-22.
 */

public class ColorTheme
{
    private static Context context;
    private static String nowTheme;
    //private static List<String> listTheme = new List<String>{"Bread", "Ocean"};

    ColorTheme(Context current){
        this.context = current;
    }

    public static void setTheme(String _theme)
    {
        nowTheme = _theme;
    }

    /**
    public static String setColor()
    {

    }
    */
}
