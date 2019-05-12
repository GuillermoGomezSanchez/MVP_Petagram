package androidcourse.companyname.com.petagrampersist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import androidcourse.companyname.com.petagrampersist.adapter.MascotaAdaptador;
import androidcourse.companyname.com.petagrampersist.fragment.IRecyclerViewFragmentView;
import androidcourse.companyname.com.petagrampersist.pojo.Global;
import androidcourse.companyname.com.petagrampersist.pojo.Mascota;
import androidcourse.companyname.com.petagrampersist.presentador.IRecyclerViewFragmentPresenter;
import androidcourse.companyname.com.petagrampersist.presentador.RecyclerViewFragmentPresenter;

public class DetalleMascota extends AppCompatActivity implements IRecyclerViewFragmentView {

    ArrayList<Mascota> lista = new ArrayList<>();
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        Toolbar actionBar = findViewById(R.id.activeDetail);
        setSupportActionBar(actionBar);
        TextView title = findViewById(R.id.titlePetagram);
        title.setText(R.string.app_name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas =  findViewById(R.id.RVDetailmascotas);

        iRecyclerViewFragmentPresenter = new RecyclerViewFragmentPresenter(this,this);

    }

    @Override
    public void generarLayoutVertical() {

        LinearLayoutManager lnm = new LinearLayoutManager(this);
        lnm.setOrientation(LinearLayoutManager.VERTICAL);

        //lstContactos.setLayoutManager(lnm);
        listaMascotas.setLayoutManager(lnm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdapt = new MascotaAdaptador(mascotas,this);
        return  mascotaAdapt;
    }

    @Override
    public void incializarAdaptador(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
