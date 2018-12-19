package controladores;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Atendente;
import entidades.Inadimplente;
import repositorios.AtendenteRepositorio;
import repositorios.InadimplenteRepositorio;

@ManagedBean(name="inadimplenteControlador")
@SessionScoped
public class InadimplenteControlador {
	private InadimplenteRepositorio ir;
	private List<Inadimplente> inadimplentes;
	private String chaveNome="";
	private Inadimplente inadimplente;
	
	public InadimplenteControlador() {
		// TODO Auto-generated constructor stub
		ir = new InadimplenteRepositorio();
	}	
	public Inadimplente getInadimplente() {
		return inadimplente;
	}
	
	public String getChaveNome() {
		return chaveNome;
	}
	
	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}
	
	
	public List<Inadimplente> getInadimplentes() {
		inadimplentes = ir.recuperarTodos();
		return inadimplentes;
	}
	
	//Interface
	public String incluir() {
		inadimplente = new Inadimplente();
		return "inadimplenteInclusao";
	}
	
	public String editar(Inadimplente inadimplente) {
		this.inadimplente = inadimplente;
		return "inadimplenteEdicao";
	}
	
	public String excluir(Inadimplente inadimplente) {
		this.inadimplente = inadimplente;
		return "inadimplenteExclusao";
	}
	
	//Controles
	
	public String adicionar() {
		ir.adicionar(inadimplente);
		
		return "telaPrincipal";
	}
	
	public String atualizar() {
		ir.atualizar(inadimplente);
		return "inadimplenteListagem";
	}

	public String remover() {
		ir.remover(inadimplente);
		return "inadimplenteListagem";
	}
	
	
	
}
