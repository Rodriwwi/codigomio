package es.unex.cum.mdp.sesion03;

public class Vehiculo {
    private String marca;
    private String modelo;
    private Persona propietario;
    private int cont;
    public Pieza[] piezas;
    public Integer bastidor;

    public Vehiculo() {
        marca = "0";
        modelo = "0";
        propietario = new Persona();
        cont = 0;
        piezas = new Pieza[3];
        bastidor = new Integer(0);
    }

    public Vehiculo(int arr) {
        marca = "no";
        modelo = "no";
        propietario = new Persona();
        cont = 0;
        piezas = new Pieza[arr];
        bastidor = new Integer(0);
    }

    public Vehiculo(String ma, String mo, Persona pro, int size, int bas) {
        marca = ma;
        modelo = mo;
        propietario = pro;
        cont = 0;
        piezas = new Pieza[size];
        bastidor = bas;
    }

    public Vehiculo(String ma, String mo, Persona pro, int bas) {
        marca = ma;
        modelo = mo;
        propietario = pro;
        cont = 0;
        piezas = new Pieza[3];
        bastidor = bas;
    }

    public Vehiculo(Vehiculo v) {
        marca = v.getMarca();
        modelo = v.getModelo();
        propietario = v.getPropietario();
        cont = v.getCont();
        piezas = v.getPiezas();
        bastidor = v.getBastidor();
    }

    public boolean addPiezaV(Pieza p) {
    if (p == null) return false;
        for (Pieza pieza : piezas) {
            if (pieza !=null && pieza.getId().equals(p.getId())) {
                return false;
            }
        }
        for (int i =0; i<piezas.length;i++){
            if(piezas[i] == null){
                cont++;
                piezas[i] = p;
                return true;
            }
        }
        return false;
    }

    public Pieza getPiezaV(int pos){
        if (pos < 0 || pos > piezas.length)
            return null;
        if (piezas[pos] == null)
            return null;
        return piezas[pos];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bastidor == null) ? 0 : bastidor.hashCode());
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
        Vehiculo other = (Vehiculo) obj;
        if (bastidor == null) {
            if (other.bastidor != null)
                return false;
        } else if (!bastidor.equals(other.bastidor))
            return false;
        return true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public Pieza[] getPiezas() {
        return piezas;
    }

    public void setPiezas(Pieza[] piezas) {
        this.piezas = piezas;
    }

    public Integer getBastidor() {
        return bastidor;
    }

    public void setBastidor(Integer bastidor) {
        this.bastidor = bastidor;
    }

}
