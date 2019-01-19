package unice.ihm.jenkins.recipe;

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
import unice.ihm.jenkins.entities.Recipe;

public class StartFragment extends Fragment {

    public static final String RECIPE_KEY = "recipe";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.follow_first, container, false);
        Bundle args = getArguments();
        if (args == null) {
            return rootView;
        }
        Recipe recipe = (Recipe) args.getSerializable(RECIPE_KEY);
        if (recipe.getImgPath() != null) {
            try {
                ImageView imageView = rootView.findViewById(R.id.first_step_picture);
                InputStream ims = getContext().getAssets().open("recipes/" + recipe.getImgPath());
                Drawable drawable = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ((TextView) rootView.findViewById(R.id.recipe_title)).setText(recipe.getTitle());
        ((TextView) rootView.findViewById(R.id.recipe_description)).setText(recipe.getDescription());
        ((TextView) rootView.findViewById(R.id.recipe_people)).setText(recipe.getNbPeople() + " personnes");
        ((TextView) rootView.findViewById(R.id.recipe_time)).setText(recipe.getTime());
        return rootView;
    }

}
