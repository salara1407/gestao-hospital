package gestaoHospital;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	private static ArrayList<Medico> medicos = new ArrayList<>();
    private static Scanner tc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar médico");
            System.out.println("2. Buscar médico por CRM");
            System.out.println("3. Remover médico por CRM");
            System.out.println("4. Listar todos os médicos cadastrados");
            System.out.println("5. Sair");
            System.out.print("Digite a opção desejada: ");

            op = tc.nextInt();
            tc.nextLine(); 

            switch (op) {
                case 1:
                    cadastrarMedico();
                    break;
                case 2:
                    buscarMedico();
                    break;
                case 3:
                    removerMedico();
                    break;
                case 4:
                    listarMedicos();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 5);
    }

    private static void cadastrarMedico() {
        System.out.println("\nEscolha o tipo de médico:");
        System.out.println("1. Médico Cirurgião");
        System.out.println("2. Médico Auxiliar");
        int tipoM = tc.nextInt();
        tc.nextLine();

        if (tipoM != 1 && tipoM != 2) {
            System.out.println("Opção inválida! Cadastro cancelado.");
            return;
        }

        System.out.print("Digite o CRM: ");
        String crm = tc.nextLine();

        System.out.print("Digite o Nome: ");
        String nome = tc.nextLine();

        System.out.print("Digite a Idade: ");
        int idade = tc.nextInt();

        System.out.print("Digite o Salário: ");
        double salario = tc.nextDouble();

        if (tipoM == 1) {
            medicos.add(new MedicoCirurgiao(crm, nome, idade, salario));
        } else {
            medicos.add(new MedicoAuxiliar(crm, nome, idade, salario));
        }

        System.out.println("Médico cadastrado com sucesso!");
    }

    private static void buscarMedico() {
        System.out.print("\nDigite o CRM do médico: ");
        String CRM = tc.nextLine();

        for (Medico m : medicos) {
            if (m.getCrm().equalsIgnoreCase(CRM)) {
                System.out.println("\n--- DADOS DO MÉDICO ---");
                System.out.println(m);
                System.out.println("Status da Aposentadoria: " + (m.medicoAposentado() ? "Aposentado" : "Ativo"));
                System.out.println("Valor da Aposentadoria: R$ " + m.valorAposentadoria());
                return;
            }
        }
        System.out.println("Médico com CRM " + CRM + " não foi encontrado.");
    }

    private static void removerMedico() {
        System.out.print("\nDigite o CRM do médico a ser removido: ");
        String CRM = tc.nextLine();

        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getCrm().equalsIgnoreCase(CRM)) {
                medicos.remove(i);
                System.out.println("Médico removido com sucesso!");
                return;
            }
        }
        System.out.println("Médico com CRM " + CRM + " não foi encontrado.");
    }

    private static void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("\nNenhum médico cadastrado no sistema.");
            return;
        }

        System.out.println("\n--- LISTA DE MÉDICOS ---");
        for (Medico m : medicos) {
            System.out.println(m);
        }
    }
}
