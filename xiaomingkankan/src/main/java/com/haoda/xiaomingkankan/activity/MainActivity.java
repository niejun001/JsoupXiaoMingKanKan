package com.haoda.xiaomingkankan.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.main.FromFragment;
import com.haoda.xiaomingkankan.fragment.main.MineFragment;
import com.haoda.xiaomingkankan.fragment.main.PicFragment;
import com.haoda.xiaomingkankan.fragment.main.VideoFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.content)
    FrameLayout content;
    @InjectView(R.id.first_layout)
    LinearLayout firstLayout;
    @InjectView(R.id.second_layout)
    LinearLayout secondLayout;
    @InjectView(R.id.third_layout)
    LinearLayout thirdLayout;
    @InjectView(R.id.four_layout)
    LinearLayout fourLayout;
    @InjectView(R.id.first_image)
    ImageView firstImage;
    @InjectView(R.id.first_text)
    TextView firstText;
    @InjectView(R.id.second_image)
    ImageView secondImage;
    @InjectView(R.id.second_text)
    TextView secondText;
    @InjectView(R.id.third_image)
    ImageView thirdImage;
    @InjectView(R.id.third_text)
    TextView thirdText;
    @InjectView(R.id.four_image)
    ImageView fourImage;
    @InjectView(R.id.four_text)
    TextView fourText;
    private FragmentManager fragmentManager;
    private VideoFragment fg1;
    private PicFragment fg2;
    private FromFragment fg3;
    private MineFragment fg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        fragmentManager = getSupportFragmentManager();
        setChioceItem(0);
    }

    @OnClick({R.id.first_layout, R.id.second_layout, R.id.third_layout, R.id.four_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.first_layout:
                setChioceItem(0);
                break;
            case R.id.second_layout:
                setChioceItem(1);
                break;
            case R.id.third_layout:
                setChioceItem(2);
                break;
            case R.id.four_layout:
                setChioceItem(3);
                break;
            default:
                break;
        }
    }

    private void setChioceItem(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        clearChioce(); // 清空, 重置选项, 隐藏所有Fragment
        hideFragments(fragmentTransaction);

        switch (index) {
            case 0:
                firstLayout.setSelected(true);

                // 如果fg1为空，则创建一个并添加到界面上
                if (fg1 == null) {
                    fg1 = new VideoFragment();
                    fragmentTransaction.add(R.id.content, fg1);
                } else {
                    // 如果不为空，则直接将它显示出来
                    fragmentTransaction.show(fg1);
                }
                break;

            case 1:
                secondLayout.setSelected(true);

                if (fg2 == null) {
                    fg2 = new PicFragment();
                    fragmentTransaction.add(R.id.content, fg2);
                } else {
                    fragmentTransaction.show(fg2);
                }
                break;

            case 2:
                thirdLayout.setSelected(true);

                if (fg3 == null) {
                    fg3 = new FromFragment();
                    fragmentTransaction.add(R.id.content, fg3);
                } else {
                    fragmentTransaction.show(fg3);
                }
                break;

            case 3:
                fourLayout.setSelected(true);

                if (fg4 == null) {
                    fg4 = new MineFragment();
                    fragmentTransaction.add(R.id.content, fg4);
                } else {
                    fragmentTransaction.show(fg4);
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();   // 提交
    }

    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) {
            fragmentTransaction.hide(fg1);
        }
        if (fg2 != null) {
            fragmentTransaction.hide(fg2);
        }
        if (fg3 != null) {
            fragmentTransaction.hide(fg3);
        }
        if (fg4 != null) {
            fragmentTransaction.hide(fg4);
        }
    }

    private void clearChioce() {
        firstLayout.setSelected(false);
        secondLayout.setSelected(false);
        thirdLayout.setSelected(false);
        fourLayout.setSelected(false);
    }

}
