package br.com.marcelosouza;

// GitHub: MarceloSouza1983		e-mail: map.souza1983@gmail.com		Cel: (12) 98813-6040

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FuncionarioPessoaFisica implements Funcionario {

	private String nome, endereco, profissao, cpf, email, dataAdmissao, dataDemissao, nit;
	private String horarioTrabalho;

	private boolean funcionarioAtivo, ferias;

	private int setor;
	private double salario;

	private List<LocalDate> admissaopf = new ArrayList<>();

	public static final double BONUS_GERENTE = 0.88;
	public static final double BONUS_SUPERVISOR = 0.92;

	public static final double DESCONTO_INSS_FAIXA_SUPERALTA = 0.86;
	public static final double DESCONTO_INSS_FAIXA_ALTA = 0.88;
	public static final double DESCONTO_INSS_FAIXA_MEDIA = 0.91;
	public static final double DESCONTO_INSS_FAIXA_BAIXA = 0.925;

	public static final double DESCONTO_IRPF_FAIXA_SUPERALTA = 0.725;
	public static final double DESCONTO_IRPF_FAIXA_ALTA = 0.775;
	public static final double DESCONTO_IRPF_FAIXA_MEDIA = 0.85;
	public static final double DESCONTO_IRPF_FAIXA_BAIXA = 0.925;

	public FuncionarioPessoaFisica(String nome, String endereco, String profissao, String cpf, String email, String dataAdmissao, int setor, String nit, double salario, String horarioTrabalho) {
		this.nome = nome;
		this.endereco = endereco;
		this.profissao = profissao;
		this.cpf = cpf;
		this.email = email;
		this.dataAdmissao = dataAdmissao;
		this.setor = setor;
		this.nit = nit;
		this.salario = salario;
		this.horarioTrabalho = horarioTrabalho;
		setDataDemissao(dataDemissao);
		this.funcionarioAtivo = true;
		this.ferias = false;
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

	public void reajustarSalario(Funcionario funcionario, double valor, String data) {
		if (getProfissao().equalsIgnoreCase("gerente")) {

			if (funcionario.getProfissao().equalsIgnoreCase("gerente")) {
				System.out.println("Você não está autorizado a reajustar salários de Gerentes.\n");
			} else {

				if (valor < 0) {
					valor = valor * (-1);

					double salarioReajustado = funcionario.getSalario() + valor;
					String textoFormatado = String.format("%.2f", + salarioReajustado);
					System.out.print(funcionario.getNome() + " seu novo salário será de R$" + textoFormatado + " a partir de " + data + "\n");
					funcionario.alteraSalario(salarioReajustado);

				} else {

					double salarioReajustado = funcionario.getSalario() + valor;

					String textoFormatado = String.format("%.2f", + salarioReajustado);
					System.out.print(funcionario.getNome() + " seu novo salário será de R$" + textoFormatado + " a partir de " + data + "\n");
					funcionario.alteraSalario(salarioReajustado);

				}

			}

		} else {
			System.out.println("Você não está autorizado a reajustar salários.\n");
		}
	}

	public void demitir(Funcionario funcionario) {

		if (funcionario.isFuncionarioAtivo() == true) {

			LocalDate data = LocalDate.now();

			if (getProfissao().equalsIgnoreCase("supervisor")) {

				if (funcionario.getProfissao().equalsIgnoreCase("gerente") || funcionario.getProfissao().equalsIgnoreCase("supervisor")) {
					System.out.println("Você não está autorizado a demitir Gerentes ou Supervisores.\n");
				} else {

					String dataFomatada = data.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));

					System.out.print(funcionario.getNome() + " você será desligado do nosso quadro de colaboradores a partir de " + dataFomatada + "\n");
					funcionario.alteraDataDemissao(dataFomatada);
					funcionario.alteraStatus();

				}
				
			} else if (getProfissao().equalsIgnoreCase("gerente")) {
				
				if (funcionario.getProfissao().equalsIgnoreCase("gerente")) {
					System.out.println("Você não está autorizado a demitir outros Gerentes.\n");
				} else {
					
					String dataFomatada = data.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));

					System.out.print(funcionario.getNome() + " você será desligado do nosso quadro de colaboradores a partir de " + dataFomatada + "\n");
					funcionario.alteraDataDemissao(dataFomatada);
					funcionario.alteraStatus();
				}

			} else {
				System.out.println(getNome() + " você não tem autorização para demitir funcionários.");
			}
		}

		System.out.println(getNome() + ", o funcionário " + funcionario.getNome() + " já se desligou da empresa.");

	}


	@Override
	public void receberSalario(String data) {
		System.out.print(getNome() + " seu salário bruto é de R$" + getSalario() + " e será pago no dia " + data + "\n");
	}

	public void receberBonificacao(String data) {
		if (getProfissao().equalsIgnoreCase("gerente") || getProfissao().equalsIgnoreCase("supervisor")) {

			if (getProfissao().equalsIgnoreCase("gerente")) {
				double bonus = getSalario() - (getSalario() * BONUS_GERENTE);
				String textoFormatado = String.format("%.2f", + bonus);
				System.out.print(getNome() + " seu bônus é de R$" + textoFormatado + " e será pago no dia " + data + "\n");

			} else if (getProfissao().equalsIgnoreCase("supervisor")) {
				double bonus = getSalario() - (getSalario() * BONUS_SUPERVISOR);
				String textoFormatado = String.format("%.2f", + bonus);
				System.out.print(getNome() + " seu bônus é de R$" + textoFormatado + " e será pago no dia " + data + "\n");
			} 

		} else {
			System.out.println("Você não está autorizado a receber bonificações.\n");
		}
	}

	@Override
	public void consultarContraCheque() {
		double valorInss = calcularDescontoInss(getSalario());
		double valorIrpf = calcularDescontoIrpf(getSalario());
		double valorDescontado = getSalario() - (valorInss + valorIrpf);

		String salarioFormatado = String.format("%.2f", + getSalario());
		String inssFormatado = String.format("%.2f", + valorInss);
		String irpfFormatado = String.format("%.2f", + valorIrpf);
		String descontoFormatado = String.format("%.2f", + valorDescontado);

		System.out.println("\n======== Incognitus S.A ========");
		System.out.println("Salário bruto: R$" + salarioFormatado);
		System.out.println("Desconto INSS: R$" + inssFormatado);
		System.out.println("Desconto IRPF: R$" + irpfFormatado + "\n");
		System.out.println("Salário Líquido: R$" + descontoFormatado);
		System.out.println("================================\n");
	}

	private double calcularDescontoInss(double salarioBruto) {

		if (getSalario() <= 1045.00) {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_INSS_FAIXA_BAIXA);
		} else if (getSalario() <= 2089.60) {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_INSS_FAIXA_MEDIA);
		} else if (getSalario() <= 3134.40) {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_INSS_FAIXA_ALTA);
		}else {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_INSS_FAIXA_SUPERALTA);
		}

	}

	private double calcularDescontoIrpf(double salarioBruto) {

		if (getSalario() <= 1903.98) {
			return salarioBruto = 0;
		} else if (getSalario() <= 2826.65) {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_IRPF_FAIXA_BAIXA);
		} else if (getSalario() <= 3751.05) {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_IRPF_FAIXA_MEDIA);
		} else if (getSalario() <= 4664.68) {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_IRPF_FAIXA_ALTA);
		}	else {
			return salarioBruto = getSalario() - (getSalario() * DESCONTO_IRPF_FAIXA_SUPERALTA);
		}

	}

	@Override
	public void solicitarFerias(String dataFerias) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		LocalDate localDateFerias = LocalDate.parse(dataFerias, formatador);
		LocalDate localDateAdmissao = LocalDate.parse(getDataAdmissao(), formatador);

		long quantidadeMeses = ChronoUnit.MONTHS.between(localDateAdmissao, localDateFerias);

		int ultimasFerias = admissaopf.size();

		if (localDateFerias.isEqual(LocalDate.now()) || localDateFerias.isAfter(LocalDate.now())) {
			System.out.println("A data das férias não pode ser igual ou maior que a data atual. Férias não autorizada.");
		} else {
			if (quantidadeMeses >= 11 && ultimasFerias == 0) {
				setFerias(true);
				admissaopf.add(localDateFerias);
				System.out.println("Suas férias foram autorizadas e começam em " + dataFerias + "\n");

			} else if (quantidadeMeses >= 11 && ultimasFerias >= 1) {
				LocalDate amountOfMonths = this.admissaopf.get(admissaopf.size()-1);
				long quantidade = ChronoUnit.MONTHS.between(amountOfMonths, localDateFerias);

				if (quantidadeMeses >= 11 && quantidade >= 4) {
					setFerias(true);
					admissaopf.add(localDateFerias);
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
		return profissao.toUpperCase();
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

	public List<LocalDate> getAdmissaopf() {
		return admissaopf;
	}

	public void setAdmissaopf(List<LocalDate> admissaopf) {
		this.admissaopf = admissaopf;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	@Override
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