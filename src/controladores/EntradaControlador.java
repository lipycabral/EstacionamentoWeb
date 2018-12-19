package controladores;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Entrada;
import entidades.Placa;
import repositorios.EntradaRepositorio;

@ManagedBean(name="entradaControlador")
@SessionScoped
public class EntradaControlador {
	private EntradaRepositorio er;
	private List<Entrada> entradas;
	private Entrada entrada;
	private Date data;
	
	public EntradaControlador() {
		er = new EntradaRepositorio();
	}

	public Entrada getEntrada() {
		return entrada;
	}
	
	public List<Entrada> getEntradas() {
		entradas = er.recuperarTodos();
		return entradas;
	}
	
	//Interface
	public String incluir() {
		entrada = new Entrada();
		data = new Date();
		return "entradaInclusao";
	}
		
	public String editar(Entrada e) {
		this.entrada = e;
		return "entradaEdicao";
	}
		
	public String excluir(Entrada e) {
		this.entrada = e;
		return "entradaExclusao";
	}
	
	//Controles
	
	public String adicionar() {
		entrada.setEntrada(data);
		er.adicionar(entrada);
		return "telaPrincipal";
	}
	
	public String atualizar() {
		er.atualizar(entrada);
		return "entradaListagem";
	}

	public String remover() {
		er.remover(entrada);
		return "entradaListagem";
	}
	
	
}
