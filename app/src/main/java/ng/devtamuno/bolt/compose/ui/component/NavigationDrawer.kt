package ng.devtamuno.bolt.compose.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import ng.devtamuno.bolt.compose.R
import ng.devtamuno.bolt.compose.ui.theme.CustomColor


@Composable
fun NavigationDrawer() {

    Surface {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {

            val (profile, divider, payment,
                promotions, workTrips,
                tripHistory, support,
                about, becomeDriver) = createRefs()

            NavigationHeader(
                modifier = Modifier
                    .constrainAs(profile) {
                        top.linkTo(anchor = parent.top, margin = 20.dp)
                        start.linkTo(anchor = parent.start)
                    }
                    .padding(top = 35.dp),
                userFirstName = "Samuel"
            ) {

            }

            Divider(
                modifier = Modifier
                    .constrainAs(divider) {
                        top.linkTo(anchor = profile.bottom, margin = 20.dp)
                        start.linkTo(anchor = profile.start)

                    }
                    .fillMaxWidth(),
                color = CustomColor.BoltProfilePhotoGrey,
                thickness = 1.dp
            )


            NavigationMenuItem(
                modifier = Modifier
                    .constrainAs(payment) {
                        top.linkTo(anchor = divider.bottom, margin = 20.dp)
                        start.linkTo(anchor = profile.start)
                    },
                title = "Payment",
                icon = R.drawable.ic_payment
            ) {

            }

            NavigationMenuItemWithLabel(
                modifier = Modifier.constrainAs(promotions) {
                    top.linkTo(anchor = payment.bottom, margin = 20.dp)
                    start.linkTo(anchor = profile.start)
                },
                title = "Promotions",
                subtitle = "Enter promo code",
                label = "NEW",
                icon = R.drawable.ic_local_offer
            ) {}

            NavigationMenuItem(
                modifier = Modifier
                    .constrainAs(workTrips) {
                        top.linkTo(anchor = promotions.bottom, margin = 20.dp)
                        start.linkTo(anchor = profile.start)
                    },
                title = "Work trips",
                icon = R.drawable.ic_work
            ) {

            }

            NavigationMenuItem(
                modifier = Modifier
                    .constrainAs(tripHistory) {
                        top.linkTo(anchor = workTrips.bottom, margin = 25.dp)
                        start.linkTo(anchor = profile.start)
                    },
                title = "Trip History",
                icon = R.drawable.ic_access_time
            ) {

            }

            NavigationMenuItem(
                modifier = Modifier
                    .constrainAs(support) {
                        top.linkTo(anchor = tripHistory.bottom, margin = 25.dp)
                        start.linkTo(anchor = profile.start)
                    },
                title = "Support",
                icon = R.drawable.ic_message
            ) {

            }

            NavigationMenuItem(
                modifier = Modifier
                    .constrainAs(about) {
                        top.linkTo(anchor = support.bottom, margin = 25.dp)
                        start.linkTo(anchor = profile.start)
                    },
                title = "About",
                icon = R.drawable.ic_info
            ) {

            }


            BecomeDriver(
                modifier = Modifier.constrainAs(becomeDriver) {
                    start.linkTo(anchor = profile.start)
                    bottom.linkTo(parent.bottom, margin = 30.dp)
                }
            ) {}


        }
    }

}


@Preview
@Composable
private fun PreviewNavigationDrawer() {

    PreviewComposableWithTheme {
        NavigationDrawer()
    }
}