package navigation.shyna.org.navigation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONException;
import org.json.JSONObject;

import navigation.shyna.org.navigation.fragment.LoginFragment;
import navigation.shyna.org.navigation.fragment.RegisterFragment;
import navigation.shyna.org.navigation.fragment.WelcomeFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container1,new WelcomeFragment());
        transaction.commit();





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_welcome) {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container1,new WelcomeFragment());
           // transaction.addToBackStack("WELCOME");
            transaction.commit();


        } else if (id == R.id.nav_login) {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container1,new LoginFragment());

           // transaction.addToBackStack("Login");
            transaction.commit();


        } else if (id == R.id.nav_register) {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container1,new RegisterFragment());
            transaction.commit();

        } else if (id == R.id.nav_list) {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container1,new ListFragment());
            transaction.commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private  void constructJSON() {
        JSONObject object=new JSONObject();
        try {
            object.put("f_name","Ria");
            object.put("l_nam","Roa");
            object.put("email","riarao@gmail.com");
            object.put("m_no","123456");
            object.put("age","25");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
