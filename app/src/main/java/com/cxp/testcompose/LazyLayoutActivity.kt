package com.cxp.testcompose

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxp.testcompose.ui.theme.TestComposeTheme

class LazyLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding()
                        .padding(top = 25.dp)
                ) {
//                    LazyColumList()
//                    LazyRowList()
                    MainLayout()

//                    val state = rememberLazyListState()
//                    ScrollableList(state)
                }
            }
        }
    }

    @Composable
    fun MainLayout() {
        val state = rememberLazyListState()
        Box {
            LazyColumList(state)
            val shouldShowAddButton by remember {
                derivedStateOf { state.firstVisibleItemIndex == 0 } //根据指定条件改变值
            }
            AddButton(shouldShowAddButton)
        }
    }

    @Composable
    fun LazyColumList(state: LazyListState) {
        val list = ('A'..'Z').map { it.toString() }
        LazyColumn(state = state) {
            items(list, key = { it }) { letter ->  // key = { it } 唯一标识，用来增删，提升性能
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(10.dp)
                ) {
                    Text(
                        text = letter,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            }
        }
    }

    @Composable
    fun BoxScope.AddButton(isVisible: Boolean) {
        if (isVisible) {
            FloatingActionButton(
                onClick = {},
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp)
            ) {
                Icon(Icons.Filled.Add, "Add Button")
            }
        }
    }

    @Composable
    fun LazyRowList() {
        val list = ('A'..'Z').map { it.toString() }
//        LazyRow(contentPadding = PaddingValues(start = 10.dp, end = 10.dp)) { //设置两边间距，contentPadding不会出现滑动半截的情况
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) { //设置子项间距
            itemsIndexed(list) { index, letter ->
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(200.dp)
                ) {
                    Text(
                        text = "$index $letter",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            }
        }
    }

    @Composable
    fun ImageHeader() {
        Image(
            painterResource(id = R.drawable.avatar),
            contentDescription = "Header Image",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }

    @Composable
    fun ImageFooter() {
        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Footer Image",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }

    @Composable
    fun ScrollableList(state: LazyListState) {
        val list = (1..10).map { it.toString() }
        LazyColumn(state = state) {
            item {
                ImageHeader()
            }
            items(list) { letter ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(10.dp)
                ) {
                    Text(
                        text = letter,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            }
            item {
                ImageFooter()
            }
        }
    }
}
