package com.mksoftware101.personalnotes.data.di

import com.mksoftware101.personalnotes.data.NotesRepositoryImpl
import com.mksoftware101.personalnotes.data.db.NoteDao
import com.mksoftware101.personalnotes.domain.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideNotesRepository(noteDao: NoteDao): NotesRepository = NotesRepositoryImpl(noteDao)
}