package com.testtask.myapplication.di

import com.testtask.myapplication.data.datasources.RepositoryImpl
import com.testtask.myapplication.data.datasources.api.ServiceApi
import com.testtask.myapplication.data.datasources.cloud.CloudSource
import com.testtask.myapplication.data.datasources.cloud.CloudSourceImpl
import com.testtask.myapplication.data.datasources.mapers.MapMovie
import com.testtask.myapplication.data.datasources.mapers.MapToMovie
import com.testtask.myapplication.di.retrofit.RetrofitBuilder
import com.testtask.myapplication.domain.repository.Repository
import com.testtask.myapplication.presentations.main.MainFragment
import com.testtask.myapplication.presentations.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Di {
    fun retrofitModule() = module {
        single <ServiceApi>{ RetrofitBuilder().getService() }
    }

    fun mappersModule() = module {
        single<MapMovie> {
            MapToMovie()
        }
    }


    fun sourceModule() = module {
        single<CloudSource> {
            CloudSourceImpl(get())
        }
    }

    fun repositoryModules() = module {
        single<Repository> {
            RepositoryImpl(get(), get())
        }
    }


    fun viewModelsModules() = module {
        scope<MainFragment> {
            viewModel { MainViewModel(get()) }
        }
    }
}