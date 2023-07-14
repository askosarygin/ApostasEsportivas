package com.andreykosarygin.signup_ui.screen_signup

import com.andreykosarygin.common.ApostasEsportivasViewModel
import com.andreykosarygin.common.ApostasEsportivasViewModelSingleLifeEvent

class ScreenSignUpViewModel(

) : ApostasEsportivasViewModel<ScreenSignUpViewModel.Model>(Model()) {


    data class Model(
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : ApostasEsportivasViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {

            }
        }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update {
            it.copy(
                navigationEvent = navigationEvent
            )
        }
    }
}