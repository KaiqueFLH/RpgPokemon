public class Venussaur extends Pokemon {

    Movimento matinhosCortantes = new Movimento("Matinhos Cortantes",20,"Planta",false);
    Movimento pinicar = new Movimento("Pinicar",30,"Planta",false);
    Movimento soneca = new Movimento("Soneca",0,"Sleep" ,true);
    Movimento pauBrasil = new Movimento("Pau Brasil",30,"Planta",false);


    //construtor
    public Venussaur(String nome, String tipoPoke, int vida, int level) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(matinhosCortantes,pinicar,soneca,pauBrasil);
    }

    @Override
    public void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            if (this.getTipoPoke().equals("Planta") && pokemonAdv.getTipoPoke().equals("Pedra")) {
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
