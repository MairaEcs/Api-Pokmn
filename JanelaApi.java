import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.edu.iftm.api.Api;
import br.edu.iftm.api.JsonParser;

public class JanelaApi {
	public static void criarJanela {
		JFrame janela = new JFrame();
		
		janela.setBounds(250, 100, 400, 400);
		janela.setLayout(null);
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setResizable(false);
		
		JPanel panelEsquerda = new JPanel();
		panelEsquerda.setBackground(Color.WHITE);
		panelEsquerda.setBounds(140, 0, 250, 365);
		janela.add(panelEsquerda);
		
		JPanel panelDireita = new JPanel();
		panelDireita.setBackground(SystemColor.inactiveCaption);
		panelDireita.setBounds(0, 0, 142, 365);
		panelDireita.setLayout(null);
		janela.add(panelDireita);
		
		JLabel label = new JLabel("Nome do pokemon:");
		label.setBounds(10, 28, 122, 20);
		panelDireita.add(label);
		
		JTextField campoTexto = new JTextField();
		campoTexto.setBounds(10, 59, 122, 20);
		panelDireita.add(campoTexto);
		campoTexto.setColumns(10);
		
		JButton botao = new JButton("PESQUISAR");
		botao.setBackground(Color.WHITE);
		botao.setForeground(Color.BLACK);
		botao.setBounds(10, 90, 120, 23);
		panelDireita.add(botao);

	}

}
