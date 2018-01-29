package th.in.androidthai.calculatekasidet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import th.in.androidthai.calculatekasidet.MainFrag.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // add fragment to activity //
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.ContentMainFragment, new MainFragment())
                    .commit();
        }


    }   //main class

    @Override
    public void onClick(View view) {

    }
}   // main class
