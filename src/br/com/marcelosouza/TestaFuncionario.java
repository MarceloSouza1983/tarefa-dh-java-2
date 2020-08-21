package br.com.marcelosouza;

// GitHub: MarceloSouza1983		e-mail: map.souza1983@gmail.com		Cel: (12) 98813-6040

public class TestaFuncionario {

	public static void main(String[] args) {
		
		// nome, endereco, profissao, cnpj, email, dataAdmissao
		
		FuncionarioPessoaFisica func1 = new FuncionarioPessoaFisica("Marcelo", "Avenida 9 de Julho", "superVIsor", "333.333.333-33", "marcelo@incognotous.com", "20/08/2020", 1, "133444231", 5000.00, "8:00 às 17:00");
		FuncionarioPessoaFisica func2 = new FuncionarioPessoaFisica("Rodolfo", "Avenida 9 de Julho", "gerente", "444.333.333-44", "rodolfo@incognotous.com", "02/01/2000", 2, "177455271", 5000.00, "13:00 às 21:00");
		FuncionarioPessoaFisica func3 = new FuncionarioPessoaFisica("Carlos", "Avenida 9 de Julho", "GERENTE", "555.333.333-55", "carlos@incognotous.com", "03/01/2005", 3, "193444281", 5500.00, "8:00 às 17:00");
		FuncionarioPessoaFisica func4 = new FuncionarioPessoaFisica("Marcos", "Avenida 9 de Julho", "GerentE", "666.333.333-66", "marcos@incognotous.com", "05/01/2015", 4, "213444261", 6500.00, "8:00 às 17:00");
		FuncionarioPessoaFisica func5 = new FuncionarioPessoaFisica("João", "Avenida 9 de Julho", "advogado", "777.333.333-77", "joao@incognotous.com", "07/01/2017", 5,"233444299", 4200.40, "13:00 às 21:00");
		
		FuncionarioPessoaJuridica func6 = new FuncionarioPessoaJuridica("Diego", "Avenida 9 de Julho", "operador", "751.343.353-81", "diego@incognotous.com", "09/01/2018", 6, 10000.00, "13:00 às 21:00");
		
		
		/*func1.trabalhar();
		System.out.println(func1.isFerias());
		
		func1.solicitarFerias("20/08/2020");
		
		System.out.println(func1.isFerias());
		
		func1.trabalhar();
		
		//System.out.println(func1.admissao.contains());
		
		func1.admissao.forEach(admissao -> System.out.println(admissao.toString())); */
		
		
		/*func2.solicitarFerias("02/01/2001");
		
		func2.voltarAoTrabalho();
		
		func2.solicitarFerias("02/01/2002");
		
		func2.voltarAoTrabalho();
		
		func2.solicitarFerias("02/01/2003");
		
		func2.voltarAoTrabalho();
		
		func2.solicitarFerias("02/01/2004");
		
		func2.voltarAoTrabalho();
		
		func2.solicitarFerias("02/01/2005");
		
		func2.trabalhar();
		
		func2.solicitarFerias("02/04/2005");
		
		System.out.println(func2.isFerias());
		//func2.trabalhar(); */
		
		
		//func1.solicitarFerias("21/08/2020");
		
		//System.out.println(func1.getDataAdmissao());
		//func2.admissao.forEach(admissao -> System.out.println(admissao));
		
		//func1.demitir("333.333.333-33");
		//func2.demitir("333.333.333-33");
		
		//func1.receberBonificacao("21/08/2020");
		//func2.receberBonificacao("21/08/2020");
		
		//func5.receberBonificacao("21/08/2020");
		
		func6.receberSalario("21/08/2020");
		
		/////////////////////////////////////////////////////////////////////////////
		// Verificando metodo reajustar salarios
		
		// func1 supervisor  func2, func3 gerente e func5 advogado (PF)   func6 operador (PJ)
		
		// Gerente nao reajusta salario pois o outro funcionario é gerente
		func2.reajustarSalario(func3, 350.00, "21/08/2020");
		
		// Gerente reajusta salario pois o outro funcionario é supervisor
		func2.reajustarSalario(func1, 350.00, "21/08/2020");
		System.out.println(func1.getSalario());
		
		// Gerente reajusta salario pois o outro funcionario é advogado
		func2.reajustarSalario(func5, 350.60, "21/08/2020");
		
		// Gerente reajusta salario de Pessoa Juridica - operador
		func2.reajustarSalario(func6, -350.60, "21/08/2020");
		
		
		func6.consultarContraCheque();
		
		
		
		func5.consultarContraCheque();
		
		FuncionarioPessoaFisica func8 = new FuncionarioPessoaFisica("João", "Avenida 9 de Julho", "advogado", "777.333.333-77", "joao@incognotous.com", "07/01/2017", 5,"233444299", 1900.40, "13:00 às 21:00");
		func8.consultarContraCheque();
		
		
		//FuncionarioPessoaJuridica funcpj7 = new FuncionarioPessoaJuridica("Gabriel", "Rua das Oliveiras", "supervisor", "345637655", "map.bastos@gmail.com", "21/08/2020", 3, 3500, "13:00 às 21:00");
		
		//funcpj7.trabalhar();
		
		

	}

}