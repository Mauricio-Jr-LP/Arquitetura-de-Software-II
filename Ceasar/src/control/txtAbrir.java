package control;
//Importações
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import model.Criptografia;


//Classe txtAbrir que é uma tela que vai ser usada para abrir arquivos txt
public class txtAbrir extends JFrame
{
	//Definindo uma area de texto
	JTextArea areaDeTexto;
	
	//Definindo um botao
	JButton botao;

	//metodo construtor
	public txtAbrir() 
	{
		//Declarando a area de texto
		areaDeTexto = new JTextArea();
		
		//Adicionando o area de texto e definindo  sua localização na tela
		add(areaDeTexto,"Center");

		//Declarando o botao
		botao = new JButton("Salvar");
		
		//Adicionando o botao e definindo  sua localização na tela
		add(botao,"South");

		//Classe para abrir um explorador de arquivos para selecionar
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);

		//Caso seja aticado
		if (returnValue == JFileChooser.APPROVE_OPTION) 
		{
			//Pega o arquivo selecionado
			File selectedFile = jfc.getSelectedFile();

			//Caso arquivo seja diferente de null
			if(selectedFile != null) 
			{
				try 
				{
					//ler o arquivo selecionado
					FileReader arq = new FileReader(selectedFile);
					
					//pega o texto e poem em uma variavel 
					BufferedReader lerArq = new BufferedReader(arq);

					//Pede a chave
					int chave = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a CHAVE: "));//chave será um número que deslocará a mensagem pela sua quantidade (msg 'a' e chave = 3, cifra= 'c')
				
					//Trata para que a chave seja de um numero menor ou igual ao alfabeto
					while (chave >= 26) 
					{
						//chave tem que ter o tamanho do alfabeto
						chave = chave - 26;
					}

					// lê a primeira linha
					String linha = lerArq.readLine(); 
					
					//Cria uma variavel e joga o texto criptografado
					String txt = Criptografia.decriptar(chave, linha);
					
					//Joga o texto na area de texto da tela
					areaDeTexto.setText(txt);
					
					//fecha arquivo
					arq.close();
				} 
				//caso n execute
				catch (IOException e) 
				{
					//exibe erro pro user
					System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
				}
			}
		}

		//ação do botao
		botao.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Explica o usuario para ele salvar corretamente o usuario
				JOptionPane.showMessageDialog(null,"Selecione o arquivo que voçê abriu");
				
				//Abre a classe do java pra seleciona o local onde vai salvar
				JFileChooser fileC= new JFileChooser();
				
				//No modo de seleção
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
				
				//se selecinou
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