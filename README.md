<html>
   <head></head>
   <body >
<h1 align="center"> <strong> Tech Challenge - Painel de Consumo de Energia</strong> </h1>

![Portal de Consumo de Energia](https://github.com/rmstrunkis/tech_challenge/assets/105131830/c0e3a5f4-0e07-447e-896e-3e3f2dee760d)

<h2><strong>Descrição do projeto</strong></h2>
<p>Projeto Tech Challenge - FIAP Alura - 1º Fase</p>
<p>APIs que serão disponibilizadas para um portal que irá demonstrar ao usuário o consumo de energia de seus eletrodomésticos.</p>

<p>Construimos nesta fase do projeto 3 APIS:</p>
<p> * Endereços</p>
<p> * Pessoas</p>
<p> * Eletrodomésticos</p>

<p>Neste momento as APIs terão a responsabilidade de cadastrar as informações de Endereços, Pessoas e Eletrodomésticos.</p>


<h2><strong>Funcionalidades e Demonstração da Aplicação</strong></h2>
<h3><strong>API Pessoas</strong></h3>
<p></p>
<p>Funcionalidade : Cadastro de Pessoas relacionadas ao usuário</p>
<p>Baixar via GIT : git clone https://github.com/rmstrunkis/tech_challenge.git </p> 
<p>Executar em máquina local : na linha de comando ir até a pasta que clonou o projeto e no prompt da linha de comando, executar: mvn spring-boot:run.</p> 
<p>Swagger da aplicação local: http://localhost:8080/swagger-ui/#/pessoa-controller/criarNovaPessoaUsingPOST </p>
<p>Utilizamos nesta fase apenas o método (verbo): POST</p>
<p>URL Local:http://localhost:8080/pessoas</p>
<p>Header da Requisição: ApplicattionType/JSON demais atributos vazios</p>
<p>Body da Requisição: Formato JSON, exemplo abaixo e no swaggwer</p>
<p></p>
<p>JSON de Exemplo de Entrada:</p>
<p> Observação: O Campo de IdUsuario abstraímos neste momento que iremos receber da aplicação que irá consumir o cadastro de pessoas informando a qual usuário as pessoas estarão reclacionadas.</p>
<p></p>
<p style="font-family:courier;" style="font-size:3px;">{</p>
   <p style="font-family:courier;" style="font-size:3px;"> "idUsuario": "1",</p>
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
<p>Retorno:</p>
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
<h2><strong>Tecnologias Utilizadas</strong></h2>
<p>Liguagem: Java versão 11</p>
<p>Padrão de Modelagem do Sistema: DDD (Driven Domin Design)</p>
<p>Arquitetura: MVC - Model View Controller</p>
<p>Frameworks e Bibliotecas: Spring Boot versão: 2.7.12 , LOMBOK versão default para a versão do Spring, Bean Validation versão default para a versão do Spring</p>
<p>Ferramentas Colaborativas: Postman,GIT,Maven e Swagger</p>
<p></p>


<h2><strong>Relatório Técnico</strong></h2>
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
<p>1 - Spring Boot Starter: Utiliza a combinação de várias dependências para forma uma unica</p>
<p>2 - Spring Boot CLI: software responsável por rodar e testar as aplicações na linha de comanndo para isto executando o Spring Boot Starter e o Spring Boot Autocofigurator</p>
<p>3 - Spring Boot Autocofigurator: Gerencia as configurações de uma aplicação</p>
<p>4 - Spring Boot Acutator: Prover o endpoints e as métricas da aplicação</p>
<p></p>
<p> APIs (Application Programming Interface) é o meio utilizado para diversas aplicações possam se comunicar e para isto algumas regras são necessárias de acordo com cada tipo : SOAP, RPC, WebSocket e REST.</p>
<p>No nosso caso optamos pela padrão REST (Representational State Transfer), por ser hoje o modelo mais utilizado e simples, utilizando o protocolo HTTP e o formato JSON (JavaScript Object Notation - Notação de Objetos JavaScript) para trafegar as informações, sendo uma formatação leve e com muitas bibiliotecas para utilização nas mais diversas linguagens de progração</p>
<p> O Padrão REST é statelles, ou seja, enviamos uma request e recebemos uma response do servidor, sem a necessidade de gerenciar o estado que o cliente ou servidor possui.</p>
<p>Outro ponto importante do tipo REST é que podemos utilizar a mesma url para o diferentes verbos HTTPs (GEP,POST,DELETE,PUT e etc).</p>

<p></p> 

<h3><strong>Spring Initializer</strong></h3>
<p></p> 
<p>Utilizamos em nosso projeto da ferramenta Spring Initializer que facilita a configuração do nosso projeto e agiliza o desenvolvimento</p>
<p>Acessamos a ferramenta através do site: https://start.spring.io/, porém caso queira poderá instalar na sua máquina e fazer de forma local</p>
<p>No momento que estamos utilizando a ferramenta, precisamos definir a linguagen: Java ou Kotlin, Versão da Linguagem, Padrão de Projeto e Gerenciador de Dependência, Versão do Spring Boot, Dependências (quase sempre iremos usar a MVC) e Tipos de Empacotamento: .JAR (Não iremos fazer deploy em Conteiners) ou .WAR (Iremos fazer deploy em Conteiners) </p>
<p>Em nosso projeto estamos utilizando o padrão de deploy .jar, mesmo o arquivo sendo um pouco maior, não iremos necessitar que o servidor tenha o Conteiner TOMCAT instalado e configurado</p>

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
<p>* Não é necessário aprender uma tecnologia de programação adicional como no caso do Gradle que precisa ser escrite em Groove; </p>
<p>* OPEN source da APACHE; </p>
<p>* Estimula e auxilia na adoção de boas práticas, utilizando-se do conceito de programação por convenção (Estrutura de diretórios por padrão); </p>
<p>* Gerencia todos os downloads das dependências das dependências que estamos utilizando; </p>
<p>* Facilita e organiza o build da nossa aplicação; </p>
<p>* Pode incorporar novas dependências através do arquivo POM.XML, podemos pesquisar no site : https://mvnrepository.com/ que é um repositório central;</p>
<p>* Arquivo XML de fácil leitura;</p>
<p>* Familiaridade do time de desenvolvimento.</p>
<p></p>
<p>Citamos acima os principais motivações para a utilização do MAVEN no nosso projeto, mas existem algumas desvantagens nos seguintes aspectos: </p>
<p>* Necessita de Instalação;</p>
<p>* Arquivo XML de fácil leitura mas pode ser de dificil gravação.</p>
<p></p>
<h4><strong>Instalação Maven</strong></h4>
<p></p>
<p>O Maven é uma ferramenta OPEN Source da Apache Software Foundation e pode ser baixado pelo site: http://maven.apache.org/download.html, seguindo os seguintes passos: </p>
<p>* Escolher a ultima versão de acordo com o seu sistema operacional</p>
<p>* Fazer o download do arquivo .zip</p>
<p>* Escolher um diretório para decompacta-lo</p>
<p>* Adicionar uma variável de ambiente: M2_HOME apontando para o diretório que descompactou o arquivo até chegar no diretório /bin</p>
<p>* Pode confirmar a instalação, executando o comando no prompt do sistema operacional : mvn - version, conforme imagem abaixo:</p>
![Comando de Versão](https://github.com/rmstrunkis/api-pessoa/assets/105131830/903b666e-428f-4902-a5fe-e74a121c2a8b)

<p></p>
<p>Observação: Na instalação do MAVEN alguns diretórios são criados na máquina local, sendo o principal deles a pasta M2 que é aonde ficam armazenadas fisicamente os arquivos .jar que estamos utilizando em nossos projetos</p>
<p></p>
<h4><strong>Estutura de pastas no Projeto Maven</strong>strong></h4>
<p></p>
<p>Quando optamos por usar o Maven em nosso projeto, além de gerenciar as dependencias e o build, ele também como foi mencionado aplica conceito de programação por convenção (Estrutura de diretórios por padrão) e facilita a vida do desenvolvoder padronizando os projetos,seguindo no padrão básico as principais estruturas listadas abaixo (o que foi abordado até fase atual do curso): </p>
<p></p>
<p><b>src/main/java -</b>    Diretório onde está o código fonte Java da Aplicação e/ou Biblioteca</p>
<p><b>src/main/resources -</b> Arquivos de configuração e outros arquivos devem ficar nesta pasta, como o application property (que veremos nas próximas fases do curso)</p>
<p><b>src/test/java -</b> Pasta que contém os arquivos de testes unitários</p>
<p><b>src/test/resources -</b> Pasta com arquivos que serão utilizados pelas classes de testes unitários</p>
<p><b>target -</b> As classes javas compiladas do nosso projeto</p>
<p><b>pom.xml -</b> Arquivo de Configuração do Maven com dados sobre o build e dependências</p>
<p><b>README.md -</b> Arquivo que fala de como configurar e os recursos utilizados no projeto</p>
<p></p>
<h4><strong>Configuração do Projeto Maven - POM.xml</strong></h4>
<p></p>
<p> O que é o arquivo POM mencionado no item acima, é um arquivo XML que contém informações sobre o projeto e detalhes de configuração usados ​​pelo Maven para construir o projeto.</p>
<p>Ele contém valores padrão para a maioria dos projetos. Exemplos disso são o diretório de construção, que é target; o diretório de origem, que é src/main/java; o diretório de origem do teste, que é src/test/java; e assim por diante.</p>
<p>Ao executar uma tarefa ou objetivo, o Maven procura o POM no diretório atual. Ele lê o POM, obtém as informações de configuração necessárias e executa.</p>
<p>Algumas das configurações que podem ser especificadas no POM são as dependências do projeto (exemplo: LOMBOK e Validation), os plugins ou objetivos que podem ser executados, os perfis de construção e assim por diante.</p>
<p>Outras informações como a versão do projeto, descrição, desenvolvedores, listas de discussão e outras também podem ser especificadas.</p>
<p></p>
<p>As principais tags são:</p>
<p></p>
<p><b>groupId:</b> nome do pacote</p>
<p><b>artifactId:</b> nome do projeto</p>
<p><b>version:</b> versão</p>
<p><b>properties-java.version: </b> com a versão do Java utulizada em nosso projeto</p>
<p><b>dependencies-dependency: </b> com as dependências que serão caregadas em nosso projeto, aqui vale mencionar que o arquivo setting.xml irá consultar o repositório para buscar estas dependências, por padrão estamos neste projeto usamos default que é o repositório oficial do Maven e quando baixadas os arquivos ficarão na pasta M2 do usuário na nossa máquina local.</p>
<p><b>build-builds-plugins: </b>Informações para o build de nossa aplicação que segue um conceito de fases,  podemos informar quais fases serão executadas ou serão ignoradas. As fases seguem uma ordem predefinida, você informa apenas quem será a última fase do build. Também é possível adicionar novas fases utilizando plugins, que precisam apenas ser configurados</p>

<p></p>


<h4><strong>Principais Comandos Maven</strong></h4>
<p></p>
<p>O Maven possui uma vasta lista de comandos para facilitar a nosa vida</p> 
<p>Para compilar: mvn compile</p>
<p>Para compilar off-line:mvn –o compile</p>
<p>Para criar os pacotes: mvn package</p>
<p>Instalar o pacote nos respectivos repositórios:mvn install</p>
<p>Limpar a pasta target:mvn clean</p>
<p>Executar os testes unitários:mvn test</p>
<p>Gerar site de documentação para o projeto:mvn site</p>
<p>Gerar Javadoc:mvn javadoc</p>
<p>Startar uma aplicação: mvn spring-boot:run</p>

<p></p>

<h3><strong>Classes e Anotações</strong></h3> 
<p></p>
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

<p></p>
<h3><strong>Separação de Camadas</strong></h3>
<p></p>

<p><b>Controller</p> 
<p><b>Service</p> 
<p><b>Respository</p> 
<p><b>Config</p>
<p><b>Factory</p> 
<p><b>DTO</p> GRASP
<p><b>Model</p> 
<p><b>Padrao de nome de classes e metodos com linguagem Ubiqua.</p> 

<p></p>
<h3><strong>LOMBOK</strong></h3>
<p></p>
<p>Que utilizamos e o motivo</p> BODERPOILITE codigos comuns...
<p><b>@Getter</p> 
<p><b>@AllArgsConstructor</p> 
<p><b>@EqualsAndHashCode</p> 
<p>Passar pelas demais não utilizadas e porque</p>

<p></p>
<h3><strong>Bean Validation</strong></h3>
<p></p>
<p><b>Validação na camada de DTO</b>
  <p><b>@NotNull</p> 
  <p><b>@CPF</p> 
  <p><b>@NotBlank</p> 
  <p><b>@Past</p> 
  <p><b>@Email</p> 

<p></p>
<h3><strong>Testes</strong></h3>
<p></p>
<p><b>Postman</b>
<p><b>CURL</b>
<p><b>ARC</b>

<p></p>  
<h2><strong>Pessoas Desenvolvedoras do Projeto</strong></h2>
<p>Grupo 38</p>
<p></p>

<h2><strong>Conclusão</strong></h2>
 </body>
</html>
