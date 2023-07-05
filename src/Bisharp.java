import java.util.ArrayList;

public class Bisharp extends Pokemons {

    Movimentos escuridao = new Movimentos("Escuridão",30,"Sombrio");
    Movimentos sombras = new Movimentos("Sombras",20,"Sombrio");
    Movimentos punhoDeAco = new Movimentos("Punho de Aço",30,"Metal");
    Movimentos almaCorrompida = new Movimentos("Alma Corrompida",20,"Sombrio");


    //construtor
    public Bisharp(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(escuridao,sombras,punhoDeAco,almaCorrompida);
    }

    //função de atacar;
    @Override
    void atacar() {

    }


}
