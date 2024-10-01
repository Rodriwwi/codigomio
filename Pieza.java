package es.unex.cum.mdp.sesion03;

public class Pieza {

    private String id;
    private String nombre;
    private int stock;

    

    public Pieza() {
        id = "0";
        nombre = "nada"; 
        stock = 0;
    }

    public Pieza(String id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public Pieza(Pieza p){
        id = p.getId();
        nombre = p.getNombre();
        stock = p.getStock();
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pieza other = (Pieza) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Pieza [id=" + id + ", nombre=" + nombre + ", stock=" + stock + "]";
    }    
}
