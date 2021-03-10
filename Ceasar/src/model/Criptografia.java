package model;

//essa classe � quem vai mdua o texto
public class Criptografia 
{
	//metodo encriptar que precisa de uma chave e do texto para ser executado
	public static String encriptar(int chave, String texto) 
	{
		// Variavel que ira guardar o texto
		StringBuilder escrivao= new StringBuilder();

		//Inicio da repeti��o que ira ler o texto todo 
		for(int i=0; i<texto.length();i++) 
		{
			//Inicio da condi��o para saber se o caracter � do alfabeto
			if(Character.isAlphabetic(texto.charAt(i))) 
			{
				//Inicio da condi��o para saber se a letra � maiscula
				if (Character.isUpperCase(texto.charAt(i))) 
				{ 
					//Criptografia de cesar
					char ch = (char)(((int)texto.charAt(i) + chave - 65) % 26 + 65); 

					//Salvar riptografia de cesar
					escrivao.append(ch);
				}//fim do if

				//Caso n�o seja da condi��o anterior
				else
				{ 
					//Criptografia de cesar
					char ch = (char)(((int)texto.charAt(i) + chave - 97) % 26 + 97); 
					//Salvar riptografia de ces
					escrivao.append(ch);  	
				}// fim da sedunda op��o
			}//fim verifica��o se � do alfabeto

			//Se n for do alfabeto
			else 
			{		
				//Salva sem criptografa
				escrivao.append(texto.charAt(i));
			}//fim do else

		}
		//Retorna o texto
		return escrivao.toString(); 
	}

	//metodo descriptar que precisa de uma chave e do texto para ser executado
	public static String decriptar(int chave, String textoCifrado) 
	{
		// Variavel que ira guardar o texto decifrado
		StringBuilder texto = new StringBuilder();

		// Variavel com tamanho do texto a ser decriptado
		int tamanhoTexto = textoCifrado.length();

		// Descriptografa cada caracter por vez
		for(int c=0; c < tamanhoTexto; c++)
		{
			// Transforma o caracter em codigo ASCII e faz a descriptografia
			int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - chave;

			// Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
			while(letraDecifradaASCII < 32)
				letraDecifradaASCII += 94;

			// Transforma codigo ASCII descriptografado em caracter ao novo texto
			texto.append((char)letraDecifradaASCII );
		}

		// Por fim retorna a mensagem descriptografada por completo
		return texto.toString();
	}
}
