public class Blastoise extends Pokemon {

    Movimento espirroFrio = new Movimento("Espirro Frio", 0, "Gelo", true);
    Movimento cuspe = new Movimento("Cuspe", 30, "Água", false);
    Movimento chuvaMolhada = new Movimento("Chuva Molhada", 25, "Água", false);
    Movimento rioSaoFrancisco = new Movimento("Rio São Francisco", 30, "Água", false);


    //construtor
    public Blastoise(String nome, String tipoPoke, int vida, int level) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(cuspe, espirroFrio, chuvaMolhada, rioSaoFrancisco);
    }


    @Override
    public void atacar(Pokemon pokemonAdv, int dano, int indice) {


        if (this.getParalizado() <= 0) {
            if (this.getTipoPoke().equals("Agua") && pokemonAdv.getTipoPoke().equals("Fogo")) {
                System.out.println("O seu Ataque é Super Efetivo!");
                pokemonAdv.setVida(pokemonAdv.getVida() - dano * 2);
            } else if (this.getTipoPoke().equals("Agua") && pokemonAdv.getTipoPoke().equals("Pedra")) {
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
