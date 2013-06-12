package jp.mixi.practice.activity.beg;

import android.support.v4.app.Fragment;
import android.view.*;
import android.os.Bundle;

public class MyFragment extends Fragment {
	public MyFragment() {}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // LayoutInflater を利用して、レイアウトをリソースとして読み込む
        View view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    	//return null;
    }
}
