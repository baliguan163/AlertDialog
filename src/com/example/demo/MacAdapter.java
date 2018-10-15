package com.example.demo;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MacAdapter extends BaseAdapter implements View.OnClickListener {
    //上下文
    private Context context;
    private LayoutInflater inflater;
    private List<ItemBeanMac> data;
    public MacAdapter(List<ItemBeanMac> data,Context context){
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            view = inflater.inflate(R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.tvMacAddress = (TextView)view.findViewById(R.id.mTvMacAddress);
            viewHolder.tvStatus = (TextView)view.findViewById(R.id.mTvStatus);
            viewHolder.btnBind  = (Button)view.findViewById(R.id.mBtnBind);
            view.setTag(viewHolder);
        }
        //获取viewHolder实例
        viewHolder = (ViewHolder)view.getTag();
        
        Log.d("tag", "getAddressMac:" + data.get(i).getAddressMac());
        viewHolder.tvMacAddress.setText(data.get(i).getAddressMac());
        viewHolder.tvMacAddress.setOnClickListener(this);
        
        Log.d("tag", "getBindStatus:" + data.get(i).getBindStatus());
        viewHolder.tvStatus.setText(data.get(i).getBindStatus());
        viewHolder.tvStatus.setOnClickListener(this);
        if(data.get(i).getBindStatus().compareTo("未绑")==0){
        	viewHolder.tvStatus.setTextColor(Color.RED);
        }
        else if(data.get(i).getBindStatus().compareTo("已绑")==0){
        	viewHolder.tvStatus.setTextColor(Color.GREEN);
        }
        else{
        	viewHolder.tvStatus.setTextColor(Color.YELLOW);
        }
        
        //设置数据
        viewHolder.btnBind.setTag(R.id.mBtnBind,i);//添加此代码
//        viewHolder.btnBind.setText("点我"+ i);
        viewHolder.btnBind.setOnClickListener(this);
        //viewHolder.btnBind.setTextColor(Color.RED);
        return view;
     }
    
    
    @Override
	public void onClick(View view) {
    	switch (view.getId()){
    	 case R.id.mTvMacAddress:
             Log.d("tag", "Tv_onClick: " + "view = " + view);
             //Toast.makeText(context,"我是文本mTvMacAddress",Toast.LENGTH_SHORT).show();
             break;
         case R.id.mTvStatus:
             Log.d("tag", "Tv_onClick: " + "view = " + view);
             //Toast.makeText(context,"我是文本mTvStatus",Toast.LENGTH_SHORT).show();
             break;
        case R.id.mBtnBind:
//        	TextView tvStatus = (TextView)view.findViewById(R.id.mTvStatus);
//        	Button btnBind = (Button)view.findViewById(R.id.mBtnBind);
//            Log.d("tag", "Btn_onClick: " + "view = " + view);
//            String status = tvStatus.getText().toString();
//            if(status.compareTo("未绑")==0){
//            	tvStatus.setText("已绑");
//            	tvStatus.setTextColor(Color.GREEN);
//            	btnBind.setText("解绑");
//            }
//            else if(status.compareTo("已绑")==0){
//            	tvStatus.setText("未绑");
//            	tvStatus.setTextColor(Color.RED);
//            	btnBind.setText("绑定");
//            }
//            else{
//            }
//            
            Toast.makeText(context,"我是按钮mBtnBind",Toast.LENGTH_SHORT).show();
            break;
    	}
    }

    static class ViewHolder{
        TextView tvMacAddress;
        TextView tvStatus;
        Button btnBind;
    }



	

}
