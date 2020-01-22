# zigulich-java-printer
Classe de impressão em java para impressoras térmicas não fiscais.

## Compatibilidade
No momento, a classe foi testada nas impressoras:
1. Bematech 4200 TH
2. Daruma DR800

## Importação
- Importe **classeImpressao-1.0.0.jar** para dentro do seu projeto.
- Faça a importação do **com.zigulich.classeimpressao.DARUMA** ou  **com.zigulich.classeimpressao.BEMATECH**

## Abertura do servidor de impressão
A impressora DARUMA usa sua biblioteca padrão de impressão, já a BEMATECH faz a impressão direta. Por isto, as configurações de abertura do servidor de impressão são diferentes. Veja:

`BEMATECH.ConfigurarImpressora("COM1"); // É passado por parâmetro OBRIGATÓRIO, a porta de impressão onde está instalada a impressora. `
`DARUMA.ConfigurarImpressora(); //Nenhum parâmetro é passado, pois a mesma busca automaticamente`

## Impressão de Texto
Para ambas classes de impressão, são usadas as seguintes funções:
> As funções aqui listadas devem estar entre a abertura do servidor de impressão e o fechamento do mesmo.
>
`*.LinhaDupla(String Texto): Imprime em linha dupla`
`*.LinhaNegrito(String Texto): Imprime em linha em negrito`
`*.LinhaNormal(String Texto): Imprime texto sem formatação`
`*.LinhaItalico(String Texto): Imprime texto em itálico`

## Controle da Guilhotina
Em ambas impressoras, há dois tipos de corta na Guilhotina, o Parcial e o Total.
O **Corte parcial** é acionado através da função:
`*.corteParcial();`
Já o **Corte total** é acionado junto ao fechamento do servidor de impressão.

## Fechamento do servidor de impressão
O fechamento do servidor de impressão é responsável por avisar a impressora que a impressão chegou ao fim, finalizando sua conexão.
É acionado pela função:
`*.FinalizarImpressao()`;
> A função resulta no Corte total do papel, como visto na sessão Guilhotina

## Extras
A impressora DARUMA imprime textos baseados em [tags D-HTML](http://www.desenvolvedoresdaruma.com.br/help/DFW/DUAL/Tags_DHTML.htm), esta personalização manual pode ser feita através da função `DARUMA.LinhaNormal(String Texto)`, porém não está disponível para impressora BEMATECH.

## Licença
O código fonte acima pode ser modificado e usado por qualquer desenvolvedor em suas aplicações (comerciais e não comerciais), desde que o mesmo não modifique a autoria do mesmo.