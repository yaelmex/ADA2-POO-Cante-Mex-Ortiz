import java.util.Stack;

public class Tareas {
	private String asunto;
	private String categoria;
	private String importancia;
	private String descripcion;
	Stack <Tareas> tarea;
	
	public Tareas(String asunto, String categoria, String importancia, String descripcion) {
		this.asunto = asunto;
		this.categoria = categoria;
		this.importancia = importancia;
		this.descripcion = descripcion;
	}
	//Landy
	public Stack<Tareas> filtrar (String filtro) {
		Stack<Tareas> filtrados = new Stack <Tareas>(); //Crear pila para las tareas
		for (Tareas importancia : tarea) {
			if (importancia.getImportancia().equalsIgnoreCase(filtro)
					|| importancia.getAsunto()!= null) {
				filtrados.push(importancia);
			}
		}
		return filtrados;
	}
	
	
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getImportancia() {
		return importancia;
	}
	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
