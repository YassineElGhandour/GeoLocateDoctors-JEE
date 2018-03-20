package com.projetjees3.dao;

import com.projetjees3.beans.RechBean;
import com.projetjees3.beans.ThemeBean;
import com.projetjees3.beans.UserInsert;
import java.util.List;


public interface ChercheurDaoMark 
{
    void ajouter(UserInsert chercheur, String idU,int idRech);
    void ajouterRech(RechBean recherche, ThemeBean theme, UserInsert chercheur,int idRech);
    List<UserInsert> lister();
}
