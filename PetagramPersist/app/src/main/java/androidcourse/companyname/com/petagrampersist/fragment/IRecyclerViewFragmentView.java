package androidcourse.companyname.com.petagrampersist.fragment;

import java.util.ArrayList;

import androidcourse.companyname.com.petagrampersist.adapter.MascotaAdaptador;
import androidcourse.companyname.com.petagrampersist.pojo.Mascota;

public interface IRecyclerViewFragmentView {

    public void generarLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void incializarAdaptador(MascotaAdaptador adaptador);

}
