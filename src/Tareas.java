import java.util.Stack;

public class Tareas {
	private String asunto;
	private String categoria;
	private String importancia;
	private String descripcion;
	Stack <Tareas> tarea;

	

	//

	public Tareas(String asunto, String categoria, String importancia, String descripcion) {
		this.asunto = asunto;
		this.categoria = categoria;
		this.importancia = importancia;
		this.descripcion = descripcion;
	}

	//Landy
	public Stack<Tareas> filtrar (String filtro) {
		Stack<Tareas> filtrados = new Stack <Tareas>(); //Crear pila para las tareas
		for (Tareas importancia : tarea) { //Crear bucle para recorrer los elementos de                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
			if (importancia.getImportancia().equalsIgnoreCase(filtro) //Verificar que la importancia coincida con el filtro 
					|| importancia.getAsunto()!= null) { //y que el asunto sea diferente a null
				filtrados.push(importancia); //Agregar a la pila
			}
		}
		return filtrados; // Devolver la pila 
	}
	


	//Método buscar realizado por Vianey
	/*Con este método podemos buscar dentro de la pila de tareas
	  tomando en cuenta si el asunto es regular o muy importante*/
	public Tareas buscar(String buscar) {
		for(Tareas asunto : tarea) {//el bucle nos permite recorrer cada tarea de la pila
			if(asunto.getAsunto().equalsIgnoreCase(buscar)) {//compara el asunto de la tarea con el texto buscado
				return asunto;//devuelve la tarea
			}
		}
		return null;
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
