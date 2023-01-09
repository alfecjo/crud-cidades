package br.edu.utfpr.cp.espjava.crudcidades.cidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public final class Cidade {

    public Cidade(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    @NotBlank(message = "{app.cidade.blank}")
    @Size(min = 5, max = 60, message = "{app.cidade.size}")
    private final String nome;

    @NotBlank(message = "{app.estado.blank}")
    @Size(min = 2, max = 2, message = "{app.estado.size}")
    private final String estado;

    public String getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public CidadeEntidade clonar() {
        var cidadeEntidade = new CidadeEntidade();

        cidadeEntidade.setNome(this.getNome());
        cidadeEntidade.setEstado(this.getEstado());

        return cidadeEntidade;
    }

    public static Cidade clonar(CidadeEntidade cidadeEntidade) {

        return new Cidade(cidadeEntidade.getNome(), cidadeEntidade.getEstado());
    }
}