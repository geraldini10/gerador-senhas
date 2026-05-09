import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean usarMaiusculas;
        boolean usarMinusculas;
        boolean usarNumeros;
        boolean usarSimbolos;
        int tamanho;

        System.out.println("=== Gerador de senhas ===");
        System.out.println("Digite o tamanho da senha: ");
        tamanho = input.nextInt();

        System.out.println("Usar maiúsculas? (s/n)");
        usarMaiusculas = input.next().equals("s");
        System.out.println("Usar minusculas? (s/n)");
        usarMinusculas = input.next().equals("s");
        System.out.println("Usar números? (s/n)");
        usarNumeros = input.next().equals("s");
        System.out.println("Usar simbolos? (s/n)");
        usarSimbolos = input.next().equals("s");

        String senha = gerarSenha(tamanho, usarMaiusculas, usarMinusculas, usarNumeros, usarSimbolos);
        if (senha != null) {
            System.out.println("Senha gerada: " + senha);
        }
    }

    static String gerarSenha(int tamanho, boolean usarMaiusculas, boolean usarMinusculas, boolean usarNumeros, boolean usarSimbolos) {
        String caracteres = "";
        if (usarMaiusculas) caracteres += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (usarMinusculas) caracteres += "abcdefghijklmnopqrstuvwxyz";
        if (usarNumeros)    caracteres += "0123456789";
        if (usarSimbolos)   caracteres += "!@#$%&*()-_=+?";

        if (caracteres.isEmpty()) {
            System.out.println("Erro: selecione ao menos um tipo de caractere!");
            return null;
        }

        Random random = new Random();
        String senha = "";
        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(caracteres.length());
            senha += caracteres.charAt(indice);
        }
        return senha;
    }
}