package com.yxf.mycompose

import android.os.Bundle
import android.util.Log
import android.widget.Chronometer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.yxf.mycompose.repository.UserInfoRepository
import com.yxf.mycompose.repository.UserInfoViewModel
import com.yxf.mycompose.repository.UserInfoViewModelFactory
import com.yxf.mycompose.ui.theme.MyComposeTheme
import com.yxf.vehicleinspection.bean.response.CommonResponse
import com.yxf.vehicleinspection.bean.response.UserInfoR001Response
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val TAG = "TAG"
    val viewModel : UserInfoViewModel by viewModels { UserInfoViewModelFactory(
        UserInfoRepository()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate: ", )


        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    PhotographerCard()
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ", )
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ", )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ", )
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: ", )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ", )
    }


    @Composable
    fun RecyclerView(list : List<UserInfoR001Response>){
        Text(text = "dsadas")
        LazyColumn{
                if (list.isNotEmpty()){
                    items(list){
                        Text(text = it.UserName)
                    }
                }
        }
    }

    @Composable
    fun PhotographerCard() {

        val scope = rememberCoroutineScope()
        var list : List<UserInfoR001Response> by remember {
            mutableStateOf(emptyList())
        }
        var show by remember {
            mutableStateOf(false)
        }
        Column {
            
            Text("Alfred Sisley", fontWeight = FontWeight.Bold, fontSize = 26.sp)
            // LocalContentAlpha is defining opacity level of its children
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
            Button(onClick = {
                show = true
                viewModel.getUser()

            }) {



            }


            if (show){
                lifecycleScope.launch{
                    viewModel.flow.collect {
                        list = it
                    }
                }
                RecyclerView(list = list)
            }

        }
    }
}




