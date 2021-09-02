package com.wj.domain

import com.wj.domain.interactor.GetBreweriesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetBreweriesUseCase(get()) }
}