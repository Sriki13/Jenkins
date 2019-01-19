package unice.ihm.jenkins.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import unice.ihm.jenkins.R;
import unice.ihm.jenkins.entities.Ingredient;

public class IngredientAdapter extends ArrayAdapter<Ingredient> {

    public IngredientAdapter(Context context, List<Ingredient> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ingredient_row, parent, false);
        }

        IngredientViewHolder viewHolder = (IngredientViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new IngredientViewHolder();
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.quantity = convertView.findViewById(R.id.quantity);
            viewHolder.unit = convertView.findViewById(R.id.unit);
            convertView.setTag(viewHolder);
        }

        Ingredient ingredient = getItem(position);


        viewHolder.name.setText(ingredient.getName());
        viewHolder.quantity.setText(ingredient.getQuantityFormat());
        viewHolder.unit.setText(ingredient.getUnitFormat());

        return convertView;
    }

    private class IngredientViewHolder {
        public TextView name;
        public TextView quantity;
        public TextView unit;
    }
}
