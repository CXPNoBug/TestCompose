package com.cxp.testcompose.test

import android.annotation.SuppressLint
import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity
import com.cxp.testcompose.R

class LayoutActivity : BaseActivity() {

    @Composable
    override fun InitView() {

        //横向布局用例
//        RowExample()

//        SurfaceExample()

        ScaffoldExample()
    }

    /**
     * 横向布局用例
     */
    @Composable
    fun RowExample() {
        Surface(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 12.dp),
            shadowElevation = 10.dp
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(text = "Jetpack Compose 是什么？", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.padding(vertical = 5.dp))
                Text(text = "Jetpack Compose 是用于构建给原生 Android 界面的新工具包。它可以简化并加快 Android 上的界面开发，使用更少的代码。")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Favorite, null)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ShoppingCart, null)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Call, null)
                    }
                }
            }
        }
    }

    @Composable
    fun SurfaceExample() {
        Surface(
            modifier = Modifier
                .wrapContentSize()
                .width(300.dp)
                .height(100.dp),
            shape = RoundedCornerShape(8.dp),
            shadowElevation = 10.dp,
        ) {
            Row(modifier = Modifier.clickable { }) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "图片描述",
                    modifier = Modifier
                        .size(100.dp)
                        .border(1.dp, Color.Red),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.padding(horizontal = 12.dp))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Lirate", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.padding(vertical = 8.dp))
                    Text(text = "礼仪")
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldExample() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("主页")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(Icons.Filled.Menu, null)
                        }
                    }
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("主页界面")
            }
        }
    }

}