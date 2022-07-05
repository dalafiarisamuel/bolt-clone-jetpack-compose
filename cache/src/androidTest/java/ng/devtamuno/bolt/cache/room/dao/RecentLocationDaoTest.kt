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
class RecentLocationDaoTest : BaseDaoTest() {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    private lateinit var dao: RecentLocationDao


    @Before
    override fun setUp() {
        super.setUp()

        dao = database.recentLocationDao()

    }


    @Test
    fun saveSingleRecentLocationAndReadList() = executeTest {

        val data = TestUtil.createRecentLocation(id = 1)

        dao.saveRecentLocation(data)

        dao.getAllRecentLocations().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).contains(data)
        }
    }


    @Test
    fun saveListOfRecentLocationAndReadList() = executeTest {

        val dataList = listOf(
            TestUtil.createRecentLocation(id = 1),
            TestUtil.createRecentLocation(id = 2),
            TestUtil.createRecentLocation(id = 3),
            TestUtil.createRecentLocation(id = 4)
        )

        dao.saveRecentLocations(dataList)

        dao.getAllRecentLocations().first().apply {

            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(size)
        }


    }

    @Test
    fun saveDuplicateDataExpectedToReplaceOldData() = executeTest {

        val data1 = TestUtil.createRecentLocation(id = 1)
        val data2 = TestUtil.createRecentLocation(id = 1, isWorkAddress = true)

        dao.saveRecentLocation(data1)
        dao.saveRecentLocation(data2)

        dao.getAllRecentLocations().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(1)
            assertThat(this).contains(data2)
        }

    }


    @Test
    fun deleteWrittenDataToClearTable() = executeTest {

        dao.saveRecentLocation(TestUtil.createRecentLocation())

        dao.getAllRecentLocations().first().apply {
            assertThat(this).isNotEmpty()
        }

        dao.cleanTable()

        dao.getAllRecentLocations().first().apply {
            assertThat(this).isEmpty()
        }


    }


    @After
    override fun tearDown() {
        super.tearDown()
    }


}