package axel.control;

import axel.Observateur;
import axel.model.Etudiant;
import axel.model.Promotion;
import axel.view.Vue_Liste;
import axel.view.Vue_Principal;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by axell on 01/12/15.
 */
public class Contr_SuppListe extends AbstractControleur{

    private Vue_Liste view;

    public Contr_SuppListe(Promotion promotion, Vue_Liste view) {
        this.promotion = promotion;
        this.view = view;
    }

    @Override
    public void control(ArrayList<String> list) {
        if(list!=null) {
            String all_etu = "";
            Etudiant etu;
            for (int i = 0; i < list.size(); i++) {
                etu = promotion.searchEtudiant(list.get(i));
                promotion.removeEtudiant(etu);
                all_etu += etu + "\n";
            }
            if (list.size() < 2) {
                JOptionPane.showMessageDialog(view, "L'étudiant :\n" + all_etu + " a été supprimé.");
            } else {
                JOptionPane.showMessageDialog(view, "Les étudiants :\n" + all_etu + "ont été supprimés.");
            }
        }else {
            JOptionPane.showMessageDialog(view, "Aucun étudiant n'a été selectionné.");
        }

    }
}