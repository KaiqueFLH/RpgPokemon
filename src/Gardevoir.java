public class Gardevoir extends Pokemon {

    Movimento recuperarVida = new Movimento("Glitter", 20, "Fada", false);
    Movimento raioPsiquico = new Movimento("Raio Psíquico", 30, "Psiquico", false);
    Movimento rajadaLunar = new Movimento("Rajada Lunar", 25, "Psiquico", false);
    Movimento luzRuinas = new Movimento("Luz das Ruínas", 15, "Psiquico", false);


    //construtor
    public Gardevoir(String nome, String tipoPoke, int vida, int level) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(recuperarVida, raioPsiquico, rajadaLunar, luzRuinas);
    }

    @Override
    void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            if (this.getTipoPoke().equals("Psiquico") && pokemonAdv.getTipoPoke().equals("Lutador")) {
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
