package com.projetjees3.dao;


import java.util.List;
import com.projetjees3.beans.UserInsert;

public interface ChercheurDao 
{
    void ajouter(UserInsert chercheurAt);
    List<UserInsert> lister();
}