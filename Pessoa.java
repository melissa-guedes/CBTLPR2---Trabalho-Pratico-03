public class Pessoa {

    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        // quando cria uma pessoa, o contador aumenta
        kp++;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this(); // chama o construtor vazio → incrementa kp
        setNome(nome);
        setSexo(sexo);
        setIdade(idade);
    }

    // por exigência do enunciado (mas não deve ser usado)
    public static void setKp(int valor) {
        if (valor >= 0)
            kp = valor;
    }

    public static int getKp() {
        return kp;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório.");
        }
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        if (sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f') {
            throw new IllegalArgumentException("Sexo deve ser M/m ou F/f.");
        }
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida.");
        }
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}

