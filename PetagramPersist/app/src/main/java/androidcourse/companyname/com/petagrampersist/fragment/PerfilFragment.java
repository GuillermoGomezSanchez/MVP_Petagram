package androidcourse.companyname.com.petagrampersist.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidcourse.companyname.com.petagrampersist.R;
import androidcourse.companyname.com.petagrampersist.adapter.MascotaAdaptador;
import androidcourse.companyname.com.petagrampersist.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> lista = new ArrayList<>();
    private RecyclerView listaMascotas;
    ArrayList<Mascota> gustoAnimal = new ArrayList<>();

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //getSupportActionBar().setTitle(R.string.app_name);
        //getSupportActionBar().setLogo(R.drawable.huella);

        lista.add(new Mascota(R.drawable.marnie1,"Normal",(byte)5,false));
        lista.add(new Mascota(R.drawable.marnie2,"Dora",(byte)3,false));
        lista.add(new Mascota(R.drawable.marnie3,"Empresario",(byte)0,false));
        lista.add(new Mascota(R.drawable.marnie4,"Santa",(byte)1,false));
        lista.add(new Mascota(R.drawable.marnie5,"Superman",(byte) 2,false));
        lista.add(new Mascota(R.drawable.marnie6,"Pirata",(byte)5,false));

        /*for(int ind=0;ind<lista.size();ind++)
        {
            for(int idx = 0; idx< Global.likeMascotas.size(); idx++)
            {
                if(lista.get(ind).getNombre() == Global.likeMascotas.get(idx).getNombre()){
                    lista.get(ind).setCalificacion(Global.likeMascotas.get(idx).getCalificacion());
                }
            }
        }*/

        listaMascotas =  v.findViewById(R.id.RVMimascota);

        //LinearLayoutManager lnm = new LinearLayoutManager(getActivity());
        GridLayoutManager gnm = new GridLayoutManager(getActivity(),2);
        //lnm.setOrientation(LinearLayoutManager.VERTICAL);

        //lstContactos.setLayoutManager(lnm);
        listaMascotas.setLayoutManager(gnm);

        listaMascotas.setAdapter(new MascotaAdaptador(lista,getActivity()));

        return v;
    }
}
