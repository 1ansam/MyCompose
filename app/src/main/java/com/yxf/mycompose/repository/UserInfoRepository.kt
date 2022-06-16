package com.yxf.mycompose.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yxf.mycompose.service.QueryService
import com.yxf.mycompose.single.RetrofitService
import com.yxf.vehicleinspection.bean.request.AllUserInfoR001Request
import com.yxf.vehicleinspection.bean.request.UserInfoRequest
import com.yxf.vehicleinspection.bean.response.CommonResponse
import com.yxf.vehicleinspection.bean.response.UserInfoR001Response
import getJsonData
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.IllegalArgumentException

/**
 *   author:yxf
 *   time:2022/6/16
 */
class UserInfoRepository {

    suspend fun getUser() =
        RetrofitService.create(QueryService::class.java).querySuspend(
            "LYYDJKR001",
            "192.168.1.1",
            getJsonData(AllUserInfoR001Request())
        )
}

class UserInfoViewModel(val repo : UserInfoRepository) : ViewModel(){
    val flow = MutableStateFlow(emptyList<UserInfoR001Response>())
    fun getUser(){
        viewModelScope.launch {
            flow.emit(repo.getUser().Body)
        }
    }

}

class UserInfoViewModelFactory(val repo : UserInfoRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserInfoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserInfoViewModel(repo) as T
        }
        throw IllegalArgumentException("未知ViewModel")
    }

}