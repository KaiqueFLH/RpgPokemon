public class Rhyperior extends Pokemons{
    Movimentos pedraRolante = new Movimentos("Pedra Rolante",30,"Pedra");
    Movimentos tempestadeTerrosa = new Movimentos("Tempestade Terrosa",25,"Pedra");
    Movimentos esmagar = new Movimentos("Esmagar",25,"Pedra");
    Movimentos explosaoDePedra = new Movimentos("Explosão de Pedra",30,"Pedra");


    //construtor
    public Rhyperior(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(pedraRolante,tempestadeTerrosa,esmagar,explosaoDePedra);
    }
}
