package com.cxp.testcompose.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressActivity : BaseActivity() {
    @Composable
    override fun InitView() {

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            //确定性指标
            LinearDeterminateIndicator()

            //不确定性指示符
            IndeterminateCircularIndicator()
        }
    }

    /**
     * 确定性指标
     */
    @Composable
    fun LinearDeterminateIndicator() {
        var currentProgress by remember { mutableStateOf(0f) }
        var loading by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope() //创建协程


        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false  //重置状态
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            LinearProgressIndicator(
                progress = { currentProgress },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    /**
     * 模拟进度
     */
    suspend fun loadProgress(updateProgress: (Float) -> Unit) {
        for (i in 1..100) {
            updateProgress(i.toFloat() / 100)
            delay(100)
        }
    }

    /**
     * 不确定性指示符
     */
    @Composable
    fun IndeterminateCircularIndicator() {
        var loading by remember { mutableStateOf(false) }

        Button(
            modifier = Modifier.padding(top = 50.dp),
            onClick = { loading = true }, enabled = !loading
        ) {
            Text("Start loading")
        }

        if (!loading) return

        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}