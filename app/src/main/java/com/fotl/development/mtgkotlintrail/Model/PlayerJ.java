package com.fotl.development.mtgkotlintrail.Model;

public class PlayerJ {    private String  _name;
    private int     _lifeTotal, _infectCounter, _cmdDmgCounter;

    public PlayerJ(String name, int lifeTotal, int infectCounter, int cmdDmgCounter){
        _name = name;
        _lifeTotal = lifeTotal;
        _infectCounter = infectCounter;
        _cmdDmgCounter = cmdDmgCounter;
    }

    //region get/set

    public String get_name(){
        return _name;
    }

    public void set_name(String _name){
        this._name = _name;
    }

    public int get_lifeTotal(){
        return _lifeTotal;
    }

    public void set_lifeTotal(int _lifeTotal){
        this._lifeTotal = _lifeTotal;
    }

    public int get_infectCounter(){
        return _infectCounter;
    }

    public void set_infectCounter(int _infectCounter){
        this._infectCounter = _infectCounter;
    }

    public int get_cmdDmgCounter(){
        return _cmdDmgCounter;
    }

    public void set_cmdDmgCounter(int _cmdDmgCounter){
        this._cmdDmgCounter = _cmdDmgCounter;
    }

    //endregion
}