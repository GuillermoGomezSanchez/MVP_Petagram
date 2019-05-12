package androidcourse.companyname.com.petagrampersist;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidcourse.companyname.com.petagrampersist.pojo.SendMail;

public class ContactoAct extends AppCompatActivity {

    EditText Message;
    TextInputEditText IETEmail;
    TextInputEditText IETName;
    EditText RemEmail;
    EditText RemPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar actionBar = findViewById(R.id.activeDetailCont);
        setSupportActionBar(actionBar);
        TextView title = findViewById(R.id.titlePetagram);
        title.setText(R.string.app_name);

        //RemEmail = findViewById(R.id.RemEmail);
        RemPassword = findViewById(R.id.RemPassword);
        Message = findViewById(R.id.Message);
        IETEmail = findViewById(R.id.IETEmail);
        IETName = findViewById(R.id.IETName);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void sendEmail() {
        //Getting content for email
        String email = IETEmail.getText().toString().trim();
        String subject = IETName.getText().toString().trim();
        String message = Message.getText().toString().trim();
        //String Remail = RemEmail.getText().toString().trim();
        String Rpassword = RemPassword.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message, Rpassword);//, Remail, Rpassword);

        //Executing sendmail to send email
        sm.execute();
    }

    public void mandarEmail(View v) {
        sendEmail();
    }
}
