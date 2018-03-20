package com.projetjees3.beans;


public class UserInsert 
{

    private int idUser;

    public int getIdUser() 
    {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    private String nomCherch;
    private String prenomCherch;
    private String emailCherch;
    private String numTelCherch;
    private String pswCherch;
    private String visibCherch;
    private String descCherch;
    private String dateNaissCherch;
    private String nivCherch;
    private String paysOrgCherch;
    private String postActCherch;
    private String type_cherch;
    private String mark;

    /** GETTERS & SETTER
     * @return S**/
    
    //Email
    public String getEmailCherch() {
        return emailCherch;
    }

    public void setEmailCherch(String emailCherch) {
        this.emailCherch = emailCherch;
    }

    //Phone Number
    public String getNumTelCherch() {
        return numTelCherch;
    }

    public void setNumTelCherch(String numTelCherch) {
        this.numTelCherch = numTelCherch;
    }

    //Password
    public String getPswCherch() {
        return pswCherch;
    }

    public void setPswCherch(String pswCherch) {
        this.pswCherch = pswCherch;
    }

    //Visibilité (boolean): 1 visible, 0 sinon
    public String getVisibCherch() {
        return visibCherch;
    }

    public void setVisibCherch(String visibCherch) {
        this.visibCherch = visibCherch;
    }

    //Description
    public String getDescCherch() {
        return descCherch;
    }

    public void setDescCherch(String descCherch) {
        this.descCherch = descCherch;
    }

    //Date de naissance
    public String getDateNaissCherch() {
        return dateNaissCherch;
    }

    public void setDateNaissCherch(String dateNaissCherch) {
        this.dateNaissCherch = dateNaissCherch;
    }

    //Niveau de Scholarité
    public String getNivCherch() {
        return nivCherch;
    }

    public void setNivCherch(String nivCherch) {
        this.nivCherch = nivCherch;
    }

    
    //Pays d'origine
    public String getPaysOrgCherch() {
        return paysOrgCherch;
    }

    public void setPaysOrgCherch(String paysOrgCherch) {
        this.paysOrgCherch = paysOrgCherch;
    }
    //Type du chercheur
    public String getType_cherch() {
        return type_cherch;
    }

    public void setType_cherch(String type_cherch) {
        this.type_cherch = type_cherch;
    }
    
    //Position Actuelle
    public String getPostActCherch() {
        return postActCherch;
    }

    public void setPostActCherch(String postActCherch) {
        this.postActCherch = postActCherch;
    }
    
    //Nom
    public String getNomCherch() {
        return nomCherch;
    }

    public void setNomCherch(String nomCherch) throws BeanException
    {
        if(nomCherch.length() > 10)
        {
            throw new BeanException("Le nom ne doit pas dépasser 10 caractères");
        }
        
        else
        {
            this.nomCherch = nomCherch;
        }
    }

    //Prenom
    public String getPrenomCherch() {
        return prenomCherch;
    }

    public void setPrenomCherch(String prenomCherch) throws BeanException
    {
        if(prenomCherch.length() > 10)
        {
            throw new BeanException("Le prenom ne doit pas dépasser 10 caractères");
        }
        
        else
        {
            this.prenomCherch = prenomCherch;
        }
    }
    
    //Mouse MARK   
    public String getMark(){
        return mark;
    }
    public void setMark(String newMark){
        this.mark = newMark;
    }

 
}
