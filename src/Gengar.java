public class Gengar extends Pokemons{
    Movimentos berroFantasma = new Movimentos("Berro Fantasma",20,"Fantasma");
    Movimentos bolaSombria = new Movimentos("Bola Sombria",30,"Fantasma");
    Movimentos comedorDeSonhos = new Movimentos("Comedor de Sonhos",25,"Fantasma");
    Movimentos maldicao = new Movimentos("Maldição",30,"Fantasma");


    //construtor
    public Gengar(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(berroFantasma,bolaSombria,comedorDeSonhos,maldicao);
    }
}
