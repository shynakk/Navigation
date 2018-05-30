package navigation.shyna.org.navigation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import navigation.shyna.org.navigation.R;

public class LoginFragment extends Fragment {
private EditText login,password;
private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View v  = inflater.inflate(R.layout.login_navigation,container,false);
login=v.findViewById(R.id.uname);
        password=v.findViewById(R.id.pwd);
        button=v.findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }

            public void validate()
            {
            if(login.length()<=0)
            {
                Toast.makeText(getActivity(),"Invalid username",Toast.LENGTH_SHORT).show();
            }
            }
        });


        return v;
    }
}
