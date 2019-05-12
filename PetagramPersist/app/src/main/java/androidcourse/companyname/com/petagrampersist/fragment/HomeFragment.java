package androidcourse.companyname.com.petagrampersist.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidcourse.companyname.com.petagrampersist.R;
import androidcourse.companyname.com.petagrampersist.adapter.MascotaAdaptador;
import androidcourse.companyname.com.petagrampersist.pojo.Mascota;
import androidcourse.companyname.com.petagrampersist.presentador.IRecyclerViewFragmentPresenter;
import androidcourse.companyname.com.petagrampersist.presentador.RecyclerViewFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements IRecyclerViewFragmentView {

    View v;
    ArrayList<Mascota> lista = new ArrayList<>();
    private RecyclerView listaMascotas;
    ArrayList<Mascota> gustoAnimal = new ArrayList<>();
    private IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);

        //getSupportActionBar().setTitle(R.string.app_name);
        //getSupportActionBar().setLogo(R.drawable.huella);

        listaMascotas =  v.findViewById(R.id.RVmascotas);

        iRecyclerViewFragmentPresenter = new RecyclerViewFragmentPresenter(this,getContext());

        /*for(int ind=0;ind<lista.size();ind++)
        {
            for(int idx = 0; idx< Global.likeMascotas.size(); idx++)
            {
                if(lista.get(ind).getNombre() == Global.likeMascotas.get(idx).getNombre()){
                    lista.get(ind).setCalificacion(Global.likeMascotas.get(idx).getCalificacion());
                }
            }
        }*/



        return v;
    }


    @Override
    public void generarLayoutVertical() {

        LinearLayoutManager lnm = new LinearLayoutManager(getActivity());
        lnm.setOrientation(LinearLayoutManager.VERTICAL);

        //lstContactos.setLayoutManager(lnm);
        listaMascotas.setLayoutManager(lnm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
         MascotaAdaptador mascotaAdapt = new MascotaAdaptador(mascotas,getActivity());
         return  mascotaAdapt;
    }

    @Override
    public void incializarAdaptador(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
