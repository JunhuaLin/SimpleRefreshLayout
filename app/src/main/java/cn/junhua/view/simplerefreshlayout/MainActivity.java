package cn.junhua.view.simplerefreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.junhua.view.refresh.layout.SmartRefreshLayout;
import cn.junhua.view.refresh.layout.api.RefreshLayout;
import cn.junhua.view.refresh.layout.header.ClassicsHeader;
import cn.junhua.view.refresh.layout.header.MaterialHeader;
import cn.junhua.view.refresh.layout.listener.OnRefreshLoadMoreListener;

public class MainActivity extends AppCompatActivity implements OnRefreshLoadMoreListener, View.OnClickListener
{

	private SmartRefreshLayout mSmartRefreshLayout;
	private RecyclerView mRecyclerView;
	private ItemAdapter mItemAdapter;
	private View tv_fixed_text;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv_fixed_text = findViewById(R.id.tv_fixed_text);

		tv_fixed_text.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showToast("isLoading:" + mSmartRefreshLayout.isLoading() + "   isRefreshing:" + mSmartRefreshLayout.isRefreshing());
			}
		});

		mSmartRefreshLayout = findViewById(R.id.srl_layout);
		mSmartRefreshLayout.setOnRefreshLoadMoreListener(this);
//		mSmartRefreshLayout.setReboundInterpolator(new DecelerateInterpolator());
//		mSmartRefreshLayout.setReboundInterpolator(new BounceInterpolator());
//		setMaterialHeader();
		setClassicHeader();


		mRecyclerView = findViewById(R.id.rv_content);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		mItemAdapter = new ItemAdapter();
		mItemAdapter.setOnClickListener(this);
		mItemAdapter.setData(genDataList());

		mRecyclerView.setAdapter(mItemAdapter);
		mItemAdapter.notifyDataSetChanged();
	}

	private void showToast(String msg)
	{
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	private void setClassicHeader()
	{
		ClassicsHeader classicsHeader = new ClassicsHeader(this);
		classicsHeader.setBackgroundColor(Color.parseColor("#cccccc"));
		mSmartRefreshLayout.setRefreshHeader(classicsHeader);
	}

	private void setMaterialHeader()
	{
		MaterialHeader materialHeader = new MaterialHeader(this);
		mSmartRefreshLayout.setRefreshHeader(materialHeader);
	}

	private List<String> genDataList()
	{
		List<String> dataList = new ArrayList<>();
		for (int i = 0; i < 50; i++)
		{
			dataList.add("item ");
		}
		return dataList;
	}

	@Override
	public void onLoadMore(@NonNull RefreshLayout refreshLayout)
	{
		mSmartRefreshLayout.finishLoadMore(2000);
	}

	@Override
	public void onRefresh(@NonNull RefreshLayout refreshLayout)
	{
		mSmartRefreshLayout.finishRefresh(2000);
	}

	@Override
	public void onClick(View v)
	{
		mSmartRefreshLayout.autoRefresh();
	}
}
