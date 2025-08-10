import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;

public class CadastroSimples {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(580, 150);
        frame.setLayout(new FlowLayout());

        
        JTextField nome = new JTextField(20);
        JTextField email = new JTextField(20);                        // Aqui eu to criando os campos para o usuário digitar as informações
        JTextField idade = new JTextField(5);

       
        JRadioButton masc = new JRadioButton("Masculino");
        JRadioButton fem = new JRadioButton("Feminino");
        ButtonGroup grupoSexo = new ButtonGroup();                             // Aqui vai escolher o sexo
        grupoSexo.add(masc);
        grupoSexo.add(fem);

      
        JButton cadastrar = new JButton("Cadastrar");                     // Botões de cadastrar e limpar
        JButton limpar = new JButton("Limpar");

        
        frame.add(new JLabel("Nome:"));                                  // vai colocar texto antes dos inputs
        frame.add(nome);

        frame.add(new JLabel("E-mail:"));
        frame.add(email);

        frame.add(new JLabel("Idade:"));
        frame.add(idade);

        frame.add(new JLabel("Sexo:"));
        frame.add(masc);
        frame.add(fem);

        frame.add(cadastrar);
        frame.add(limpar);
        frame.setVisible(true);

        
        cadastrar.addActionListener(e -> {                               // aqui o botão vai realizar o cadastro
            String n = nome.getText().trim();
            String em = email.getText().trim();                         
            String age = idade.getText().trim();
            String sexo = masc.isSelected() ? "Masculino" : fem.isSelected() ? "Feminino" : "";

            if (n.isEmpty() || em.isEmpty() || age.isEmpty() || sexo.isEmpty()) {          // aqui ele ve se tem algum campo vazio
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
            } else if (!em.matches(".+@.+\\..+")) {  //Essa expressão checa se o texto tem formato de um e-mail 
                JOptionPane.showMessageDialog(frame, "E-mail inválido.");
            } else {
                JOptionPane.showMessageDialog(frame,
                    "Usuário cadastrado:\n" +
                    "Nome: " + n + "\n" +
                    "E-mail: " + em + "\n" +         // aqui mostra os dados do usuario cadastrado
                    "Idade: " + age + "\n" +
                    "Sexo: " + sexo);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("cadastros.txt", true))) {
                writer.write("Usuário:\n");
                writer.write("Nome: " + n + "\n");
                writer.write("E-mail: " + em + "\n");                   // aqui eu pesquisei e fiz uma forma de salvar em um arquivo txt
                writer.write("Idade: " + age + "\n");
                writer.write("Sexo: " + sexo + "\n");
                writer.write("\n");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao salvar no arquivo.");
            }

        });

        
        limpar.addActionListener(e -> {
            nome.setText("");
            email.setText("");                       // limpa as informações dos campos
            idade.setText("");
            grupoSexo.clearSelection();
        });
    }
}
 