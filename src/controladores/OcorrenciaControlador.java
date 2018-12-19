package controladores;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Ocorrencia;
import repositorios.OcorrenciaRepositorio;

@ManagedBean(name="ocorrenciaControlador")
@SessionScoped
public class OcorrenciaControlador {
	private OcorrenciaRepositorio mr;
	private List<Ocorrencia> ocorrencias;
	private Ocorrencia ocorrencia;

	
	public OcorrenciaControlador() {
		mr = new OcorrenciaRepositorio();
	}
	
	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}
	
	public List<Ocorrencia> getOcorrencias() {
		ocorrencias = mr.recuperarTodos();
		return ocorrencias;
	}
	
	//Interface
	
	public String incluir() {
		ocorrencia = new Ocorrencia();
		return "ocorrenciaInclusao";
	}

	public String editar(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
		return "ocorrenciaEdicao";
	}

	public String excluir(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
		return "ocorrenciaExclusao";
	}
	
	//Controles
	
	public String adicionar() {
		Date data = new Date(System.currentTimeMillis());
		ocorrencia.setData(data);
		mr.adicionar(ocorrencia);
		return "ocorrenciaListagem";
	}
	
	public String atualizar() {
		mr.atualizar(ocorrencia);
		return "ocorrenciaListagem";
	}

	public String remover() {
		mr.remover(ocorrencia);
		return "ocorrenciaListagem";
	}
	
	
}
