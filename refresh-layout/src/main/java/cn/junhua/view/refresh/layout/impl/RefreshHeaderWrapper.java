package cn.junhua.view.refresh.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;

import cn.junhua.view.refresh.layout.api.RefreshHeader;
import cn.junhua.view.refresh.layout.internal.InternalAbstract;


/**
 * 刷新头部包装
 * Created by scwang on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshHeaderWrapper extends InternalAbstract implements RefreshHeader/*, InvocationHandler*/
{

	public RefreshHeaderWrapper(View wrapper)
	{
		super(wrapper);
	}

}
