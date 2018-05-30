package navigation.shyna.org.navigation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import navigation.shyna.org.navigation.R;

public class WelcomeFragment extends Fragment {
  private Button login,register;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.welcome_navigation,container,false);
      login=v.findViewById(R.id.loginb);
      register=v.findViewById(R.id.rej);

     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
             transaction.add(R.id.fragment_container1,new LoginFragment());
             transaction.commit();
         }
     });

        return v;
    }

}
