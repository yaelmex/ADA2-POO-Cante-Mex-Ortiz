
public class Tareas {
	private String asunto;
	private String categoria;
	private String importancia;
	private String descripcion;
	
	public Tareas(String asunto, String categoria, String importancia, String descripcion) {
		this.asunto = asunto;
		this.categoria = categoria;
		this.importancia = importancia;
		this.descripcion = descripcion;
	}

	//Método buscar realizado por Vianey
	/*Con este método podemos buscar dentro de la pila de tareas
	  tomando en cuenta si el asunto es regular o muy importante*/
	public Tareas buscar(String buscar) {
		for(Tareas asunto : tarea) {//el bucle nos permite recorrer cada tarea de la pila
			if(asunto.getAsunto()) {//verifica que el asunto de la tarea en la que se encuentra sea verdadero o no
				return asunto;//devuelve la tarea
			}
		}
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
