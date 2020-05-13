package br.edu.faculdadealfa.projectfolhaofi.model.Enuns;

public enum TipoFolha {
	SALARIO("SALÁRIO"),
	FERIAS("FÉRIAS"),
	DECIMOTERCEIRO("DÉCIMO TERCEIRO");
	
	private String descricao;
	 //renomeia o enum
    TipoFolha(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
    
}
