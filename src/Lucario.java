public class Lucario extends Pokemons{
    Movimentos socoExplosivo = new Movimentos("Soco Explosivo",35,"Lutador");
    Movimentos chuteGiratorio = new Movimentos("Chute Giratório",20,"Lutador");
    Movimentos rasteira = new Movimentos("Soco Explosivo",25,"Lutador");
    Movimentos soco = new Movimentos("Soco",15,"Lutador");


    //construtor
    public Lucario(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(socoExplosivo,chuteGiratorio,rasteira,soco);
    }
}
