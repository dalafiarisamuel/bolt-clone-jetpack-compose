package ng.devtamuno.bolt.compose.ui.component


import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import ng.devtamuno.bolt.compose.R
import ng.devtamuno.bolt.compose.ui.theme.CustomColor

@Composable
fun NavigationMenuItem(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes icon: Int,
    iconColor: Color = CustomColor.BoltGrey,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .noRippleClickable(onClick = onClick),
        horizontalArrangement = Arrangement.Start
    ) {

        Icon(
            modifier = Modifier
                .size(25.dp),
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            tint = iconColor
        )

        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 10.dp),
            text = title,
            fontWeight = FontWeight.Normal,
            color = CustomColor.MatteBlack,
            fontSize = 17.sp,
            textAlign = TextAlign.Center

        )

    }
}

@Composable
fun NavigationMenuItemWithLabel(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    label: String,
    labelColor: Color = MaterialTheme.colors.onPrimary,
    labelBackgroundColor: Color = CustomColor.BoltRed,
    @DrawableRes icon: Int,
    iconColor: Color = CustomColor.BoltGrey,
    onClick: () -> Unit

) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .noRippleClickable(onClick = onClick),
    ) {

        val (menuIcon, titleTv, subtitleTv, labelTv) = createRefs()

        Icon(
            modifier = Modifier
                .constrainAs(menuIcon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)

                }
                .wrapContentSize(),
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            tint = iconColor
        )

        Text(
            modifier = Modifier
                .constrainAs(titleTv) {
                    top.linkTo(parent.top, 5.dp)
                    start.linkTo(menuIcon.end)
                }
                .wrapContentSize()
                .padding(start = 10.dp),
            text = title,
            fontWeight = FontWeight.Normal,
            color = CustomColor.MatteBlack,
            fontSize = 17.sp,
            textAlign = TextAlign.Center

        )

        Text(
            modifier = Modifier
                .constrainAs(subtitleTv) {
                    top.linkTo(titleTv.bottom, 5.dp)
                    start.linkTo(titleTv.start, 10.dp)
                }
                .padding(bottom = 10.dp)
                .wrapContentSize(),
            text = subtitle,
            fontWeight = FontWeight.Normal,
            color = CustomColor.BoltGrey,
            fontSize = 13.sp,
            textAlign = TextAlign.Center

        )


        Row(
            modifier = Modifier
                .constrainAs(labelTv) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end, margin = 5.dp)
                }
                .wrapContentSize()
                .background(
                    color = labelBackgroundColor,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Text(
                modifier = Modifier
                    .width(35.dp)
                    .padding(
                        top = 2.dp,
                        start = 4.dp,
                        end = 4.dp,
                        bottom = 2.dp
                    ),
                text = label,
                fontWeight = FontWeight.SemiBold,
                color = labelColor,
                fontSize = 10.sp,
                textAlign = TextAlign.Center

            )
        }


    }

}


@Preview
@Composable
private fun PreviewMenuItem() {

    PreviewComposableWithTheme {
        NavigationMenuItem(
            title = "Payment",
            icon = R.drawable.ic_payment
        ) {}
    }

}

@Preview
@Composable
private fun PreviewMenuItemWithLabel() {

    PreviewComposableWithTheme {
        NavigationMenuItemWithLabel(
            title = "Promotions",
            subtitle = "Enter promo code",
            label = "NEW",
            icon = R.drawable.ic_local_offer
        ) {}
    }

}