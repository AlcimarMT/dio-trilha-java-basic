import java.util.Scanner;


public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm =  terminal.nextInt();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException e) {
			System.out.println("O segundo parâmetro deve ser maior que o primeiro.");
		}
		terminal.close();
	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
       
		//realizar o for para imprimir os números com base na variável contagem
        if (parametroUm > parametroDois) throw new ParametrosInvalidosException();
        else {
            String pUm = Integer.toString(parametroUm);
            String pDois = Integer.toString(parametroDois);
            for (int i = 0; i < pUm.length(); i++) System.out.println("Imprimindo o número "+ pUm.charAt(i));
            System.out.println("");
            for (int i = 0; i < pDois.length(); i++) System.out.println("Imprimindo o número "+ pDois.charAt(i));
        }
        
	}
}