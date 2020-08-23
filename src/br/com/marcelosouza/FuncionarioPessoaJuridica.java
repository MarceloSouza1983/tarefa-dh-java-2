package br.com.marcelosouza;

// GitHub: MarceloSouza1983		e-mail: map.souza1983@gmail.com		Cel: (12) 98813-6040

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FuncionarioPessoaJuridica implements Funcionario {

	private String nome, endereco, profissao, cpf, cnpj, email, dataAdmissao, dataDemissao;
	private String horarioTrabalho;
	private boolean funcionarioAtivo, ferias;

	private double salario;
	private int setor;

	private List<LocalDate> admissao = new ArrayList<>();
	
	public static final double INSS_MEI = 0.97;
	public static final double FGTS_MEI = 0.92;

	public FuncionarioPessoaJuridica(String nome, String endereco, String profissao, String cpf, String cnpj, String email, String dataAdmissao, int setor, double salario, String horarioTrabalho) {
		this.nome = nome;
		this.endereco = endereco;
		
		if (profissao.equalsIgnoreCase("supervisor") || profissao.equalsIgnoreCase("gerente")) {
			System.out.println("Supervisor e gerente devem ser pessoas fisicas, modifique a profissao");
			System.out.println("O programa será finalizado.");
			System.exit(1);
		} else {
		this.profissao = profissao;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.email = email;
		this.dataAdmissao = dataAdmissao;
		this.setor = setor;
		setDataDemissao(dataDemissao);
		this.salario = salario;
		this.horarioTrabalho = horarioTrabalho;
		this.funcionarioAtivo = true;
		this.ferias = false;
		}
	}

	@Override
	public void trabalhar() {
		if (isFerias() == false) {
			System.out.println("Me chamo: " + getNome() + " sou " + getProfissao() + " e trabalho das " + getHorarioTrabalho() + "\n");
		} else {
			System.out.println(getNome() + " você está de férias e portanto não pode trabalhar.");
		}
	}

	@Override
	public void pedirDemissao() {
		if (isFuncionarioAtivo() == false) {
			System.out.println(getNome() + " você já se desligou da empresa.");
		} else {
			System.out.println(getNome() + ", entregue o pedido de demissão ao RH.");
		}
	}

	@Override
	public void solicitarAumento() {

		if (isFuncionarioAtivo() == true) {

			int numeroAleatorio = new Random().nextInt(10) +1;

			switch (numeroAleatorio) {
			case 8:
				System.out.println("Parabéns " + getNome() + "!!! Você ganhou 15% de aumento.");

				break;
			case 9:
				System.out.println("Parabéns " + getNome() + "!!! Você ganhou 10% de aumento.");

				break;
			case 10:
				System.out.println("Parabéns " + getNome() + "!!! Você ganhou 5% de aumento.");
				break;

			default:
				System.out.println(getNome() + " seu pedido de aumento foi recusado\n");
				break;
			}

		} else {
			System.out.println(getNome() + " você já se desligou da empresa.");
		}

	}

	@Override
	public void receberSalario(String data) {
		System.out.print(getNome() + " seu salário bruto é de R$" + getSalario() + " e será pago no dia " + data + "\n");
	}

	@Override
	public void consultarContraCheque() {
		double valorInss = calcularDescontoInss(getSalario());
		double valorFgts = calcularDescontoFgts(getSalario());
		double valorDescontado = getSalario() - (valorInss + valorFgts);
		
		String salarioFormatado = String.format("%.2f", + getSalario());
		String inssFormatado = String.format("%.2f", + valorInss);
		String fgtsFormatado = String.format("%.2f", + valorFgts);
		String descontoFormatado = String.format("%.2f", + valorDescontado);
		
		System.out.println("\n======== Incognitus S.A ========");
		System.out.println("Salário bruto: R$" + salarioFormatado);
		System.out.println("Desconto INSS: R$" + inssFormatado);
		System.out.println("Desconto FGTS: R$" + fgtsFormatado + "\n");
		System.out.println("Salário Líquido: R$" + descontoFormatado);
		System.out.println("================================\n");
	}

	@Override
	public void solicitarFerias(String dataFerias) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		// Convertendo String para LocalDate
		LocalDate localDateFerias = LocalDate.parse(dataFerias, formatador);
		LocalDate localDateAdmissao = LocalDate.parse(getDataAdmissao(), formatador);

		long quantidadeMeses = ChronoUnit.MONTHS.between(localDateAdmissao, localDateFerias);

		int ultimasFerias = admissao.size();

		if (localDateFerias.isEqual(LocalDate.now()) || localDateFerias.isAfter(LocalDate.now())) {
			System.out.println("A data das férias não pode ser igual ou maior que a data atual. Férias não autorizada.");
		} else {
			if (quantidadeMeses >= 11 && ultimasFerias == 0) {
				setFerias(true);
				admissao.add(localDateFerias);
				System.out.println("Suas férias foram autorizadas e começam em " + dataFerias + "\n");

			} else if (quantidadeMeses >= 11 && ultimasFerias >= 1) {
				LocalDate amountOfMonths = this.admissao.get(admissao.size()-1);
				long quantidade = ChronoUnit.MONTHS.between(amountOfMonths, localDateFerias);

				if (quantidadeMeses >= 11 && quantidade >= 4) {
					setFerias(true);
					admissao.add(localDateFerias);
					System.out.println("Suas férias foram autorizadas e começam em " + dataFerias + "\n");
				} else {
					System.out.println("Desculpe, você ainda não tem o tempo necessário para solicitar suas férias.");
				}
			} else {
				System.out.println("Desculpe, você ainda não tem o tempo necessário para solicitar suas férias.");
			}
		}
	}

	@Override
	public void voltarAoTrabalho() {
		setFerias(false);
		System.out.println(isFerias());
	}

	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cpf;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public String getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(String dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	@Override
	public int getSetor() {
		return setor;
	}

	public void setSetor(int setor) {
		this.setor = setor;
	}

	public boolean isFuncionarioAtivo() {
		return funcionarioAtivo;
	}

	public void setFuncionarioAtivo(boolean funcionarioAtivo) {
		this.funcionarioAtivo = funcionarioAtivo;
	}

	public boolean isFerias() {
		return ferias;
	}

	public void setFerias(boolean ferias) {
		this.ferias = ferias;
	}

	public List<LocalDate> getAdmissao() {
		return admissao;
	}

	public void setAdmissao(List<LocalDate> admissao) {
		this.admissao = admissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getHorarioTrabalho() {
		return horarioTrabalho;
	}

	public void setHorarioTrabalho(String horarioTrabalho) {
		this.horarioTrabalho = horarioTrabalho;
	}

	private double calcularDescontoInss(double salarioBruto) {
		return salarioBruto = getSalario() - (getSalario() * INSS_MEI);
	}
	
	private double calcularDescontoFgts(double salarioBruto) {
		return salarioBruto = getSalario() - (getSalario() * FGTS_MEI);
	}

	@Override
	public void alteraSalario(double valor) {
		setSalario(valor);
	}
	
	@Override
	public void alteraDataDemissao(String data) {
		setDataDemissao(data);
	}
	
	@Override
	public void alteraStatus() {
		this.funcionarioAtivo = false;
	}

}