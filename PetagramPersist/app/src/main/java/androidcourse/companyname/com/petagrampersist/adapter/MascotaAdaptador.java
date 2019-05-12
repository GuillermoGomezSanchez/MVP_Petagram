package androidcourse.companyname.com.petagrampersist.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import androidcourse.companyname.com.petagrampersist.db.ConstructorMascotas;
import androidcourse.companyname.com.petagrampersist.pojo.Global;
import androidcourse.companyname.com.petagrampersist.pojo.Mascota;
import androidcourse.companyname.com.petagrampersist.R;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>
{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview,viewGroup,false);

        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder viewHolder, int i) {
        final Mascota mascota = mascotas.get(i);

        viewHolder.namePet.setText(mascota.getNombre());
        viewHolder.imagePet.setImageResource(mascota.getImagen());

        /*viewHolder.imagePet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alDarClick(mascota);
                    }
                }
        );*/

        viewHolder.showcalifPet.setText(Integer.toString(mascota.getCalificacion()));
        viewHolder.imageBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mascota.isDynamic()){

                    ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                    constructorMascotas.darLikeMascota(mascota);
                    int likes = constructorMascotas.obtenerLikesMascota(mascota);

                    HashMap<Integer,Mascota> favs = constructorMascotas.obtenerDatosFav();

                    try{
                        if(favs.size()<5){
                            if(constructorMascotas.checarMascota(mascota)==0){
                                constructorMascotas.insertarMascotaFav(mascota);
                            }

                            else{
                                constructorMascotas.deleteMascotaFav(mascota.getId());
                                constructorMascotas.insertarMascotaFav(mascota);
                            }
                        }

                        else{
                            if(constructorMascotas.checarMascota(mascota)==0){
                                constructorMascotas.deleteLastMascotaFav();
                                constructorMascotas.insertarMascotaFav(mascota);
                            }

                            else{
                                constructorMascotas.deleteMascotaFav(mascota.getId());
                                constructorMascotas.insertarMascotaFav(mascota);
                            }
                        }
                    }

                    catch(Exception e){

                    }

                    viewHolder.showcalifPet.setText(Integer.toString(likes));
                    mascota.setCalificacion(likes);
                    /*
                    byte aux = mascota.getCalificacion();
                aux++;
                mascota.setCalificacion(aux);
                viewHolder.showcalifPet.setText(Byte.toString(mascota.getCalificacion()));

                if (!Global.likeMascotas.contains(mascota)) {
                    if (Global.likeMascotas.size() < 5) {

                        Global.likeMascotas.add(mascota);
                    } else {
                        //Mascota aux = Global.likeMascotas.get(0);
                        Global.likeMascotas.remove(0);
                        Global.likeMascotas.add(mascota);
                        //Global.likeMascotas.add(aux);
                    }
                } else {
                    if (mascota.getCalificacion() == (byte) 0) {
                        Global.likeMascotas.remove(mascota);
                    }
                }*/
            }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePet;
        private TextView namePet;
        private TextView showcalifPet;
        private ImageView imageBone;

        public MascotaViewHolder(View itemView){
            super(itemView);
            imagePet = itemView.findViewById(R.id.IVPet);
            namePet = itemView.findViewById(R.id.namePet);
            showcalifPet = itemView.findViewById(R.id.showCalifPet);
            imageBone = itemView.findViewById(R.id.califPet);
        }
    }
}
