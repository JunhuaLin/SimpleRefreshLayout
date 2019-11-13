package cn.junhua.view.simplerefreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

import cn.junhua.view.refresh.layout.SmartRefreshLayout;
import cn.junhua.view.refresh.layout.api.RefreshLayout;
import cn.junhua.view.refresh.layout.header.MaterialHeader;
import cn.junhua.view.refresh.layout.listener.OnRefreshLoadMoreListener;

public class MainActivity extends AppCompatActivity implements OnRefreshLoadMoreListener, View.OnClickListener
{

	private SmartRefreshLayout mSmartRefreshLayout;
	private RecyclerView mRecyclerView;
	private ItemAdapter mItemAdapter;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSmartRefreshLayout = findViewById(R.id.srl_layout);
		mSmartRefreshLayout.setOnRefreshLoadMoreListener(this);
		mSmartRefreshLayout.setReboundInterpolator(new DecelerateInterpolator());
//		mSmartRefreshLayout.setReboundInterpolator(new BounceInterpolator());
//		MaterialHeader materialHeader = new MaterialHeader(this);
//		mSmartRefreshLayout.setRefreshHeader(materialHeader);

		mRecyclerView = findViewById(R.id.rv_content);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		mItemAdapter = new ItemAdapter();
		mItemAdapter.setOnClickListener(this);
		mItemAdapter.setData(genDataList());

		mRecyclerView.setAdapter(mItemAdapter);
		mItemAdapter.notifyDataSetChanged();
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
		mHandler.postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				mSmartRefreshLayout.closeHeaderOrFooter();
			}
		}, 2000);
	}

	@Override
	public void onRefresh(@NonNull RefreshLayout refreshLayout)
	{
		mHandler.postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				mSmartRefreshLayout.closeHeaderOrFooter();
			}
		}, 2000);
	}

	@Override
	public void onClick(View v)
	{
		mSmartRefreshLayout.autoRefresh();
	}
}
