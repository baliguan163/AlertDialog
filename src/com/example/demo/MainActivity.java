package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

	//��Ӧ����button
    private Button simpleDiaog;
    private Button simpleListDiaog;
    private Button singleChoiceDiaog;
    private Button multiChoiceDiaog;
    private Button customAdateprDiaog;
    private Button customViewDiaog;
    private Button customViewDiaog1;
    //����һ��AlertDialog������
    private AlertDialog.Builder builder;
    private AlertDialog.Builder builder2;
    //
    private List<ItemBean> items;
    private CustomAdapter  adapter;
    //
    private View bottomView;
    private ListView lvCarIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ʵ�����ؼ�
        simpleDiaog= (Button) findViewById(R.id.btn_simple_dialog);
        simpleListDiaog= (Button) findViewById(R.id.btn_simple_list_dialog);
        singleChoiceDiaog= (Button) findViewById(R.id.btn_single_choice_dialog);
        multiChoiceDiaog= (Button) findViewById(R.id.btn_multi_choice_dialog);
        
        customAdateprDiaog= (Button) findViewById(R.id.btn_custom_adapter_dialog);
        items = new ArrayList<>();
        items.add(new ItemBean(R.drawable.ic_launcher,"You can call me xiaoming"));
        items.add(new ItemBean(R.drawable.ic_launcher, "I'm android xiao"));
        items.add(new ItemBean(R.drawable.ic_launcher, "I'm android 1"));
        items.add(new ItemBean(R.drawable.ic_launcher, "I'm android 2"));
        items.add(new ItemBean(R.drawable.ic_launcher, "I'm android 3"));
        items.add(new ItemBean(R.drawable.ic_launcher, "I'm android 4"));
        items.add(new ItemBean(R.drawable.ic_launcher, "I'm android 5"));
        adapter = new CustomAdapter(items,getApplicationContext());
        //
        customViewDiaog= (Button) findViewById(R.id.btn_custom_view_dialog);
        
        //
        customViewDiaog1= (Button) findViewById(R.id.custom_view_dialog1);
       
        
        
        
        
        //��������¼�
        simpleDiaog.setOnClickListener(this);
        simpleListDiaog.setOnClickListener(this);
        singleChoiceDiaog.setOnClickListener(this);
        multiChoiceDiaog.setOnClickListener(this);
        customAdateprDiaog.setOnClickListener(this);
        customViewDiaog.setOnClickListener(this);
        customViewDiaog1.setOnClickListener(this);
        
        
    	
    	
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View view) {
		switch (view.getId()){
        case R.id.btn_simple_dialog:
            showSimpleDialog(view);//��ʾ����Dialog
            break;
        case R.id.btn_simple_list_dialog:
            showSimpleListDialog(view);
            break;
        case R.id.btn_single_choice_dialog:
            showSingleChoiceDialog(view);
            break;
        case R.id.btn_multi_choice_dialog:
            showMultiChoiceDialog(view);
            break;
        case R.id.btn_custom_adapter_dialog:
            showCustomAdapterDialog(view);
            break;
        case R.id.btn_custom_view_dialog:
            showCustomViewDialog(view);
            break;
        case R.id.custom_view_dialog1:
        	showCustomMyTest1(view);
            break;
    }
		
	}
	//��ʾ����Dialog
    private void showSimpleDialog(View view) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.simple_dialog);
        builder.setMessage(R.string.dialog_message);
        //�����·�button����¼�
        builder.setPositiveButton(R.string.postive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),R.string.toast_postive,Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), R.string.toast_negative, Toast.LENGTH_SHORT).show();
            }
        });
        //���öԻ����ǿ�ȡ����
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    
    private void showSimpleListDialog(View view) {
        builder=new AlertDialog.Builder(this);
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.simple_list_dialog);
        /**
         * ������������Ϊ���б���
         */
        final String[] Items={"Items_one","Items_two","Items_three"};
        builder.setItems(Items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You clicked "+Items[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    
    private void showSingleChoiceDialog(View view) {
        builder=new AlertDialog.Builder(this);
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.single_choice_dialog);

        /**
         * ������������Ϊ��ѡ�б���
         */
        final String[] items={"Items_one","Items_two","Items_three"};
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You clicked "+items[i], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void showMultiChoiceDialog(View view) {
        builder=new AlertDialog.Builder(this);
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.simple_list_dialog);

        /**
         * ������������Ϊ��ѡ�б���
         */
        final String[] items={"Items_one","Items_two","Items_three"};
        builder.setMultiChoiceItems(items, new boolean[]{true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(getApplicationContext(),"You clicked "+items[i]+" "+b,Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            	//dialog.dismiss();
            	 Toast.makeText(getApplicationContext(),"You clicked "+ which,Toast.LENGTH_SHORT).show();
            }
        }).create();
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();

    }
    
    
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter = new CustomAdapter(items,getApplicationContext());
    	    lvCarIds.setAdapter(adapter);//ListView����������
            adapter.notifyDataSetChanged();
        }
    };
    
    ////
    private void showCustomAdapterDialog(View view){
    builder = new AlertDialog.Builder(this);
    builder.setIcon(R.drawable.ic_launcher);
    builder.setTitle(R.string.custom_adapter_dialog);

    /**
     * ������������Ϊ�Զ���adapter
     */
    
    builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int position) {
        	String msg = items.get(position).getMessage();
        	items.remove(items.get(position));
            handler.sendEmptyMessageDelayed(100,1000);
            Toast.makeText(getApplicationContext(),"You clicked"+position + " " + msg,Toast.LENGTH_SHORT).show();
        }
    });
    
    builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        	//dialog.dismiss();
        	 Toast.makeText(getApplicationContext(),"You clicked "+ which,Toast.LENGTH_SHORT).show();
        }
    });
//    builder.setCancelable(false);
    builder.create();
    builder.show();
   }
    
    ///
    private void showCustomViewDialog(View view){
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.custom_view_dialog);
        /**
         * ������������Ϊ�Զ���View
         */
        LinearLayout loginDialog= (LinearLayout)getLayoutInflater().inflate(R.layout.custom_view,null);
        builder.setView(loginDialog);
        builder.setCancelable(true);
       
    }
    
    //my test
    private void showCustomMyTest1(View view){
    	
    	 bottomView = View.inflate(MainActivity.this,R.layout.carids_dialog,null);//���ListView����
         lvCarIds = (ListView) bottomView.findViewById(R.id.lv_carids);//��ʼ��ListView�ؼ�
         adapter = new CustomAdapter(items,getApplicationContext());
 	    lvCarIds.setAdapter(adapter);
 	    lvCarIds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // data.remove(data.get(position));
                 //handler.sendEmptyMessageDelayed(100,1000);
             	String msg = items.get(position).getMessage();
             	items.remove(items.get(position));
             	Toast.makeText(getApplicationContext(),"You clicked"+position + " " + msg,Toast.LENGTH_SHORT).show();
                 handler.sendEmptyMessageDelayed(100,1000);
             }
         });
 	    
    	builder2 = new AlertDialog.Builder(this);
    	builder2.setTitle("ѡ���ƺ�");
    	builder2.setView(bottomView)
    	    .setPositiveButton("�_��", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                	 dialog.dismiss();
                	 Toast.makeText(getApplicationContext(),"You clicked "+ which,Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                	 dialog.dismiss();
                	 Toast.makeText(getApplicationContext(),"You clicked "+ which,Toast.LENGTH_SHORT).show();
                }
            });
    	builder2.setCancelable(false);
    	builder2.create();
    	builder2.show();
    }
    
    
    
    
    
}
