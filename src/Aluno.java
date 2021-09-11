import java.util.Date;

public class Aluno {

    private long id;
    private Date nascimento;
    private String ra;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  "ID=" + id +
                "; \nNascimento=" + nascimento +
                ", \nra='" + ra + '\'' +
                ", \nnome='" + nome + '\'' ;

    }
}
