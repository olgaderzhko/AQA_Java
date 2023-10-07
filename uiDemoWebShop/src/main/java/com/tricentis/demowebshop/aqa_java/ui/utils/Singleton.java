package com.tricentis.demowebshop.aqa_java.ui.utils;

/**
 * @author Derzhko.O
 */
public class Singleton {
    private  static Singleton instance;
    private Singleton(){}
    static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return  instance;
    }
}
