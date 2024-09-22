package com.cxp.testcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.cxp.testcompose.ui.theme.TestComposeTheme
import com.cxp.testcompose.viewmodel.StateFlowViewModel
import com.cxp.testcompose.viewmodel.StateViewModel

class StateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Counter()
                    CallCounter()
                }
            }
        }
    }

    /**
     * 计算器
     */
//    @Composable
//    fun Counter(modifier: Modifier = Modifier) {
//        var count by rememberSaveable { mutableStateOf(0) }
//        Column(
//            modifier = modifier,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Text(
//                text = "$count",
//                fontSize = 50.sp
//            )
//            Button(
//                onClick = { count++ }
//            ) {
//                Text(
//                    text = "Click me",
//                    fontSize = 26.sp
//                )
//            }
//        }
//    }


//    @Composable
//    fun CallCounter(modifier: Modifier = Modifier) {
//        var count by rememberSaveable { mutableStateOf(0) }
//        var doubleCount  by rememberSaveable { mutableStateOf(0) }
//        Column {
//            Counter(
//                count = count,
//                onIncrement = { count++ },
//                modifier.fillMaxWidth()
//            )
//            Counter(
//                count = doubleCount,
//                onIncrement = { doubleCount += 2 },
//                modifier.fillMaxWidth()
//            )
//        }
//    }

    /**
     * ViewModel+LiveData
     */
//    @Composable
//    fun CallCounter(modifier: Modifier = Modifier, viewModel: StateViewModel = viewModel()) {
//        val count by viewModel.count.observeAsState(0)
//        val doubleCount by viewModel.doubleCount.observeAsState(0)
//        Column {
//            Counter(
//                count = count,
//                onIncrement = { viewModel.incrementCount() },
//                modifier.fillMaxWidth()
//            )
//            Counter(
//                count = doubleCount,
//                onIncrement = { viewModel.incrementDoubleCount() },
//                modifier.fillMaxWidth()
//            )
//        }
//    }

    @Composable
    fun CallCounter(modifier: Modifier=Modifier,viewModel: StateFlowViewModel = viewModel()){
        val count=viewModel.count.collectAsState()
        val doubleCount=viewModel.doubleCount.collectAsState()
        Column {
            Counter(
                count = count.value,
                onIncrement = { viewModel.incrementCount() },
                modifier.fillMaxWidth()
            )
            Counter(
                count = doubleCount.value,
                onIncrement = { viewModel.incrementDoubleCount() },
                modifier.fillMaxWidth()
            )
        }
    }

    @Composable
    fun Counter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
        val context = LocalContext.current
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "$count",
                fontSize = 50.sp
            )
            Button(
                onClick = { onIncrement() }
            ) {
                Text(
                    text = "Click Me",
                    color = Color.White,
                    fontSize = 26.sp
                )
            }
        }
    }
}

