
/**
 * Classe que possui a operação principal da aplicação.
 *
 * @version 1.0
 */
public class Principal {

    /**
     * Inicia a aplicação.
     *
     * @param args args
     */
    public static void main(String[] args) {
        //Instancio a classe da janela do cadastro de cliente
        FrmCadastroCliente frmCadastroCliente = new FrmCadastroCliente();
        //Deixo a janela visivel
        frmCadastroCliente.setVisible(true);
    }
}
