public class Charizard extends Pokemon {

    Movimento rajadaDeFogo = new Movimento("Rajada de Fogo",20,"Fogo",false);
    Movimento vortexInfernal = new Movimento("Vortex Infernal",30,"Fogo",false);
    Movimento espirroQuente = new Movimento("Espirro Quente",25,"Fogo",false);
    Movimento labaredaFlamejante = new Movimento("Labareda Flamejante",15,"Fogo",false);
    //construtor
    public Charizard(String nome, String tipoPoke,int vida,int level){
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(rajadaDeFogo,vortexInfernal,espirroQuente,labaredaFlamejante);
    }

    @Override
    public void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            if (this.getTipoPoke().equals("Fogo") && pokemonAdv.getTipoPoke().equals("Planta")) {
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
        this.setLevel(this.getLevel()+1);
        return this.getNome() + " Subiu para o level: " + this.getLevel();

    }
}
