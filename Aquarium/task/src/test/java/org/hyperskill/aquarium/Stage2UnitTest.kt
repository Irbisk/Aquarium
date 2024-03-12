package org.hyperskill.aquarium

import org.hyperskill.aquarium.internals.AquariumTest
import org.hyperskill.aquarium.internals.data.AquariumFakeData.fakeListDescriptions
import org.hyperskill.aquarium.internals.data.AquariumFakeData.fakeListImageUrls
import org.hyperskill.aquarium.internals.data.AquariumFakeData.fakeListNames
import org.hyperskill.aquarium.internals.screen.MainScreenWithButtons
import org.hyperskill.aquarium.internals.screen.MainScreenWithButtons.Companion.ID_BUTTON_NEXT
import org.hyperskill.aquarium.internals.screen.MainScreenWithButtons.Companion.ID_BUTTON_PREVIOUS
import org.hyperskill.aquarium.internals.screen.PageScreen
import org.hyperskill.aquarium.internals.shadow.CustomShadowPicasso
import org.hyperskill.aquarium.internals.shadow.CustomShadowRequestCreator
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Config(shadows = [CustomShadowPicasso::class, CustomShadowRequestCreator::class])
class Stage2UnitTest : AquariumTest<MainActivity>(MainActivity::class.java) {

    @Before
    fun setUp() {
        CustomShadowPicasso.setContext(activity)
        CustomShadowPicasso.setSingletonNull()
    }

    @Test
    fun test00_checkButtonPrevious() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this, initViews = false).apply {
                btnPrevious
            }
        }
    }

    @Test
    fun test01_checkButtonNext() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this, initViews = false).apply {
                btnNext
            }
        }
    }

    @Test
    fun test02_whenOnPageZeroCheckClickToButtonNext() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page after clicking $ID_BUTTON_NEXT once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }

    @Test
    fun test03_whenOnPageZeroCheckClickToButtonPreviousGoesToLastPage() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }
    @Test
    fun test04_whenOnPageZeroCheckDoubleClickToButtonNext() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page after clicking $ID_BUTTON_NEXT once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_NEXT twice"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }
    @Test
    fun test05_whenOnPageZeroCheckDoubleClickToButtonPreviousGoesToMiddlePage() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS twice"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }
    @Test
    fun test06_whenOnPageZeroCheckTripleClickToButtonNext() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page after clicking $ID_BUTTON_NEXT once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page, $ID_BUTTON_NEXT is clicked twice"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page, $ID_BUTTON_NEXT is clicked three times"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }
    @Test
    fun test07_whenOnPageZeroCheckTripleClickToButtonPreviousGoesToFirstPage() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS twice"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS three times"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }

    @Test
    fun test08_whenOnPageZeroCheckClickToButtonPreviousThenClickToButtonNext() {
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on last page after clicking $ID_BUTTON_NEXT once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }


    @Test
    fun test09_whenOnPageZeroCheckDoubleClickToButtonPreviousThenClickToButtonNext(){
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page, $ID_BUTTON_PREVIOUS is clicked twice"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {

                    val caseDescription = "When on page 1, $ID_BUTTON_NEXT is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }

    @Test
    fun test10_whenOnPageZeroCheckDoubleClickToButtonNextThenClickToButtonPrevious(){
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page after clicking $ID_BUTTON_NEXT once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page, $ID_BUTTON_NEXT is clicked twice"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on page 2, $ID_BUTTON_PREVIOUS is clicked once"
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }
    @Test
    fun test11_whenOnPageZeroCheckClickToButtonPreviousThenClickToButtonNext(){
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page, $ID_BUTTON_PREVIOUS is clicked twice"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on page 1, $ID_BUTTON_NEXT is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }

    @Test
    fun test12_whenOnPageZeroCheckClickToButtonNextThenDoubleClickToButtonPrevious(){
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page after clicking $ID_BUTTON_NEXT once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on page 1, $ID_BUTTON_PREVIOUS is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial, $ID_BUTTON_PREVIOUS is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }

    @Test
    fun test13_whenOnPageZeroCheckClickToButtonPreviousThenClickToButtonNextThenClickToButtonPrevious(){
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription =
                        "When on initial page after clicking $ID_BUTTON_PREVIOUS once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on last page, $ID_BUTTON_NEXT is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page $ID_BUTTON_PREVIOUS is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }
    @Test
    fun test14_whenOnPageZeroCheckClickToButtonNextThenClickToButtonPreviousThenClickToButtonNext(){
        testActivity(arguments = stage2Args) {
            MainScreenWithButtons(this).apply {
                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "After app init"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page after clicking $ID_BUTTON_NEXT once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                previousPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on page 1, $ID_BUTTON_PREVIOUS is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }

                CustomShadowPicasso.clearRequests()
                nextPage()

                PageScreen(this@Stage2UnitTest).apply {
                    val caseDescription = "When on initial page, $ID_BUTTON_NEXT is clicked once"
                    assertPageTextContent(
                        caseDescription = caseDescription,
                        expectedName = fakeListNames[pageIndex],
                        expectedDescription = fakeListDescriptions[pageIndex]
                    )
                    assertPageImageRequest(
                        caseDescription = caseDescription,
                        imageUrls = fakeListImageUrls,
                        pageIndex = pageIndex
                    )
                    assertImageViewScale()
                }
            }
        }
    }
}