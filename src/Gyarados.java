public class Gyarados extends Pokemons{
    Movimentos tempestade = new Movimentos("Tempestade",20,"Agua");
    Movimentos torneiraAberta = new Movimentos("Torneira Aberta",25,"Agua");
    Movimentos surfar = new Movimentos("Surfar",30,"Agua");
    Movimentos rastroAquatico = new Movimentos("Rastro Aquático",30,"Agua");


    //construtor
    public Gyarados(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(tempestade,torneiraAberta,surfar,rastroAquatico);
    }
}
