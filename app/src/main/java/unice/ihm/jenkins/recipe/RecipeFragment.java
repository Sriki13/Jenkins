package unice.ihm.jenkins.recipe;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import ai.picovoice.porcupinemanager.KeywordCallback;
import ai.picovoice.porcupinemanager.PorcupineManager;
import ai.picovoice.porcupinemanager.PorcupineManagerException;
import unice.ihm.jenkins.R;
import unice.ihm.jenkins.entities.Recipe;

import static android.app.Activity.RESULT_OK;

public class RecipeFragment extends Fragment {

    public static final String RECIPE_KEY = "recipe";

    private ViewPager pager;
    private JenkinsTextAnalyzer textAnalyzer;

    private static final int SPEECH_REQUEST_CODE = 0;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.follow_main, container, false);
        Recipe recipe = (Recipe) getArguments().get(RECIPE_KEY);
        StepPagerAdapter pagerAdapter = new StepPagerAdapter(recipe, getActivity().getSupportFragmentManager());
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

        TextToSpeech tts = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });
        tts.setLanguage(Locale.FRANCE);
        textAnalyzer = new JenkinsTextAnalyzer(tts, recipe, pager);


        try {
            initHotword();
        } catch (PorcupineManagerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return root;
    }

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            textAnalyzer.answer(spokenText);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initHotword() throws PorcupineManagerException, IOException {
        String filename = "francesca";
        copyPorcupineConfigFiles(getActivity().getApplicationContext());
        // get the keyword file and model parameter file from internal storage.
        String keywordFilePath = new File(getActivity().getFilesDir(), filename + ".ppn")
                .getAbsolutePath();
        String modelFilePath = new File(getActivity().getFilesDir(), "params.pv").getAbsolutePath();

        PorcupineManager manager = new PorcupineManager(
                modelFilePath,
                keywordFilePath,
                0.5f,
                new KeywordCallback() {
                    @Override
                    public void run(int keyword_index) {
                      displaySpeechRecognizer();

                    }
                });

        manager.start();
    }

    private static void copyPorcupineConfigFiles(Context context) {
        int[] resIds = {
                R.raw.francesca, R.raw.params
        };
        Resources resources = context.getResources();
        for (int resId : resIds) {
            String filename = resources.getResourceEntryName(resId);
            String fileExtension = resId == R.raw.params ? ".pv" : ".ppn";
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new BufferedInputStream(resources.openRawResource(resId),
                        256);
                os = new BufferedOutputStream(context.openFileOutput(filename + fileExtension,
                        Context.MODE_PRIVATE), 256);
                int r;
                while ((r = is.read()) != -1) {
                    os.write(r);
                }
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
