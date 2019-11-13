package cn.junhua.view.refresh.layout.listener;

import android.support.annotation.NonNull;

import cn.junhua.view.refresh.layout.api.RefreshLayout;


/**
 * 刷新监听器
 * Created by scwang on 2017/5/26.
 */
public interface OnRefreshListener
{
	void onRefresh(@NonNull RefreshLayout refreshLayout);
}
