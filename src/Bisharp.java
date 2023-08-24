public class Bisharp extends Pokemon {

    Movimento escuridao = new Movimento("Escuridão", 30, "Sombrio", false);
    Movimento sombras = new Movimento("Sombras", 20, "Sombrio", false);
    Movimento punhoDeAco = new Movimento("Punho de Aço", 30, "Metal", false);
    Movimento almaCorrompida = new Movimento("Alma Corrompida", 20, "Sombrio", false);


    //construtor
    public Bisharp(String nome, String tipoPoke, int vida, int level) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(escuridao, sombras, punhoDeAco, almaCorrompida);
    }

    @Override
    void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            if (this.getTipoPoke().equals("Sombrio") && pokemonAdv.getTipoPoke().equals("Psiquico")) {
                System.out.println("O seu Ataque é Super Efetivo!");
                pokemonAdv.setVida(pokemonAdv.getVida() - dano * 2);
            } else if (this.getTipoPoke().equals("Sombrio") && pokemonAdv.getTipoPoke().equals("Fantasma")) {
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
