package org.hyperskill.aquarium.internals.screen

import android.app.Activity
import android.widget.Button
import org.hyperskill.aquarium.internals.AquariumTest
import org.hyperskill.aquarium.internals.data.AquariumFakeData.fakeListNames

class MainScreenWithButtons<T : Activity> (
    private val test: AquariumTest<T>, val
    numPages: Int = fakeListNames.size,
    initViews: Boolean = true
) {

// lazy instantiation of views that belong to activity but not to "page"
    companion object {
        const val ID_BUTTON_PREVIOUS = "btn_previous"
        const val ID_BUTTON_NEXT = "btn_next"
    }

    var pageIndex = 0
        private set

    val btnPrevious: Button by lazy {
        with(test) {
            activity.findViewByString<Button>(ID_BUTTON_PREVIOUS)
        }
    }

    val btnNext: Button by lazy {
        with(test) {
            activity.findViewByString<Button>(ID_BUTTON_NEXT)
        }
    }

    fun nextPage() = with(test) {
        btnNext.clickAndRun()
        pageIndex = (pageIndex + 1).mod(numPages)
    }

    fun previousPage() = with(test) {
        btnPrevious.clickAndRun()
        pageIndex = (pageIndex - 1).mod(numPages)
    }

    init {
        if(initViews) {
            btnNext
            btnPrevious
        }
    }
}