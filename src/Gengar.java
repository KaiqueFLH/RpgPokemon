public class Gengar extends Pokemon {
    Movimento berroFantasma = new Movimento("Berro Fantasma",20,"Fantasma",false);
    Movimento bolaSombria = new Movimento("Bola Sombria",30,"Fantasma",false);
    Movimento botaDormir = new Movimento("Bota pra Dormir",0,"Fantasma",true);
    Movimento maldicao = new Movimento("Maldição",30,"Fantasma",false);


    //construtor
    public Gengar(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(berroFantasma,bolaSombria,botaDormir,maldicao);
    }

    @Override
    public void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            if (this.getTipoPoke().equals("Fantasma") && pokemonAdv.getTipoPoke().equals("Psiquico")) {
                System.out.println("O seu Ataque é Super Efetivo!");
                pokemonAdv.setVida(pokemonAdv.getVida() - dano * 2);
            } else {
                pokemonAdv.setVida(pokemonAdv.getVida() - dano);
            }
            if (this.getMovimentosPoke().get(indice).isStatus()) {
                pokemonAdv.setParalizado(3);
            }
        }
        else{
            System.out.println("Paralizado!");
        }
    }

    @Override
    public String UpgradeLevel(Pokemon pokemon) {
        int qtdAdvAntigo = this.getQtdPokeAdvDerrotados();
        if (this.getQtdPokeAdvDerrotados() == qtdAdvAntigo+1){
            return this.getNome()+" Subiu para o level: " + this.getLevel();
        }
        else return null;
    }
}
