package androidcourse.companyname.com.petagrampersist.pojo;

public class Mascota {

    private int id;
    private int imagen;
    private String nombre;
    private int calificacion;
    private boolean dynamic;

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    public Mascota(int imagen, String nombre, int calificacion){
        this.imagen = imagen;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.dynamic = true;
        this.id=-1;
    }

    public Mascota(int imagen,String nombre, int calificacion, boolean dynamic){
        this.imagen = imagen;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.dynamic = dynamic;
        this.id=-1;
    }

    public Mascota(int imagen,String nombre){
        this.imagen = imagen;
        this.nombre = nombre;
        calificacion = 0;
        this.id = -1;
    }

    public Mascota(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
        //if(calificacion>(byte)5){this.calificacion=(byte)0;}
    }
}
