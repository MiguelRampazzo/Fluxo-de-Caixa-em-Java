📁 Descrição dos Arquivos
Arquivos de Configuração e Raizpom.xml: Arquivo de configuração do Maven. Gerencia as dependências do projeto (como o driver JDBC para conexão com o banco de dados) e o processo de compilação.  

Main.java: Ponto de entrada (entry point) da aplicação. Apresenta a interface via terminal/CLI e gerencia as interações do usuário com o sistema. 

Camada de Modelo (model)

Lancamento.java: Classe que representa a entidade de domínio de um lançamento financeiro (com atributos como ID, descrição, valor, data e tipo). 

TipoLancamento.java: Enumeração que define a classificação do lançamento financeiro (RECEITA ou DESPESA).  

Camada de Dados e Persistência (db / dao)

ConnectionFactory.java: Classe responsável por gerenciar e fornecer as conexões JDBC com o banco de dados SQL.  

LancamentoDAO.java: Objeto de Acesso a Dados (Data Access Object). Contém os métodos SQL para persistir, consultar, atualizar e deletar lançamentos diretamente no banco de dados.  

Camada de Serviço (service)

LancamentoService.java: Contém a lógica de negócio da aplicação. Faz a ponte entre a interface (Main) e a persistência (LancamentoDAO), aplicando validações e cálculos (como o saldo do fluxo de caixa).  

Explicação Geral do Projeto :

Este projeto é um Sistema de Controle de Fluxo de Caixa desenvolvido em Java com gerenciamento de dependências via Apache Maven e integração com banco de dados relacional via JDBC. 

O código é estruturado seguindo o padrão de arquitetura em camadas (Layered Architecture / MVC - DAO Pattern), garantindo o isolamento entre a interface, a regra de negócio e o acesso aos dados:  

Gestão de Lançamentos: Permite ao usuário cadastrar novas movimentações financeiras, classificando-as explicitamente como Receitas (entradas) ou Despesas (saídas).  
Persistência Relacional: Utiliza o padrão DAO (LancamentoDAO) juntamente com uma fábrica de conexões (ConnectionFactory) para executar operações CRUD no banco de dados via JDBC.  
Cálculo de Balanço/Saldo: A camada de serviço (LancamentoService) consolida os registros para fornecer relatórios e saldos do fluxo de caixa (subtraindo as despesas do total de receitas).
