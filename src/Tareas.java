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

	//Constructor vacío que inicializa el Stack - Yael
	public Tareas() {
		tarea = new Stack<Tareas>();
	}

	//Método agregar - Yael
	public void Agregar(Tareas TareaNueva) {
		tarea.push(TareaNueva); //Unicamente se llama al método push y se le pasa la tarea nueva
	}

	//Landy
	public Stack<Tareas> filtrar (String filtro) {
		Stack<Tareas> filtrados = new Stack <Tareas>(); //Crear pila para las tareas
		for (Tareas importancia : tarea) { //Crear bucle para recorrer los elementos de                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
			if (importancia.getImportancia().equalsIgnoreCase(filtro) //Verificar que la importancia coincida con el filtro 
					&& importancia.getAsunto()!= null) { //y que el asunto sea diferente a null
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
	
	
	//Método para marcar como hecho - Yael
	public Stack<Tareas> hecho(String asunto){
		Stack <Tareas> actualizados = new Stack<Tareas>(); //Se inicializa un nuveo Stack que alamecenará los nuevos
		for(Tareas hecho : tarea) {
			//Mediante un for each se crea un objeto hecho que irá comparando a aquellos en tarea
			//Si coinciden el asunto con el parámetro dado se pone en null, o sea se "borra"
			if(hecho.getAsunto().equalsIgnoreCase(asunto)) {
				hecho.setAsunto(null);
				hecho.setCategoria(null);
				hecho.setDescripcion(null);
				hecho.setImportancia(null);
			} else {
				//En caso de que no coincidan se agregan al Stack nuevo
				actualizados.push(hecho);
			}
		}
		//Finalmente se actualiza el Stack principal con los actualizados ya sin el borrado
		tarea = actualizados;
		//Se retorna el Stack al final
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
