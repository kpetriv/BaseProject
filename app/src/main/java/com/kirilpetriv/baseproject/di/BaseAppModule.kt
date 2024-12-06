package com.kirilpetriv.baseproject.di

import com.kirilpetriv.baseproject.domain.BaseRepository
import com.kirilpetriv.baseproject.network.BaseRepositoryImpl
import com.kirilpetriv.baseproject.network.core.Client
import com.kirilpetriv.baseproject.network.core.HttpClientFactory
import com.kirilpetriv.baseproject.network.services.BaseService
import com.kirilpetriv.baseproject.uilayer.BaseViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val baseAppModule = module {
    single { Client() }
    single { HttpClientFactory().getHttpClient() }
    single<BaseService> { get<Client>().createService(get()) }

    single<BaseRepository> { BaseRepositoryImpl(baseService = get()) }
    viewModel { BaseViewModel(baseRepository = get()) }
}