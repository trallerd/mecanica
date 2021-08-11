# Mecânica

Sistema para simular, de maneira simplificada, o funcionamento de uma mecânica de veículos. A mecânica também presta serviços de consertos e reparos de pintura em veículos. 
### A descrição dos casos de uso é a seguinte:
- Cadastrar Veículo: o sistema permite o cadastro de um veículo com os seguintes dados: placa, ano, modelo, cliente. Cada veículo também possui um código único, que é gerado automaticamente pelo sistema.
- Cadastrar Serviço: para que um serviço seja realizado, ele deve estar previamente cadastrado no sistema. Podem existir dois tipos de serviços: conserto e pintura. Todos os serviços possuem um código único que deve ser gerado automaticamente, bem como uma descrição textual. Todos os serviços possuem um valor de mão de obra. Um serviço de conserto possui um valor das peças, bem como uma lista das peças utilizadas durante o conserto. Um serviço de pintura possui a cor da tinta utilizada, o valor da tinta e o valor da cera. 
- Executar Serviço: o sistema permite o registro da execução de um serviço que foi realizado em um veículo. Ambos o serviço e o veículo são previamente cadastrados no sistema. O sistema gera um código automático para cada execução de serviço. 
- Emitir Relatórios: o sistema permite a geração de relatórios de veículos, serviços e execuções de serviços.
