public class Gyarados extends Pokemon {
    Movimento tempestade = new Movimento("Tempestade",20,"Agua",false);
    Movimento torneiraAberta = new Movimento("Torneira Aberta",25,"Agua",false);
    Movimento surfar = new Movimento("Surfar",30,"Agua",false);
    Movimento rastroAquatico = new Movimento("Rastro Aquático",30,"Agua",false);


    //construtor
    public Gyarados(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(tempestade,torneiraAberta,surfar,rastroAquatico);
    }

    @Override
    void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            if (pokemonAdv.getTipoPoke().equals("Fogo")) {
                System.out.println("O seu Ataque é Super Efetivo!");
                pokemonAdv.setVida(pokemonAdv.getVida() - dano * 2);
            } else if (pokemonAdv.getTipoPoke().equals("Pedra")) {
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
