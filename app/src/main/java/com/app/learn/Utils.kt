package com.app.learn

import com.app.learn.viewmodel.recycler.ItemModel

object Utils {

    fun getSimpleItems(count : Int) : MutableList<ItemModel>{
        val list : MutableList<ItemModel> = mutableListOf()
        for (i in 0..count){
            list.add(ItemModel(i , "item $i"))
        }
        return list
    }
}