package com.bhanu.autism.screens

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bhanu.autism.AddtoCartActivity
import com.bhanu.autism.Autism
import com.bhanu.autism.DetailActivity
import com.bhanu.autism.FunfruitActivity
import com.bhanu.autism.LetterAndWordActivity
import com.bhanu.autism.ProfileActivity
import com.bhanu.autism.R
import com.bhanu.autism.components.AppToolbar
import com.bhanu.autism.components.NavigationDrawerBody
import com.bhanu.autism.components.NavigationDrawerHeader
import com.bhanu.autism.data.home.HomeViewModel
import com.bhanu.autism.getActionList
import com.bhanu.autism.getCommonList
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val localContext = LocalContext.current
    val CELL_COUNT = 2
    val span: (LazyGridItemSpanScope) -> GridItemSpan = { GridItemSpan(CELL_COUNT) }


    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {


            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val context = LocalContext.current

//                Spacer(modifier = Modifier.height(50.dp))

//                GenreTitle(genreTitle = "Select Types")

                Image(
                    painterResource(id = R.drawable.letters_img),
                    modifier = Modifier
                        .clickable {
                            context.startActivity(
                                Intent(context, LetterAndWordActivity::class.java))
                        }
                        .width(400.dp)
                        .height(100.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()

                        .padding(start = 10.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    text = "Letters and Words"
                )


                Spacer(Modifier.size(70.dp))

                Image(
                    painterResource(id = R.drawable.fruit_fun),
                    modifier = Modifier
                        .clickable {
                            context.startActivity(
                                Intent(context, FunfruitActivity::class.java))
                        }
                        .width(400.dp)
                        .height(100.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(start = 10.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    text = "Fruits Count"
                )

                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .clickable {
                            context.startActivity(
                                Intent(context, AddtoCartActivity::class.java))
                        }
                        .padding(start = 10.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    text = "Get Subscription"
                )

                Spacer(modifier = Modifier.height(80.dp))

                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .clickable {
                            context.startActivity(
                                Intent(context, ProfileActivity::class.java))
                        }
                        .padding(start = 10.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    text = "Profile Info"
                )

            }




           /* Column(modifier = Modifier.fillMaxWidth()) {




                *//*LazyVerticalGrid(columns = GridCells.Fixed(2))
                {
                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AutismList(autismList = getActionList()) { autism ->
                                Toast.makeText(localContext, autism.name, Toast.LENGTH_SHORT).show()
                                localContext.startActivity(
                                    Intent(localContext, DetailActivity::class.java)
                                        .putExtra("autism_data", autism))
                            }
                        }

                    }
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(1))
                {
                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AutismList(autismList = getCommonList()) { autism ->
                                Toast.makeText(localContext, autism.name, Toast.LENGTH_SHORT).show()
                                localContext.startActivity(
                                    Intent(localContext, DetailActivity::class.java)
                                        .putExtra("autism_data", autism))
                            }
                        }

                    }
                }*//*
            }*/
        }
    }
}

@Composable
fun GenreTitle(genreTitle: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp),
        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
        text = genreTitle
    )
}

@Composable
fun AutismList(autismList: List<Autism>, onItemClick: (movie: Autism) -> Unit) {
    LazyRow(content = {
        items(autismList) { autism ->
            MovieItemView(toy = autism) {
                onItemClick(autism)
            }
        }
    })
}

@Composable
fun MovieItemView(toy: Autism, onClick: (movie: Autism) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(
                onClick = { onClick(toy) }
            )
            .width(100.dp)
            .wrapContentHeight()) {
        Image(
            painterResource(id = toy.poster),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(5.dp),
            contentDescription = ""
        )
        Text(
            text = toy.name,
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}