package com.leemo.android_dailyrecord;

import java.util.HashMap;
import java.util.List;

import com.leemo.util.KeyBoardUtil;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
	private Context mContext;
	private List<RecordMessage> mData;
	private LayoutInflater mLayoutInflater;
	private ViewHolder holder;
	private Activity mActivity;
	private HashMap<Integer, Integer> listcount;
	private HashMap<Integer, Integer> listcosttime;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ItemAdapter(Activity mActivity, List<RecordMessage> mData) {
		super();
		this.mActivity = mActivity;
		this.mData = mData;
		mContext=mActivity.getApplicationContext();
		mLayoutInflater=LayoutInflater.from(mContext);
		listcosttime=new HashMap<Integer, Integer>();
		listcount=new HashMap<Integer, Integer>();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mLayoutInflater.inflate(R.layout.listview_item, null);
			holder.tvitemid=(TextView) convertView.findViewById(R.id.tv_listview_itemid);
			holder.tvitemname = (TextView) convertView.findViewById(R.id.tv_listview_itemname);
			holder.etitemcount = (EditText) convertView.findViewById(R.id.et_listview_count);
			holder.etitemcosttime = (EditText) convertView.findViewById(R.id.et_listview_costtime);
			holder.etitemcount.setInputType(InputType.TYPE_NULL);
			holder.etitemcosttime.setInputType(InputType.TYPE_NULL);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
			holder.tvitemid.setText(mData.get(position).getItemid()+"");
			holder.tvitemname.setText(mData.get(position).getItemName());
			if(listcount.get(position)==null) holder.etitemcount.setText("0");
			else holder.etitemcount.setText(listcount.get(position)+"");
//			holder.etitemcosttime.setText("0");
//			holder.etitemcount.setText("0");
			holder.etitemcosttime.setOnTouchListener(new EditOnTouch(holder.etitemcosttime,position));
			holder.etitemcount.setOnTouchListener(new EditOnTouch(holder.etitemcount,position));
			holder.etitemcount.addTextChangedListener(new TextWatch(position,holder.etitemcount));
			holder.etitemcosttime.addTextChangedListener(new TextWatch(position, holder.etitemcosttime));
		return convertView;
	}

	class ViewHolder {
		TextView tvitemid;
		TextView tvitemname;
		EditText etitemcount;
		EditText etitemcosttime;
	}
	/**
	 */
	private class EditOnTouch implements OnTouchListener{
		private EditText met;
		private int position;
		

		public EditOnTouch(EditText met, int position) {
			super();
			this.met = met;
			this.position = position;
		}


		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			new KeyBoardUtil(mContext, mActivity, met).showKeyboard();;
			return false;
		} 
		
	}
	public class TextWatch implements TextWatcher {
		private int position;
		private EditText met;
		
		public TextWatch(int position, EditText met) {
			super();
			this.position = position;
			this.met = met;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", "before TextChanged Method position="+position+"content="+s.toString());
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			Log.i("System.out.alex", " onTextChanged Method position="+position+"content="+s.toString());
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
//			mData.get(position).setCount(Integer.valueOf(met.getText().toString()));
//			notifyDataSetChanged();
			Log.i("System.out.alex", "after TextChanged Method position="+position+"content="+s.toString());
			listcount.put(position, Integer.valueOf(s.toString()));
		}
		
	}
	public class AdapterOnClick implements OnClickListener {
		private int position;
		private Object obj;

		public AdapterOnClick(int position, Object obj) {
			super();
			this.position = position;
			this.obj = obj;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}

	}
}
