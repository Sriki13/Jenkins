package unice.ihm.jenkins.step;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import unice.ihm.jenkins.R;

public class StepFragment extends Fragment {

    public static final String STEP_KEY = "step";
    public static final String INDEX_KEY = "step_number";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.follow_step, container, false);
        Bundle args = getArguments();
        if (args == null) {
            return rootView;
        }
        Step step = (Step) args.get(STEP_KEY);
        ((TextView) rootView.findViewById(R.id.step_title)).setText("Etape " + args.getInt(INDEX_KEY) + ": " + step.getTitle());
        ((TextView) rootView.findViewById(R.id.step_text)).setText(step.getStepText());
        if (step.getImgPath() != null) {
            try {
                ImageView imageView = rootView.findViewById(R.id.step_picture);
                InputStream ims = getContext().getAssets().open("recipes/" + step.getImgPath());
                Drawable drawable = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rootView;
    }

}
