
<h1 align="center"> Tech Challenge - Painel de Consumo de Energia </h1>

![Portal de Consumo de Energia](https://github.com/rmstrunkis/tech_challenge/assets/105131830/c0e3a5f4-0e07-447e-896e-3e3f2dee760d)

<h2>Descrição do projeto</h2>
<p>Projeto Tech Challenge - FIAP Alura - 1º Fase</p>
<p>APIs que serão disponibilizadas para um portal que irá demonstrar ao usuário o consumo de energia de seus eletrodomésticos.</p>

<p>Construimos nesta fase do projeto 3 APIS:</p>
<p> * Endereços</p>
<p> * Pessoas</p>
<p> * Eletrodomésticos</p>

<p>Neste momento as APIs terão a responsabilidade de cadastrar as informações de Endereços, Pessoas e Eletrodomésticos.</p>


<h2>Funcionalidades e Demonstração da Aplicação</h2>
<h3>API Pessoas</h3>
<p><b>Funcionalidade : Cadastro de Pessoas relacionadas ao usuário</p>
<p><b>Baixar via GIT : git clone https://github.com/rmstrunkis/tech_challenge.git </p> 
<p><b>Executar em máquina local : na linha de comando ir até a pasta que clonou o projeto e no prompt da linha de comando, executar: mvn spring-boot:run.</p> 
<p><b>Swaggwer da aplicação local: http://localhost:8080/swagger-ui/#/pessoa-controller/criarNovaPessoaUsingPOST </p>
<p><b>Utilizamos nesta fase apenas o método (verbo): POST</p>
<p><b>URL Local:http://localhost:8080/pessoas</p>
<p><b>Header da Requisição: ApplicattionType/JSON demais atributos vazios</p>
<p><b>Body da Requisição: Formato JSON, exemplo abaixo e no swaggwer</p>
<p><b>JSON de Exemplo de Entrada:</p>
<p> Observação: O Campo de IdUsuario abstraímos neste momento que iremos receber da aplicação que irá consumir o cadastro de pessoas informando a qual usuário as pessoas estarão reclacionadas.</p>
<p>{</p>
   <p> "idUsuario": "1",</p>
   <p> "cpf":"49397364073" ,</p>
   <p> "nome": "Zezinho",</p>
   <p> "nomePai": "Ze",</p>
   <p> "nomeMae": "Zinha",</p>
   <p> "telefone": "11 32585303",</p>
   <p> "senha": "123",</p>
   <p> "dataNascimento": "01/07/1977",</p>
   <p> "email": "arlei_lepiani@hotmail.com",</p>
   <p> "parentesco": "FILHOS",</p>
   <p> "sexo":"MASCULINO"</p>
<p>}</p>
<p></p>
<p><b></b>Retorno:</p>
<p> O Campo de Id será gerado de forma automática a cada novo cadastro, porém não permitimos que um mesmo CPF seja relacionado mais de uma vez ao mesmo usuário, mas permitimos em outro usuário, assumindo que nesta fase uma mesma pessoa pode estar relacionada a N usuários</p>
<p> Ocorrendo o cadastro do usuário receberemos o HTTP STATUS 201 - CREATED, caso não seja criado o usuário por algum erro no preecnhimento do JSON será retornado o Status HTTP 401 com a mensagem do(s) campo(s) que foram preenchidos de forma errada ou que a pessoa ja esta relacionada ao usuário</p>
<p>Sucesso na Criação:</p>
<p></p>
   <p>Pessoa cadastrada com ID:-4427849907557628080
<p></p>
<p>Falha na Criação por erro em preenchimento de campo, informando o(s) campo(s) validados e a mensagem da regra utilizada:</p>
<p>{</p>
   <p>"cpf": "CPF deve ser válido"
<p>}</p>
<p>Falha na Criação por duplicidade:</p>
<p></p>
   <p>"Pessoa ja cadastrada, com o ID:-4427849907557628080 para o usuário: 2
<p></p>
<h2>Tecnologias Utilizadas</h2>
<p>Liguagem: Java versão 11</p>
<p>Padrão de Modelagem do Sistema: DDD (Driven Domin Design)</p>
<p>Arquitetura: MVC - Model View Controller</p>
<p>Frameworks e Bibliotecas: Spring Boot versão: 2.7.12 , LOMBOK versão default para a versão do Spring, Bean Validation versão default para a versão do Spring</p>
<p>Ferramentas Colaborativas: Postman,GIT e Swagger</p>
<p>Gestão de Dependências: Maven </p>

<h2>Relatório Técnico</h2>
<p>O objetivo deste tópico é explicar as motivações e desafios desta fase do Tech Challenge.</p>
<h3>API Pessoas</h3>
<h4>Spring Boot E API REST</h4>
<p> A Framework Spring é Open Source e foi criado pela PIVOTAL com o objetivo de facilitar o desenvolvimento de sistemas, descomplicando toda a parte de infraestrutura e algumas outras complexidades que existe na especificação JAVA EE.</p>
<p></p>
<p>A Framework Spring Boot é uma versão reduzida da Spring, ideal para o desevolvimento de aplicações WEB stand alone de forma rápida e simples, foi baseada no conceito de Injeção de Dependências e Inversão de Controle o que torna o código mais coeso e com menos acomplamento entre as classes, além de gerenciar bem todas as dependências iniciais internas e externas, ter de forma embracada o servidor de aplicação, sendo por padrão o Apache-Tomcat, mas podemos usar outros como o Jetty e Undertown , durante a descrição deste documento iremos registrar aonde são aplicados estes conceitos e facilidades com base em anotações e na estruturação das camadas,sendo estes o principais motivos de optarmos por esta framework.</p>
<p></p>
<p>Internamento o Spring Boot possui 4 componentes chaves na sua execução:</p>
<p>1 - Spring Boot Starter: Utiliza a combinação de várias dependências para forma uma unica</p>
<p>2 - Spring Boot CLI: software responsável por rodar e testar as aplicações na linha de comnando para isto executando o Spring Boot Starter e o Spring Boot Autocofigurator</p>
<p>3 - Spring Boot Autocofigurator: Gerencia as configurações de uma aplicação</p>
<p>4 - Spring Boot Acutator: Prover o endpoints e as métricas da aplicação</p>
<p></p>
<p> APIs (Application Programming Interface) é o meio utilizado para diversas aplicações possam se comunicar e para isto algumas regras são necessárias de acordo com cada tipo : SOAP, RPC, WebSocket e REST.</p>
<p>No nosso caso optamos pela padrão REST (Representational State Transfer), por ser hoje o modelo mais utilizado e simples, utilizando o protocolo HTTP e o formato JSON (JavaScript Object Notation - Notação de Objetos JavaScript) para trafegar as informações, sendo uma formatação leve e com muitas bibiliotecas para utilização nas mais diversas linguagens de progração</p>
<p> O Padrão REST é statelles, ou seja, enviamos uma request e recebemos uma response do servidor, sem a necessidade de gerenciar o estado que o cliente ou servidor possui.</p>
<p>Outro ponto importante do tipo REST é que podemos utilizar a mesma url para o diferentes verbos HTTPs (GEP,POST,DELETE,PUT e etc).</p>

<p></p> 

<h4>Spring Initializer</h4>
<p></p> 
<p>Utilizamos em nosso projeto da ferramenta Spring Initializer que facilita a configuração do nosso projeto e agiliza o desenvolvimento</p>
<p>Acessamos a ferramenta através do site: https://start.spring.io/</p>
<p>No momento que estamos utilizando a ferramenta, precisamos definir a linguagen: Java ou Kotlin, Versão da Linguagem, Padrão de Projeto e Gerenciador de Dependência, Versão do Spring Boot, Dependências (quase sempre iremos usar a MVC) e Tipos de Empacotamento: JAR (Não iremos fazer deploy em Conteiners) ou WAR (Iremos fazer deploy em Conteiners) </p>
<p>Em nosso projeto estamos utilizando o padrão de deploy .jar, mesmo o arquivo sendo um pouco maior, não iremos necessitar que o servidor tenha ja tenha o TOMCAT instalado e configurado</p>

<h4>Gestão de Dependências</h4>
<p>MAVEN</p>
<p>diretórios</p>
<p>POM.XML</p>

<p><b>Anotações: </p> 
<p><b>@SpringBootApplication</p> Main em aplicações web....
<p><b>@RestController</p>  padrão json
<p><b>@RequestMapping</p> 
<p><b>@Configuration</p> 
<p><b>@Repository</p> 
<p><b>@Service</p> 
<p><b>RequestBody</p> 
<p><b>@Autowired</p> injeção de dependencias
<p><b>@Bean</p> 
<p><b>@PostMapping</p> 
<p><b>Biclioteca default Jackson :     @JsonIgnore,@JsonFormat</p> 
<p><b>ResponseEntity</p> 
<p><b>HTTP Status</p> 
<p><b>Enum</p> 
<p><b>Set</p> 
<p><b>MAP</p> 
<p><b>Generics</p> 


<h4>MVC-DTO-Partners</h4>

<p><b>Separação de Camadas</p> 

<p><b>Controller</p> 
<p><b>Service</p> 
<p><b>Respository</p> 
<p><b>Config</p>
<p><b>Factory</p> 
<p><b>DTO</p> GRISP
<p><b>Model</p> 
<p><b>Padrao de nome de classes e metodos com linguagem Ubiqua.</p> 

<h4>LOMBOK</h4>
<p>Que utilizamos e o motivo</p> BODERPOILITE codigos comuns...
<p><b>@Getter</p> 
<p><b>@AllArgsConstructor</p> 
<p><b>@EqualsAndHashCode</p> 
<p>Passar pelas demais não utilizadas e porque</p>

<h4>Bean Validation</h4>
<p><b>Validação na camada de DTO</b>
  <p><b>@NotNull</p> 
  <p><b>@CPF</p> 
  <p><b>@NotBlank</p> 
  <p><b>@Past</p> 
  <p><b>@Email</p> 

<h4>Testes</h4>
<p><b>Postman</b>
<p><b>CURL</b>
<p><b>ARC</b>

   
<h2>Pessoas Desenvolvedoras do Projeto</h2>
<p>Grupo 38</p>

<h2>Conclusão</h2>
