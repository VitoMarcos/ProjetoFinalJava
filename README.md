# ProjetoFinalJava
Requisitos:

1.Java Development Kit (JDK) 8 ou superior.

2.Um ambiente de desenvolvimento Java.

execução:

1. Clone o repositório para o seu ambiente local.

2. Importe o projeto para o seu ambiente de desenvolvimento.

3. Navegue até o diretório src dentro do pacote UP BET.

4. Execute a classe principal "App.java".

Repositório da avaliação final da matéria de Desenvolvimento de Software da Universidade Positivo  
Casa de apostas UP BET.

Plataforma desenvolvida em linguagem Java, com o intuito de simular um sistema de apostas.
No qual poderão ser cadastrados usuários (apostadores) e administradores, que terão por sua vez funções exclusivas para cada usuário.

estrutura:

Classes e Suas Funções
Diretório: src
App.java

Função: Classe principal que inicia a aplicação. Contém o método main que é o ponto de entrada do programa.
Console.java

Função: Classe responsável por manipular a entrada e saída de dados no console. Provavelmente inclui métodos para leitura de entradas do usuário e exibição de mensagens.
Sistema.java

Função: Classe que representa o sistema principal da aplicação. Provavelmente gerencia a lógica principal do programa, inicializando e controlando outras partes do sistema.
Pacote: Classes/Aposta
Aposta.java

Função: Classe que representa uma aposta. Contém atributos e métodos relacionados às apostas, como valor, odds (probabilidades), e possivelmente o estado da aposta (ativa, vencida, perdida, etc.).
CadastrarApostas.java

Função: Classe responsável pelo cadastro de novas apostas. Provavelmente contém métodos para adicionar novas apostas ao sistema.
CadastrarEvento.java

Função: Classe responsável pelo cadastro de novos eventos esportivos. Contém métodos para adicionar eventos que os usuários podem apostar.
Evento.java

Função: Classe que representa um evento esportivo. Inclui atributos como nome do evento, data, equipes participantes, e status do evento (ativo, finalizado, etc.).
GerirAposta.java

Função: Classe para gerenciar apostas existentes. Inclui métodos para atualizar, remover e consultar apostas.
GerirEventos.java

Função: Classe para gerenciar eventos esportivos. Contém métodos para adicionar, atualizar, remover e listar eventos.
Pacote: Classes/Esporte
Esporte.java

Função: Classe abstrata para esportes. Provavelmente define atributos e métodos comuns a todos os tipos de esportes (ex: nome do esporte, regras básicas, etc.).
Futebol.java

Função: Classe que representa o esporte futebol. Herda de Esporte.java e inclui atributos e métodos específicos para o futebol, como número de jogadores, regras específicas, etc.
Pacote: Classes/Pessoa
Administrador.java

Função: Classe que representa um administrador. Contém atributos e métodos específicos para um administrador do sistema, como permissões de gerenciamento avançadas.
GerirUsuarios.java

Função: Classe para gerenciar usuários da plataforma. Inclui métodos para adicionar, remover, atualizar e listar usuários.
Pessoa.java

Função: Classe abstrata para pessoas. Define atributos e métodos comuns a todas as pessoas (ex: nome, CPF, data de nascimento, etc.).
Usuario.java

Função: Classe que representa um usuário comum da plataforma. Herda de Pessoa.java e pode incluir métodos e atributos específicos para um usuário, como saldo da conta, histórico de apostas, etc.
Pacote: Times
Resultados.java

Função: Classe para gerenciar resultados dos times em eventos esportivos. Contém métodos para registrar e consultar resultados dos jogos.
Time.java

Função: Classe que representa um time esportivo. Inclui atributos como nome do time, jogadores, técnico, e métodos para manipular esses dados.
TimeA.java

Função: Classe que representa um time específico (ex: Time A). Provavelmente herda de Time.java e pode incluir atributos ou métodos específicos para esse time.
TimeB.java

Função: Classe que representa um time específico (ex: Time B). Semelhante ao TimeA.java, herda de Time.java e pode ter características específicas.

após selecionar seu tipo de usuário, sera necessário fornecer um nome e um e-mail para cadastro.

Funcionalidades de administrador: 

Criar Evento: Permite cadastrar novos eventos esportivos, adicionando 2 times e seus respectivos ODD's (a cotação de cada time em uma aposta).
Listar Eventos: Permite listar os eventos criados anteriormente.
Atualizar Eventos: Atualizar os eventos criados anteriormente.
Excluir Evento: Permite excluir eventos existentes.
Voltar para o Menu Principal: Retorna a tela de escolha de usuário.

Funcionalidades de apostador: 

Apostar: Permite ao apostador escolher um evento e realizar sua aposta.
Ver Apostas: Permite o apostador Visualizar as apostas feita anteriormente.
Gerenciar saldo: Adiciona valores ao seu saldo inicial de 50,00 para que possa utilizar nas apostas.
Ver resultados: Permite visualizar os resultados dos eventos adicionados pelo administrador.
Voltar para o Menu Principal: Retorna a tela de escolha de usuário.

Sobre o uso de IA: 
IA utilizada de forma a sanar duvidas do grupo a respeito do projeto.
