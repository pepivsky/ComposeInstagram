package com.pepivsky.composeinstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close app",
        modifier = modifier.clickable {
            activity.finish()
        })
}

@Composable
fun ImageLogo() {
    Image(
        modifier = Modifier.size(150.dp),
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "instagram logo"
    )
}

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        placeholder = { Text(text = "Phone number, username or email") },
        onValueChange = { onTextChanged(it) })
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        placeholder = { Text(text = "Password") },
        onValueChange = { onTextChanged(it) })
}

@Composable
fun ForgotPassWord(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun BtnLogin(loginEnable: Boolean) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
        enabled = loginEnable,
        onClick = { /*TODO*/ }) {
        Text(text = "Log In", color = Color.White)
    }
}


@Composable
fun LoginDivider() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(Modifier.weight(1F))
        Text(
            text = "OR",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            color = Color(0xFFB5B5B5)
        )
        Divider(Modifier.weight(1F))

    }
}

@Composable
fun SocialLogin() {
    Row(verticalAlignment = (Alignment.CenterVertically)) {
        Icon(
            painter = painterResource(id = R.drawable.icon_facebook),
            contentDescription = "facebook icon"
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Continue as Dave Johnson")
    }
}


@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        ImageLogo()
        Email(email = email, onTextChanged = { email = it })
        Password(password = password, onTextChanged = { password = it })
        ForgotPassWord(Modifier.align(Alignment.End))
        BtnLogin(isLoginEnable)
        LoginDivider()
        Spacer(modifier = Modifier.size(30.dp))
        SocialLogin()
    }
}


@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Divider(Modifier.height(1.dp))
        Spacer(modifier = Modifier.size(16.dp))
        SignUp()
        Spacer(modifier = Modifier.size(16.dp))

    }
}

@Composable
fun SignUp() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Don't have an account?", fontSize = 12.sp, fontWeight = FontWeight.Bold,color = Color(0xFFB5B5B5) )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Sign Up.", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4EA8E9))
    }

}