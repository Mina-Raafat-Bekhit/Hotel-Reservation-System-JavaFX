/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx;

/**
 *
 * @author Anton Hany
 */
public class User {
    String name;
    int id;
    int numroom;
    int numnights;

    public User(String name, int id, int numroom, int numnights) {
        this.name = name;
        this.id = id;
        this.numroom = numroom;
        this.numnights = numnights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumroom() {
        return numroom;
    }

    public void setNumroom(int numroom) {
        this.numroom = numroom;
    }

    public int getNumnights() {
        return numnights;
    }

    public void setNumnights(int numnights) {
        this.numnights = numnights;
    }
}
