package com.example.demo;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LvCarIdsDailogAdapter extends BaseAdapter {
    private Activity activity;

    public LvCarIdsDailogAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = View.inflate(activity, R.layout.carids_dialog_item,null);
        TextView tvCarId = (TextView) convertView.findViewById(R.id.tv_carId);
        tvCarId.setText("ԥA88888"+position);
        return convertView;
	}
}