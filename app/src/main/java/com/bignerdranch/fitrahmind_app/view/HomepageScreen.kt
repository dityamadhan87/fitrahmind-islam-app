package com.bignerdranch.fitrahmind_app.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.fitrahmind_app.R
import com.bignerdranch.fitrahmind_app.ui.theme.FitrahmindappTheme

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color(0xFFE9EFEC))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6A9C89))
                .height(260.dp)
        ) {

        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        ){
            FeaturesSection()
            Spacer(modifier = Modifier.height(30.dp))

            UpcomingEventsSection()
            Spacer(modifier = Modifier.height(30.dp))

            HotFeaturesSection()
            Spacer(modifier = Modifier.height(30.dp))

            TrendingArticlesSection()
        }
    }
}

@Composable
private fun FeaturesSection() {
    Text(
        text = stringResource(id = R.string.features_title),
        style = MaterialTheme.typography.headlineSmall
    )
    Spacer(modifier = Modifier.height(15.dp))

    Row {
        FeatureItem(iconRes = R.drawable.prayer_icon, label = "Doa", onClick ={})
        Spacer(modifier = Modifier.width(20.dp))
        FeatureItem(iconRes = R.drawable.sunnah_icon, label = "Sunnah", onClick ={})
        Spacer(modifier = Modifier.width(20.dp))
        FeatureItem(iconRes = R.drawable.guide_icon, label = "Sholat", onClick ={})
    }
}

@Composable
private fun FeatureItem(iconRes: Int, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Surface(
            modifier = Modifier.size(58.dp),
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFFC4DAD2)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = "$label Icon"
                )
            }
        }
        Text(text = label)
    }
}

@Composable
private fun UpcomingEventsSection() {
    Text(
        text = stringResource(id = R.string.upcoming_events_title),
        style = MaterialTheme.typography.headlineSmall
    )
    Spacer(modifier = Modifier.height(15.dp))

    Row {
        CustomOutlinedButton(text = "View All", onClick = {})
        CustomOutlinedButton(text = "Puasa", onClick = {})
        CustomOutlinedButton(text = "Sholat", onClick = {})
    }
    Spacer(modifier = Modifier.height(10.dp))

    EventItem(
        day = "Mon",
        date = "09",
        monthYear = "Feb 2024",
        title = "Puasa Senin Kamis",
        description = "Baca artikel tentang keutamaan dan manfaat puasa Senin-Kamis di sini!",
        onClick = {}
    )
}

@Composable
fun CustomOutlinedButton(text: String,onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Black),
        shape = RectangleShape
    ) {
        Text(
            text = text,
            color = Color.Black)
    }
}

@Composable
private fun EventItem(day: String, date: String, monthYear: String, title: String, description: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(Color(0xFFC4DAD2))
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.width(115.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(day)
                Text(date)
                Text(monthYear)
            }
            VerticalDivider(
                thickness = 1.dp,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Column {
                Text(text = title)
                Text(
                    text = description,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Composable
private fun HotFeaturesSection() {
    Text(
        text = stringResource(id = R.string.hot_features_title),
        style = MaterialTheme.typography.headlineSmall
    )
    Spacer(modifier = Modifier.height(15.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(Color(0xFFC4DAD2))
            .clickable {}
    ) {
        Image(
            painter = painterResource(id = R.drawable.quran_woman),
            contentDescription = "Quran Woman",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Jadikan Sholatmu Lebih Berwarna dengan Pilih Surat!",
                color = Color.White
            )
        }
    }
}

@Composable
private fun TrendingArticlesSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.trending_article_title),
                style = MaterialTheme.typography.headlineSmall
            )
            Button(
                onClick = { /* Handle click */ },
            ) {
                Text(text = "See All")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ArticleItem(
                imageRes = R.drawable.quran_woman,
                title = "Gus Miftah hina tukang es : Indonesia buta agama?",
                modifier = Modifier.weight(1f),
                onClick = {}
            )
            Spacer(modifier = Modifier.width(10.dp))
            ArticleItem(
                imageRes = R.drawable.quran_woman,
                title = "Sejarah puasa Senin Kamis yang wajib anda ketahui!",
                modifier = Modifier.weight(1f),
                onClick = {}
            )
        }
    }
}

@Composable
private fun ArticleItem(
    imageRes: Int,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        Box(
            modifier = Modifier.aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Article Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview(){
    FitrahmindappTheme{
        HomePage()
    }
}