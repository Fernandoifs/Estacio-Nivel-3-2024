package cadastrobd.model;


public class Pessoa {

    private int idpessoa;
    private String nome;
    private int logradouro;
    private int cidade;
    private int estado;
    private String telefone;
    private String email;

    public Pessoa() {
    }

    public Pessoa(int idpessoa, String nome, int logradouro, int cidade, int estado, String telefone, String email) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }

    public void exibir() {
        System.out.println("ID: " + idpessoa);
        System.out.println("Nome: " + nome);
        System.out.println("Logradouro: " + logradouro);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }

    public int getId() {
        return idpessoa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(int logradouro) {
        this.logradouro = logradouro;
    }
    public int getCidade() {
        return cidade;
    }
    public void setCidade(int cidade) {
        this.cidade = cidade;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
