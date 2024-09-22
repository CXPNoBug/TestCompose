package com.cxp.testcompose.test

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.cxp.testcompose.BaseActivity

/**
 * value: Float,  //进度值
 * onValueChange: (Float) -> Unit, //进度改变的监听
 * modifier: Modifier = Modifier,
 * enabled: Boolean = true,
 * valueRange: ClosedFloatingPointRange<Float> = 0f..1f,  //进度值范围
 * @IntRange(from = 0)
 * steps: Int = 0, //进度分段
 * onValueChangeFinished: (() -> Unit)? = null, //进度改变完成的监听
 * colors: SliderColors = SliderDefaults.colors(),  //颜色设置
 * interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }  //监听
 */
class SliderActivity : BaseActivity() {

    @Composable
    override fun InitView() {

        Column {
            //简单使用
            SliderMinimalExample()

            //高级实现
            SliderAdvancedExample()

            //范围滑块
            RangeSliderExample()
        }
    }

    /**
     * 简单使用
     */
    @Composable
    fun SliderMinimalExample() {
        var sliderPosition by remember { mutableFloatStateOf(0f) }

        Column {
            Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
            Text(text = sliderPosition.toString())
        }
    }

    /**
     * 高级实现
     */
    @Composable
    fun SliderAdvancedExample() {
        var sliderPosition by remember { mutableFloatStateOf(0f) }
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = Color.Red,  //滑块颜色
                    activeTrackColor = Color.Gray, //进度条颜色
                    inactiveTickColor = Color.Yellow
                ),
                steps = 3,  //步数
                valueRange = 0f..50f //范围
            )
            Text(text = sliderPosition.toString())
        }
    }

    /**
     * 范围滑块
     */
    @Composable
    fun RangeSliderExample() {
        var sliderPosition by remember { mutableStateOf(0f..100f) }
        Column {
            RangeSlider(
                value = sliderPosition,
                steps = 5,
                onValueChange = { range -> sliderPosition = range },
                onValueChangeFinished = {
                    Log.d(TAG, "=========onValueChangeFinished========== ")
                }
            )
            Text(text = sliderPosition.toString())
        }
    }
}