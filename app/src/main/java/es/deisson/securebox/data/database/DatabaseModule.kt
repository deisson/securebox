package es.deisson.securebox.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideSecureBoxDatabase(
        @ApplicationContext context: Context
    ): SecureBoxDatabase {
        return Room.databaseBuilder(
            context,
            SecureBoxDatabase::class.java,
            SecureBoxDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideSecureItemDao(
        database: SecureBoxDatabase
    ): SecureItemDao {
        return database.secureItemDao()
    }
}
