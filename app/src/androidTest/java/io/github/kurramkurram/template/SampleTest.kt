package io.github.kurramkurram.template

import android.content.Intent
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiObject2
import android.support.test.uiautomator.Until
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.github.kurramkurram.template.datalayer.source.database.SampleDatabase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File


@RunWith(AndroidJUnit4::class)
class SampleTest {

    companion object {
        private const val PACKAGE_NAME = "io.github.kurramkurram.template"

        private const val TIME_OUT = 5000L
    }

    private val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    private val context = InstrumentationRegistry.getInstrumentation().context

    @Before
    fun startActivityFromHomeScreen() {
        // press home
        uiDevice.pressHome()

        // start app
        val launcherPackage: String = uiDevice.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        uiDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), TIME_OUT)

        val intent: Intent? = context.packageManager.getLaunchIntentForPackage(PACKAGE_NAME)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        // wait
        uiDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), TIME_OUT)
    }

    @Test
    fun test_editText() {
        val sampleDao = SampleDatabase.getDatabases(context).sampleWordDao()
        sampleDao.deleteAll()

        // enter EditText
        uiDevice.findObject(By.res(PACKAGE_NAME, "edit_text")).text = "ABCDE"

        val editText =
            uiDevice.wait(Until.findObject(By.res(PACKAGE_NAME, "edit_text")), TIME_OUT)

        val textView =
            uiDevice.wait(Until.findObject(By.res(PACKAGE_NAME, "origin_text")), TIME_OUT)

        assertThat(editText.text, `is`(equalTo("ABCDE")))
        assertThat(textView.text, `is`(equalTo("ABCDE")))

        // click Shuffle button
        uiDevice.findObject(By.res(PACKAGE_NAME, "shuffle_button")).click()

        // click Save button
        uiDevice.findObject(By.res(PACKAGE_NAME, "save_button")).click()

        // shuffled TextView
        val shuffledTextView =
            uiDevice.wait(Until.findObject(By.res(PACKAGE_NAME, "shuffle_text")), TIME_OUT)
        val shuffledText = shuffledTextView.text

        // take screenshot
        val file = File("/sdcard/Pictures/screenshot.png")
        uiDevice.takeScreenshot(file)

        // rotate screen
        uiDevice.setOrientationLeft()
        Thread.sleep(1000)

        // select word
        val word = sampleDao.selectWord("ABCDE")
        assertThat(word.shuffled, `is`(equalTo(shuffledText)))
    }
}