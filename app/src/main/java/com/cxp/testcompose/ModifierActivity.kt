package com.cxp.testcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxp.testcompose.ui.theme.TestComposeTheme
import kotlin.math.roundToInt

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    IconImage()
//                    PointerInputEvent()
//                    ColumnVerticalScroll()
                    DragGableCompose()
                }
            }
        }
    }

    @Composable
    fun IconImage() {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "头像",
            modifier = Modifier
                .wrapContentSize(align = Alignment.CenterStart) //根据自身内容来决定控件的大小
                .border(5.dp, Color.Red, CircleShape)
                .clip(CircleShape)
                .rotate(180f)
        )
    }

    /**
     * 处理用户的输入
     */
    @Composable
    fun PointerInputEvent() {
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .requiredSize(200.dp)
                .background(Color.Blue)
                .clickable {
                    Toast
                        .makeText(context, "点我", Toast.LENGTH_SHORT)
                        .show()
                }
//                .pointerInput(Unit) {
//                    awaitPointerEventScope {
//                        while (true) {
//                            val event = awaitPointerEvent()
//                            Log.d("PointerInputEvent", "event: ${event.type}")
//                        }
//                    }
//                }
//                .pointerInput(Unit) {
//                    //单击
//                    detectTapGestures {
//                        Log.d("PointerInputEvent", "Tap")
//                    }
//                }
//                .pointerInput(Unit) {
//                    //拖动
//                    detectDragGestures { change, dragAmount ->
//                        Log.d("PointerInputEvent", "Draging")
//                    }
//                }
        ) { }
    }

    @Composable
    fun ColumnVerticalScroll() {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .requiredSize(200.dp)
                .background(Color.Blue)
                .verticalScroll(rememberScrollState())
        ) {
            repeat(10) {
                Text(
                    text = "Item $it",
                    color = Color.White,
                    fontSize = 22.sp
                )
            }
        }
    }

    /**
     * 拖拽事件
     */
    @Composable
    fun DragGableCompose() {
        var offsetX  by remember{ mutableStateOf(0f) }
        var offsetY  by remember{ mutableStateOf(0f) }
        Box(
            modifier = Modifier
//                .offset {IntOffset(offsetX.roundToInt(),0)}
                .offset {IntOffset(offsetX.roundToInt(),offsetY.roundToInt())}
                .requiredSize(200.dp)
                .background(Color.Blue)
//                .draggable(
//                    orientation = Orientation.Horizontal,
//                    state = rememberDraggableState { delta ->
//                        offsetX += delta
//                    }
//                )  //单一的手势拖拽
                .pointerInput(Unit){
                    detectDragGestures { change, dragAmount ->
                        change.consume()  //销毁
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        )

    }
}

