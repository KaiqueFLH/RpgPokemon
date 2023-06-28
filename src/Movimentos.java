public class Movimentos {

//    private String efeitoBoiola;

    //Criação dos atributos dos movimentos de cada pokemon
    private int dano;
    private String tipoDano;

    //construtor
    public Movimentos (int dano, String tipoDano){
        this.dano = dano;
        this.tipoDano = tipoDano;
    }


    @Override
    public String toString() {
        return "Movimentos{" +
                "dano=" + dano +
                ", tipoDano='" + tipoDano + '\'' +
                '}';
    }
}
