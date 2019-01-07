package unice.ihm.jenkins.step;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import unice.ihm.jenkins.R;

public class StepFragment extends Fragment {

    public static final String STEP_KEY = "step";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.follow_step, container, false);
        Bundle args = getArguments();
        if (args == null) {
            return rootView;
        }
        Step step = (Step) args.get(STEP_KEY);
        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
                Integer.toString(args.getInt(STEP_KEY)));
        return rootView;
    }

}
