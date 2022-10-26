package com.xll.e_commerceapp.ui.Activity.xml.adpter

import android.content.Context
import com.xll.e_commerceapp.Data.repository.HomeRepoItem
import com.xll.e_commerceapp.R
import java.security.AccessControlContext

object data {
    var list = ArrayList<HomeRepoItem>()
    fun d1(homeAdpter:HomeAdpter){
        list.add(HomeRepoItem(R.drawable.tast,"",1))
        list.add(HomeRepoItem(R.drawable.test2,"",1))
        list.add(HomeRepoItem(R.drawable.test3,"",1))
        list.add(HomeRepoItem(R.drawable.test4,"",1))
        list.add(HomeRepoItem(R.drawable.tast,"",1))
        homeAdpter.Get_Date(list)
    }
}