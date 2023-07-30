public class Kyogre extends Pokemons {
    Movimentos hidroAgua = new Movimentos("Hidro Água",40,"Agua");
    Movimentos bombaSplash = new Movimentos("Bomba Splash",25,"Agua");
    Movimentos tsunami = new Movimentos("Tsunami",30,"Agua");
    Movimentos ondaDoMar = new Movimentos("Onda do Mar",20,"Agua");


    //construtor
    public Kyogre(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(hidroAgua,bombaSplash,tsunami,ondaDoMar);
    }
}
