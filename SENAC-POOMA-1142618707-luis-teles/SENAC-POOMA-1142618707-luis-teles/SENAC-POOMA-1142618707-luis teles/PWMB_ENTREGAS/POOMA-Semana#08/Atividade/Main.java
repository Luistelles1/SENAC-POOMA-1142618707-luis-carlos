import java.util.Scanner;

// Classe base para representar um funcionário
class Funcionario {
    String nome;
    String departamento;
    String funcao;
    double salario;

    // Construtor
    public Funcionario(String nome, String departamento, String funcao, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.funcao = funcao;
        this.salario = salario;
    }

    // Método para imprimir o comprovante de pagamento
    public void imprimirComprovante() {
        System.out.println("Nome do funcionário: " + nome);
        System.out.println("Departamento: " + departamento);
        System.out.println("Função: " + funcao);
        System.out.println("Salário: R$" + salario);
    }
}

// Classe para representar um funcionário tarefeiro
class Tarefeiro extends Funcionario {
    int quantidadeTarefas;
    double valorTarefa;

    // Construtor
    public Tarefeiro(String nome, String departamento, int quantidadeTarefas, double valorTarefa) {
        super(nome, departamento, "Tarefeiro", quantidadeTarefas * valorTarefa);
        this.quantidadeTarefas = quantidadeTarefas;
        this.valorTarefa = valorTarefa;
    }
}

// Classe para representar um funcionário horista
class Horista extends Funcionario {
    double horasTrabalhadas;
    double valorHora;

    // Construtor
    public Horista(String nome, String departamento, double horasTrabalhadas, double valorHora) {
        super(nome, departamento, "Horista", horasTrabalhadas * valorHora);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }
}

// Classe para representar um funcionário mensalista
class Mensalista extends Funcionario {
    // Construtor
    public Mensalista(String nome, String departamento, double salarioMensal) {
        super(nome, departamento, "Mensalista", salarioMensal);
    }
}

public class FolhaDePagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicite informações do funcionário
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Tipo de vínculo (Tarefeiro/Horista/Mensalista): ");
        String tipoVinculo = scanner.nextLine();

        // Com base no tipo de vínculo, colete informações específicas e crie o funcionário correspondente
        Funcionario funcionario = null;
        if (tipoVinculo.equalsIgnoreCase("Tarefeiro")) {
            System.out.print("Quantidade de tarefas: ");
            int quantidadeTarefas = scanner.nextInt();
            System.out.print("Valor da tarefa: ");
            double valorTarefa = scanner.nextDouble();
            funcionario = new Tarefeiro(nome, departamento, quantidadeTarefas, valorTarefa);
        } else if (tipoVinculo.equalsIgnoreCase("Horista")) {
            System.out.print("Horas trabalhadas: ");
            double horasTrabalhadas = scanner.nextDouble();
            System.out.print("Valor da hora: ");
            double valorHora = scanner.nextDouble();
            funcionario = new Horista(nome, departamento, horasTrabalhadas, valorHora);
        } else if (tipoVinculo.equalsIgnoreCase("Mensalista")) {
            System.out.print("Salário mensal: ");
            double salarioMensal = scanner.nextDouble();
            funcionario = new Mensalista(nome, departamento, salarioMensal);
        } else {
            System.out.println("Tipo de vínculo inválido.");
            scanner.close();
            return;
        }

        // Imprima o comprovante de pagamento
        System.out.println("\nComprovante de Pagamento:");
        funcionario.imprimirComprovante();

        scanner.close();
    }
}