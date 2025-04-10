
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame {
    private JTextField nomeField, quantidadeField, precoField;
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<Produtos> produtos;

    public App() {
        setTitle("Loja de Utilidades");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        produtos = new ArrayList<>();

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome do Produto:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        panel.add(quantidadeField);

        panel.add(new JLabel("Preço:"));
        precoField = new JTextField();
        panel.add(precoField);

        JButton addButton = new JButton("Adicionar Produto");
        panel.add(addButton);

        JButton removeButton = new JButton("Remover Produto");
        panel.add(removeButton);

        add(panel, BorderLayout.NORTH);

        // Tabela de Produtos
        String[] colunas = {"Nome", "Quantidade", "Preço"};
        tableModel = new DefaultTableModel(colunas, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Ações dos Botões
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProduto();
            }
        });

        setVisible(true);
    }

    private void adicionarProduto() {
        try {
            String nome = nomeField.getText();
            int quantidade = Integer.parseInt(quantidadeField.getText());
            double preco = Double.parseDouble(precoField.getText());

            Produtos produto = new Produtos(nome, quantidade, preco);
            produtos.add(produto);

            atualizarTabela();

            nomeField.setText("");
            quantidadeField.setText("");
            precoField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerProduto() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            produtos.remove(selectedRow);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Produtos p : produtos) {
            tableModel.addRow(new Object[]{p.getNome(), p.getQuantidade(), p.getPreco()});
        }
    }

    public static void main(String[] args) {
        new App();
    }
}

