public class Rayquaza extends Pokemons{
    Movimentos pulsoDragao = new Movimentos("Pulso do Dragão",20,"Dragao");
    Movimentos bafoDoDragao = new Movimentos("Bafo do Dragão",25,"Dragao");
    Movimentos labaredaFlamejante = new Movimentos("Labareda Flamejante",15,"Dragao");
    Movimentos velocidadeDraconica = new Movimentos("Velocidade Dracônica",45,"Dragao");


    //construtor
    public Rayquaza(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(pulsoDragao,velocidadeDraconica,bafoDoDragao,labaredaFlamejante);
    }
}
