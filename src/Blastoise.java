import java.util.ArrayList;

public class Blastoise extends Pokemons {

    Movimentos cuspe = new Movimentos("Cuspe",20,"Água");
    Movimentos aguaMole = new Movimentos("Espirro Frio",30,"Água");
    Movimentos chuvaMolhada = new Movimentos("Chuva Molhada",25,"Água");
    Movimentos rioSaoFrancisco = new Movimentos("Rio São Francisco",30,"Água");


    //construtor
    public Blastoise(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(cuspe,aguaMole,chuvaMolhada,rioSaoFrancisco);
    }

}
