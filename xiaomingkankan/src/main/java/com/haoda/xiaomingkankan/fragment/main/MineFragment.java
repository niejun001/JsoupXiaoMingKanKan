package com.haoda.xiaomingkankan.fragment.main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/4.
 */

public class MineFragment extends Fragment {

    /*
    * "   良心软件，多多支持，每天点击几下广告，多谢了！！！\n" +
                                "网速慢的可能打开会慢点，部分网络可能打不开视频，不是软件的bug，而是你" +
                                "的网络可能屏蔽了这个视频站点，不过图片小说能正常看！网速慢的耐心等待一会噢~"
    * */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_mine, container, false);
        TextView test = ((TextView) view.findViewById(R.id.test));
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("使用说明")
                        .setMessage("网速慢的可能打开会慢点，部分网络可能打不开视频，不是软件的bug，而是你" +
                                "的网络可能屏蔽了这个视频站点，不过图片小说能正常看！网速慢的耐心等待一会噢~")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        });
        return view;
    }
}
