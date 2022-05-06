
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Osmar de Oliveira Braz Junior
 */
public class FrmCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrmCadastroCliente
     */
    public FrmCadastroCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLClienteId = new javax.swing.JLabel();
        jTClienteId = new javax.swing.JTextField();
        jLNome = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jLCpf = new javax.swing.JLabel();
        jTCpf = new javax.swing.JTextField();
        jLTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBConsultar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jBFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Cliente");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLClienteId.setText("ClienteID");

        jTClienteId.setEnabled(false);

        jLNome.setText("Nome");

        jLCpf.setText("CPF");

        jLTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLTitulo.setText("Cadastro de Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLClienteId)
                    .addComponent(jTClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNome)
                    .addComponent(jLCpf)
                    .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTitulo))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLClienteId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBListar.setText("Listar");
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBConsultar.setText("Consultar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jBFechar.setText("Fechar");
        jBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBConsultar))
                    .addComponent(jBFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addGap(4, 4, 4)
                .addComponent(jBListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFecharActionPerformed
        //Fecha a aplicação
        System.exit(0);
    }//GEN-LAST:event_jBFecharActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        //Limpa as caixas de texto do formulário
        jTClienteId.setText("");
        jTNome.setText("");
        jTCpf.setText("");
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        //Se é um cliente novo o id está em branco
        if (jTClienteId.getText().equals("")) {
            //Inclusão de um novo cliente pois o ID está em branco
            //Instancia o Gerenciador do Arquivo
            GerenciadorCliente gerente = new GerenciadorCliente();
            RegistroCliente cliente = new RegistroCliente();
            cliente.setCodigo(gerente.proximoCodigo());
            cliente.setNome(jTNome.getText());
            cliente.setCpf(jTCpf.getText());
            boolean resultado = gerente.inserirFimArquivo(cliente);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não foi inserido!");
            }
        } else {
            //Atualização de cliente pois o Id está preenchido            
            GerenciadorCliente gerente = new GerenciadorCliente();
            RegistroCliente cliente = new RegistroCliente();
            cliente.setCodigo(Integer.parseInt(jTClienteId.getText()));
            cliente.setNome(jTNome.getText());
            cliente.setCpf(jTCpf.getText());
            boolean resultado = gerente.atualizarArquivo(Integer.parseInt(jTClienteId.getText()), cliente);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não foi atualizado!");
            }
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
        //Cria um textArea para exibir os dados
        JTextArea textArea = new JTextArea(10, 30);
        //Deixa o textarea editavel
        textArea.setEditable(false);
        //Coloca um painel de rolagem ao textArea
        JScrollPane painelRolagem = new JScrollPane(textArea);

        //String de saída de dos dados
        String linha = "";
        //Instancia o Gerenciador do Arquivo
        GerenciadorCliente gerente = new GerenciadorCliente();
        //Recupera as linhas do arquivo
        linha = gerente.listarLogico();

        //Coloco a string no textArea
        textArea.setText(linha);
        //Mostro o textArea com o JOptionPane
        JOptionPane.showMessageDialog(null, painelRolagem, "Listagem de Clientes", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jBListarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        //Pergunto ao usuário qual o id a ser alterado
        int clienteIdAlterar = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente a ser alterado"));

        //Instancia o Gerenciador
        GerenciadorCliente gerente = new GerenciadorCliente();
        //Recupera o registro do arquivo
        RegistroCliente cliente = gerente.pesquisarRegistro(clienteIdAlterar);

        //Verifica se existe algum registro no arquivo
        if (cliente != null) {
            //Exibe os dados na janela
            jTClienteId.setText(cliente.getCodigo() + "");
            jTNome.setText(cliente.getNome());
            jTCpf.setText(cliente.getCpf());
            JOptionPane.showMessageDialog(null, "Cliente encontrado!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        // TODO add your handling code here:
        //Pergunto ao usuário qual o id a ser excluído
        int clienteIdExcluir = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente a ser excluído"));

        //Instancia o Gerenciador
        GerenciadorCliente gerente = new GerenciadorCliente();
        //Exclui o registro do arquivo
        boolean resultado = gerente.excluirLogico(clienteIdExcluir);

        //Verifica se existe a exclusão foi realizada
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não excluído!");
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        // TODO add your handling code here:

        //Pergunto ao usuário qual o id a ser alterado
        int clienteIdConsultar = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente a ser consultado"));

        //Instancia o Gerenciador
        GerenciadorCliente gerente = new GerenciadorCliente();
        //Recupera o registro do arquivo
        RegistroCliente cliente = gerente.pesquisarRegistro(clienteIdConsultar);

        //Verifica se existe algum registro no arquivo
        if (cliente != null) {
            //Exibe os dados na janela
            jTClienteId.setText(cliente.getCodigo() + "");
            jTNome.setText(cliente.getNome());
            jTCpf.setText(cliente.getCpf());
            JOptionPane.showMessageDialog(null, "Cliente encontrado!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }//GEN-LAST:event_jBConsultarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBFechar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBListar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLClienteId;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTClienteId;
    private javax.swing.JTextField jTCpf;
    private javax.swing.JTextField jTNome;
    // End of variables declaration//GEN-END:variables
}
