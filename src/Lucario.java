public class Lucario extends Pokemon {
    Movimento socoExplosivo = new Movimento("Soco Explosivo", 35, "Lutador",false);
    Movimento chuteGiratorio = new Movimento("Chute Giratório", 20, "Lutador",false);
    Movimento rasteira = new Movimento("Soco Explosivo", 25, "Lutador",false);
    Movimento soco = new Movimento("Soco", 15, "Lutador",false);


    //construtor
    public Lucario(String nome, String tipoPoke, int vida, int level) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(socoExplosivo, chuteGiratorio, rasteira, soco);
    }

    @Override
    void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            pokemonAdv.setVida(pokemonAdv.getVida() - dano);
        }
        else{
            System.out.println("Paralizado!");
        }
    }
}
