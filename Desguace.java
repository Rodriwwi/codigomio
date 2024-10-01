package es.unex.cum.mdp.sesion03;

import java.util.ArrayList;
import java.util.Iterator;

public class Desguace {
    private String nombre;
    private ArrayList<Vehiculo> vehiculos;
    
    public Desguace(){
        this.nombre="nada";
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public Desguace(String nombre, int tam) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<Vehiculo>(tam);
    }

    public Desguace(String nom) {
        this.nombre = nom;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Desguace [nombre=" + nombre + ", vehiculos=" + vehiculos + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((vehiculos == null) ? 0 : vehiculos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Desguace other = (Desguace) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (vehiculos == null) {
            if (other.vehiculos != null)
                return false;
        } else if (!vehiculos.equals(other.vehiculos))
            return false;
        return true;
    }

    public boolean addVehiculo(Vehiculo v) {
        for (Vehiculo aux : vehiculos) {
            if (v.getBastidor() != null && v.getBastidor().equals(aux.getBastidor())) {
                return false;
            }
        }
        vehiculos.add(v);
        return true;
    }

    public Vehiculo getVehiculoBastidor(Integer bastidor) {
        if (bastidor == null) // si me pasan un null devuelvo null
            return null;
        for (Vehiculo v : vehiculos) { // busco en la lista de vehiculos
            if (v.getBastidor().equals(bastidor)) 
                return v; // si lo encuentro lo devuelvo
        }
        return null; //sino devuelvo null
    }

    public boolean addPiezaVehiculo(Pieza p, Integer bastidor) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo aux = (Vehiculo) it.next();
            if (aux.getBastidor().equals(bastidor)) {
                for (Pieza pieza : aux.getPiezas()) {
                    if (pieza.getId().equals(p.getId())) {
                        pieza.setStock(pieza.getStock() + 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Pieza getPiezaVehiculo(String idP, Integer bastidor) {
        if (idP == null || bastidor == null)
            return null; // comprobacion de que no me pasa null
        Vehiculo ve = getVehiculoBastidor(bastidor); // recupero vehiculo
        if (ve == null) return null;
        for (Pieza p : ve.getPiezas()) { // busca piezas en la lista
            if (idP.equals(p.getId()))
                return p; // si la encuentra la devuelve
        }
        return null; // sino devuelve null
    }
}

/*
 * boolean enc = false;
 * Iterator<Vehiculo> it = vehiculos.iterator();
 * while (it.hasNext() & !enc) {
 * Vehiculo aux = (Vehiculo) it.next();
 * if (aux.getBastidor().equals(bastidor)) {
 * int i = 0;
 * while (i < aux.getPiezas().length) {
 * if (aux.getPiezas()[i].getId() == idP){
 * return aux.getPiezas()[i];
 * }
 * else
 * {
 * i++;
 * }
 * }
 * }
 * }
 * return null;
 * }
 */

/*
 * if (idP != null && bastidor != null && bastidor != 0) {
 * for (Vehiculo v : vehiculos) {
 * if (v.getBastidor().equals(bastidor)) {
 * for (Pieza p : v.getPiezas()) {
 * if (p.getId().equals(idP))
 * return p;
 * }
 * }
 * }
 * return null;
 * }
 * return null;
 * }
 */
