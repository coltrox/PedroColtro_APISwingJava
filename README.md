# Cadastro de Usuário – Java Swing

Projeto simples desenvolvido em **Java** utilizando **Swing** para criar uma interface gráfica que permite cadastrar usuários.  
O sistema pede **nome**, **e-mail**, **idade** e **sexo**, valida as informações e salva tudo em um arquivo `.txt`.

---

##  Funcionalidades

 **Interface Gráfica (Swing)**  
- Campos para **Nome**, **E-mail** e **Idade**.  
- Botões de seleção para escolher **Masculino** ou **Feminino**.  
- Botões **Cadastrar** e **Limpar**.

 **Validação de Dados**  
- Verifica se todos os campos estão preenchidos.  
- Checa se o e-mail está no formato correto usando.  
- Exibe mensagem de aviso se o email estiver errado ou se faltar informações.

 **Cadastro e Salvamento**  
- Mostra na tela um resumo das informações cadastradas.  
- Salva os dados no arquivo `cadastros.txt` sem apagar cadastros antigos.

 **Função de Limpar**  
- Apaga todo o conteúdo dos campos.  
- Desmarca a seleção de sexo.

 **Tratamento de Erro**  
- Informa caso haja falha ao salvar no arquivo.
