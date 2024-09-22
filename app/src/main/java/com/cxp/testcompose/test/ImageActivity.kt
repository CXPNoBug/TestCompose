package com.cxp.testcompose.test

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.cxp.testcompose.BaseActivity
import com.cxp.testcompose.R

/**
 * painter: Painter,  //加载资源
 * contentDescription: String?,
 * modifier: Modifier = Modifier,
 * alignment: Alignment = Alignment.Center,
 * contentScale: ContentScale = ContentScale.Fit,
 * alpha: Float = DefaultAlpha,
 * colorFilter: ColorFilter? = null
 *
 * 剪裁
 * ContentScale.Crop  //居中剪裁 类似ImageView的centerCrop
 * ContentScale.Fit  //类似ImageView的fitCenter
 * ContentScale.FillHeight //充满高
 * ContentScale.FillWidth //充满宽
 * ContentScale.Inside //类似ImageView的centerInside
 * ContentScale.None  //不处理
 * ContentScale.FillBounds  //类似ImageView的fitXY
 *
 */
class ImageActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        //图片预览
        ImageSample()
    }

    /**
     * 图片预览
     */
    @Composable
    fun ImageSample() {
        Image(painter = painterResource(id = R.drawable.avatar), contentDescription = "图片描述")
    }
}