package com.cxp.testcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.ui.theme.TestComposeTheme

/**
 * <pre>
 *     author : CXP
 *     e-mail : cxpnobug@gmail.com
 *     time   : 2024/09/22
 *     desc   : 应用程序中所有Activity的基类。
 *     version: 1.0
 * </pre>
 */
abstract class BaseActivity : ComponentActivity() {

    /**
     * 日志输出标志
     */
    protected val TAG: String = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        initData()
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                Surface(
                    modifier = Modifier
                        .border(2.dp,Color.Red)
                        .background(Color.White)
                        .fillMaxSize()
                        .padding(10.dp)
                        .navigationBarsPadding(),

                    ) {
                    InitView()
                }
            }
        }

    }

    open fun initData() {}

    @Composable
    abstract fun InitView()


    inline fun <reified T> start() {
        startActivity(Intent(this, T::class.java))
    }

}