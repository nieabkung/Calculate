import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.in.androidthai.calculatekasidet.MainActivity;
import th.in.androidthai.calculatekasidet.R;

public class MainFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      //  Create toolbar

        createToolbar();
    }

    private void createToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbarMain);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main.,  container, false);
        return view;
    }
}
