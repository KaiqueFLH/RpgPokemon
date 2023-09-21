public class Kyogre extends Pokemon {
    Movimento hidroAgua = new Movimento("Hidro Água",40,"Agua",false);
    Movimento bombaSplash = new Movimento("Bomba Splash",25,"Agua",false);
    Movimento tsunami = new Movimento("Tsunami",30,"Agua",false);
    Movimento ondaDoMar = new Movimento("Onda do Mar",20,"Agua",false);


    //construtor
    public Kyogre(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(hidroAgua,bombaSplash,tsunami,ondaDoMar);
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
