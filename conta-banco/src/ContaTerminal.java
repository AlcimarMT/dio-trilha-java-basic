import java.util.Locale;
import java.util.Scanner;

//Variaveis requisitadas:
//Numero, inteiro;
//Agencia, Texto;
//Nome Cliente, Texto;
//Saldo, Decimal.

//"Olá [Nome Cliente], obrigado por criar uma conta em nosso banco, sua agência 
//é [Agencia], conta [Numero] e seu saldo [Saldo] já está disponível para saque."
public class ContaTerminal {

    public static void main(String[] args) {
        int minNumero = 10000;
        int maxNumero = 99999;
        int minAgencia = 1000;
        int maxAgencia = 9999;

        int randomNumero = (int) Math.floor(Math.random() * (maxNumero - minNumero) + minNumero);
        int randomAgencia = (int) Math.floor(Math.random() * (maxAgencia - minAgencia) + minAgencia);
        String numeroAgencia = Integer.toString( randomAgencia);

        int digitoVerificador = (int) Math.floor(Math.random()*9+1);
        String numeroContaBanco = "000" + randomNumero + "-" + digitoVerificador;
        //Print both numeroContaBanco e numeroAgencia
        //System.out.println("Numero da Conta Bancária: "+numeroContaBanco+ "; Numero da Agência: "+randomAgencia);


        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o seu nome completo: ");
        
        String nomeCompleto = scanner.nextLine();
        
        System.out.println("Digite o saldo da conta: ");
        String saldo = scanner.nextLine();

        scanner.close();
        
        
        System.out.println("Olá "+ nomeCompleto+", obrigado por criar uma conta em nosso banco, sua agência "+ numeroAgencia+", conta "+ numeroContaBanco+" e seu saldo R$ "+saldo+ " já está disponível para saque.");
        
    }
}
