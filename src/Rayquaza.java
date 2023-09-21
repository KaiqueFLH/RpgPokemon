public class Rayquaza extends Pokemon {
    Movimento pulsoDragao = new Movimento("Pulso do Dragão",20,"Dragao",false);
    Movimento bafoDoDragao = new Movimento("Bafo do Dragão",25,"Dragao",false);
    Movimento labaredaFlamejante = new Movimento("Labareda Flamejante",15,"Dragao",false);
    Movimento velocidadeDraconica = new Movimento("Velocidade Dracônica",45,"Dragao",false);


    //construtor
    public Rayquaza(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(pulsoDragao,velocidadeDraconica,bafoDoDragao,labaredaFlamejante);
    }

    @Override
    public void atacar(Pokemon pokemonAdv, int dano, int indice) {
        if (this.getParalizado() <= 0) {
            pokemonAdv.setVida(pokemonAdv.getVida() - dano);
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
