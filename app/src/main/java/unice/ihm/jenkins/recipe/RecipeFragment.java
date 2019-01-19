package unice.ihm.jenkins.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import unice.ihm.jenkins.R;
import unice.ihm.jenkins.entities.Recipe;

import static android.app.Activity.RESULT_OK;

public class RecipeFragment extends Fragment {

    public static final String RECIPE_KEY = "recipe";

    private StepPagerAdapter pagerAdapter;
    private ViewPager pager;

    private static final int SPEECH_REQUEST_CODE = 0;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.follow_main, container, false);
        Recipe recipe = (Recipe) getArguments().get(RECIPE_KEY);
        pagerAdapter = new StepPagerAdapter(recipe, getActivity().getSupportFragmentManager());
        pager = root.findViewById(R.id.step_pager);
        pager.setAdapter(pagerAdapter);
        IngredientAdapter ingredientAdapter = new IngredientAdapter(this.getContext(), recipe.getIngredients());
        ListView listView = root.findViewById(R.id.ingredientList);

        listView.setAdapter(ingredientAdapter);

        FloatingActionButton next = root.findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.arrowScroll(View.FOCUS_RIGHT);
            }
        });
        FloatingActionButton previous = root.findViewById(R.id.previous_button);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.arrowScroll(View.FOCUS_LEFT);
            }
        });

        FloatingActionButton button = root.findViewById(R.id.voice_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                displaySpeechRecognizer();
            }
        });

        return root;
    }

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
