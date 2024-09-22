package com.cxp.testcompose.test

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity

/**
 * onClick: () -> Unit, //点击回调
 * modifier: Modifier = Modifier, // 修饰符
 * enabled: Boolean = true, //是否启用按钮
 * shape: Shape = ButtonDefaults.outlinedShape, //绘画弧度
 * colors: ButtonColors = ButtonDefaults.outlinedButtonColors(), //颜色
 * elevation: ButtonElevation? = null, //阴影
 * border: BorderStroke? = ButtonDefaults.outlinedButtonBorder, //边框
 * contentPadding: PaddingValues = ButtonDefaults.ContentPadding, //按钮内的内边距
 * interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }, //监听组件状态，可以设置不同样式，按下，松开可以分别设置样式
 * content: @Composable RowScope.() -> Unit
 *
 * 监听
 *
 * interactionSource.collectIsPressedAsState()：//判断是否按下状态
 * interactionSource.collectIsFocusedAsState()：//判断是否获取焦点的状态
 * interactionSource.collectIsDraggedAsState()：//判断是否拖动
 *
 */
class ButtonActivity : BaseActivity() {
    @Composable
    override fun InitView() {
        val context = LocalContext.current
        Column(
            modifier = Modifier.wrapContentSize()
        ) {
            //实心按钮
            FilledButtonExample() {
                Toast.makeText(context, "实心按钮", Toast.LENGTH_SHORT).show()
            }

            //填充色调按钮
            FilledTonalButtonExample() {
                Toast.makeText(context, "填充色调按钮", Toast.LENGTH_SHORT).show()
            }

            //轮廓按钮
            OutlinedButtonExample() {
                Toast.makeText(context, "轮廓按钮", Toast.LENGTH_SHORT).show()
            }

            //凸起按钮
            ElevatedButtonExample() {
                Toast.makeText(context, "凸起按钮", Toast.LENGTH_SHORT).show()
            }

            //文本按钮
            TextButtonExample() {
                Toast.makeText(context, "文本按钮", Toast.LENGTH_SHORT).show()
            }

            //按钮添加图片
            ButtonImageExample() {
                Toast.makeText(context, "按钮添加图片", Toast.LENGTH_SHORT).show()
            }

            //动态改变按钮边框颜色
            InteractionSourceExample() {
                Toast.makeText(context, "动态改变按钮边框颜色", Toast.LENGTH_SHORT).show()
            }

            //按钮图标 一般尺寸 24x24
            IconButtonExample() {
                Toast.makeText(context, "按钮图标", Toast.LENGTH_SHORT).show()
            }

            //悬浮按钮
            FloatingActionButtonExample() {
                Toast.makeText(context, "悬浮按钮", Toast.LENGTH_SHORT).show()
            }

            //拓展悬浮图标
            ExtendedFloatingActionButtonExample() {
                Toast.makeText(context, "拓展悬浮图标", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * 实心按钮
     */
    @Composable
    fun FilledButtonExample(onClick: () -> Unit) {
        Button(onClick = { onClick() }) {
            Text("Filled")
        }
    }

    /**
     * 填充色调按钮
     */
    @Composable
    fun FilledTonalButtonExample(onClick: () -> Unit) {
        FilledTonalButton(onClick = { onClick() }) {
            Text("Tonal")
        }
    }

    /**
     * 轮廓按钮
     */
    @Composable
    fun OutlinedButtonExample(onClick: () -> Unit) {
        OutlinedButton(onClick = { onClick() }) {
            Text("Outlined")
        }
    }

    /**
     * 凸起按钮
     */
    @Composable
    fun ElevatedButtonExample(onClick: () -> Unit) {
        ElevatedButton(onClick = { onClick() }) {
            Text("Elevated")
        }
    }

    /**
     * 文本按钮
     */
    @Composable
    fun TextButtonExample(onClick: () -> Unit) {
        TextButton(onClick = { onClick() }) {
            Text("Text Button")
        }
    }

    @Composable
    fun ButtonImageExample(onClick: () -> Unit) {
        Button(onClick = { onClick() }) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("确认")
        }
    }

    /**
     * 动态改变按钮边框颜色
     */
    @Composable
    fun InteractionSourceExample(onClick: () -> Unit) {
        val interactionSource = remember { MutableInteractionSource() }
        val pressState = interactionSource.collectIsPressedAsState()
        val borderColor = if (pressState.value) Color.Green else Color.White

        Button(
            onClick = { onClick() },
            border = BorderStroke(2.dp, color = borderColor),
            interactionSource = interactionSource
        ) {
            Text("Long Press")
        }
    }

    /**
     * 按钮图标 一般尺寸 24x24
     */
    @Composable
    fun IconButtonExample(onClick: () -> Unit) {
        IconButton(onClick = { onClick() }) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
        }
    }

    /**
     * 悬浮按钮
     */
    @Composable
    fun FloatingActionButtonExample(onClick: () -> Unit) {
        FloatingActionButton(onClick = { onClick() }) {
            Icon(Icons.Filled.PlayArrow, contentDescription = null)
        }
    }

    /**
     * 拓展悬浮图标
     */
    @Composable
    fun ExtendedFloatingActionButtonExample(onClick: () -> Unit) {
        ExtendedFloatingActionButton(
            modifier = Modifier.padding(top = 10.dp),
            icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
            text = { Text("添加到我喜欢的") },
            onClick = {},
        )
    }
}