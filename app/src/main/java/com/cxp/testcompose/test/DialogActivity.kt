package com.cxp.testcompose.test

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cxp.testcompose.BaseActivity
import com.cxp.testcompose.R

/**
 * onDismissRequest: () -> Unit,  //关闭对话框执行回调
 * properties: DialogProperties = DialogProperties(), //对话框属性，自定义使用
 * content: @Composable () -> Unit //对话框内容
 *
 * DialogProperties 扩展
 *
 * val dismissOnBackPress: Boolean = true,  //是否可以按下返回键取消对话框
 * val dismissOnClickOutside: Boolean = true, //是否可以点击对话框以外区域取消对话框
 * val securePolicy: SecureFlagPolicy = SecureFlagPolicy.Inherit,
 * val usePlatformDefaultWidth: Boolean = true, //对话框内容是否呗限制在平台默认范围内
 *
 */
class DialogActivity : BaseActivity() {
    @Composable
    override fun InitView() {

        Column {
            //AlertDialog
            DialogExamples()

            //弹窗
//            MinimalDialog() {}

            //显示自定义弹窗
//            DialogWithImageExample()
        }
    }

    /**
     * AlertDialog
     */
    @Composable
    fun DialogExamples() {
        val context = LocalContext.current
        var openAlertDialog by remember { mutableStateOf(true) }

        when {
            openAlertDialog -> {
                AlertDialogExample(
                    onDismissRequest = { openAlertDialog = false },
                    onConfirmation = {
                        openAlertDialog = false //关闭弹窗
                        Toast.makeText(context, "确认", Toast.LENGTH_SHORT).show()
                    },
                    dialogTitle = "AlertDialog 标题",
                    dialogText = "我是文本",
                    icon = Icons.Default.Info
                )
            }
        }
    }

    /**
     * 警告提示框
     */
    @Composable
    fun AlertDialogExample(
        onDismissRequest: () -> Unit,  //当用户关闭对话框时调用的函数。 例如点按屏幕以外的地
        onConfirmation: () -> Unit,  //确认按钮
        dialogTitle: String,
        dialogText: String,
        icon: ImageVector,
    ) {
        AlertDialog(
//            icon = {
//            Icon(icon, contentDescription = "Example Icon")
//        },
            title = {
            Text(text = dialogTitle)
        }, text = {
            Text(text = dialogText)
        }, onDismissRequest = {
            onDismissRequest()
        }, confirmButton = {
            TextButton(onClick = {
                onConfirmation()
            }) {
                Text("确认")
            }
        }, dismissButton = {
            TextButton(onClick = {
                onDismissRequest()
            }) {
                Text("取消")
            }
        })
    }


    /**
     * Dialog 简单使用
     */
    @Composable
    fun MinimalDialog(onDismissRequest: () -> Unit) {
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "我是弹窗呦~",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    /**
     * Dialog 图片自定义
     */
    @Composable
    fun DialogWithImage(
        onDismissRequest: () -> Unit,
        onConfirmation: () -> Unit,
        painter: Painter,
        imageDescription: String,
    ) {
        Dialog(
            onDismissRequest = {onDismissRequest()},
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painter,
                        contentDescription = imageDescription,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.height(160.dp)
                    )
                    Text(text = "自定义Dialog")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TextButton(
                            onClick = {
                                onDismissRequest()
                            },
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text("取消")
                        }
                        TextButton(
                            onClick = {
                                onConfirmation()
                            },
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text("确认")
                        }
                    }
                }
            }
        }
    }

    /**
     * 显示自定义弹窗
     */
    @Composable
    fun DialogWithImageExample() {
        val context = LocalContext.current
        var openAlertDialog by remember { mutableStateOf(true) }

        when {
            openAlertDialog -> {
                DialogWithImage(
                    onDismissRequest = { openAlertDialog = false },
                    onConfirmation = {
                        openAlertDialog = false //关闭弹窗
                        Toast.makeText(context, "确认", Toast.LENGTH_SHORT).show()
                    },
                    painter = painterResource(id = R.drawable.avatar),
                    imageDescription = "图片"
                )
            }
        }
    }
}