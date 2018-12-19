package controladores;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Atendente;
import repositorios.AtendenteRepositorio;

@ManagedBean(name="atendenteControlador")
@SessionScoped
public class AtendenteControlador {
	private AtendenteRepositorio ar;
	private List<Atendente> atendentes;
	private String chaveNome="";
	private Atendente atendente;
	
	public AtendenteControlador() {
		ar = new AtendenteRepositorio();
	}
	
	public Atendente getAtendente() {
		return atendente;
	}
	
	public String getChaveNome() {
		return chaveNome;
	}
	
	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}
	
	public List<Atendente> getAtendentesPorNome() {
		atendentes = ar.recuperarTodosPorNomeEspecifico(chaveNome);
		return atendentes;
	}
	
	public List<Atendente> getAtendentes() {
		atendentes = ar.recuperarTodos();
		
		return atendentes;
	}
	
	//Interface
	public String incluir() {
		atendente = new Atendente();
		return "atendenteInclusao";
	}
	
	public String editar(Atendente atendente) {
		this.atendente = atendente;
		return "atendenteEdicao";
	}
	
	public String excluir(Atendente atendente) {
		this.atendente = atendente;
		return "atendenteExclusao";
	}
	
	//Controles
	
	public String adicionar() {
		ar.adicionar(atendente);
		
		return "telaPrincipal";
	}
	
	public String atualizar() {
		ar.atualizar(atendente);
		return "atendenteListagem";
	}

	public String remover() {
		ar.remover(atendente);
		return "atendenteListagem";
	}
	
	
	
}
