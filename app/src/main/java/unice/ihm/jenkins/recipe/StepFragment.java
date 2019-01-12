package unice.ihm.jenkins.recipe;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import unice.ihm.jenkins.R;
import unice.ihm.jenkins.entities.Keyword;
import unice.ihm.jenkins.entities.Step;

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
        TextView stepText = rootView.findViewById(R.id.step_text);
        stepText.setText(step.getStepText());
        setupKeywords(stepText, step.getStepText(), step.getKeywords());
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

    private void setupKeywords(TextView textView, String text, List<Keyword> keywords) {
        SpannableString ss = new SpannableString(text);
        for (final Keyword word : keywords) {
            ClickableSpan span = new ClickableSpan() {
                @Override
                public void onClick(@NonNull View widget) {
                    readDescription(word.getExplanation());
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            };
            int start = text.indexOf(word.getWord());
            int end = start + word.getWord().length();
            ss.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }

    private void readDescription(String toRead) {
        Toast.makeText(getContext(), toRead, Toast.LENGTH_LONG).show();
    }


}
