package com.cxp.testcompose.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.cxp.testcompose.BaseActivity

class ListActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        val list = ('A'..'Z').map { it.toString() }
    }


}