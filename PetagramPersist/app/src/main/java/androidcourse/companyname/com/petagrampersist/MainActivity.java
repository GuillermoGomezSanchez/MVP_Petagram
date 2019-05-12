package androidcourse.companyname.com.petagrampersist;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidcourse.companyname.com.petagrampersist.adapter.PageAdapter;
import androidcourse.companyname.com.petagrampersist.fragment.HomeFragment;
import androidcourse.companyname.com.petagrampersist.fragment.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = findViewById(R.id.activPrinc);
        setSupportActionBar(actionBar);

        TextView title = findViewById(R.id.titlePetagram);
        title.setText(R.string.app_name);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        ImageView estrella = findViewById(R.id.iconStar);
        TextView textEstrella = findViewById(R.id.textIconStar);

        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, DetalleMascota.class);
                startActivity(i);
            }
        });

        textEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,DetalleMascota.class);
                startActivity(i);
            }
        });

        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch(item.getItemId()){

            case R.id.mContact:
                i = new Intent(this,ContactoAct.class);
                startActivity(i);
                break;
            case R.id.mAbout:
                i = new Intent(this,AboutDev.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*private void alDarClick(Mascota mascota){
        //Toast.makeText(activity,mascota.getNombre(),Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,DetalleMascota.class);

        for(int j=0;j<mascotas.size();j++)
        {
            if(j==5){break;}

            i.putExtra("nombre"+Integer.toString(j),mascotas.get(j).getNombre());
            i.putExtra("calificacion"+Integer.toString(j),mascotas.get(j).getCalificacion());
            i.putExtra("imagen"+Integer.toString(j),mascotas.get(j).getImagen());
        }

        startActivity(i);
        //activity.finish();
    }*/

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.footprint);
    }
}
