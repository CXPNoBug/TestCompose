package com.cxp.testcompose.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity

/**
 * value: String, //输入框显示的文本
 * onValueChange: (String) -> Unit, //当输入框内的文本发生改变时的回调，其中带有最新的文本参数
 * modifier: Modifier = Modifier, //修饰符
 * enabled: Boolean = true, //是否启用
 * readOnly: Boolean = false, //控制输入框的可编辑状态
 * textStyle: TextStyle = LocalTextStyle.current, //输入框内文字的样式
 * label: @Composable (() -> Unit)? = null, //可选标签，显示在输入框内
 * placeholder: @Composable (() -> Unit)? = null, //提示内容
 * leadingIcon: @Composable (() -> Unit)? = null, //在输入框开头显示图标
 * trailingIcon: @Composable (() -> Unit)? = null, //在输入框结尾显示图标
 * isError: Boolean = false, //检测值是否错误
 * visualTransformation: VisualTransformation = VisualTransformation.None, //可以切换是否明文 PasswordVisualTransformation 密码
 * maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE, //最大行数
 * interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }, //监听组件状态
 * shape: Shape = TextFieldDefaults.shape, //输入框外观形状
 * colors: TextFieldColors = TextFieldDefaults.colors() //输入框颜色
 * onTextLayout: (TextLayoutResult) -> Unit = {}, //输入框文本更新回调
 * interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
 * cursorBrush: Brush = SolidColor(Color.Black), //光标颜色
 * decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
 * @Composable { innerTextField -> innerTextField() }  //自定义TextField，但是必须要执行innerTextField()，才能完成构建
 */
class TextFieldActivity : BaseActivity() {
    @Composable
    override fun InitView() {
        val context = LocalContext.current
        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            //输入框
            TextFieldSample()
            //边框样式输入框
            OutlinedTextFieldSample()
            //基类输入框
            BasicTextFieldSample()
            //搜索框
            SearchBar()
        }
    }

    /**
     * 输入框
     */
    @Composable
    fun TextFieldSample() {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        TextField(value = username, onValueChange = {
            username = it
        }, label = { Text("用户名") }, //标签
            leadingIcon = {
                Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "用户名")
            })
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = PasswordVisualTransformation(), //非明文
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //密码键盘（不能输入中文）
            label = { Text("密码") }, //标签
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Face, contentDescription = "用户密码")
                }
            },
        )
    }

    /**
     * 边框样式输入框
     */
    @Composable
    fun OutlinedTextFieldSample() {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        OutlinedTextField(value = username, onValueChange = {
            username = it
        }, label = { Text("用户名") }, //标签
            leadingIcon = {
                Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "用户名")
            })
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = PasswordVisualTransformation(), //非明文
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //密码键盘（不能输入中文）
            label = { Text("密码") }, //标签
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Face, contentDescription = "用户密码")
                }
            },
        )
    }

    /**
     * 基类输入框
     */
    @Composable
    fun BasicTextFieldSample() {
        var text by remember { mutableStateOf("") }
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            decorationBox = { innerTextField ->
                innerTextField()
                HorizontalDivider(
                    thickness = 5.dp, //分割线粗度
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
            }
        )
    }

    /*
     * 搜索框
     */
    @Composable
    fun SearchBar() {
        var text by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFD3D3D3)),
            contentAlignment = Alignment.Center  //将Box里面的组件放置于Box容器的中央
        ) {
            BasicTextField(
                value = text,
                maxLines = 1,
                onValueChange = {
                    text = it
                },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .background(Color.White, CircleShape)
                    .height(35.dp)
                    .fillMaxWidth(),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "搜索 图标"
                        )
                        Box(
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .weight(1f),
                            contentAlignment = Alignment.CenterStart,

                            ) {
                            if (text.isEmpty()) {
                                Text(
                                    text = "请输入内容",
                                    color = Color(0, 0, 0, 128)
                                )
                            }
                            innerTextField()
                        }
                        if (text.isNotEmpty()) {
                            IconButton(
                                modifier = Modifier.size(16.dp),
                                onClick = { text = "" },
                            ) {
                                Icon(imageVector = Icons.Filled.Close, contentDescription = "清空")
                            }
                        }
                    }
                },

                )
        }
    }
}