package br.edu.faculdadealfa.projectfolhaofi.model.Enuns;

public enum TipoFolha {
	SALARIO("SAL�RIO"),
	FERIAS("F�RIAS"),
	DECIMOTERCEIRO("D�CIMO TERCEIRO");
	
	private String descricao;
	 //renomeia o enum
    TipoFolha(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
    
}
