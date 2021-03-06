package io.github.rangaofei.timeline;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.rangaofei.libannotations.TimeLineDividerAdapter;
import io.github.rangaofei.sakatimeline.TimeLineView;
import io.github.rangaofei.sakatimeline.adapter.AbstractTimeLineAdapter;
import io.github.rangaofei.sakatimeline.adapter.ItemClickListener;
import io.github.rangaofei.sakatimeline.divider.TimeLineType;
import io.github.rangaofei.timeline.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private AbstractTimeLineAdapter firstAdapter;
    private AbstractTimeLineAdapter secondAdapter;
    private List<StepViewModel> firstStepViewModels = new ArrayList<>();
    private List<StepViewModel> secondStepViewModels = new ArrayList<>();
    @TimeLineDividerAdapter("Test")
    private List<Drawable> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        list = new ArrayList<>();
        list.add(getResources().getDrawable(R.drawable.ic_order));
        list.add(null);
        list.add(getResources().getDrawable(R.drawable.withpadding));
        initRecyclerView();

    }


    private void initRecyclerView() {
        firstStepViewModels.add(new StepViewModel("许愿日", true, "2016年5月"));
        firstStepViewModels.add(new StepViewModel("签约日", false, "2016年6月"));
        firstStepViewModels.add(new StepViewModel("出游日", false, "2016年6月"));

        secondStepViewModels.add(new StepViewModel("许愿日", true, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        secondStepViewModels.add(new StepViewModel("签约日", false, "04/25"));
        firstAdapter = new StepViewModelAdapter(firstStepViewModels);
        firstAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onKeyViewClick(int position) {
                Toast.makeText(MainActivity.this, "key=" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onValueViewClick(int position) {
                Toast.makeText(MainActivity.this, "value=" + position, Toast.LENGTH_SHORT).show();
            }
        });

        secondAdapter = new StepViewModelAdapter(secondStepViewModels);
        ((TimeLineView) findViewById(R.id.one)).
                setTimeLineConfig(firstAdapter, TimeLineType.StepViewType.TOP_STEP_PROGRESS, 1.3f, list);
        ((TimeLineView) findViewById(R.id.two)).
                setTimeLineConfig(secondAdapter, TimeLineType.StepViewType.LEFT_STEP_PROGRESS, 0);
//        ((TimeLineView) findViewById(R.id.one)).updateDividerNum(2.3f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstStepViewModels.get(0).right = false;
                firstAdapter.notifyDataSetChanged();
//                ((TimeLineView) findViewById(R.id.one)).updateDividerNum(2.3f);
//                ((TimeLineView) findViewById(R.id.two)).updateDividerNum(4.0f);
            }
        }, 3000);


    }
}
