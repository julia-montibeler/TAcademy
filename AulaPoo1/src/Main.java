public class Main {
    public static void main(String[] args) {
        int idade;
        Animal a = new Animal();
        a.nome = "Cachorro";
        System.out.println(a.nome);
        a.mamifero = true;

        Animal a2 = new Animal();
        a2.nome = "Gato";
        a2.peso = 12;
        a2.mamifero = true;

        Animal a3 = new Animal("Tubarão", 1.6, false);

        //abstrair a entidade aluno
        //criar atributos, construtores
        //Criar 3 instâncias da classe aluno
        //desafio: salvar as 3 instâncias em um vetor do tipo aluno

    }
}
