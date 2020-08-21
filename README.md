# Exercício Incognitous

## Desafio
Desenvolva um sistema para gerenciamento de pessoas em uma empresa.

A empresa Incognitous S.A. Decidiu informatizar a gestão de funcionários e contratou você para implementar um sistema levando em consideração as seguintes necessidades da mesma:

- Todo funcionário precisa ter cadastrado o seu
- endereço,
- nome,
- CPF,
- email,
- setor,
- data de admissão
- data de demissão.

Obrigatorio criar 2 classes distintas para Pessoa Fisica e Pessoa Juridica

- Os funcionários Pessoa Física devem ter o número da carteira de trabalho (NIT) no cadastro deles.

- Os funcionários Pessoa Jurídica precisam guardar o CNPJ.

- Todo funcionário receberá um salário base

- Todo funcionário poderá consultar o contra-cheque

- Supervisores e gerentes sempre serão do tipo de funcionário Pessoa Física.

- Supervisores e gerentes receberão uma bonificação.

- A bonificação padrão de um gerente é de 12% do seu salário.

- A bonificação padrão de um supervisor é de 8% do seu salário.

- Para um funcionário requisitar férias é necessário que o mesmo esteja na empresa há pelo menos 11 meses e que as últimas férias tenham sido tiradas há pelo menos 4 meses.

- um gerente pode demitir um funcionário ou um supervisor, mas não é possível demitir outro gerente.

- um gerente pode reajustar os salários de um funcionário ou de um supervisor, contanto que o reajuste não implique em redução do salário.

- Um supervisor pode demitir um funcionário, mas não pode demitir um gerente e nem outro supervisor.

- Um funcionário pode trabalhar, pedir demissão ou solicitar aumento (você precisará implementar uma lógica de escolha aleatória para que o aumento seja ou não aprovado).

- Funcionários em estado de férias não devem trabalhar.
Você está livre para implementar outros atributos e métodos nas classes considerando que estes não quebrem nenhuma regra de negócio explicita acima.