/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Models;

/**
 *
 * @author asus
 */
public class Coordonnees {

    private int x;
    private int y;

    public Coordonnees(int pX, int pY) {
        this.x = pX;
        this.y = pY;
    }

    // vérifier si les coordonnées de la tondeuse après mouvement sont en dehors de celles de la pelouse
    public boolean isHorsCoordonnesMax(Coordonnees pCoordonnees) {
        return pCoordonnees.getX() >= 0
                && pCoordonnees.getY() >= 0
                && pCoordonnees.getX() <= this.x
                && pCoordonnees.getY() <= this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Coordonnees other = (Coordonnees) obj;
        if (x != other.x || y != other.y) {
            return false;
        }

        return true;
    }
}
