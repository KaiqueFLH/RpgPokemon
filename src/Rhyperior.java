public class Rhyperior extends Pokemon {
    Movimento pedraRolante = new Movimento("Pedra Rolante",30,"Pedra",false);
    Movimento tempestadeTerrosa = new Movimento("Tempestade Terrosa",25,"Pedra",false);
    Movimento esmagar = new Movimento("Esmagar",25,"Pedra",false);
    Movimento explosaoDePedra = new Movimento("Explosão de Pedra",30,"Pedra",false);


    //construtor
    public Rhyperior(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(pedraRolante,tempestadeTerrosa,esmagar,explosaoDePedra);
    }

    @Override
    void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            if (this.getTipoPoke().equals("Pedra") && pokemonAdv.getTipoPoke().equals("Fogo")) {
                System.out.println("O seu Ataque é Super Efetivo!");
                pokemonAdv.setVida(pokemonAdv.getVida() - dano * 2);
            } else {
                pokemonAdv.setVida(pokemonAdv.getVida() - dano);
            }
        }
        else{
            System.out.println("Paralizado!");
        }
    }
}
