package com.example.businesscardapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        stringResource(R.string.name), stringResource(R.string.title_role),
                        stringResource(R.string.contact_number),
                        stringResource(R.string.email_id),
                        stringResource(R.string.social_media_id)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    fullName: String, title: String,
    contactNumber: String, email: String,
    socialMediaHandle: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.android_logo)
    val mail = painterResource(R.drawable.mail_24px)
    val phone = painterResource(R.drawable.baseline_phone_24)
    val linkedin = painterResource(R.drawable.share_24px)

    // Column for the main content of the business card
    Column(
        modifier = modifier
            .width(50.dp)
            .background(Color(0xFFc7f9cc)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Image section
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .background(Color.DarkGray)
                .size(150.dp)
                .height(50.dp)
        )
        // Full name section
        Text(
            text = fullName,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 30.sp,
            color = Color.DarkGray,
            modifier = modifier
        )
        // Title section
        Text(
            text = title,
            color = Color(0xFF2a9d8f),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
        )
    }

    // Column for the contact information section
    Column(
        modifier = modifier.padding(bottom = 10.dp, start = 90.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        // Contact number section
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = phone,
                contentDescription = null,
                alignment = Alignment.BottomStart,
                modifier = modifier
                    .size(20.dp)
                    .padding(end = 5.dp)
            )
            Text(
                text = contactNumber,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = modifier
            )
        }
        // Social media handle section
        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            Image(
                painter = linkedin,
                contentDescription = null,
                modifier = modifier
                    .size(20.dp)
                    .padding(end = 5.dp)
            )
            Text(
                text = socialMediaHandle,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
        }
        // Email section
        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            Image(
                painter = mail,
                contentDescription = null,
                modifier = modifier
                    .size(20.dp)
                    .padding(end = 5.dp)
            )
            Text(
                text = email,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
            )
        }
    }
}
