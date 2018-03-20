package com.projetjees3.beans;


public class RechBean 
{
    private int idRech;
    private String nomRech;
    private String descRech;
    private String uniRech;
    private String terrainRech;
    private String laboRech;
    private String paysRech;
    private String motsCleRech;
    private String nomUser;
    private String prenomUser;
    private String locRech;

    public String getLocRech() {
        return locRech;
    }

    public void setLocRech(String locRech) {
        this.locRech = locRech;
    }

    /* GETTERS AND SETTERS*/

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

   
    
    //Nom de la recherche
    
    //Getter
    public String getNomRech() {
        return nomRech;
    }

    //Setter
    public void setNomRech(String nomRech) {
        this.nomRech = nomRech;
    }

    
    //Description de la recherche
    
    //Getter
    public String getDescRech() {
        return descRech;
    }

    //Setter
    public void setDescRech(String descRech) {
        this.descRech = descRech;
    }
    
    
    //Uni
     public String getUniRech() {
        return uniRech;
    }

    public void setUniRech(String uniRech) {
        this.uniRech = uniRech;
    }

    
    //Terrain
    public String getTerrainRech() {
        return terrainRech;
    }

    public void setTerrainRech(String terrainRech) {
        this.terrainRech = terrainRech;
    }

    
    //Laboratoire
    public String getLaboRech() {
        return laboRech;
    }

    public void setLaboRech(String laboRech) {
        this.laboRech = laboRech;
    }

    
    //Pays de recherche
    public String getPaysRech() {
        return paysRech;
    }

    public void setPaysRech(String paysRech) {
        this.paysRech = paysRech;
    }

    //Mots-clés
    public String getMotsCleRech() {
        return motsCleRech;
    }

    public void setMotsCleRech(String motsCleRech) {
        this.motsCleRech = motsCleRech;
    }

        public int getIdRech() {
        return idRech;
    }

    public void setIdRech(int idRech) {
        this.idRech = idRech;
    }


}
