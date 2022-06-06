package ng.devtamuno.bolt.compose.ui.component.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import ng.devtamuno.bolt.compose.R
import ng.devtamuno.bolt.compose.ui.component.PreviewComposableWithTheme
import ng.devtamuno.bolt.compose.ui.theme.CustomColor

@Composable
fun NavigationHeader(
    modifier: Modifier = Modifier,
    userFirstName: String,
    onEditClicked: () -> Unit,
) {


    ConstraintLayout(modifier = modifier) {

        val (profilePicture, profileName, editProfile) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(profilePicture) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.fillToConstraints
                }
                .size(50.dp)
                .background(
                    color = CustomColor.BoltProfilePhotoGrey,
                    shape = CircleShape
                ),
            contentScale = ContentScale.Inside,
            imageVector = Icons.Rounded.Person,
            colorFilter = ColorFilter.tint(color = Color.Gray),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .constrainAs(profileName) {
                    top.linkTo(anchor = profilePicture.top)
                    start.linkTo(anchor = profilePicture.end, margin = 10.dp)
                    width = Dimension.fillToConstraints
                },
            text = userFirstName,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 17.sp
        )

        Text(
            modifier = Modifier
                .constrainAs(editProfile) {
                    start.linkTo(anchor = profileName.start)
                    bottom.linkTo(anchor = profilePicture.bottom)
                    width = Dimension.fillToConstraints
                }
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onEditClicked
                ),
            text = stringResource(R.string.edit_profile),
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            color = Color.Gray
        )

    }


}

@Preview
@Composable
private fun NavigationHeaderPreview() {
    PreviewComposableWithTheme {
        NavigationHeader(
            modifier = Modifier.fillMaxWidth(),
            userFirstName = "Samuel",
            onEditClicked = {})
    }
}
