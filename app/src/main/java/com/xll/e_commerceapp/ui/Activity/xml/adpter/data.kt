package com.xll.e_commerceapp.ui.Activity.xml.adpter

import android.content.Context
import com.xll.e_commerceapp.Data.repository.HomeRepoItem
import com.xll.e_commerceapp.R
import java.security.AccessControlContext

object data {
    var list = ArrayList<HomeRepoItem>()
    fun d1(homeAdpter:HomeAdpter){
        list.addAll(listOf(HomeRepoItem(R.drawable.tast,"White shirt","50.00",true)))
        list.addAll(listOf(HomeRepoItem(R.drawable.test2,"White shirt","70.00",false)))
        list.addAll(listOf(HomeRepoItem(R.drawable.test3,"White shirt","80.00",true)))
        list.addAll(listOf(HomeRepoItem(R.drawable.test4,"White shirt","20.00",true)))
        list.addAll(listOf(HomeRepoItem(R.drawable.tast,"White shirt","30.00",true)))
        list.addAll(listOf(HomeRepoItem(R.drawable.tast,"White shirt","35.00",true)))

        homeAdpter.Get_Date(list)
    }
}