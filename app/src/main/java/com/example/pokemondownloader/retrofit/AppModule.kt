package com.example.pokemondownloader.retrofit

import android.app.Application
import androidx.room.Room
import com.example.pokemondownloader.Constants
import com.example.pokemondownloader.PokeApi
import com.example.pokemondownloader.db.PokemonDao
import com.example.pokemondownloader.db.PokemonDatabase
import dagger.Module
import dagger.Provides
import io.reactivex.plugins.RxJavaPlugins
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module()
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): PokeApi{
        return retrofit.create(PokeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): PokemonDatabase{
        return Room
            .databaseBuilder(app,PokemonDatabase::class.java, "pokemon.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: PokemonDatabase): PokemonDao{
        return db.PokemonDao()
    }
}