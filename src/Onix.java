public class Onix extends Pokemon {

    Movimento jogaRocha = new Movimento("Joga Rocha",20,"Pedra" ,false);
    Movimento pedraDura = new Movimento("Pedra Dura",30,"Pedra" ,false);
    Movimento pesoRocha = new Movimento("Peso Rocha",25,"Pedra" ,false);
    Movimento punhoRochoso = new Movimento("Punho Rochoso",15,"Pedra" ,false);


    //construtor
    public Onix(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(jogaRocha,pedraDura,pesoRocha,punhoRochoso);
    }

    @Override
    public void atacar(Pokemon pokemonAdv, int dano, int indice) {
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

    @Override
    public String upgradeLevel(Pokemon pokemon) {
        this.setLevel(this.getLevel()+1);
        return this.getNome() + " Subiu para o level: " + this.getLevel();

    }
}
