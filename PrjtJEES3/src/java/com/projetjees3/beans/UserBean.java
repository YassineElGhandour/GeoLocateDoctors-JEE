
package com.projetjees3.beans;

import java.util.ArrayList;

public class UserBean 
{
    private int idUserBean;

    public int getIdUserBean() {
        return idUserBean;
    }

    public void setIdUserBean(int idUserBean) {
        this.idUserBean = idUserBean;
    }


    private String email ;
    private String psw;
    private int NbreRow;
    private String firstName;
    private String lastName;
    public boolean valid;
    private String desc ;
    private String niveau ;
    private String nivUser;
    private String postAct;
    private String visibUser;

    public String getVisibUser() {
        return visibUser;
    }

    public void setVisibUser(String VisibUser) {
        this.visibUser = VisibUser;
    }
    

    public String getNivUser() {
        return nivUser;
    }

    public void setNivUser(String nivUser) {
        this.nivUser = nivUser;
    }

    public String getPostAct() {
        return postAct;
    }

    public void setPostAct(String postAct) {
        this.postAct = postAct;
    }
    private String dateN ;
    private String pays ;
    private int id ;
    private int nbMark;
    private String[][] liste;
    private int typeCherch;
    private ArrayList<UserBean> li;
    private String loc;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public ArrayList<UserBean> getLi() {
        return li;
    }

    public void setLi(ArrayList<UserBean> li) {
        this.li = li;
    }

    public int getTypeCherch() {
        return typeCherch;
    }

    public void setTypeCherch(int typeCherch) {
        this.typeCherch = typeCherch;
    }

    
    public String getEmail(){
        return email;
    }
    public String getPsw(){
        return psw;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public void setPsw(String newPsw){
        this.psw = newPsw;
    }
    public int getNbreRow() {
		return NbreRow;
	}
    public void setNbreRow(int nbreRow) {
	NbreRow = nbreRow;
    }
        public int getNbMark() {
		return nbMark;
	}
    public void setNbMark(int nbreM) {
	nbMark = nbreM;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
       lastName = newLastName;
    }
    public boolean isValid(){
        return valid;
    }
    public void setValid(boolean val){
        this.valid = val;
    }	
    public void setDesc(String newDesc) {
        desc = newDesc;
    }

    public String getDesc() {
        return desc;
    }
    public void setNiveau(String newNiv) {
        niveau = newNiv;
    }

    public String getNiveau() {
        return niveau;
    }
    public void setDateN(String newDate) {
        dateN = newDate;
    }

    public String getDateN() {
        return dateN;
    }
    public void setPays(String newPays) {
        pays = newPays;
    }

    public String getPays() {
        return pays;
    }
    public void setId(int newId) {
        id = newId;
    }

    public int getId() {
        return id;
    }
    public void setListe(String[][] newListe) {
        liste= newListe;
    }

    public String[][] getListe() {
        return liste;
    }
    
    
}
