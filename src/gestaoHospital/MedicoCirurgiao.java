package gestaoHospital;

public class MedicoCirurgiao extends Medico{
	
	 public MedicoCirurgiao(String CRM, String nome, int idade, double salario) {
	        super(CRM, nome, idade, salario);
	    }

	    @Override
	    public boolean medicoAposentado() {
	        return getIdade() >= 50;
	    }

	    @Override
	    public double valorAposentadoria() {
	        return super.valorAposentadoria() + 800.0;
	    }

	public MedicoCirurgiao() {
		// TODO Auto-generated constructor stub
	}

}
