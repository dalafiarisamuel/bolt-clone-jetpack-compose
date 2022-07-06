package ng.devtamuno.bolt.cache.room.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import ng.devtamuno.bolt.cache.room.util.TestCoroutineRule
import ng.devtamuno.bolt.cache.room.util.TestUtil
import ng.devtamuno.bolt.cache.room.util.TestUtil.executeTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest
class UserDaoTest : BaseDaoTest() {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var userDao: UserDao

    @Before
    override fun setUp() {
        super.setUp()
        userDao = database.userDao()
    }


    @Test
    fun saveSingleUser_dataBaseShouldReturnSingleUser() = executeTest {
        val user = TestUtil.createUser(id = 1)
        userDao.saveUser(user)

        userDao.getUser().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(1)
            assertThat(this).contains(user)
        }

    }

    @Test
    fun saveMultipleUsers_databaseShouldReturnLastInsertedUser() = executeTest {

        val user1 = TestUtil.createUser(id = 1)
        val user2 = TestUtil.createUser(
            id = 2,
            firstName = "Alice",
            lastName = "Wonderland",
            email = "alice@wonderland.com",
            phoneNumber = "+233345635"
        )
        val user3 = TestUtil.createUser(
            id = 3,
            firstName = "Arthur",
            lastName = "Spiderwick",
            email = "arthur@spiderwick.com",
            phoneNumber = "+23334563523"
        )

        userDao.saveUser(user1)
        userDao.saveUser(user2)
        userDao.saveUser(user3)

        userDao.getUser().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(1)
            assertThat(this).contains(user3)
        }

    }


    @Test
    fun saveMultipleUsersWithSamePhoneNumberAndEmailAddress_databaseShouldReturnSingleUpdatedUser() =
        executeTest {

            val user1 = TestUtil.createUser()
            val user2 = TestUtil.createUser(
                id = 2,
                firstName = "Alice",
                lastName = "Wonderland",
                isEmailVerified = true
            )

            userDao.saveUser(user1)
            userDao.saveUser(user2)

            userDao.getAllUsers().first().apply {
                assertThat(this).isNotEmpty()
                assertThat(this).hasSize(1)
                assertThat(this).contains(user2)
            }

        }

    @Test
    fun deleteSavedUsers_databaseShouldReturnEmptyList() = executeTest {

        val user1 = TestUtil.createUser()
        val user2 = TestUtil.createUser(
            firstName = "Alice",
            lastName = "Wonderland",
            email = "alice@wonderland.com",
            phoneNumber = "+233345635"
        )
        val user3 = TestUtil.createUser(
            firstName = "Arthur",
            lastName = "Spiderwick",
            email = "arthur@spiderwick.com",
            phoneNumber = "+23334563523"
        )

        userDao.saveUser(user1)
        userDao.saveUser(user2)
        userDao.saveUser(user3)

        userDao.getAllUsers().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(3)
        }

        userDao.cleanTable()

        userDao.getAllUsers().first().apply {
            assertThat(this).isEmpty()
        }


    }


    @After
    override fun tearDown() {
        super.tearDown()
    }
}