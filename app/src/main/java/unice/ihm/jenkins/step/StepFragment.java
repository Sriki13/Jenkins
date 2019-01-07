package unice.ihm.jenkins.step;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import unice.ihm.jenkins.R;

public class StepFragment extends Fragment {

    public static final String STEP_KEY = "step";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.follow_step, container, false);
        Bundle args = getArguments();
        if (args == null) {
            return rootView;
        }
        Step step = (Step) args.get(STEP_KEY);
        ((TextView) rootView.findViewById(R.id.step_title)).setText(step.getTitle());
        ((TextView) rootView.findViewById(R.id.step_text)).setText(step.getStepText());
        if (step.getImgPath() != null) {
            ImageView imageView = rootView.findViewById(R.id.step_picture);
            imageView.setImageBitmap(BitmapFactory.decodeFile(step.getImgPath()));
        }
        return rootView;
    }

}
