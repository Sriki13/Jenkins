package unice.ihm.jenkins;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class ListViewQuiBugPas extends ListView {

    public ListViewQuiBugPas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewQuiBugPas(Context context) {
        super(context);
    }

    public ListViewQuiBugPas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
