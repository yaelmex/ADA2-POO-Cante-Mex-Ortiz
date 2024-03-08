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
	
	//Constructor vacío que inicializa el Stack
	public Tareas() {
		tarea = new Stack<Tareas>();
	}
	
	//Método agregar
	public void Agregar(Tareas TareaNueva) {
		tarea.push(TareaNueva);
	}
	
	//Método para marcar como hecho
	public Stack<Tareas> hecho(String asunto){
		Stack <Tareas> actualizados = new Stack<Tareas>();
		for(Tareas hecho : tarea) {
			if(hecho.getAsunto().equalsIgnoreCase(asunto)) {
				hecho.setAsunto(null);
				hecho.setCategoria(null);
				hecho.setDescripcion(null);
				hecho.setImportancia(null);
			} else {
				actualizados.push(hecho);
			}
		}
		tarea = actualizados;
		return tarea;
		
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
