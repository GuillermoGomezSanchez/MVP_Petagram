package androidcourse.companyname.com.petagrampersist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AboutDev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);

        Toolbar actionBar = findViewById(R.id.activeDetailDev);
        setSupportActionBar(actionBar);
        TextView title = findViewById(R.id.titlePetagram);
        title.setText(R.string.app_name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
