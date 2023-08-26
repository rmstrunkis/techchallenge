<html>
   <head></head>
   <body >
<h1 align="center"> <strong> Tech Challenge - Painel de Consumo de Energia</strong> </h1>

![Portal de Consumo de Energia](https://github.com/rmstrunkis/tech_challenge/assets/105131830/c0e3a5f4-0e07-447e-896e-3e3f2dee760d)

<h2><strong>Descrição do projeto</strong></h2>
<p>Projeto Tech Challenge - FIAP Alura - 2º Fase</p>
<p>APIs que serão disponibilizadas para um portal que irá demonstrar ao usuário o consumo de energia de seus eletrodomésticos.</p>

<p> * Endereços</p>
<p> * Pessoas</p>
<p> * Eletrodomésticos</p>

<p>Neste momento as APIs irão fornecer todos os métodos de um CRUD, Relacionamentos entre si, Filtros diversos de pesquisas sobre os dados de Endereços, Pessoas e Eletrodomésticos.</p>


<p> Após construimos na 1º Fase do projeto 3 APIs apenas com ações do método\verbo POST, sendo que 2 estavam persistindo em  banco de memória H2 e uma em collection do tipo SET, nesta 2º Fase estamos agora persistindo em um banco de dados relacional confiável, criamos em todas as APIs os demais métodos que compõe um CRUD (GET,POST,UPDATE,DELETE), relacionamentos entre as entidades utlizando a framework do JPA e o ambiente de execução com Docker, para estes temas adicionais acrescentamos em nosso README os capitulos\tópicos abaixo com os detalhes do que utilizamos, motivações e dificuldades :</p>

<p> * Banco de Dados</p>
<p> * JPA</p>
<p> * Docker</p>



<h2><strong>Funcionalidades e Demonstração da Aplicação - 2º Item do Entregável</strong></h2>
<p></p>
<p>Baixar via GIT : git clone https://github.com/rmstrunkis/techchallenge.git</p> 
<p>Executar em máquina local : na linha de comando ir até a pasta que clonou o projeto e no prompt da linha de comando, executar: mvn compile.</p> 
<p>Executar em máquina local : na linha de comando ir até a pasta que clonou o projeto e no prompt da linha de comando, executar: mvn spring-boot:run.</p> 
<p>Colocar como utilizar o docker .</p> 
<p></p>

<h3><strong>API Usuários</strong></h3>
<p></p>
<p>Funcionalidades: CRUD de Usuários</p>
<p>Header da Requisição: ApplicattionType/JSON demais atributos vazios</p>
<p>Body da Requisição: Formato JSON, exemplo no swagger da aplicação</p>
<p>Swagger da aplicação local: http://localhost:8080/swagger-ui/#/usuario-controller/ </p>
<p>URL Local:http://localhost:8080/usuarios</p>
<p></p>

<h3><strong>API Pessoas</strong></h3>
<p></p>
<p>Funcionalidades: CRUD de Pessoas relacionadas ao usuário</p>
<p>Header da Requisição: ApplicattionType/JSON demais atributos vazios</p>
<p>Body da Requisição: Formato JSON, exemplo no swagger da aplicação</p>
<p>Swagger da aplicação local: http://localhost:8080/swagger-ui/#/pessoa-controller/</p>
<p>URL Local:http://localhost:8080/pessoas</p>
<p></p>

<h3><strong>API Endereços</strong></h3>
<p></p>
<p>Funcionalidades: CRUD de Endereços relacionados aos usuários</p>
<p>Header da Requisição: ApplicattionType/JSON demais atributos vazios</p>
<p>Body da Requisição: Formato JSON, exemplo no swagger da aplicação</p>
<p>URL Local:http://localhost:8080/enderecos</p>
<p>Swagger da aplicação: http://localhost:8080/swagger-ui/#/endereco-controller/</p>

<p></p>

<h3>API Eletrodomesticos</h3>
<p></p>
<p>Funcionalidade : CRUD de Eletrodomesticos relacionados aos endereços</p>
<p>Header da Requisição: ApplicattionType/JSON demais atributos vazios</p>
<p>Body da Requisição: Formato JSON, exemplo no swagger da aplicação</p>
<p>URL Local:http://localhost:8080/eletrodomestico</p>
<p>Swagger da aplicação: http://localhost:8080/swagger-ui/#/eletrodomestico-controller/</p>]

<p></p>
<h2><strong>Tecnologias Utilizadas</strong></h2>

<p></p>
<p>Liguagem: Java versão 11</p>

<p>Arquitetura: MVC - Model View Controller</p>
<p>Frameworks e Bibliotecas: Spring Boot versão: 2.7.12 , LOMBOK versão default para a versão do Spring, Bean Validation versão default para a versão do Spring, JPA</p>
<p>Ferramentas Colaborativas: Docker,Postman,GIT,Maven e Swagger</p>
<p>Banco de Dados: POSTGRES </p>
<p></p>


<h2><strong>Relatório Técnico - 3º Item do Entregável</strong></h2>
<p></p>
<p>O objetivo deste tópico é explicar as motivações e desafios das técnicas e tecnologias aplicadas nesta fase do Tech Challenge.</p>
<p></p>
<h3><strong>Spring Boot E API REST</strong></h3>
<p></p>
<p> A Framework Spring é Open Source e foi criado pela PIVOTAL com o objetivo de facilitar o desenvolvimento de sistemas, descomplicando toda a parte de infraestrutura e algumas outras complexidades que existe na especificação JAVA EE.</p>
<p></p>
<p>A Framework Spring Boot é uma versão reduzida da Spring, ideal para o desevolvimento de aplicações WEB stand alone de forma rápida e simples, foi baseada no conceito de Injeção de Dependências e Inversão de Controle o que torna o código mais coeso e com menos acoplamento entre as classes, além de gerenciar bem todas as dependências iniciais internas e externas, ter de forma embracada o servidor de aplicação, sendo por padrão o Apache-Tomcat, mas podemos usar outros como o Jetty e Undertown , durante a descrição deste documento iremos registrar aonde são aplicados estes conceitos e facilidades com base em anotações e na estruturação das camadas, sendo estes o principais motivos de optarmos por esta framework.</p>
<p></p>
<p>Internamente o Spring Boot possui 4 componentes chaves na sua execução:</p>
<p>1 - Spring Boot Starter: Utiliza a combinação de várias dependências para formar uma unica</p>
<p>2 - Spring Boot CLI: software responsável por rodar e testar as aplicações na linha de comando para isto executando o Spring Boot Starter e o Spring Boot Autocofigurator</p>
<p>3 - Spring Boot Autocofigurator: Gerencia as configurações de uma aplicação</p>
<p>4 - Spring Boot Acutator: Prover o endpoints e as métricas da aplicação</p>
<p></p>
<p> APIs (Application Programming Interface) é o meio utilizado para que diversas aplicações possam se comunicar e para isto algumas regras são necessárias de acordo com cada tipo : SOAP, RPC, WebSocket e REST.</p>
<p>No nosso caso optamos pela padrão REST (Representational State Transfer), por ser hoje o modelo mais utilizado e simples, utilizando o protocolo HTTP e o formato JSON (JavaScript Object Notation - Notação de Objetos JavaScript) para trafegar as informações, sendo uma formatação leve e com muitas bibiliotecas para utilização nas mais diversas linguagens de progração</p>
<p> O Padrão REST é statelles, ou seja, enviamos uma request e recebemos uma response do servidor, sem a necessidade de gerenciar o estado que o cliente ou servidor possui.</p>
<p>Outro ponto importante do tipo REST é que podemos utilizar a mesma url para os diferentes verbos HTTPs (GEP,POST,DELETE,PUT e etc).</p>

<p></p> 

<h3><strong>Spring Initializer</strong></h3>
<p></p> 
<p>Utilizamos em nosso projeto da ferramenta Spring Initializer que facilita a configuração do nosso projeto e agiliza o desenvolvimento, adicionando todas as depedências que necessitamos e formatando toda a sequência inicial do nosso build. </p>
<p>Acessamos a ferramenta através do site: https://start.spring.io/, porém caso queira poderá instalar na sua máquina e fazer de forma local.</p>
<p>No momento que estamos utilizando a ferramenta, precisamos definir a linguagem: Java ou Kotlin, Versão da Linguagem, Padrão de Projeto e Gerenciador de Dependência, Versão do Spring Boot, Dependências (quase sempre iremos usar a MVC, pois já irá outras como a WEB) e Tipos de Empacotamento: .JAR (Não iremos fazer deploy em Conteiners) ou .WAR (Iremos fazer deploy em Conteiners) </p>
<p>Em nosso projeto estamos utilizando o padrão de deploy .JAR, mesmo o arquivo sendo um pouco maior, não iremos necessitar que o servidor tenha o Conteiner TOMCAT instalado e configurado</p>

<p></p>
<h3><strong>Gestão de Dependências</strong></h3>
<p></p>
<p>Com a abordagem de reutilização de códigos, frameworks, padrões e pacotes com a o qual o Java foi pioneiro, uma ferramenta que nos auxilie a gerenciar todos estes aspectos é de suma importância, sendo que as mais comuns no mercado são: Maven: Linguagens Java ou Kotlin, Gradle:Linguagens Java ou Kotlin, NPM: linguagem java Script, NuGet: aplicações .NET e Pip: Aplicações Phython </p>
<p></p>
<h4><strong>Maven</strong></h4>
<p></p>
<p>No nosso caso optamos pela ferramenta Maven pelas seguintes questões: </p>
<p></p>
<p>* Estamos usando a liguagem JAVA;</p>
<p>* Não é necessário aprender uma tecnologia de programação adicional como no caso do Gradle que precisa ser escrito em Groove; </p>
<p>* OPEN source da APACHE; </p>
<p>* Estimula e auxilia na adoção de boas práticas, utilizando-se do conceito de programação por convenção (Estrutura de diretórios por padrão); </p>
<p>* Gerencia todos os downloads das dependências das dependências que estamos utilizando (antes do Maven era muito trabalhoso importar os .jar e adicionar ao build path); </p>
<p>* Facilita e organiza o build da nossa aplicação; </p>
<p>* Pode incorporar novas dependências através do arquivo POM.XML, podemos pesquisar no site : https://mvnrepository.com/ que é um repositório central;</p>
<p>* Arquivo XML de fácil leitura;</p>
<p>* Usando a ferramenta spring initializer com algumas poucas configurações ficamos com todas as dependências já configuradas e com a definição do arquétipo para o padrão\framework do Spring Boot;</p>
<p>* Familiaridade do time de desenvolvimento.</p>
<p></p>
<p>Citamos acima os principais motivações para a utilização do Maven no nosso projeto, mas existem algumas desvantagens nos seguintes aspectos: </p>
<p>* Necessita de Instalação;</p>
<p>* Arquivo XML de fácil leitura mas pode ser de dificil gravação.</p>
<p></p>
<h4><strong>Instalação Maven</strong></h4>
<p></p>
<p>O Maven é uma ferramenta OPEN Source da Apache Software Foundation e pode ser baixado pelo site: http://maven.apache.org/download.html, seguindo os seguintes passos: </p>
<p>* Escolher a ultima versão de acordo com o seu sistema operacional</p>
<p>* Fazer o download do arquivo .zip</p>
<p>* Escolher um diretório para descompacta-lo</p>
<p>* Adicionar uma variável de ambiente: M2_HOME apontando para o diretório que descompactou o arquivo até chegar no diretório /bin</p>
<p>* Podemos confirmar a instalação, executando o comando no prompt do sistema operacional : mvn - version</p>

<p></p>
<p>Observação: Na primeira utilização do Maven alguns diretórios são criados na máquina local, sendo o principal deles a pasta M2 que é aonde ficam armazenadas fisicamente os arquivos .jar que estamos utilizando em nossos projetos</p>
<p></p>
<h4><strong>Estutura de pastas no Projeto Maven</strong></h4>
<p></p>
<p>Quando optamos por usar o Maven em nosso projeto, além de gerenciar as dependências e o build, ele também como foi mencionado aplica conceito de programação por convenção (Estrutura de diretórios por padrão) e facilita a vida do desenvolvoder padronizando também os projetos,seguindo no padrão do arquétipo Spring Boot teremos as principais estruturas listadas abaixo (o que foi abordado até fase atual do curso): </p>
<p></p>
<p><b>src/main/java -</b>    Diretório onde está o(s) código(s) fonte(s) Java da Aplicação e/ou Biblioteca(s)</p>
<p><b>src/main/resources -</b> Arquivos de configuração e outros arquivos devem ficar nesta pasta, como o application property (utilziada na configuração de acesso aos bancos de dados)</p>
<p><b>src/test/java -</b> Pasta que contém os arquivos de testes unitários</p>
<p><b>src/test/resources -</b> Pasta com arquivos que serão utilizados pelas classes de testes unitários</p>
<p><b>target -</b> As classes javas compiladas do nosso projeto</p>
<p><b>pom.xml -</b> Arquivo de Configuração do Maven com dados sobre o build e dependências, abaixo iremos detalhar.</p>
<p><b>README.md -</b> Arquivo que fala de como configurar e os recursos utilizados no projeto</p>
<p></p>
<h4><strong>Configuração do Projeto Maven - POM.xml</strong></h4>
<p></p>
<p> O que é o arquivo POM mencionado no item acima, é um arquivo XML que contém informações sobre o projeto e detalhes de configuração usados ​​pelo Maven para construir o projeto.</p>
<p>Ele contém valores padrão para a maioria dos projetos. Exemplos disso são o diretório de construção, que é target; o diretório de origem, que é src/main/java; o diretório de origem do teste, que é src/test/java; e assim por diante seguindo o conceito de programação por convenção.</p>
<p>Ao executar uma tarefa ou objetivo, o Maven procura o POM no diretório atual. Ele lê o POM, obtém as informações de configuração necessárias e executa.</p>
<p>Algumas das configurações que podem ser especificadas no POM são as dependências do projeto (exemplo: LOMBOK e Validation que usamos em nosso projeto), os plugins ou objetivos que podem ser executados, os perfis de construção e assim por diante.</p>
<p>Outras informações como a versão do projeto, descrição, desenvolvedores, listas de discussão e outras também podem ser especificadas.</p>
<p></p>
<p>As principais tags são:</p>
<p></p>
<p><b>groupId:</b> nome do pacote e comum em quase todas as demais tags como dependências e build</p>
<p><b>artifactId:</b> nome do projeto e comum em quase todas as demais tags como dependências e build</p>
<p><b>version:</b> versão e comum em quase todas as demais tags como dependências e build</p>
<p><b>parent:</b> Arquétipo Pai de nosso projeto</p>
<p><b>properties-java.version: </b> com a versão do Java utilizada em nosso projeto</p>
<p><b>dependencies-dependency: </b> com as dependências que serão caregadas em nosso projeto, aqui vale mencionar que o arquivo settings.xml irá consultar o repositório para buscar estas dependências, por padrão estamos neste projeto usando o default que é o repositório oficial do Maven e quando baixadas os arquivos ficarão na pasta M2 do usuário na nossa máquina local.</p>
<p><b>build-builds-plugins: </b>Informações para o build de nossa aplicação que segue um conceito de fases,  podemos informar quais fases serão executadas ou serão ignoradas. As fases seguem uma ordem predefinida, você informa apenas quem será a última fase do build. Também é possível adicionar novas fases utilizando plugins, que precisam apenas ser configurados</p>

<p></p>
<h4><strong>POM de nosso projeto - Principais configurações</strong></h4>
<p></p>
<p>Nas configurações abaixo, que foram geradas pela ferramenta Spring Initializer, informamos: que estamos herdando as funcionalidades de um Arquétipo de um projeto padrão Spring Boot e a sua versão.</p>
<p></p>
        

                <parent>
                	<groupId>org.springframework.boot</groupId>
			<artifactId>pring-boot-starter-parent</artifactId>
   		        <version>2.7.12</version>
		        <relativePath/> <!-- lookup parent from repository -->
		</parent>
  		
   
<p></p>
<p></p>
<p>Seguem as dependências que também adicionamos durante a utilização da ferramenta Spring Initializer, lembrando que como explicado anteriormente, caso nossas dependências possuam outras dependências o Maven já faz todo este gerenciamento</p>
<p> Outro aspecto interessante é que na configuração de nosso projeto na 1º fase optamos inicialmente em utilizar 4 dependências: Spring MVC (Que ja traz todas as dependências necessárias para um API Rest - Web Stand Alone ), Validation (para utilizarmos o Validation Bean), Lombok (reutilização de códigos comuns) e Swagger(Documentação), porém nesta 2º fase para trabalharmos efetivamente com um banco de dados e a framework mais adequada para isto, acrescentamos a depedência do JPA. </p>        
<p></p>
			
   	<dependencies>
                <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
  		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>3.0.0</version>
		</dependency>

		<p><dependency></p>
			<p><groupId>io.springfox</groupId></p>
			<p><artifactId>springfox-boot-starter</artifactId></p>
			<p><version>3.0.0</version></p>
		<p></dependency></p>

		<p><dependency></p>
			<p><groupId>io.springfox</groupId></p>
			<p><artifactId>springfox-swagger-ui</artifactId></p>
			<p><version>3.0.0</version></p>
		<p></dependency></p>

                 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

	</dependencies>

 <p></p>

	
<p>Também temos as configurações de Plugin para o Build:</p>
 <p></p>
	
                <build>
		<plugins>
			<plugin>
                		<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
	      		</plugin>
		</plugins>
  		</build>
<p></p>
<h4><strong>Principais Comandos Maven</strong></h4>
<p></p>
<p>O Maven possui uma vasta lista de comandos para facilitar a nosa vida:</p> 
<p>Para compilar: mvn compile</p>
<p>Para compilar off-line:mvn –o compile</p>
<p>Executar todas as fases do Maven até o build: mvn clean install</p>
<p>Para criar os pacotes: mvn package</p>
<p>Instalar o pacote nos respectivos repositórios:mvn install</p>
<p>Limpar a pasta target:mvn clean</p>
<p>Executar os testes unitários:mvn test</p>
<p>Gerar site de documentação para o projeto:mvn site</p>
<p>Gerar Javadoc:mvn javadoc</p>
<p>Startar uma aplicação: mvn spring-boot:run</p>

<p></p>
<h3><strong>Separação de Camadas, Padrões de Projeto, Principais: Anotações e Classes </strong></h3>
<p></p>
<p>Em nosso projeto, pensando na separação de responsabilidades, melhores práticas e na arquitetura MVC, criamos os pacotes\pastas (algumas padrões do Maven para o arquétipo escolhido) abaixo em negrito: </p> 

<p><b>Pasta: Controller:</b>  Contêm as classes PessoaController,EnderecoController e EletrodomesticoController que serão as responsáveis por atender as requisições da camada View e direcionar as ações para as classes de Negócio, nesta camada que é o C - Controller da arquitetura MVC, estamos fazendo a injeção de dependência da nossa classe de Serviço que esta no pacote Service, na classe da Controller temos a exposição dos serviços disponiveis no servidor com base no verbos HTTP, na fase 1 deste projeto estamos apenas expondo serviço com chamada via metódo POST, um pouco mais abaixo expomos novas necessidades da utilização de outras anotações e classes com a evolução das fases.</p> 
<p>As principais Classes e Anotações que estamos utilizando nesta package são:<p>
<p>Anotação @RestController: anotação no nível de classe que indica que  esta é camada de controller do tipo Rest com dados no padrão JSON.</p>
<p>Anotação @RequestMapping: anotação no nível de classe\ atributo que irá indicar a URL principal da API que no nosso casos teremos: Pessoa, Eletrodomestico e Endereço.</p>
<p>Anotação @Autowired: Que fará a injeção de dependência da classe Service, usamos a injeção de dependência para evitarmos o Acoplamento e separarmos bem as responsabilidades, um aspecto importante podemos apenas fazer a injeção nas classes que possuem as anotações:  @Component, @Service, @Repository, @Controller e @RestController  que serão mapeadas para serem instanciadas na inicialização da aplicação pelo Spring Boot</p>
<p>Anotação @PostMapping: anotação no nível de método que indica qual método irá executar a chamada de uma requisição do verbo POST na URL definida na anotação @RequestMapping da classe, mas podemos também nesta anotação definir uma URL caso tenhamos necessidade.
<p>Anotação @RequestBody: anotação no nível de parâmetros dos métodos que indica que o valor do objeto virá do corpo da requisição, em nosso projeto usamos como parâmetro de entrada para o método que estamos vinculando ao verbo POST da requisição</p>
<p>Classe ResponseEntity: representa toda a resposta HTTP: código de status, cabeçalhos e corpo, em nosso projeto estamos utilizando no retorno do método que estamos vinculado ao método POST mas poderia na ser resposta de qualquer outro tipo de requisição</p>
<p></p>
<p>Nesta 2º Fase com as necessidades de termos um CRUD completo, acrescetamos mais algumas anotações e classes, explicados logo abaixo:</p>
<p></p>
<p>@GetMapping:anotação no nível de método que indica qual método irá executar a chamada de uma requisição do verbo GET, aqui podemos acrecentar um atributo que irá recuperar o(s) parametro(s) ou variaveis para uma chamada que necessite de uma pesquisa mais especifica, recuperadas através das anotações: @PathVariable entendemos a forma mais adequada para a semantica do padrão Rest ou através  @RequestParam que viria como QueryString e no casos mais indicada para tratarmos com o solicitante quer paginar uma resposta com muitos registros</p>
<p>@PutMapping:anotação no nível de método que indica qual método irá executar a chamada de uma requisição do verbo PUT, recebendo normalmente a variável que sofrerá alteração, conforme explicado no verbo GET.</p>
<p>@DeleteMapping:anotação no nível de método que indica qual método irá executar a chamada de uma requisição do verbo DELETE, recebendo normalmente a variável que sofrerá aa exclusão, conforme explicado no verbo GET.</p>
<p>@RequestParam:anotação no nível de parametro,  podemos ter vários parametros passados por url mas que não são parte da url em sí, conceito da QueryString, podemos também definir se o parametro é obrigatório ou não.</p>
<p>@PathVariable:anotação no nível de parametro, é utilizada quando o valor da variável é passada diretamente na URL, mas não como um parametro que você passa após o sinal de interrogação (?) mas sim quando o valor faz parte da url.</p>
<p>Classe PageRequest: Classe que define os atributos para paginação dentro de um Objeto Page</p>
<p>Classe Page: é uma sublista de uma lista de objetos. Permite obter informações sobre a posição do mesmo na lista inteira que o contém, usamos para termos um interface adequada com o front end</p>

 

<p><b>Pasta: Config:</b>Criamos esta package como boa prática para termos as classes de infra-estrutura da nossa aplicação bem identificadas, nesta fase do projeto, estamos utilizando duas:</p>
<p>ValidatorBean:   Esta classe possui apenas um método com a anotação @Bean que retorna uma factory (padrão de software) de Bean Validations para que possamos, validar os dados das requisições.</p>
<p>SpringFoxConfig: Esta classe possui apenas um método com a anotação @Bean retorna uma factory (padrão de software) de Docket para que possamos documentar e executar nossa API com a ferramenta Swagger</p>
<p></p>
<p>As principais Classes e Anotações que estamos utilizando nesta package são:<p>
<p>Anotação @Configuration: anotação no nível de classe que indica que uma classe declara um ou mais @Bean-métodos e pode ser processada pelo contêiner Spring para gerar definições de bean e solicitações de serviços para esses beans em tempo de execução</p>
<p>Anotação @Bean: Essa anotação é no nível do Método e indica que esse cria e retorna um “bean” que pode ser usado como dependência em outras classes.</p>
<p>Classe Validation: Classe que possui diversos métodos estáticos, sendo que usamos um deles no projeto para o retorno de Validators que iremos utilizar para a valdiação de nossos objetos do tipo DTO, centralizando assim na entrada dos dados as regras de validações antes do processamento e persistência.</p>
<p>Sobre o Swagger nesta fase do projeto não iremos detalhar ainda.</p>
<p><b>Pasta: Domain - DTO</b></p> 
<p>Nesta pasta temos as classes que irão representar as Entidades que irão ser utilizadas nas interações entra a camada View e Controller, tendo apenas esta responsabilidade de trafegar os dados (Seguindo o que é conhecido como padrão de software DTO) e aqui podemos falar que aplicamos a 1º especificação do SOLID (Single Responsability Principle (Princípio da Responsabilidade Única); Open/Closed Principle (Princípio do “Aberto para Extensão/Fechado para Implementação); Liskov Substitution Principle (Princípio da Substituição de Liskov)), estas classes são muito similares as classes de entidade do negócio nos atributos, mas aqui podemos tirar alguns atributos que não devem ser expostos por questões de segurança, aplicamos as validações e no nosso caso utilizando as anotações do bean validation</p>
<p> Para realizar o mapeamento dos atributos das classes DTO e das classes de Dominio que estão na nossa pasta MODEL, podemos utilizar diversas Classes, dentre elas a mais recomendada pela questão de performance e com o JMapper mas em nosso projeto pela simplicidade, criamos uma método na classe de DTO que retorna um objeto da nossa classe de Dominio\Negócio (Padrão de software Creator)</p>
<p>As principais Classes e Anotações que estamos utilizando nesta package são:<p>
<p>Anotação @Getter: Iremos falar sobre o Lombok que é a blblioteca que nos fornece esta anotação, em um capítulo mais abaixo, mas a priori esta anotação implementa os métodos Getters (Encapsulamento OO) , podemos usar esta anotação na classe ou nos atributos.</p>
<p>Anotação @ApiModelProperty: nível de atributo ou classe para descrever a especificação, exemplos de utilização na documentação do swagger </p>
<p>Anotação @NotBlank: anotação no nível de atributo do bean validation que não permite espaços em brancos ou não preenchimento do atributo, teremos também uma explicação mais detalhada sobre o Bean validation em um novo tópico abaixo</p>
<p>Anotação @Past: anotação no nível de atributo do bean validation que não permite que uma data seja menor que a data atual, ideal para preenchimento de datas de nascimento</p>
<p>Anotação @JsonFormat: anotação em nível de atributo do jackson que já vem de maneira deafult em projetos Spring Boot que podemos usar parametrizações de padrões como no nosso caso de data</p>
<p>Anotação @Email: anotação no nível de atributo do bean validation que valida se o email é válido</p>
<p>Anotação @NotNull: anotação no nível de atributo do bean validation que valida se o campo esta nulo, cuidado na utilização em conjunto com a anotação @NotBlank, que irá apresentar uma exceção</p>
<p></p>
<p></p>
<p><b>Pasta: Domain-Entitie</b></p> 
<p>Nesta pasta temos as classes que irão representar as Classes e Entidades de negócio, dentro da arquitetura MVC estamos falando que faz parte do  M-Model, que dentro dos sistemas corporativos deveria ser a camada mais importante e que não deveria ter implementações de classes relacionadas a infra-estrutura, seguindo os conceitos inciais que estamos apredendo de DDD (Domain Divre Design) devemos padronizar classes e metódos com nomes que fazem referência ao negócio com linguagem ubíqua, em nosso projeto estamos usando nomes que facilitam o entendimento do que representa como Pessoa, PessoaSexo, Endereco e etc</p>
<p>As principais Classes e Anotações que estamos utilizando nesta package são:<p>
<p>Anotação @Getter: Iremos falar sobre o Lombok que é a blblioteca que nos fornece esta anotação, em um capítulo mais abaixo, mas a priori esta anotação implementa os métodos Getters (Encapsulamento OO) , podemos usar esta anotação na classe ou nos atributos.</p>
<p>Anotação @AllArgsConstructor: Iremos falar sobre o Lombok que é a blblioteca que nos fornece esta anotação, em um capítulo mais abaixo, mas a priori esta anotação implementa um construtor com todos os atributos da classe, podemos usar esta anotação no nível da classe.</p>
<p>Anotação @EqualsAndHashCode: Iremos falar sobre o Lombok que é a biblioteca que nos fornece esta anotação, em um capítulo mais abaixo, mas a priori esta anotação implementa os métodos equals e hashcode sobrescritos de Object (podemos definir quais atributos devem ou não ser utilizados, através de parâmetros), podemos usar esta anotação no nível da classe</p>
<p></p>
<p>Nesta 2º Fase com as necessidades de termos um CRUD completo e em especial as persistência a camada de dados, acrescetamos mais algumas anotações e classes, explicados logo abaixo de forma sucinta, pois temos uma tópico mais especifico sobre JPA\Hibernate:</p>
<p></p>
<p>@Entity: anotação a nível de classe, utulizamos para declarar que uma classe é uma entidade. A partir disso o JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, onde os dados de objetos desse tipo poderão ser persistidos</p>
<p>@Table: anotação a nível de classe, podemos especificar detalhes em seus 4 tipos de atributos (nome, sobrescrever seu catálogo, seu esquema e assegurar restrições de unicidade nas colunas) da tabela que serão utilizados para persistir as nossas entidades na base de dados. Caso essa anotação seja omitida, não teremos um erro como resultado, porém será utilizado o nome da classe como valor default. Dessa forma, apenas definimos a anotação se quisermos sobrescrever algo do foi mencionado na parametrização de seus atributos.</p>
<p>@Column: anotação a nível de atributo, podemosespecificar os detalhes da coluna que um campo ou propriedade, alguns detalhes são relacionados com o esquema e, portanto aplicados apenas quando um esquema for gerado. A anotação @Column é opcional, possuindo valores default já configurados. </p>
<p>@GeneratedValue: anotação a nível de atributo  utilizada para indicar que a geração do valor do identificador único da entidade será gerenciada pelo provedor de persistência. Essa anotação deve ser adicionada logo após a anotação @Id. Quando não anotamos o campo com essa opção, significa que a responsabilidade de gerar e gerenciar as chaves primárias será da nossa aplicação</p>
<p>@Id: anotação a nível de atributo  utilizada para indicar que será a chave primária de nossa entidade</p>
<p>@OneToOne: anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade de um-para-um</p>
<p>@OneToMany: anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade  um-para-muitos</p>
<p>@ManyToOne:anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade de muitos-para-um</p> 
<p>@ManyToMany:anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade de muitos-para-muitos</p> 
<p>@JoinColumn: anotação a nível de atributo: é usado para especificar o mapeamento de uma coluna de chave estrangeira em um relacionamento entre duas entidades. A anotação @JoinColumn é aplicada no lado proprietário da associação para definir o nome da coluna de chave estrangeira e outros atributos relacionados à coluna de junção.</p> 
<p>@JoinTable: anotação a nível de atributo, usada para mapear uma relação ManyToMany entre duas entidades</p> 
<p>@Transactional: anotação a nível de classe, criar uma transação na persistencia de nosso dados para evitar erros de constraints</p> 


<p></p>
<p><b>Pasta: Respository</b></p> 
<p>Nesta pasta temos as classes que irão representar as Classes de persistências e relacionamento com o banco de dados, dentro da arquitetura MVC estamos indicando que pertence ao M-Model também,  seguindo os conceitos de DDD  devemos padronizar classes e metódos com nomes que fazem referência ao negócio com linguagem ubíqua, em nosso projeto estamos usando nomes que facilitam o entendimento do que representa como PessoaRepository, Métodos : Salvar, Buscar e etc. Nesta fase do projeto ainda não estamos usando JPA e mesmo banco de dados não estava obrigatório, mas em algumas APIS deste projeto persistimos em banco H2 e em outras seguimos a persistência em Collections do tipo Set.</p>
<p>As principais Classes e Anotações que estamos utilizando nesta package são:<p>
<p></p>
<p>Anotação @Repository: Indica que uma classe anotada é um Repositório, originalmente definido por DDD como  um mecanismo para encapsular armazenamento, recuperação e comportamento de pesquisa que representa uma coleção de objetos, com base nesta anotação e seguindo o objetivo de evitarmos acomplamento pela injeção de dependências e inversão de controle, injetamos estas classes nas classes da pasta Service.</p>
<p></p>
<p></p>
<p><b>Pasta: Service:</b> Pasta com as classes de serviço que contêm as regras de negócios comuns e são responsáveis em delegar para as classes de Negócios as requisições da Controller, em nosso projeto ela é injetada na Controller e recebe a injeção das classes de negócio.</p> 
<p>As principais Classes e Anotações que estamos utilizando nesta package são:<p>
<p></p>
<p>Anotação @Service: Indica que uma classe anotada é um Serviço</p>
<p>Anotação @Autowired: Que fará a injeção de dependência da classe Repositório e da Config - Bean validation, usamos a injenção de dependência para evitarmos o Acoplamento.</p>

 
<p></p>
<h3><strong>LOMBOK</strong></h3>
<p></p>
<p>Em tópicos anteriores, falamos sobre algumas das anotações que utilizamos desta biblioteca, sendo que esta surgiu da necessidade de reutilizarmos códigos comuns as mais diversas aplicações, chamados de boilerplate (alusão a contratos juridicos com clausulas comuns) como a criação de construtores, metodos getters e setters (polimorfismos OO).</p>
<p>Porém devemos tomar cuidados em usar sempre todas as anotações de forma indiscriminada, vendo a real necessidade sempre.</p> 
<p>Para utilizarmos esta biblioteca, devemos adicionar a sua dependência no arquivo POM do gerenciador Maven.</p>	
<p>Principais anotações:</p> 
<p>@NoArgsConstructor: nível de classe para criar  construtores  sem  nenhum  parâmetro</p> 
<p>@AllArgsConstructor:nível de classe para criar  construtores   com   todos   os parâmetros   da   classe</p> 
<p>@RequiredArgsConstructor:nível de classe para criar   construtores   com   alguns  parâmetros   da   classe </p> 
<p>@NonNull:nível de atributo, em conjunto com @RequiredArgsConstructor, para  determinar  qual  parâmetro  deve  ser  utilizado no construtor, o Lombok pede para que você o declare como tipo final sem inicialização ou com a annotation @NonNull sem inicialização.</p> 
<p>@Getter:nível de classe (todos os atributos) e atributo para implementação de métodos getters, neste caso temos o  nível de permissão como parâmetro: PUBLIC,PROTECTED,PACKAGE  ou PRIVATE </p>  
<p>@Setter:nível de classe (todos os atributos) e atributo para implementação de métodos setters, neste caso temos o  nível de permissão como parâmetro: PUBLIC,PROTECTED,PACKAGE  ou PRIVATE</p> 
<p>@EqualsAndHashCode: nivel de classe, com essa annotation, o Lombok cria os métodos equals() e hashCode() que podem ser utilizados em comparação. Podemos usar@EqualsAndHashCode.Include e @EqualsAndHashCode.Exclude para adicionar ou excluir algum atributo da classe  conforme nossa necessidade</p>
<p>@Data:nível de classe é para implementarmos as seguintes anotações de forma implicita : @Getter, @Setter, @ToString, @EqualsAndHashCode e @RequiredArgsConstructor na classe (exceto que nenhum construtor será gerado se já existir algum construtor explicitamente escrito). </p>  
<p>@ToString:nível de class(todos os atributos) e atributo para implementação do método ToString  </p>  
<p>@Value:nível de classe é a variante imutável de @Data; todos os campos são privados e finais por padrão, e os setters não são gerados. A própria classe também é finalizada por padrão, porque a imutabilidade não é algo que pode ser forçado em uma subclasse. Como @Data, métodos úteis toString(), equals() e hashCode() também são gerados, cada campo recebe um método getter e um construtor que cobre todos os argumentos (exceto os campos finais que são inicializados na declaração do campo) também é gerado .</p>  

<p></p>
<h3><strong>Bean Validation</strong></h3>
<p></p>
<p>O Bean Validation é uma biblioteca para apoiar na validação dos valores preenchidos em campos de entrada de dados e é extremamente importante em aplicações. O procedimento evita que armazenemos sujeira em nossas bases de dados e, dependendo do caso, pode até mesmo ter impacto na segurança do sistema.</p>
<p>Um dos mecanismos que podemos utilizar para realizar esta verificação surgiu com a liberação da plataforma Java EE 6, na qual foi introduzida a especificação Bean Validation 1.0.</p>
<p>O objetivo principal da biblioteca foi auxiliar os programadores nesta tarefa, que muitas vezes toma bastante tempo durante o desenvolvimento.</p>
<p>As boas práticas indicam que devemos inserir as anotações de validações desta biblioteca na camada de DTO evitando assim que tenhamos em diversas partes do código estas regras, auxiliando até na manutenção do projeto<p>
<p>Em nosso projeto usamos esta biblioteca e suas anotações nos atribuitos das classes da camada de DTO, passando também o parâmetro da mensagem de erro a ser retornada na response</p>
<p>Principais anotações que utulizamos:</p>
<p>@NotNull: valida se o valor é diferente de nulo.</p>
<p>@AssertTrue: valida se o valor é verdadeiro.</p>
<p>@Size: valida se a variável possui o tamanho entre valores mínimo
(parâmetro min) e máximo (parâmetro max). Você pode utilizar essa
annotation em campos de tipo String, Collection, Map e array.</p>
<p>@Min: valida se o valor da variável é maior que o passado no parâmetro
value.</p>
<p>@Email: valida se o valor da variável é um e-mail válido.</p>
<p>@NotEmpty valida se o valor do campo não está vazio; pode ser utilizado em
variáveis de tipo o String, Collection, Map ou Array.</p>
<p>@NotBlank: valida se o valor do campo não é nulo ou com espaços em branco;
pode ser utilizado em variáveis de tipo de texto.</p>
<p>@Positive e @PositiveOrZero: valida se o valor do campo é positivo ou
positivo incluindo o 0; pode ser utilizado em variáveis numéricas.</p>
<p>@Negative e @NegativeOrZero: valida se o valor do campo é negativo ou
negativo incluindo o 0; pode ser utilizado em variáveis numéricas.</p>
<p>@Past e @PastOrPresent: valida se o valor do campo de tipo de data está
somente no passado ou no passado e no presente.</p>
<p>@Future e @FutureOrPresent: valida se o valor do campo de tipo de data
está somente no futuro ou no futuro ou no presente.</p>
<p></p>
<h3><strong>Banco de Dados</strong></h3>
<p></p>
<p></p>
<h3><strong>JPA\Hibernate</strong></h3>
<p></p>
<p></p>
<p>@Entity: anotação a nível de classe, utulizamos para declarar que uma classe é uma entidade. A partir disso o JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, onde os dados de objetos desse tipo poderão ser persistidos</p>
<p>@Table: anotação a nível de classe, podemos especificar detalhes em seus 4 tipos de atributos (nome, sobrescrever seu catálogo, seu esquema e assegurar restrições de unicidade nas colunas) da tabela que serão utilizados para persistir as nossas entidades na base de dados. Caso essa anotação seja omitida, não teremos um erro como resultado, porém será utilizado o nome da classe como valor default. Dessa forma, apenas definimos a anotação se quisermos sobrescrever algo do foi mencionado na parametrização de seus atributos.</p>
<p>@Column: anotação a nível de atributo, podemosespecificar os detalhes da coluna que um campo ou propriedade, alguns detalhes são relacionados com o esquema e, portanto aplicados apenas quando um esquema for gerado. A anotação @Column é opcional, possuindo valores default já configurados. </p>
<p>@GeneratedValue: anotação a nível de atributo  utilizada para indicar que a geração do valor do identificador único da entidade será gerenciada pelo provedor de persistência. Essa anotação deve ser adicionada logo após a anotação @Id. Quando não anotamos o campo com essa opção, significa que a responsabilidade de gerar e gerenciar as chaves primárias será da nossa aplicação</p>
<p>@Id: anotação a nível de atributo  utilizada para indicar que será a chave primária de nossa entidade</p>
<p>@OneToOne: anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade de um-para-um</p>
<p>@OneToMany: anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade  um-para-muitos</p>
<p>@ManyToOne:anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade de muitos-para-um</p> 
<p>@ManyToMany:anotação a nível de atributo, que define uma associação com outra entidade que tenha a multiplicidade de muitos-para-muitos</p> 
<p>@JoinColumn: anotação a nível de atributo: é usado para especificar o mapeamento de uma coluna de chave estrangeira em um relacionamento entre duas entidades. A anotação @JoinColumn é aplicada no lado proprietário da associação para definir o nome da coluna de chave estrangeira e outros atributos relacionados à coluna de junção.</p> 
<p>@JoinTable: anotação a nível de atributo, usada para mapear uma relação ManyToMany entre duas entidades</p> 
<p>@Transactional: anotação a nível de classe, criar uma transação na persistencia de nosso dados para evitar erros de constraints</p> 

<p></p>
<h3><strong>Docker</strong></h3>
<p></p>



<p></p>  
<p></p>  
<h2><strong>Pessoas Desenvolvedoras do Projeto</strong></h2>
<p>Grupo 38</p>
<p></p>

<h2><strong>Conclusão</strong></h2>
 </body>
</html>
