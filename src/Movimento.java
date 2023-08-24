public class Movimento {


    //Criação dos atributos dos movimentos de cada pokemon
    private int dano;
    private String tipoDano;
    private String nomeMov;
    private boolean status;

    //construtor
    public Movimento(String nomeMov, int dano, String tipoDano, boolean status){
        this.nomeMov = nomeMov;
        this.dano = dano;
        this.tipoDano = tipoDano;
        this.status = status;
    }

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //============================================================================================================================================




    @Override
    public String toString() {
        return nomeMov+": {" +
                "Dano:" + dano +
                ", tipoDano='" + tipoDano + '\'' +"}";
    }
}
