package com.brandyodhiambo.mynote.di

import com.brandyodhiambo.mynote.feature_auth.data.repository.AuthRepostoryImpl
import com.brandyodhiambo.mynote.feature_auth.domain.repository.AuthRepository
import com.brandyodhiambo.mynote.feature_auth.domain.usecase.LoginUseCase
import com.brandyodhiambo.mynote.feature_auth.domain.usecase.SignUpUseCase
import com.brandyodhiambo.mynote.feature_notes.data.data_source.NotesDatabase
import com.brandyodhiambo.mynote.feature_notes.data.repository.NoteRespositoryImpl
import com.brandyodhiambo.mynote.feature_notes.domain.repository.NoteRepository
import com.brandyodhiambo.mynote.feature_notes.domain.usecase.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideNoteRepository(db: NotesDatabase): NoteRepository {
        return NoteRespositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth,firestore: FirebaseFirestore):AuthRepository{
        return AuthRepostoryImpl(firebaseAuth,firestore)
    }




}