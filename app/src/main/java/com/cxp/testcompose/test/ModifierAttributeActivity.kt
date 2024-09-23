package com.cxp.testcompose.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxp.testcompose.BaseActivity
import com.cxp.testcompose.R

/**
 * 修饰符顺序可以影响效果
 *
 * Modifier.size()  //大小，宽高也可分别设置
 * Modifier.padding()  //
 * Modifier.background()  //背景色
 * Modifier.fillMaxSize()  //填满整个父布局
 * Modifier.fillMaxWidth()  //宽度填满父布局
 * Modifier.fillMaxHeight()  //高度填满父布局
 * Modifier.requiredSize()  //指定大小，不随父布局大小改变
 * Modifier.border()  //边框
 * Modifier.padding()  //内外边距（根据不同的位置，变为内外边距）
 * Modifier.offset()  //偏移量
 * Modifier.weight()  //权重比例
 *
 */
class ModifierAttributeActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        //用例
//        Example()

        //matchParentSize修饰符使用
        MatchParentModifierExample()
    }

    /**
     * 用例
     */
    @Composable
    private fun Example() {
        Column(
            modifier = Modifier
//                .offset(x = 100.dp, y = 50.dp)
                .wrapContentSize()  //组件本身大小
                .background(Color.Blue) //背景色
                .size(150.dp) //大小，宽高也可分别设置
                .padding(10.dp)  //内边距
                .border(3.dp, Color.Black)//边框
                .padding(10.dp), //外边距

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

    @Composable
    fun ArtistCard() {
        Row(
            modifier = Modifier.size(width = 400.dp, height = 100.dp)
        ) {
            Image(
                modifier = Modifier.requiredSize(50.dp),
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "头像"
            )
            Column {
                Text(text = "标题", fontSize = 18.sp, color = Color.Black)
                Text(
                    text = "描述描述描述描述描述描述描述描述",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }

    /**
     * matchParentSize修饰符使用
     */
    @Composable
    fun MatchParentModifierExample() {
        Box {
            Spacer(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.LightGray)
            )
            ArtistCard()
        }
    }
}

