package com.cxp.testcompose.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity

class ModifierAttributeActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        //用例
        Example()
    }

    /**
     * 用例
     */
    @Composable
    private fun Example() {
        Column(
            modifier = Modifier
                .wrapContentSize()  //组件本身大小
                .background(Color.Blue) //背景色
                .size(150.dp) //大小，宽高也可分别设置
                .padding(10.dp)  //边距
                .border(3.dp, Color.Black),  //边框
            horizontalAlignment = Alignment.CenterHorizontally,  //水平居中
            verticalArrangement = Arrangement.Center //垂直居中
        ) {
            Text(
                text = "Hello",
                color = Color.White,
                modifier = Modifier
                    .border(1.dp, Color.Green)
                    .fillMaxWidth(), //最大宽度
                textAlign = TextAlign.End
            )
            Icon(
                Icons.Filled.Favorite, contentDescription = null, modifier = Modifier
                    .border(1.dp, Color.Green)
                    .align(Alignment.CenterHorizontally) //设置子项位置
                    .fillMaxSize()  //充满父布局
            )
        }
    }
}

