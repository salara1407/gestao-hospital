package gestaoHospital;

/*Abstração e Herança:
○ Crie uma classe abstrata Medico que serve de base para as especialidades. A classe deve
conter os seguintes atributos privados: crm (String), nome (String), idade (int) e salario
(double).
○ Implemente os métodos Getters e Setters para todos os atributos.
○ Declare os métodos abstratos (ou base) boolean medicoAposentado() e double
valorAposentadoria().
○ Crie duas classes filhas que herdam de Medico: MedicoAuxiliar e MedicoCirurgiao.*/

public abstract class Medico {
	private String CRM;
    private String nome;
    private int idade;
    private double salario;

    public Medico(String CRM, String nome, int idade, double salario) {
        this.CRM = CRM;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    
    public abstract boolean medicoAposentado();

    public double valorAposentadoria() {
        return salario * 0.8;
    }

 
    public String getCrm() {
        return CRM;
    }

    public void setCrm(String CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "CRM: " + CRM + " | Nome: " + nome + " | Idade: " + idade + " | Salário: R$ " + salario;
    }

	public Medico() {
		// TODO Auto-generated constructor stub
	}

}
