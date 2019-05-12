package androidcourse.companyname.com.petagrampersist.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import androidcourse.companyname.com.petagrampersist.R;
import androidcourse.companyname.com.petagrampersist.pojo.Mascota;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public HashMap<Integer,Mascota> obtenerDatosFav(){
        BaseDatos db = new BaseDatos(context);

        HashMap<Integer,Mascota> aux = db.obtenerTodoslosContactosFavs();
        return aux;
    }

    public int checarMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);

        int aux = db.checarMascota(mascota);
        return aux;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> lista = new ArrayList<>();

        lista.add(new Mascota(R.drawable.chihuahua,"Dominico",(byte)0));
        lista.add(new Mascota(R.drawable.happycat,"Perejilo",(byte)0));
        lista.add(new Mascota(R.drawable.husky,"Laboriel",(byte)0));
        lista.add(new Mascota(R.drawable.pomeranian,"Ito",(byte)0));
        lista.add(new Mascota(R.drawable.pitbull,"Brutus",(byte) 0));
        lista.add(new Mascota(R.drawable.kitty,"Hello",(byte)0));
        lista.add(new Mascota(R.drawable.pug,"Edgar", (byte)0));
        return lista;*/

        BaseDatos db = new BaseDatos(context);

        ArrayList<Mascota> aux = db.obtenerTodoslosContactos();

        if(aux.size()==0){
            insertarMascotas(db);
            aux = db.obtenerTodoslosContactos();
        }

        return aux;
    }

    public void deleteMascotaFav(int id_cntacto){

        BaseDatos db = new BaseDatos(context);
        db.deleteMascotaFav(id_cntacto);
    }

    public void deleteLastMascotaFav(){

        BaseDatos db = new BaseDatos(context);
        db.deleteLastMascotaFav();
    }

    public void insertarMascotaFav(Mascota mascota){

        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,mascota.getImagen());
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,false);

        db.insertarMascotaFav(contentValues);
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Dominico");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,R.drawable.chihuahua);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,true)
        ;

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Perejilo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,R.drawable.happycat);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,true);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Edgar");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,R.drawable.pug);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,true);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Laboriel");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,R.drawable.husky);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,true);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Ito");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,R.drawable.pomeranian);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,true);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Brutus");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,R.drawable.pitbull);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,true);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Heather");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IMAGEN,R.drawable.kitty);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_CALIFICACION,(byte)0);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_DYNAMIC,true);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PETSLIKES_NUMEROLIKES,LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
