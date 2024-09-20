package com.cxp.testcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cxp.testcompose.ui.theme.TestComposeTheme
import okhttp3.internal.wait
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SimpleWidgetColumn()
//                    SimpleWidgetRow()
                    SimpleWidgetBox()
                }
            }
        }
    }

    @Composable
    fun SimpleWidgetColumn() {
        val context = LocalContext.current
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //文本控件
            Text(
                modifier = Modifier.align(Alignment.End),
                text = "This is Text", color = Color.Blue, fontSize = 26.sp
            )
            //按钮控件
            Button(onClick = {
                Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
            }) {
                Text(
                    text = "This is Button",
                    color = Color.White,
                    fontSize = 26.sp,
                )
            }
            //输入框控件
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "请输入内容")  //hint
                },
                colors = TextFieldDefaults.colors(
                    // 设置文本字段聚焦时的背景颜色
                    focusedContainerColor = Color.White,
                    // 设置文本字段未聚焦或初始状态时的背景颜色
                    unfocusedContainerColor = Color.White,
                    // 设置文本字段禁用时的背景颜色
                    disabledContainerColor = Color.White
                )
            )
            //图片控件
            val bitmap = ImageBitmap.imageResource(id = R.drawable.avatar)
            Image(
//                painter = painterResource(R.drawable.avatar), //直接导入资源
                bitmap = bitmap, //bitmap资源 ,如果是传统的Bitmap对象，需要用asImageBitmap转换一下，例如：bitmap = bitmap.asImageBitmap(),
                contentDescription = "头像图片",  //描述,（必填）在accessibility模式下，为有视觉障碍的群体提供发音辅助的，可以填null
            )
            //加载网络图片
            AsyncImage(
                model = "https://img.shetu66.com/2022/08/cutCoverImg/1663065913148990.jpg",
                contentDescription = "网络图片",
                modifier = Modifier
                    .size(100.dp) //图片大小
                    .clip(CircleShape) //图片裁剪圆形
            )
            //圆形进度条
            CircularProgressIndicator(
                color = Color.Red, //颜色
                strokeWidth = 6.dp //粗细
            )
            //长条形进度条
            LinearProgressIndicator(
                color = Color.Yellow,//前景色
                trackColor = Color.Red //背景色
            )
        }
    }

    @Composable
    fun SimpleWidgetRow() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "This is Text",
                color = Color.Blue,
                fontSize = 26.sp
            )

            val context = LocalContext.current

            Button(onClick = {
                Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
            }) {
                Text(
                    text = "This is Button",
                    color = Color.White,
                    fontSize = 26.sp
                )
            }

            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "请输入内容")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White
                )
            )
        }
    }

    @Composable
    fun SimpleWidgetBox() {
        val context = LocalContext.current
        Box(
//            modifier = Modifier.fillMaxSize(),  //大小充满父布局
        ) {
            //文本控件
            Text(
                modifier = Modifier.align(Alignment.TopStart),
                text = "This is Text",
                color = Color.Blue,
                fontSize = 26.sp
            )
            //按钮控件
            Button(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = {
                    Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
                }) {
                Text(
                    text = "This is Button",
                    color = Color.White,
                    fontSize = 26.sp,
                )
            }
            //输入框控件
            TextField(
                modifier = Modifier.align(Alignment.CenterStart),
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "请输入内容")  //hint
                },
                colors = TextFieldDefaults.colors(
                    // 设置文本字段聚焦时的背景颜色
                    focusedContainerColor = Color.White,
                    // 设置文本字段未聚焦或初始状态时的背景颜色
                    unfocusedContainerColor = Color.White,
                    // 设置文本字段禁用时的背景颜色
                    disabledContainerColor = Color.White
                )
            )
            //图片控件
            val bitmap = ImageBitmap.imageResource(id = R.drawable.avatar)
            Image(
                modifier = Modifier.align(Alignment.CenterEnd),
//                painter = painterResource(R.drawable.avatar), //直接导入资源
                bitmap = bitmap, //bitmap资源 ,如果是传统的Bitmap对象，需要用asImageBitmap转换一下，例如：bitmap = bitmap.asImageBitmap(),
                contentDescription = "头像图片",  //描述,（必填）在accessibility模式下，为有视觉障碍的群体提供发音辅助的，可以填null
            )
            //加载网络图片
            AsyncImage(
                model = "https://img.shetu66.com/2022/08/cutCoverImg/1663065913148990.jpg",
                contentDescription = "网络图片",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(100.dp) //图片大小
                    .clip(CircleShape) //图片裁剪圆形
            )
            //圆形进度条
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.BottomEnd),
                color = Color.Red, //颜色
                strokeWidth = 6.dp //粗细
            )
            //长条形进度条
            LinearProgressIndicator(
                modifier = Modifier.align(Alignment.BottomCenter),
                color = Color.Yellow,//前景色
                trackColor = Color.Red //背景色
            )
        }
    }
}

