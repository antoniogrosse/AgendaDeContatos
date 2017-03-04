/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.pi3.agendadecontatos.telas;

/**
 *
 * @author Antonio Grosse
 */
public class telaConsulta extends javax.swing.JPanel {

    /**
     * Creates new form telaConsulta
     */
    public telaConsulta() {
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

        jLabel1 = new javax.swing.JLabel();
        busca = new javax.swing.JTextField();
        labelBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Buscar Contato:");

        busca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelBuscar.setText("Buscar");

        tabelaCliente.setAutoCreateRowSorter(true);
        tabelaCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "E-mail", "Data de Nascimento", "Data e Hora de Inclusão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCliente.setGridColor(new java.awt.Color(0, 0, 0));
        tabelaCliente.setSelectionMode();
        tabelaCliente.getTableHeader().setReorderingAllowed(false);
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        jButton1.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelBuscar)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked

        // Pega evento.
        if (evt.getClickCount() == 2) {

            // Variavel recebe linha selecionada.
            int linha = tabelaCliente.getSelectedRow();

            // Se nao tiver linha.
            if (linha == -1) {

                // Mensagem.
                JOptionPane.showMessageDialog(null, "Sem resultado de busca", "Erro", JOptionPane.ERROR_MESSAGE);

                // Se tiver linha.
            } else {

                try {

                    // Variavel recebe id do cliente.
                    String ID = tabelaCliente.getValueAt(linha, 0).toString();

                    // Variavel recebe id para int.
                    int id = Integer.parseInt(ID);

                    // Variavel recebe cliente.
                    ArrayList<Cliente> cliente = ServicosCliente.procurarCliente(id, false);

                    // Declara painel de alteracao e apresentacao.
                    painelAlterar clienteSelecionado = new painelAlterar();

                    // Remove tudo do painel atual.
                    painelBuscarCliente.removeAll();

                    // Adiciona painel a tela.
                    painelBuscarCliente.add(clienteSelecionado);

                    // Escolhe tamanho do painel.
                    clienteSelecionado.setSize(painelBuscarCliente.getWidth(), painelBuscarCliente.getHeight());

                    // Deixa painel visivel.
                    clienteSelecionado.setVisible(true);

                    // Remasteriza painel.
                    clienteSelecionado.validate();

                    // Lista de dados do cliente recebe metodo de procura.
                    ArrayList<DadosPessoais> dados = ServicosCliente.procurarDadosCliente(" ", cliente.get(0).getID_DadosPessoais(), false);

                    // Preenche painel de alterar com os dados.
                    clienteSelecionado.textoNome.setText(dados.get(0).getNome());
                    clienteSelecionado.textoCPF.setText(dados.get(0).getCPF());
                    clienteSelecionado.comboGenero.setSelectedItem(dados.get(0).getGenero());
                    clienteSelecionado.textoDataDeNascimento.setText(dados.get(0).getDataNascimento());
                    clienteSelecionado.imagemCliente.setIcon(dados.get(0).getImagemAlterar());

                    // Lista de endereco do cliente recebe metodo de procura.
                    ArrayList<Endereco> endereco = ServicosCliente.procurarEndereco(cliente.get(0).getID_Endereco());

                    // Preenche painel de alterar com o endereco.
                    clienteSelecionado.textoEnderecoLogradouro.setText(endereco.get(0).getLogradouro());
                    clienteSelecionado.textoBairro.setText(endereco.get(0).getBairro());
                    clienteSelecionado.textoComplemento.setText(endereco.get(0).getComplemento());
                    clienteSelecionado.textoNumero.setText(endereco.get(0).getNumero());
                    clienteSelecionado.textoCEP.setText(endereco.get(0).getCEP());

                    // Lista de contato do cliente recebe metodo de procura.
                    ArrayList<Contato> contato = ServicosCliente.procurarContatoCliente(cliente.get(0).getID_Contato());

                    // Preenche painel de alterar com o contato.
                    clienteSelecionado.textoEmail.setText(contato.get(0).getEmail());
                    clienteSelecionado.textoTelefone.setText(contato.get(0).getTelefone());
                    clienteSelecionado.textoCelular.setText(contato.get(0).getCelular());
                    clienteSelecionado.textoDD_Celular.setText(contato.get(0).getDD_Celular());
                    clienteSelecionado.textoDD_Telefone.setText(contato.get(0).getDD_Telefone());
                    clienteSelecionado.textoEmail.setText(contato.get(0).getEmail());

                    // Preenche painel de alterar com o id.
                    clienteSelecionado.textoID_Cliente.setText(ID);

                } catch (IOException ex) {

                    // Mensagem.
                    JOptionPane.showMessageDialog(null, "Erro na busca", "Erro", JOptionPane.ERROR);

                }

            }

        }
    }//GEN-LAST:event_tabelaClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton labelBuscar;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables
}
