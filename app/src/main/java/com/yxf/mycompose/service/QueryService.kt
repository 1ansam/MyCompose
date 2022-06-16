package com.yxf.mycompose.service

import com.yxf.vehicleinspection.bean.response.CommonResponse
import com.yxf.vehicleinspection.bean.response.UserInfoR001Response
import com.yxf.vehicleinspection.bean.response.VehicleQueueR002Response
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

/**
 *   author:yxf
 *   time:2022/6/16
 */
interface QueryService {

    //coroutines
    @POST("VehicleInspection/Query")
    suspend fun querySuspend(
        @Query("jkId") jkId: String,
        @Query("zdbs") zdbs: String,
        @Query("jsonData") jsonData: String
    ): CommonResponse<UserInfoR001Response>
}