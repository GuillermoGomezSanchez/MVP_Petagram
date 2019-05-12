package androidcourse.companyname.com.petagrampersist.presentador;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

import androidcourse.companyname.com.petagrampersist.DetalleMascota;
import androidcourse.companyname.com.petagrampersist.db.ConstructorMascotas;
import androidcourse.companyname.com.petagrampersist.fragment.IRecyclerViewFragmentView;
import androidcourse.companyname.com.petagrampersist.pojo.Mascota;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private ConstructorMascotas constructorMascotas;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.context = context;
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);


        if(iRecyclerViewFragmentView.getClass() == DetalleMascota.class){
            HashMap<Integer,Mascota> aux=constructorMascotas.obtenerDatosFav();

            ArrayList<Mascota> lista = new ArrayList<>();

            for(Integer key : aux.keySet()){
                lista.add(aux.get(key));
            }

            mascotas = lista;
        }

        else{
            mascotas = constructorMascotas.obtenerDatos();
        }

        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {

        iRecyclerViewFragmentView.incializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLayoutVertical();
    }



}
