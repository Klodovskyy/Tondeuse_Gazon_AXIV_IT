/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Traitements;

import java.util.ArrayList;
import java.util.List;

import tondeuse_gazon_axiv_it.Models.Coordonnees;
import tondeuse_gazon_axiv_it.Models.Parametres.InstructionTondeuse;
import tondeuse_gazon_axiv_it.Models.Parametres.Orientation;
import tondeuse_gazon_axiv_it.Models.Pelouse;
import tondeuse_gazon_axiv_it.Models.Position_Tondeuse;

/**
 *
 * @author asus
 */
public class Formater_ligne {

    private static final String CHAINE_ESPACE = " ";

    private Formater_ligne() {

    }
        //récuperer la position de la tondeuse qui est définit par ses coordonnées et son orientation
    
    public static Position_Tondeuse formaterLigneTondeuse(String ligneTondeuse) {
        String[] elts = ligneTondeuse.split(CHAINE_ESPACE);
        Coordonnees pCoordonneesTondeuse = new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
        Orientation orientationTondeuse = getOrientation(elts[2].charAt(0));
        return new Position_Tondeuse(pCoordonneesTondeuse, orientationTondeuse);
    }
        //récuperer l'objet Pelouse contenant les coordonnées limites de la pelouse
    
    public static Pelouse formaterLignePelouse(String lignePelouse) {
        String[] elts = lignePelouse.split(CHAINE_ESPACE);
        return new Pelouse(new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
    }
        //récuperer une liste d'enum InstructionTondeuse correspondante à la ligne d'instruction
    public static List<InstructionTondeuse> formaterLigneInstruction(String ligneInstruction) {
        List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
        for (char instruction : ligneInstruction.toCharArray()) {
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }
       //récuperer un enum Orientation correspondant au caractère de l'orientation
    
    public static Orientation getOrientation(char cOrientation) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getCodeOrientation() == cOrientation) {
                return orientation;
            }
        }
        return null;
    }
        //récuperer une liste d'enum InstructionTondeuse correspondante à la ligne d'instruction
    
    public static InstructionTondeuse getInstruction(char cInstruction) {
        for (InstructionTondeuse instruction : InstructionTondeuse.values()) {
            if (instruction.getCodeInstruction() == cInstruction) {
                return instruction;
            }
        }
        return null;
    }
}
