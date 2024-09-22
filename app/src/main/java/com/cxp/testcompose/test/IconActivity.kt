package com.cxp.testcompose.test

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity

/**
 *  imageVector: ImageVector, //矢量图
 *  bitmap: ImageBitmap, //位图
 *  painter: Painter, // 画笔
 *  contentDescription: String?, //图标描述
 *  modifier: Modifier = Modifier, //修饰符
 *  tint: Color //颜色
 */
class IconActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        //图标显示
        IconSample()
    }

    @Composable
    fun IconSample() {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.wrapContentSize()  //自适应大小
        )
    }

}