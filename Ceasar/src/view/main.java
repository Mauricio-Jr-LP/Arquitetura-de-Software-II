package view;
//Importações
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import view.TelaInicial;

//classe main é a principal e ela que sera executada
public class main
{	
	public static void main(String st[]) 
	{
		//invoca a tela
        SwingUtilities.invokeLater(new Runnable()
        {
        	//executa
            public void run()
            {
            	//cria objeto
                TelaInicial ti = new TelaInicial();
                
                //executa o metodo load
                ti.load();
            }
        });
    }
}