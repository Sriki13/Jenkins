package unice.ihm.jenkins.recipe;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import unice.ihm.jenkins.R;

public class EndFragment extends Fragment {

    public static final String IMG_PATH_KEY = "imgPath";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.follow_last, container, false);
        Bundle args = getArguments();
        if (args == null) {
            return rootView;
        }
        String imgPath = args.getString(IMG_PATH_KEY);
        if (imgPath != null) {
            try {
                ImageView imageView = rootView.findViewById(R.id.last_step_picture);
                InputStream ims = getContext().getAssets().open("recipes/" + imgPath);
                Drawable drawable = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rootView;
    }
}
