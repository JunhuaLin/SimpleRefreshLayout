package cn.junhua.view.simplerefreshlayout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junhualin on 2019/11/13.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>
{

	private List<String> mData = new ArrayList<>();

	public void setData(List<String> data)
	{
		mData = data;
	}

	@NonNull
	@Override
	public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_layout, parent, false);
		return new ItemViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull ItemViewHolder holder, int position)
	{
		holder.bind(position);
	}

	@Override
	public int getItemCount()
	{
		return mData.size();
	}

	class ItemViewHolder extends RecyclerView.ViewHolder
	{
		private TextView tv_hint;

		ItemViewHolder(View itemView)
		{
			super(itemView);

			tv_hint = itemView.findViewById(R.id.tv_hint);
		}

		public void bind(int position)
		{
			tv_hint.setText("ItemView:" + position);
		}
	}
}
