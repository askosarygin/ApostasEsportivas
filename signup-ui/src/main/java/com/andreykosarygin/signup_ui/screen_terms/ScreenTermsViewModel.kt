package com.andreykosarygin.signup_ui.screen_terms

import com.andreykosarygin.common.ApostasEsportivasViewModel
import com.andreykosarygin.common.ApostasEsportivasViewModelSingleLifeEvent

class ScreenTermsViewModel : ApostasEsportivasViewModel<ScreenTermsViewModel.Model>(Model()) {

    fun onBackPressed() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationDestination.ScreenSignUp
            )
        )
    }

    data class Model(
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : ApostasEsportivasViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {
                ScreenSignUp
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