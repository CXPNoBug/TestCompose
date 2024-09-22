package com.cxp.testcompose.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cxp.testcompose.BaseActivity

class BadgedBoxActivity : BaseActivity() {
    @Composable
    override fun InitView() {

        Column {
            //简单使用
            BadgeExample()

            //徽章数据
            BadgeInteractiveExample()
        }
    }

    /**
     * 简单使用
     */
    @Composable
    fun BadgeExample() {
        BadgedBox(
            badge = { Badge() }
        ) {
            Icon(imageVector = Icons.Filled.Email, contentDescription = null)
        }
    }

    @Composable
    fun BadgeInteractiveExample() {
        var itemCount by remember { mutableStateOf(0) }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BadgedBox(
                badge = {
                    if (itemCount > 0) {
                        Badge(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ) {
                            Text("$itemCount")
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Shopping cart",
                )
            }
            Button(onClick = { itemCount++ }) {
                Text("Add item")
            }
        }
    }
}