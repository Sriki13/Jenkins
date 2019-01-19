package unice.ihm.jenkins.recipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import unice.ihm.jenkins.entities.Recipe;

public class StepPagerAdapter extends FragmentStatePagerAdapter {

    private Recipe recipe;
    private int mCurrentPosition = -1;

    public StepPagerAdapter(Recipe recipe, FragmentManager fm) {
        super(fm);
        this.recipe = recipe;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle args = new Bundle();
        Fragment fragment;
        if (i == 0) {
            fragment = new StartFragment();
            args.putSerializable(StartFragment.RECIPE_KEY, recipe);
        } else if (i == recipe.getSteps().size() + 1) {
            fragment = new EndFragment();
            args.putString(EndFragment.IMG_PATH_KEY, recipe.getImgPath());
        } else {
            fragment = new StepFragment();
            args.putSerializable(StepFragment.STEP_KEY, recipe.getSteps().get(i));
            args.putSerializable(StepFragment.INDEX_KEY, i);
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (position != mCurrentPosition) {
            Fragment fragment = (Fragment) object;
            CustomPager pager = (CustomPager) container;
            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }
    }

    @Override
    public int getCount() {
        return recipe.getSteps().size() + 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Etape " + position;
    }

}
