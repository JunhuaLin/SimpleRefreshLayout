package cn.junhua.view.refresh.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;

import cn.junhua.view.refresh.layout.api.RefreshFooter;
import cn.junhua.view.refresh.layout.internal.InternalAbstract;


/**
 * 刷新底部包装
 * Created by scwang on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshFooterWrapper extends InternalAbstract implements RefreshFooter/*, InvocationHandler */
{

	public RefreshFooterWrapper(View wrapper)
	{
		super(wrapper);
	}

//    @Override
//    public boolean setNoMoreData(boolean noMoreData) {
//        return mWrappedInternal instanceof RefreshFooter && ((RefreshFooter) mWrappedInternal).setNoMoreData(noMoreData);
//    }

}
