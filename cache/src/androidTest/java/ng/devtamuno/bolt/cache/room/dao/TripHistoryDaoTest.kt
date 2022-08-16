package ng.devtamuno.bolt.cache.room.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import ng.devtamuno.bolt.cache.room.util.TestCoroutineRule
import ng.devtamuno.bolt.cache.room.util.TestUtil
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest
class TripHistoryDaoTest : BaseDaoTest() {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var dao: TripHistoryDao


    @Before
    override fun setUp() {
        super.setUp()
        dao = database.tripHistoryDao()
    }


    @Test
    fun saveSingleTripHistory_databaseReturnsListWithSingleItem() = runTest {

        val data = TestUtil.createTripHistory(id = 1)
        dao.saveTripHistory(data)

        dao.getAllTripHistories().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(1)
            assertThat(this).contains(data)
        }
    }


    @Test
    fun saveMultipleTripHistory_databaseReturnsListOfItems() = runTest {

        val data1 = TestUtil.createTripHistory(id = 1)
        val data2 = TestUtil.createTripHistory(id = 2)
        val data3 = TestUtil.createTripHistory(id = 3)
        dao.saveTripHistory(data1)
        dao.saveTripHistory(data2)
        dao.saveTripHistory(data3)

        dao.getAllTripHistories().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(3)
        }
    }


    @Test
    fun deleteTripHistory_databaseReturnsAnEmptyList() = runTest {

        val data1 = TestUtil.createTripHistory(id = 1)
        val data2 = TestUtil.createTripHistory(id = 2)
        val data3 = TestUtil.createTripHistory(id = 3)
        dao.saveTripHistory(data1)
        dao.saveTripHistory(data2)
        dao.saveTripHistory(data3)

        dao.getAllTripHistories().first().apply {
            assertThat(this).isNotEmpty()
        }

        dao.cleanTable()

        dao.getAllTripHistories().first().apply {
            assertThat(this).isEmpty()
        }
    }

    @After
    override fun tearDown() {
        super.tearDown()
    }
}
