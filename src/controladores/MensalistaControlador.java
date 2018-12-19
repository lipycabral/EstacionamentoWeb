package controladores;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Mensalista;
import entidades.Placa;
import repositorios.MensalistaRepositorio;

@ManagedBean(name="mensalistaControlador")
@SessionScoped
public class MensalistaControlador {
	private MensalistaRepositorio mr;
	private List<Mensalista> mensalistas;
	private List<Placa> placas;
	private Mensalista mensalista;
	private Placa placa;
	
	public MensalistaControlador() {
		mr = new MensalistaRepositorio();
	}
	
	public Mensalista getMensalista() {
		return mensalista;
	}
	
	public List<Mensalista> getMensalistas() {
		mensalistas = mr.recuperarTodos();
		return mensalistas;
	}
	
	
	public Placa getPlaca() {
		return placa;
	}
	
	//Interface
	
	public String incluir() {
		mensalista = new Mensalista();
		return "mensalistaInclusao";
	}
	

	public String editar(Mensalista mensalista) {
		this.mensalista = mensalista;
		return "mensalistaEdicao";
	}

	public String excluir(Mensalista mensalista) {
		this.mensalista = mensalista;
		return "mensalistaExclusao";
	}
	
	//Controles
	
	public String adicionar() {
		mr.adicionar(mensalista);
		return "mensalistaListagem";
	}
	
	
	public String atualizar() {
		mr.atualizar(mensalista);
		return "mensalistaListagem";
	}

	public String remover() {
		mr.remover(mensalista);
		return "mensalistaListagem";
	}
	
	
}
