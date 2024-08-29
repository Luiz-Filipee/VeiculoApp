VeiculoApp
VeiculoApp é um aplicativo Android para gerenciamento de veículos, desenvolvido com o objetivo de permitir que os usuários cadastrem, editem e visualizem informações sobre seus veículos de forma simples e organizada.

Funcionalidades
Cadastro de Veículos: Adicione novos veículos preenchendo nome, marca e ano.
Edição de Veículos: Atualize as informações dos veículos cadastrados.
Visualização de Veículos: Visualize todos os veículos cadastrados em uma interface de grade (GridView).
Persistência de Dados: Os dados dos veículos são salvos localmente usando uma classe Dados para simular um repositório.
Tecnologias Utilizadas
Java: Linguagem principal usada no desenvolvimento do aplicativo.
Android SDK: Framework utilizado para desenvolver a interface e funcionalidades do aplicativo.
GridView: Usado para exibir a lista de veículos em uma grade de dois itens por linha.
ArrayAdapter: Inicialmente utilizado para gerenciar a lista de veículos, mas posteriormente substituído por um adapter customizado.
Custom Adapter (VeiculoAdapter): Implementado para personalizar a exibição dos itens na lista de veículos.
Estrutura do Projeto
ui.activity: Contém as atividades principais do aplicativo, como MainActivity e CadastroActivity.
ui.adapter: Contém o adapter personalizado para exibição dos veículos (VeiculoAdapter).
model: Contém a classe Veiculo, que representa os veículos cadastrados.
repository: Contém a classe Dados, que simula um repositório local de dados.
Como Rodar o Projeto
Clone este repositório:

sh
Copiar código
git clone https://github.com/seuusuario/veiculoapp.git
Importe o projeto no Android Studio.

Compile e execute o aplicativo em um dispositivo ou emulador Android.

Próximos Passos
Implementar persistência de dados em banco de dados SQLite ou usando Room.
Melhorar a interface do usuário, adicionando novas funcionalidades como filtros e ordenação.
Adicionar suporte a múltiplos idiomas.
Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias e novas funcionalidades.

Licença
Este projeto está licenciado sob a MIT License.
