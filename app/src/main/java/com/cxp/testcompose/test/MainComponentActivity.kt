package com.cxp.testcompose.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity

class ComponentActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        ComponentList() { status ->
            when (status) {
                "Text" -> start<TextActivity>()
                "TextField" -> start<TextFieldActivity>()
                "Icon" -> start<IconActivity>()
                "Image" -> start<ImageActivity>()
                "Button" -> start<ButtonActivity>()
                "Selector" -> start<SelectorActivity>()
                "BadgedBox" -> start<BadgedBoxActivity>()
                "Slider" -> start<SliderActivity>()
                "Dialog" -> start<DialogActivity>()
                "Progress" -> start<ProgressActivity>()
                "Modifier" -> start<ModifierAttributeActivity>()
                "Layout" -> start<LayoutActivity>()
                else -> {}
            }
        }
    }

    @Composable
    fun ComponentList(onClick: (String) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Text") }) {
                Text(text = "Text 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("TextField") }) {
                Text(text = "TextField 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Icon") }) {
                Text(text = "Icon 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Image") }) {
                Text(text = "Image 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Button") }) {
                Text(text = "Button 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Selector") }) {
                Text(text = "选择器 组件（Checkbox复选框/Switch开关）")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("BadgedBox") }) {
                Text(text = "小红点 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Slider") }) {
                Text(text = "滑块 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Dialog") }) {
                Text(text = "Dialog 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Progress") }) {
                Text(text = "Progress 组件")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Modifier") }) {
                Text(text = "Modifier 修饰符")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onClick("Layout") }) {
                Text(text = "Layout 布局")
            }
        }
    }
}