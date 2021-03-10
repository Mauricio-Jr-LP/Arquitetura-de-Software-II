package control;

//Importações
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Criptografia;

//Classe txtAbrir que é uma tela que receber o texto e salvar em um txt
public class txtNovo extends JFrame 
{
	//Definindo uma area de texto
	JTextArea areaDeTexto;

	//Definindo um botao
	JButton botao;

	//metodo construtor
	public txtNovo() 
	{
		//Declarando a area de texto
		areaDeTexto = new JTextArea();

		//Adicionando o area de texto e definindo  sua localização na tela
		add(areaDeTexto,"Center");

		//Declarando o botao
		botao = new JButton("Salvar");

		//Adicionando o botao e definindo  sua localização na tela
		add(botao,"South");

		//Função do botão
		botao.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Classe para abrir um explorador de arquivos para selecionar
				JFileChooser fileC= new JFileChooser();
				fileC.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				//saivado arquivo e pondo em uma variavel inteira para fazer a verificação
				int i= fileC.showSaveDialog(null);

				//se n selecionou aqruivo
				if (i==1)
				{
					//Exibi uma msg de erro
					JOptionPane.showMessageDialog(null, "Voce nao escolheu nome de arquivo nenhum",
							"alerta", JOptionPane.ERROR_MESSAGE);
				} 
				
				//se colocou
				else 
				{
					//pega arquivo selecionado
					File arquivo = fileC.getSelectedFile();
					
					//ler texto do arquivo
					FileWriter arq;
					
					//tratar
					try 
					{
						//ler o texto do arquivo
						arq = new FileWriter(arquivo.getAbsolutePath());
						
						//grava o texto
						PrintWriter gravarArq = new PrintWriter(arq);

						//Pede a chave
						int chave = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a chave:"));

						//Criptografa o texto
						String novoTexto = Criptografia.encriptar(chave, areaDeTexto.getText());

						//Salva o arquivo
						gravarArq.printf(novoTexto+"%n");

						//Fecha o arquivp
						arq.close();

						//Exibi msg falando que salvou e exibi o nome do aquivo
						JOptionPane.showMessageDialog(null,"O arquivo "+arquivo.getName() +" foi salvo com sucesso!",
								"alerta", JOptionPane.INFORMATION_MESSAGE);
					} 
					
					//se não for
					catch (IOException e1) 
					{
						//alerta de erro
						e1.printStackTrace();
					}
				}
			}
		});

		//propriedades da tela 
		setLocationRelativeTo(null);
		setSize(400,400);
		setVisible(true);
	}
}