import java.util.Scanner;


public class HashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
       
       
        System.out.print("Digite a quantidade de alunos: ");
        int quantidadeAlunos;
        try {
            quantidadeAlunos = Integer.parseInt(scanner.nextLine());
            if (quantidadeAlunos <= 0) {
                System.out.println("Erro: Quantidade de alunos deve ser maior que zero!");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido para a quantidade de alunos!");
            scanner.close();
            return;
        }
       
   
        System.out.print("Digite a quantidade de notas por aluno: ");
        int quantidadeNotas;
        try {
            quantidadeNotas = Integer.parseInt(scanner.nextLine());
            if (quantidadeNotas <= 0) {
                System.out.println("Erro: Quantidade de notas deve ser maior que zero!");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido para a quantidade de notas!");
            scanner.close();
            return;
        }
       
       
        String[] nomes = new String[quantidadeAlunos];
        double[] medias = new double[quantidadeAlunos];
       
   
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
            if (nomes[i].trim().isEmpty()) {
                System.out.println("Erro: O nome do aluno não pode ser vazio!");
                scanner.close();
                return;
            }
           
            double somaNotas = 0;
            for (int j = 0; j < quantidadeNotas; j++) {
                System.out.print("Digite a nota " + (j + 1) + " do aluno " + nomes[i] + ": ");
                try {
                    double nota = Double.parseDouble(scanner.nextLine());
                    if (nota < 0 || nota > 10) {
                        System.out.println("Erro: A nota deve estar entre 0 e 10!");
                        scanner.close();
                        return;
                    }
                    somaNotas += nota;
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite uma nota válida!");
                    scanner.close();
                    return;
                }
            }
            medias[i] = somaNotas / quantidadeNotas;
        }
       
       
        System.out.println("\nResultados:");
        for (int i = 0; i < quantidadeAlunos; i++) {
            String resultado = medias[i] >= 6.0 ? "Aprovado" : "Reprovado";
            System.out.printf("%s [%.2f] [%s]%n", nomes[i], medias[i], resultado);
        }
       
        System.out.println("Processamento concluído com sucesso!");
        scanner.close();
    }
}
