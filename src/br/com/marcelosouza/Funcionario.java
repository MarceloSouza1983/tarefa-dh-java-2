package br.com.marcelosouza;

// GitHub: MarceloSouza1983		e-mail: map.souza1983@gmail.com		Cel: (12) 98813-6040

public interface Funcionario {
	
	public void trabalhar();
	public void pedirDemissao();
	public void solicitarAumento();
	
	public String getNome();
	public String getProfissao();
	public String getEndereco();
	public String getEmail();
	public String getDataAdmissao();
	public String getDataDemissao();
	public double getSalario();
	public int getSetor();
	public void receberSalario(String data);
	public void consultarContraCheque();
	public void solicitarFerias(String dataFerias);
	public void voltarAoTrabalho();
	
	public void alteraSalario(double valor);
	
}