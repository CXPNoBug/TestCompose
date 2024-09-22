package com.cxp.testcompose.test

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxp.testcompose.BaseActivity
import com.cxp.testcompose.R
import com.cxp.testcompose.ui.theme.TestComposeTheme

class TextActivity : BaseActivity() {

    @Composable
    override fun InitView() {
        val context = LocalContext.current
        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            //显示文本
            SimpleText()
            //显示资源中的文字
            StringResourceText()
            //更改文本颜色
            BlueText()
            //更改文字大小
            BigText()
            //将文本设为斜体
            ItalicText()
            //将文本设为粗体
            BoldText()
            //添加阴影
            TextShadow()
            //在文本中添加多种样式
            MultipleStylesInText()
            //在文本中添加多种样式
            CenterText()
            //在段落中添加多种样式
            ParagraphStyle()
            //限制显示的行数
            LongText()
            //指示文字溢出
            OverflowedText()
            //输入框
            SimpleFilledTextFieldSample()
            //设置字体
            DifferentFonts()
            //超链接
            AnnotatedStringWithLinkSample()
            //复制文本
            SelectableText()
        }
    }

    /**
     * 显示文本
     */
    @Composable
    fun SimpleText() {
        Text("显示文本:Hello World")
    }

    /**
     * 显示资源中的文字
     */
    @Composable
    fun StringResourceText() {
        Text("显示资源中的文字:${stringResource(R.string.app_name)}")
    }

    /**
     * 更改文本颜色
     */
    @Composable
    fun BlueText() {
        Text("更改文本颜色:Hello World", color = Color.Blue) //颜色
    }

    /**
     * 更改文字大小
     */
    @Composable
    fun BigText() {
        Text("更改文字大小:Hello World", fontSize = 30.sp) //大小
    }

    /**
     * 将文本设为斜体
     */
    @Composable
    fun ItalicText() {
        Text(
            "将文本设为斜体:Hello World",
            fontStyle = FontStyle.Italic, //斜体
        )
    }

    /**
     * 将文本设为粗体
     */
    @Composable
    fun BoldText() {
        Text(
            "将文本设为粗体:Hello World",
            fontWeight = FontWeight.Bold, //粗体
        )
    }

    /**
     * 添加阴影
     */
    @Composable
    fun TextShadow() {
        val offset = Offset(5.0f, 10.0f)
        Text(
            text = "添加阴影:Hello world!",
            style = TextStyle(
                fontSize = 24.sp,
                //阴影颜色、偏移量
                shadow = Shadow(
                    color = Color.Blue, offset = offset, blurRadius = 3f
                )
            )
        )
    }

    /**
     * 在文本中添加多种样式
     */
    @Composable
    fun MultipleStylesInText() {
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) { //SpanStyle文字样式
                append("H")
            }
            append("ello ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        }
        )
    }

    //设置文本对齐方式
    @Composable
    fun CenterText() {
        Text(
            "设置文本对齐方式:Hello World",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(150.dp),
            style = TextStyle(
                background = Color.Gray //背景颜色
            )
        )
    }

    //在段落中添加多种样式
    @Composable
    fun ParagraphStyle() {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) { //ParagraphStyle指定文字对齐、文字方向、行高和文字缩进样式
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Hello\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold, color = Color.Red
                        )
                    ) {
                        append("World\n")
                    }
                    append("Compose")
                }
            }
        )
    }

    /**
     * 限制显示的行数
     */
    @Composable
    fun LongText() {
        Text("hello ".repeat(50), maxLines = 2)
    }

    /**
     * 指示文字溢出
     */
    @Composable
    fun OverflowedText() {
        Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
    }

    /**
     * 输入框
     */
    @Composable
    fun SimpleFilledTextFieldSample() {
        var text by remember { mutableStateOf("Hello") }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") },
            placeholder = {
                Text(text = "请输入内容")  //hint
            },
        )
    }

    /**
     * 设置字体
     */
    @Composable
    fun DifferentFonts() {
        Text("Hello World", fontFamily = FontFamily.Serif)
        Text("Hello World", fontFamily = FontFamily.SansSerif)
    }

    /**
     * 超链接
     */
    val annotatedText= buildAnnotatedString {
        withStyle(style = ParagraphStyle(lineHeight = 25.sp)){
            pushStringAnnotation(
                tag = "URL",
                annotation = "https://www.baidu.com"
            )
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Red
                )
            ){
                append("点我")
            }
            pop()
        }
    }

    /**
     * 超链接
     */
    @Composable
    fun AnnotatedStringWithLinkSample(){
        ClickableText(
            text = annotatedText,
            onClick = { offset->
                annotatedText.getStringAnnotations("URL", start = offset, end = offset).firstOrNull()?.let {
                    val url =it.item
                    Log.i(TAG, "test-->: $offset  $url")
                }
            }
        )
    }

    /**
     * 复制文本
     */
    @Composable
    fun SelectableText() {
        SelectionContainer {
            Text("复制文本")
        }
    }


}
