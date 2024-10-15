package com.example.myapplicationtp

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationtp.ui.theme.MyApplicationTPTheme
import com.example.myapplicationtp.ui.theme.MyBlue
import com.example.myapplicationtp.ui.theme.MyGrey


@Composable
fun Home() {
        Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
    Nom()

    Maphoto()
    Spacer(modifier= Modifier.height(40.dp))

    Statut()
    Spacer(modifier= Modifier.height(20.dp))

    Formation()
    Spacer(modifier= Modifier.height(40.dp))

    Mail()
    //Spacer(modifier= Modifier.height(20.dp))

    LinkedinOne()
    LinkedinTwo()
    Spacer(modifier= Modifier.height(70.dp))

    Demarrer()
    }
}

@Composable
fun Nom(){
    Text(
        text = "Maéva Desfours",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = MyBlue,
        fontSize = 30.sp,
        modifier = Modifier.padding(80.dp)

    )
}


@Composable
fun Maphoto() {

        Image(
            painterResource(id = R.drawable.ma_va_android),
            contentDescription = "photo de profil",
            modifier = Modifier.size(250.dp)
    )
}
@Composable
fun Statut(){
    Text(
        text = "Etudiante en informatique pour la santé",
        //style = MaterialTheme.typography.titleLarge,
        color = MyGrey,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
}

@Composable
fun Formation(){
    Text(
        text = "Ecole d'ingénieur ISIS - Castres",
        color = MyGrey,
    )
}

@Composable
fun Mail(){
    Text(
        text = "Mail : maeva.desfours@etud.univ-jfc.fr",
        color = MyBlue,

    )
}
@Composable
fun LinkedinOne(){
    Text(
        text = "Linkedin: www.linkedin.com/in/maéva",
        color = MyBlue,)
}

@Composable
fun LinkedinTwo(){
    Text(
        text = "desfours-b80bbb263",
        color = MyBlue,)
}
@Composable
fun Demarrer() {
    Button(onClick = { /*action*/ }) {
        Text("Démarrer", fontWeight = FontWeight.Bold, fontSize = 30.sp,style = MaterialTheme.typography.bodyMedium)
    }
}

/*@Composable
fun ButtonColors(
    backgroundColor: Color = MyBlue,
    /*contentColor: Color = contentColorFor(backgroundColor),
    disabledBackgroundColor: Color = MaterialTheme.colors.onSurface
        .copy(alpha = 0.12f)
        .compositeOver(MaterialTheme.colors.surface),
    disabledContentColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)*/
) {
}

@Composable
fun Demarrer() {
        ButtonColors()
        Text("Démarrer", color = Color.White)

        }*/


/*@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MyApplicationTPTheme {
        Home("Android")
    }
}*/
