package androidcourse.companyname.com.petagrampersist.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import androidcourse.companyname.com.petagrampersist.pojo.Mascota;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context){
        super(context,ConstantesBaseDatos.DATABASE_NAME,null,ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE "+ConstantesBaseDatos.TABLE_PETS+" ("+
                ConstantesBaseDatos.TABLE_PETS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_PETS_NOMBRE+ " TEXT, "+
                //ConstantesBaseDatos.TABLE_PETS_CALIFICACION+ " INTEGER,"+
                ConstantesBaseDatos.TABLE_PETS_IMAGEN+ " INTEGER, "+
                ConstantesBaseDatos.TABLE_PETS_DYNAMIC+ " BOOLEAN"+
                ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE "+ConstantesBaseDatos.TABLE_PETSLIKES+" ("+
                ConstantesBaseDatos.TABLE_PETSLIKES_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO+ " INTEGER, "+
                ConstantesBaseDatos.TABLE_PETSLIKES_NUMEROLIKES+ " INTEGER, "+
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO+") "+
                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + " ("+ConstantesBaseDatos.TABLE_PETS_ID+") "+
                ")";

        String queryCrearTablaFavsMascotas = "CREATE TABLE "+ConstantesBaseDatos.TABLE_PETSFAV+" ("+
                ConstantesBaseDatos.TABLE_PETS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_PETS_NOMBRE+ " TEXT, "+
                ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO+ " INTEGER, "+
                //ConstantesBaseDatos.TABLE_PETS_CALIFICACION+ " INTEGER,"+
                ConstantesBaseDatos.TABLE_PETS_IMAGEN+ " INTEGER, "+
                ConstantesBaseDatos.TABLE_PETS_DYNAMIC+ " BOOLEAN, "+
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO+") "+
                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + " ("+ConstantesBaseDatos.TABLE_PETS_ID+")"+
                ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascotas);
        db.execSQL(queryCrearTablaFavsMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_PETSLIKES);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_PETSFAV);
        onCreate(db);
    }

    public HashMap<Integer,Mascota> obtenerTodoslosContactosFavs(){

        HashMap<Integer,Mascota> dictionary = new HashMap<Integer, Mascota>();
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM "+ConstantesBaseDatos.TABLE_PETSFAV;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota actual = new Mascota();

            actual.setId(registros.getInt(2));
            actual.setNombre(registros.getString(1));
            /*actual.setCalificacion((byte) registros.getInt(2));
            actual.setImagen(registros.getInt(3));
            actual.setDynamic(registros.getInt(4)!=0);*/
            actual.setImagen(registros.getInt(3));
            actual.setDynamic(registros.getInt(4)!=0);

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_PETSLIKES_NUMEROLIKES+") as likes "+
                    " FROM " + ConstantesBaseDatos.TABLE_PETSLIKES+
                    " WHERE " + ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO +"="+actual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes,null);

            if(registrosLikes.moveToNext()){
                actual.setCalificacion(registrosLikes.getInt(0));
            }

            else{
                actual.setCalificacion(0);
            }

            dictionary.put(Integer.valueOf(registros.getInt(0)),actual);
            //mascotas.add(actual);
        }

        db.close();

        return dictionary;
        //return mascotas;
    }

    public ArrayList<Mascota> obtenerTodoslosContactos(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM "+ConstantesBaseDatos.TABLE_PETS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota actual = new Mascota();

            actual.setId(registros.getInt(0));
            actual.setNombre(registros.getString(1));
            /*actual.setCalificacion((byte) registros.getInt(2));
            actual.setImagen(registros.getInt(3));
            actual.setDynamic(registros.getInt(4)!=0);*/
            actual.setImagen(registros.getInt(2));
            actual.setDynamic(registros.getInt(3)!=0);

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_PETSLIKES_NUMEROLIKES+") as likes "+
                    " FROM " + ConstantesBaseDatos.TABLE_PETSLIKES+
                    " WHERE " + ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO +"="+actual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes,null);

            if(registrosLikes.moveToNext()){
                actual.setCalificacion(registrosLikes.getInt(0));
            }

            else{
                actual.setCalificacion(0);
            }

            mascotas.add(actual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascotaFav(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETSFAV,null,contentValues);
        db.close();
    }

    public void deleteMascotaFav(int id_contacto) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(ConstantesBaseDatos.TABLE_PETSFAV,ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO+"="+id_contacto,null);
        db.close();
    }


        public void deleteLastMascotaFav(){

        Double id = Double.POSITIVE_INFINITY;
        HashMap<Integer,Mascota> mascotas = obtenerTodoslosContactosFavs();

        for(Integer key : mascotas.keySet()){
            if(key<id.intValue()){
                id = new Double(key);
            }
        }

        SQLiteDatabase db = this.getWritableDatabase();

        int aux = id.intValue();

        db.delete(ConstantesBaseDatos.TABLE_PETSFAV,ConstantesBaseDatos.TABLE_PETS_ID+"="+aux,null);
        db.close();
    }

    public int checarMascota(Mascota mascota){
        int number = 0;

        String query = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_PETS_ID+")" +
                " FROM "+ConstantesBaseDatos.TABLE_PETSFAV+
                " WHERE " + ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO+" = "+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            number = registros.getInt(0);
        }

        db.close();
        return number;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETSLIKES,null,contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_PETSLIKES_NUMEROLIKES+")" +
                " FROM "+ConstantesBaseDatos.TABLE_PETSLIKES+
                " WHERE " + ConstantesBaseDatos.TABLE_PETSLIKES_ID_CONTACTO+" = "+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }
}
