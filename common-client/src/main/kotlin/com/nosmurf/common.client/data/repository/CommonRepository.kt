package com.nosmurf.common.client.data.repository

import com.nosmurf.common.client.data.datasource.local.LocalDataSource
import com.nosmurf.common.client.data.datasource.remote.RemoteDataSource
import com.nosmurf.common.client.domain.repository.Repository

class CommonRepository(
        private val local: LocalDataSource,
        private val remote: RemoteDataSource
) : Repository {


}