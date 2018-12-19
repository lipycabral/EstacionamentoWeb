package controladores;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Vaga;
import repositorios.VagaRepositorio;

@ManagedBean(name="vagaControlador")
@SessionScoped
public class VagaControlador {
	private VagaRepositorio vr;
	private List<Vaga> vagas;
	private String chaveNome="";
	private Vaga vaga;
	
	public VagaControlador() {
		vr = new VagaRepositorio();
	}
	
	public Vaga getVaga() {
		return vaga;
	}
	
	public String getChaveNome() {
		return chaveNome;
	}
	
	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}
	
	public List<Vaga> getVagas() {
		vagas = vr.recuperarTodos();
		return vagas;
	}
	
	//Interface
	public String incluir() {
		vaga = new Vaga();
		return "vagaInclusao";
	}
	
	public String editar(Vaga vaga) {
		this.vaga = vaga;
		return "vagaEdicao";
	}
	
	public String excluir(Vaga vaga) {
		this.vaga = vaga;
		return "vagaExclusao";
	}
	
	//Controles
	
	public String adicionar() {
		vr.adicionar(vaga);
		return "telaPrincipal";
	}
	
	public String atualizar() {
		vr.atualizar(vaga);
		return "vagaListagem";
	}

	public String remover() {
		vr.remover(vaga);
		return "vagaListagem";
	}	
	
}
