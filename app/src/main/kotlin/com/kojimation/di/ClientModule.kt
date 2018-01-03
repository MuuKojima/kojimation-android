package com.kojimation.di

import com.kojimation.data.api.DiaryApi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ClientModule {

  @Provides
  @Singleton
  fun provideMoshi() = Moshi.Builder()
      .add(KotlinJsonAdapterFactory())
      .build()

  @Singleton
  @Provides
  fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
      .build()

  @Provides
  @Singleton
  fun provideRetrofit(oktHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
      .baseUrl("https://kojimation.com")
      .client(oktHttpClient)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
      .build()

  @Provides
  @Singleton
  fun provideArticleClient(retrofit: Retrofit): DiaryApi = retrofit.create(DiaryApi::class.java)
}
