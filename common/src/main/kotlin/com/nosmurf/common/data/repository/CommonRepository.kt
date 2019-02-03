package com.nosmurf.common.data.repository

import com.nosmurf.common.data.datasource.local.LocalDataSource
import com.nosmurf.common.data.datasource.remote.RemoteDataSource
import com.nosmurf.common.domain.repository.Repository

class CommonRepository(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) : Repository {

   
}