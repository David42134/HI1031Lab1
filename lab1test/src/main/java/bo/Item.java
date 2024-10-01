package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {
    private String name;
    private String descr;
    private int id;

    static public Collection searchItems(String group){
        return ItemDB.searchItems(group);
    }

    protected Item(int id, String name, String descr){
        this.id = id;
        this.name = name;
        this.descr = descr;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescr() {
        return this.descr;
    }
}
