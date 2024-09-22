package com.cxp.testcompose.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipState
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxp.testcompose.BaseActivity

/**
 * checked: Boolean, //是否被选中
 * onCheckedChange: ((Boolean) -> Unit)?, //当复选框被点击时被调用的回调
 * modifier: Modifier = Modifier, //修饰符
 * enabled: Boolean = true, //是否启用
 * colors: CheckboxColors = CheckboxDefaults.colors(), //颜色组
 * interactionSource: MutableInteractionSource = remember { MutableInteractionSource() } //监听
 */
class SelectorActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        Column(modifier = Modifier.padding(10.dp)) {
            //复选框简单使用
            CheckboxExample()

            //复选框复杂使用
            CheckboxParentExample()

            //开关按钮
            SwitchMinimalExample()

            //自定义缩略图开关
            SwitchWithIconExample()

            //自定义颜色开关
            SwitchWithCustomColors()
        }
    }

    /**
     * 复选框简单使用
     */
    @Composable
    fun CheckboxExample() {
        var checked by remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("男")
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red
                )
            )
            Text(
                if (checked) "选中" else "未选中"
            )
        }
    }

    /**
     * 复选框复杂使用
     */
    @Composable
    fun CheckboxParentExample() {
        //初始化复选框的状态
        val childCheckedStates = remember { mutableStateListOf(false, false, false) }
        //根据子状态计算父状态
        val parentState = when {
            childCheckedStates.all { it } -> ToggleableState.On
            childCheckedStates.none { it } -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }

        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Select all")
                TriStateCheckbox(state = parentState, onClick = {
                    //根据当前状态改变新状态
                    val newState = parentState != ToggleableState.On
                    childCheckedStates.forEachIndexed { index, _ ->
                        childCheckedStates[index] = newState
                    }
                })
            }

            //子复选框
            childCheckedStates.forEachIndexed { index, checked ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Option ${index + 1}")
                    Checkbox(checked = checked, onCheckedChange = { isChecked ->
                        //更新单个子状态
                        childCheckedStates[index] = isChecked
                    })
                }
            }
        }

        if (childCheckedStates.all { it }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                text = "All options selected",
                fontSize = 24.sp,
                color = Color.Green
            )
        }
    }

    /**
     * 开关按钮
     */
    @Composable
    fun SwitchMinimalExample() {
        var checked by remember { mutableStateOf(false) }
        Switch(checked = checked, onCheckedChange = {
            checked = it
        })
    }


    /**
     * 自定义缩略图开关
     */
    @Composable
    fun SwitchWithIconExample() {
        var checked by remember { mutableStateOf(true) }

        Switch(checked = checked,
            onCheckedChange = { checked = it },
            thumbContent = if (checked) { //thumbContent 改变图片样式
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize)
                    )
                }
            } else null)
    }

    /**
     * 自定义颜色开关
     */
    @Composable
    fun SwitchWithCustomColors() {
        var checked by remember { mutableStateOf(false) }

        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.Yellow,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
    }
}