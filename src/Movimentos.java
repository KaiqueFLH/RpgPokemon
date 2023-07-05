public class Movimentos {

//    private String efeitoBoiola;

    //Criação dos atributos dos movimentos de cada pokemon
    private int dano;
    private String tipoDano;
    private String nomeMov;

    //construtor
    public Movimentos (String nomeMov,int dano, String tipoDano){
        this.nomeMov = nomeMov;
        this.dano = dano;
        this.tipoDano = tipoDano;
    }


    @Override
    public String toString() {
        return nomeMov+" {" +
                "dano=" + dano +
                ", tipoDano='" + tipoDano + '\'' +
                '}';
    }
}
