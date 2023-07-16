package com.andreykosarygin.companies_ui.screen_companies

import com.andreykosarygin.common.ApostasEsportivasViewModel
import com.andreykosarygin.common.ApostasEsportivasViewModelSingleLifeEvent

class ScreenCompaniesViewModel : ApostasEsportivasViewModel<ScreenCompaniesViewModel.Model>(Model()) {

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