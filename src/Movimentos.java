public class Movimentos {


    //Criação dos atributos dos movimentos de cada pokemon
    private int dano;
    private String tipoDano;
    private String nomeMov;

//============================================================================================================================================

//    GETTERS E SETTERS

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getTipoDano() {
        return tipoDano;
    }

    public void setTipoDano(String tipoDano) {
        this.tipoDano = tipoDano;
    }

    public String getNomeMov() {
        return nomeMov;
    }

    public void setNomeMov(String nomeMov) {
        this.nomeMov = nomeMov;
    }

    //============================================================================================================================================

    //construtor
    public Movimentos (String nomeMov,int dano, String tipoDano){
        this.nomeMov = nomeMov;
        this.dano = dano;
        this.tipoDano = tipoDano;
    }


    @Override
    public String toString() {
        return nomeMov+": {" +
                "Dano:" + dano +
                ", tipoDano='" + tipoDano + '\'' +"}";
    }
}
