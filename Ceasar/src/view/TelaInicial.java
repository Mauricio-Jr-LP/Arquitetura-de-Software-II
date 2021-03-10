package view;

//Importações
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.txtAbrir;
import control.txtNovo;

//Classe responsavel pra acessa as outras telas, essa é a tela "inicial"
public class TelaInicial extends JFrame
{
	//Criando tela
	protected JFrame  janela = new JFrame("Tela Inicial");
	
	//instanciando label
	private JLabel lab;
	
	//instanciando botoes
	JButton criar;
	JButton abrir;
	
	//instanciando telas
	txtNovo telaTxtNovo;
	txtAbrir abrirTxt;

	//contrutor
	public TelaInicial() 
	{
		//dando valor as variavies
		lab = new JLabel("O que deseja fazer?");
		criar = new JButton("Criar arquivo de texto");
		abrir = new JButton("Abrir arquivo de texto");

		//Criando função do botao criar
		criar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//chama a tela que instaciou anteriormente
				telaTxtNovo = new txtNovo();

			}
		});

		//Criando função do botao criar
		abrir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//chama a tela que instaciou anteriormente
				abrirTxt = new txtAbrir();
			}
		});
	}	

	//metodo load
	public void load() 
	{
		//Configurando tela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //se fechar a janela encerra o sistema
		janela.setSize(new Dimension(500, 300));   //Dimencçoes do painel
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);//Aparecer no meio da tela

		//Criando container
		Container c = janela.getContentPane();
		c.setLayout(null); //vamos fazer a gestão manualmente
		lab.setBounds(200, 75, 250, 50);//dimensoes e posicionamento da label (os dois primeiros valores indicam a posicao absoluta da label)
		abrir.setBounds(0, 200, 250, 50); //dimensoes e posicionamento do botão (os dois primeiros valores indicam a posicao absoluta do botao)
		criar.setBounds(250, 200, 250, 50); //dimensoes e posicionamento do botão (os dois primeiros valores indicam a posicao absoluta do botao)
		
		
		c.add(lab); //Adicionando label
		c.add(abrir); //Adicionando botao
		c.add(criar); //Adicionando botao
	}

}
