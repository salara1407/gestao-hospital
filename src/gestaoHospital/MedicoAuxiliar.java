package gestaoHospital;

public class MedicoAuxiliar extends Medico {

	public MedicoAuxiliar(String CRM, String nome, int idade, double salario) {
        super(CRM, nome, idade, salario);
    }

    @Override
    public boolean medicoAposentado() {
        return getIdade() >= 60;
    }
	public MedicoAuxiliar() {
		// TODO Auto-generated constructor stub
	}

}
